package com.npkompleet.phenomenon.bowser.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.npkompleet.phenomenon.bowser.mvp.models.PrintADI;
import com.npkompleet.phenomenon.bowser.mvp.models.PrintPTN;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.npkompleet.phenomenon.bowser.LoginActivity.FOOTER;
import static com.npkompleet.phenomenon.bowser.LoginActivity.HEADER;
import static com.npkompleet.phenomenon.bowser.LoginActivity.LOGO;
import static com.npkompleet.phenomenon.bowser.LoginActivity.NAME;


public class BluetoothUtils {
    public static final Map<String, BluetoothDevice> btMap= new HashMap<>();
    public static final List<String> btList= new ArrayList<>();



    public static BluetoothDevice getDevice(String deviceName){
        return btMap.get(deviceName);
    }

    public static void fetchAllDevice(){
        BluetoothAdapter btAdapter = BluetoothAdapter.getDefaultAdapter();
        btMap.clear();
        btList.clear();
        //BluetoothDevice mBtDevice = btAdapter.getBondedDevices().iterator().next();   // Get first paired device

        for (BluetoothDevice dv: btAdapter.getBondedDevices()){
            btMap.put(dv.getName(), dv);
            btList.add(dv.getName());
        }

    }

    public static void printPTN(BluetoothDevice mBtDevice, final PrintPTN ptn){

        final BluetoothPrinter mPrinter = new BluetoothPrinter(mBtDevice);
        mPrinter.connectPrinter(new BluetoothPrinter.PrinterConnectListener() {

            @Override
            public void onConnected() {
                    mPrinter.setAlign(BluetoothPrinter.ALIGN_CENTER);
                    //mPrinter.setBold(true);
                    mPrinter.printText(NAME.toUpperCase());
                    mPrinter.addNewLine();
                    //mPrinter.printText("Energy of Choice. Anywhere, Everywhere");
                    mPrinter.printText(HEADER);
                    mPrinter.setBold(false);
                    mPrinter.addNewLine();

                    mPrinter.setAlign(BluetoothPrinter.ALIGN_LEFT);
                    mPrinter.printText("PTN No.: "+ ptn.getFaitFormPtnNo());
                    mPrinter.addNewLine();
                    mPrinter.printText("Date: "+ ptn.getFaitFormPtnDeliveryDate());
                    mPrinter.addNewLine();
                    mPrinter.printText("Company Branch: "+ ptn.getFaitLocationsName());
                    mPrinter.addNewLine();
                    mPrinter.printText("Company Rep: "+ ptn.getFaitFormPtnLoaderName());
                    mPrinter.addNewLine();
                    mPrinter.printText("Receiving Tank: "+ ptn.getFaitAssetsStorageName());
                    mPrinter.addNewLine();
                    mPrinter.printText("WayBill No.: "+ ptn.getFaitFormPtnWaybillNo());
                    mPrinter.addNewLine();
                    mPrinter.printText("PTN Quantity: "+ ptn.getFaitFormPtnQuantity()+"LTRS");
                    mPrinter.addNewLine();
                    mPrinter.printText("Loading Station: "+ ptn.getFaitFormPtnLoadingStation());
                    mPrinter.addNewLine();
                    mPrinter.printText("Loader Name: "+ ptn.getFaitFormPtnLoaderName());
                    mPrinter.addNewLine();
                    mPrinter.printText("Transporter: "+ ptn.getFaitFormPtnTransporter());
                    mPrinter.addNewLine();
                    mPrinter.printText("Truck Number: "+ ptn.getFaitFormPtnTruckNo());
                    mPrinter.addNewLine();
                    mPrinter.printText("Driver Name: "+ ptn.getFaitFormPtnDriverName());
                    mPrinter.addNewLine();
                    mPrinter.printText("Meter Start: "+ ptn.getFaitFormPtnMeterStart());
                    mPrinter.addNewLine();
                    mPrinter.printText("Meter End: "+ ptn.getFaitFormPtnMeterEnd());
                    mPrinter.addNewLine();
                    mPrinter.printText("Volume: "+ ptn.getFaitFormPtnQuantityReceivedByMeter());
                    mPrinter.addNewLines(2);

                    mPrinter.setAlign(BluetoothPrinter.ALIGN_CENTER);
                    //mPrinter.setBold(true);
                    //mPrinter.printText("Tel. 0804765665 | Email. support@cl.com");
                    //mPrinter.printText(FOOTER);

                    mPrinter.addNewLines(4);

                    mPrinter.finish();
            }

            @Override
            public void onFailed() {
                Log.d("BluetoothPrinter", "Conection failed");
            }

        });
    }


    public static void printADI(BluetoothDevice mBtDevice, final PrintADI adi){


        final BluetoothPrinter mPrinter = new BluetoothPrinter(mBtDevice);


        mPrinter.connectPrinter(new BluetoothPrinter.PrinterConnectListener() {

            @Override
            public void onConnected() {
                    mPrinter.setAlign(BluetoothPrinter.ALIGN_CENTER);
                    //mPrinter.setBold(true);
                    mPrinter.printText(NAME.toUpperCase());
                    mPrinter.addNewLine();
                    //mPrinter.printText("Energy of Choice. Anywhere, Everywhere");
                    mPrinter.printText(HEADER);
                    //mPrinter.setBold(false);
                    mPrinter.addNewLines(1);
                    mPrinter.setAlign(BluetoothPrinter.ALIGN_LEFT);
                    mPrinter.printText("ADI No.: "+adi.getFaitFormAdiNo());
                    mPrinter.addNewLine();
                    mPrinter.printText("DATE: "+adi.getFaitFormAdiDate());
                    mPrinter.addNewLine();
                    mPrinter.printText("COMPANY BRANCH: "+adi.getFaitLocationsName());
                    mPrinter.addNewLine();
                    mPrinter.printText("SALES REP: "+adi.getFaitUsersFirstname()+ " "+ adi.getFaitUsersLastname());
                    mPrinter.addNewLine();
                    mPrinter.printText("LOCATION: "+adi.getFaitFormAdiLocation());
                    mPrinter.addNewLine();
                    mPrinter.printText("AIRLINE: "+adi.getFaitAssetsCustomerName());
                    mPrinter.addNewLine();
                    mPrinter.printText("AIRCRAFT TYPE: "+adi.getFaitFormAdiAircraftType());
                    mPrinter.addNewLine();
                    mPrinter.printText("AIRCRAFT NO.: "+adi.getFaitFormAdiAircraftNo());
                    mPrinter.addNewLine();
                    mPrinter.printText("METER START: "+adi.getFaitFormAdiMeterStart()+" LTRS");
                    mPrinter.addNewLine();
                    mPrinter.printText("METER END: "+adi.getFaitFormAdiMeterEnd()+ " LTRS");
                    mPrinter.addNewLine();
                    mPrinter.printText("VOLUME: "+adi.getFaitFormAdiVolumeSold());
                    mPrinter.addNewLine();
                    mPrinter.printText("AIRLINE REP: "+adi.getFaitFormAdiReceivingCustomerName());
                    mPrinter.addNewLines(2);
                    mPrinter.setAlign(BluetoothPrinter.ALIGN_CENTER);
                    //mPrinter.setBold(true);
                    //mPrinter.printText("Tel. 0804765665 | Email. support@cl.com");
                    mPrinter.printText(FOOTER);

                    mPrinter.addNewLines(4);
                    mPrinter.finish();
            }

            @Override
            public void onFailed() {
                Log.d("BluetoothPrinter", "Conection failed");
            }

        });
    }



    public static void printToDevice(BluetoothDevice mBtDevice, View view) {

        final Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());

        //Toast.makeText(view.getContext(), ""+ bitmap.getByteCount(), Toast.LENGTH_SHORT).show();

        view.draw(canvas);
        final Bitmap resized =
                Bitmap.createScaledBitmap(bitmap,(int)(bitmap.getWidth()*0.2), (int)(bitmap.getHeight()*0.2), true);
        Toast.makeText(view.getContext(), "width:"+ resized.getWidth()+" height:"+resized.getHeight()+ " bytes:"+resized.getByteCount(),
                Toast.LENGTH_SHORT).show();
        bitmap.recycle();

        final BluetoothPrinter mPrinter = new BluetoothPrinter(mBtDevice);


        mPrinter.connectPrinter(new BluetoothPrinter.PrinterConnectListener() {

            @Override
            public void onConnected() {
                mPrinter.setAlign(BluetoothPrinter.ALIGN_CENTER);
                mPrinter.printText("Hello World!");
                mPrinter.printImage(resized);
                mPrinter.addNewLine();
                mPrinter.addNewLine();
                mPrinter.addNewLine();
                mPrinter.addNewLine();
                mPrinter.addNewLine();
                mPrinter.addNewLine();

                mPrinter.finish();
            }

            @Override
            public void onFailed() {
                Log.d("BluetoothPrinter", "Conection failed");
            }

        });
    }

}
