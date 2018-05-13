package com.npkompleet.phenomenon.bowser.bluetooth;

/**
 * Created by imrankst1221@gmail.com
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import android.Manifest;
import android.app.ListActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.npkompleet.phenomenon.bowser.R;
import com.npkompleet.phenomenon.bowser.forms.ListADI;


public class DeviceList extends /*ListActivity*/ AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    static public final int REQUEST_CONNECT_BT = 0*2300;
    static private final int REQUEST_ENABLE_BT = 0*1000;
    static private BluetoothAdapter mBluetoothAdapter = null;
    /*static private ArrayAdapter<String> mArrayAdapter = null;*/
    static private SimpleItemRecyclerViewAdapter mArrayAdapter=null;

    static private ArrayAdapter<BluetoothDevice> btDevices = null;

    String e2;
    
    static private final int MY_PERMISSIONS_REQUEST_COARSE_LOCATION= 22;
    private int MY_PERMISSIONS_REQUEST_BLUETOOTH_ADMIN= 23;

    private static final UUID SPP_UUID = UUID
            .fromString("8ce255c0-200a-11e0-ac64-0800200c9a66");
    // UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    static private BluetoothSocket mbtSocket = null;

    RecyclerView deviceRecyclerView;
    SwipeRefreshLayout swipe;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_device_list);
        deviceRecyclerView= findViewById(R.id.rv_device_list) ;
        swipe= findViewById(R.id.swipeLayoutDevice);

        swipe.setOnRefreshListener(this);

        /*setTitle("Bluetooth Devices");*/

        checkLocationPermission();

        try {
            if (initDevicesList() != 0) {
                this.finish();
                return;
            }

        } catch (Exception ex) {
            this.finish();
            return;
        }

        IntentFilter btIntentFilter = new IntentFilter(
                BluetoothDevice.ACTION_FOUND);
        registerReceiver(mBTReceiver, btIntentFilter);
    }


    private void checkLocationPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {  // Only ask for these permissions on runtime when running Android 6.0 or higher
            switch (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.ACCESS_COARSE_LOCATION)) {
                case PackageManager.PERMISSION_DENIED:
                    Toast.makeText(this, "Must grant permission to use bluetooth on this device", Toast.LENGTH_SHORT).show();
                    /*if (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(DeviceList.this,
                                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                                MY_PERMISSIONS_REQUEST_COARSE_LOCATION);
                    }
                    checkLocationPermission();*/
                    /*((TextView) new AlertDialog.Builder(this)
                            .setTitle("Runtime Permissions up ahead")
                            .setMessage(Html.fromHtml("<p>To find nearby bluetooth devices please click \"Allow\" on the runtime permissions popup.</p>" +
                                    "<p>For more info see <a href=\"http://developer.android.com/about/versions/marshmallow/android-6.0-changes.html#behavior-hardware-id\">here</a>.</p>"))
                            .setNeutralButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                                        ActivityCompat.requestPermissions(DeviceList.this,
                                                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                                                MY_PERMISSIONS_REQUEST_COARSE_LOCATION);
                                    }
                                }
                            })
                            .show()
                            .findViewById(android.R.id.message))
                            .setMovementMethod(LinkMovementMethod.getInstance());  */     // Make the link clickable. Needs to be called after show(), in order to generate hyperlinks
                    break;
                case PackageManager.PERMISSION_GRANTED:
                    break;
            }
        }

    }

    public static BluetoothSocket getSocket() {
        return mbtSocket;
    }

    private void flushData() {
        try {
            if (mbtSocket != null) {
                mbtSocket.close();
                mbtSocket = null;
            }

            if (mBluetoothAdapter != null) {
                mBluetoothAdapter.cancelDiscovery();
            }

            if (btDevices != null) {
                btDevices.clear();
                btDevices = null;
            }

            if (mArrayAdapter != null) {
                mArrayAdapter.clear();
                mArrayAdapter.notifyDataSetChanged();
                /*mArrayAdapter.notifyDataSetInvalidated();*/
                mArrayAdapter = null;
            }

            finalize();
        } catch (Exception ex) {
        } catch (Throwable e) {
        }

    }
    private int initDevicesList() {
        flushData();

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (mBluetoothAdapter == null) {
            Toast.makeText(getApplicationContext(),
                    "Bluetooth not supported!!", Toast.LENGTH_LONG).show();
            return -1;
        }

        if (mBluetoothAdapter.isDiscovering()) {
            mBluetoothAdapter.cancelDiscovery();
        }

        /*mArrayAdapter = new ArrayAdapter<String>(this,
                R.layout.layout_list);*/


        /*setListAdapter(mArrayAdapter);*/
        setUpRecyclerView();

        Intent enableBtIntent = new Intent(
                BluetoothAdapter.ACTION_REQUEST_ENABLE);
        try {
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        } catch (Exception ex) {
            return -2;
        }

        Toast.makeText(getApplicationContext(),
                "Getting all available Bluetooth Devices", Toast.LENGTH_SHORT)
                .show();

        return 0;

    }

    private void setUpRecyclerView(){
        deviceRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mArrayAdapter= new SimpleItemRecyclerViewAdapter(new ArrayList<String>());
        deviceRecyclerView.setAdapter(mArrayAdapter);
    }

    @Override
    protected void onActivityResult(int reqCode, int resultCode, Intent intent) {
        super.onActivityResult(reqCode, resultCode, intent);

        switch (reqCode) {
            case REQUEST_ENABLE_BT:

                if (resultCode == RESULT_OK) {
                    Set<BluetoothDevice> btDeviceList = mBluetoothAdapter
                            .getBondedDevices();
                    try {
                        if (btDeviceList.size() > 0) {

                            for (BluetoothDevice device : btDeviceList) {
                                if (!btDeviceList.contains(device)) {

                                    btDevices.add(device);

                                    mArrayAdapter.add(device.getName() + "\n"
                                            + device.getAddress());
                                    /*mArrayAdapter.notifyDataSetInvalidated();*/
                                    mArrayAdapter.notifyDataSetChanged();
                                }
                            }
                        }
                    } catch (Exception ex) {
                    }
                }

                break;
        }
        mBluetoothAdapter.startDiscovery();

    }

    private final BroadcastReceiver mBTReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                BluetoothDevice device = intent
                        .getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);

                try {
                    if (btDevices == null) {
                        btDevices = new ArrayAdapter<BluetoothDevice>(
                                getApplicationContext(), R.layout.layout_list);
                    }

                    if (btDevices.getPosition(device) < 0) {
                        btDevices.add(device);
                        mArrayAdapter.add(device.getName() + "\n"
                                + device.getAddress() + "\n" );
                        /*mArrayAdapter.notifyDataSetInvalidated();*/
                        mArrayAdapter.notifyDataSetChanged();
                    }
                } catch (Exception ex) {
                    ex.fillInStackTrace();
                }
            }
        }
    };

    /*@Override
    protected void onListItemClick(ListView l, View v, final int position,
                                   long id) {
        super.onListItemClick(l, v, position, id);*/
   public void onListItemClicked(final int position){

        if (mBluetoothAdapter == null) {
            return;
        }

        if (mBluetoothAdapter.isDiscovering()) {
            mBluetoothAdapter.cancelDiscovery();
        }

        Toast.makeText(
                getApplicationContext(),
                "Connecting to " + btDevices.getItem(position).getName() + ","
                        + btDevices.getItem(position).getAddress(),
                Toast.LENGTH_SHORT).show();

        Thread connectThread = new Thread(new Runnable() {

            @Override
            public void run() {
                BluetoothDevice device= btDevices.getItem(position);
                try {
                    boolean gotuuid = device.fetchUuidsWithSdp();
                    UUID uuid = device.getUuids()[0].getUuid();
                    mbtSocket = device.createRfcommSocketToServiceRecord(uuid);

                    //new block starts here
                    try {
                        mbtSocket.connect();
                    } catch (IOException e) {
                        try {
                            mbtSocket = (BluetoothSocket) device.getClass().getMethod("createRfcommSocket", new Class[]{int.class})
                                    .invoke(device, 1);
                            mbtSocket.connect();
                        } catch (Exception e2) {
                            /*gotuuid = false;*/
                            setE2(e2.getMessage());
                            //showAlertDialog();
                            runOnUiThread(someErrorRunnable);
                            /*Toast.makeText(getApplicationContext(),
                                    "Socket error", Toast.LENGTH_SHORT).show();*/
                        }

                    }


                } catch (IOException ex) {
                    runOnUiThread(socketErrorRunnable);
                    try {
                        mbtSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mbtSocket = null;
                    return;
                } finally {
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {
                            finish();

                        }
                    });
                }
            }
        });

        connectThread.start();
    }

    public void showAlertDialog(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        //set the title to be appear in the dialog
        alertDialogBuilder.setTitle("Bluetooth Connection Error");
        alertDialogBuilder.setMessage("Please restart the printer");
        alertDialogBuilder.setCancelable(true);
        alertDialogBuilder.setIcon(android.R.drawable.ic_dialog_alert);
        alertDialogBuilder.show();
    }





    private Runnable someErrorRunnable = new Runnable() {

        @Override
        public void run() {
            //showAlertDialog();
            /*Toast.makeText(getApplicationContext(),
                    "E2: "+ e2, Toast.LENGTH_SHORT).show();*/
            Toast.makeText(getApplicationContext(), "Bluetooth Error. Please restart the printer", Toast.LENGTH_LONG).show();
            //mBluetoothAdapter.startDiscovery();
            ListADI.resetConnection();


        }
    };

    private Runnable socketErrorRunnable = new Runnable() {

        @Override
        public void run() {
            //Toast.makeText(getApplicationContext(),
                    //"Cannot establish connection", Toast.LENGTH_SHORT).show();
            mBluetoothAdapter.startDiscovery();

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(0, Menu.FIRST, Menu.NONE, "Refresh Scanning");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case Menu.FIRST:
                initDevicesList();
                break;
        }

        return true;
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        try {
            unregisterReceiver(mBTReceiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setE2(String e2) {
        this.e2 = e2;
    }


    @Override
    protected void onStart() {
        super.onStart();
        /*if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.BLUETOOTH)
                != PackageManager.PERMISSION_GRANTED && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Toast.makeText(
                    getApplicationContext(),
                    "No Bluetooth Permissions Granted",
                    Toast.LENGTH_SHORT).show();

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.BLUETOOTH)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                Toast.makeText(
                        getApplicationContext(),
                        "Needs Bluetooth",
                        Toast.LENGTH_SHORT).show();
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.BLUETOOTH*//*, Manifest.permission.BLUETOOTH_ADMIN*//*},
                        MY_PERMISSIONS_REQUEST_BLUETOOTH);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
            Toast.makeText(
                    getApplicationContext(),
                    "You now have Permissions Granted",
                    Toast.LENGTH_SHORT).show();
        }*/
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_COARSE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1]==PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    Toast.makeText(
                            getApplicationContext(),
                            "Permissions Granted",
                            Toast.LENGTH_SHORT).show();
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(
                            getApplicationContext(),
                            "Permissions Denied",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

    public static void resetConnection() {

        if (mbtSocket != null) {
            try {mbtSocket.close();} catch (Exception e) {}
            mbtSocket = null;
        }

    }

    @Override
    public void onRefresh() {
        swipe.setRefreshing(false);
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {
            List<String> mValues;

        public SimpleItemRecyclerViewAdapter(List<String> items) {
            mValues = items;
        }

        public void add(String item){
            mValues.add(item);
            this.notifyDataSetChanged();
        }

        public void clear(){
            mValues.clear();
            this.notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_list, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            //holder.mItem = mValues.get(position);

            holder.mContentView.setText(mValues.get(position));
            /*holder.mContentView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onListItemClicked(position);
                }
            });*/
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            TextView mContentView;


            public ViewHolder(View view) {
                super(view);
                mContentView = view.findViewById(R.id.tv);
                view.setOnClickListener(this);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }

            @Override
            public void onClick(View view) {
                onListItemClicked(getAdapterPosition());
            }
        }
    }

}
