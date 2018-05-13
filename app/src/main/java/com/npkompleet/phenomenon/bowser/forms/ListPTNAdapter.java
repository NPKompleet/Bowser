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

import com.npkompleet.phenomenon.bowser.R;
import com.npkompleet.phenomenon.bowser.bluetooth.BluetoothUtils;
import com.npkompleet.phenomenon.bowser.mvp.models.PrintPTN;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListPTNAdapter extends RecyclerView.Adapter<ListPTNAdapter.FormViewHolder>{
    private Context context;
    private List<PrintPTN> returnedForms;
    private FormClickHandler clickHandler;

    public ListPTNAdapter(Context context, List<PrintPTN> returnedForms, FormClickHandler clickHandler) {
        this.context = context;
        this.returnedForms = returnedForms;
        this.clickHandler = clickHandler;
    }


    public void swapData(List<PrintPTN> newUsers){
        returnedForms.clear();
        returnedForms.addAll(newUsers);
        this.notifyDataSetChanged();
    }

    public void addData(List<PrintPTN> moreUsers){
        returnedForms.addAll(moreUsers);
        this.notifyDataSetChanged();
    }


    @Override
    public ListPTNAdapter.FormViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(context).inflate(R.layout.item_ptn_list, parent, false);
        return new FormViewHolder(item);
    }

    //populate the viewholder
    @Override
    public void onBindViewHolder(final ListPTNAdapter.FormViewHolder holder, int position) {

        final PrintPTN form= returnedForms.get(position);
        holder.bowserFrom.setText(form.getFaitFormPtnTransporter()+"("+ form.getFaitFormPtnTruckNo() +")" +
                        " >> "+ form.getFaitAssetsStorageName());
        holder.amount.setText(form.getFaitFormPtnQuantity()+" LTRS");
        holder.printer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*printPTN(form, holder.printer);*/
                clickHandler.onClickPrint(form);
            }
        });

       /* holder.quality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                *//*printPTN(form, holder.printer);*//*
                clickHandler.onClickQuality(form);
            }
        });*/
    
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
        @BindView(R.id.ptn_list_bowserFrom)
        TextView bowserFrom;

        @BindView(R.id.ptn_list_amount)
        TextView amount;

        @BindView(R.id.ptn_list_print)
        ImageView printer;

        /*@BindView(R.id.ptn_list_quality)
        ImageView quality;*/


        public FormViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            /*int position= getAdapterPosition();
            clickHandler.onClickForm(returnedForms.get(position));*/
        }
    }

    public interface FormClickHandler{
        void onClickPrint(PrintPTN form);
        void onClickQuality(PrintPTN form);
    }

    public void printPTN(final PrintPTN ptn, View view){
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
                BluetoothUtils.printPTN(BluetoothUtils.getDevice(item.getTitle().toString()), ptn);
                return true;
            }
        });

        printerPop.show();
    }
}

