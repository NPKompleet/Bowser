package com.npkompleet.phenomenon.bowser.forms;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.npkompleet.phenomenon.bowser.LoginActivity;
import com.npkompleet.phenomenon.bowser.R;
import com.npkompleet.phenomenon.bowser.bluetooth.BluetoothUtils;
import com.npkompleet.phenomenon.bowser.mvp.models.PrintADI;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListADIAdapter extends RecyclerView.Adapter<ListADIAdapter.FormViewHolder>{
    private Context context;
    private List<PrintADI> returnedForms;
    private FormClickHandler clickHandler;
    
    public ListADIAdapter(Context context, List<PrintADI> returnedForms, FormClickHandler clickHandler) {
            this.context = context;
            this.returnedForms = returnedForms;
            this.clickHandler = clickHandler;
            }
    
    
    public void swapData(List<PrintADI> newUsers){
            returnedForms.clear();
            returnedForms.addAll(newUsers);
            this.notifyDataSetChanged();
            }
    
    public void addData(List<PrintADI> moreUsers){
            returnedForms.addAll(moreUsers);
            this.notifyDataSetChanged();
            }
    
    
    @Override
    public ListADIAdapter.FormViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View item = LayoutInflater.from(context).inflate(R.layout.item_adi_list, parent, false);
            return new FormViewHolder(item);
            }
    
    //populate the viewholder
    @Override
    public void onBindViewHolder(final ListADIAdapter.FormViewHolder holder, int position) {
    
            final PrintADI form= returnedForms.get(position);
            holder.bowserFrom.setText(form.getFaitLocationsName()+ " " + form.getFaitAssetsStorageName()+ " >> "
                    + form.getFaitAssetsCustomerName() + " ("+form.getFaitFormAdiAircraftNo()+")");
            holder.amount.setText(form.getFaitFormAdiVolumeSold()+" LTRS");
            //holder.givenTo.setText(form.getFaitFormAdiAssetsCustomerSystemCode());
            holder.printer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    /*printADI(form, holder.printer);*/
                    clickHandler.onClickForm(form);
                }
            });
    
            /*Picasso.with(context).load(form.getPicture())
            .placeholder(R.drawable.ic_person_outline)
            .error(R.drawable.ic_person_outline)
            .into(holder.imageView);*/
    
            }
    
    @Override
    public int getItemCount() {
            return returnedForms.size();
            }
    
    
    public class FormViewHolder extends RecyclerView.ViewHolder implements ViewGroup.OnClickListener{
        @BindView(R.id.adi_list_bowserFrom)
        TextView bowserFrom;
    
        @BindView(R.id.adi_list_amount)
        TextView amount;
    
        @BindView(R.id.adi_list_print)
        ImageView printer;
    
    
        public FormViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }
    
        @Override
        public void onClick(View view) {
            int position= getAdapterPosition();
            clickHandler.onClickForm(returnedForms.get(position));
        }
    }
    
    public interface FormClickHandler{
        void onClickForm(PrintADI form);
    }

    public void printADI(final PrintADI adi, View view){
        BluetoothUtils.fetchAllDevice();
        PopupMenu printerPop= new PopupMenu(this.context, view);
        //Toast.makeText(LoginActivity.this, (""+BluetoothUtils.btList.size()), Toast.LENGTH_SHORT).show();

        for(int i=0; i<BluetoothUtils.btList.size(); i++ ) {
            printerPop.getMenu().add(BluetoothUtils.btList.get(i));
        }

        printerPop.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){

            @Override
            public boolean onMenuItemClick(MenuItem item) {
                //salesLocation.setText(item.getTitle());
                BluetoothUtils.printADI(BluetoothUtils.getDevice(item.getTitle().toString()), adi);
                return true;
            }
        });

        printerPop.show();
    }
}
