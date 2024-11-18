package com.example.bancomillba_v1.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bancomillba_v1.AtmListActivity;
import com.example.bancomillba_v1.R;
import com.example.bancomillba_v1.api.BancoDAO;

public class CajerosAdapter extends RecyclerView.Adapter<CajerosAdapter.ViewHolderDatos>  implements View.OnClickListener{

    private BancoDAO bancoDAO = null;
    private Cursor cursor = null;
    // Propiedad para el onClick
    private View.OnClickListener listener;

    public CajerosAdapter(Context context, Cursor cursor) {
        this.bancoDAO = new BancoDAO(context);
        this.bancoDAO.abrir();
        this.cursor = cursor;

    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.element_list_cajeros, null, false);

        // Para que cada ítem ocupe el match_parent
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        // Para realizar onClick
        view.setOnClickListener(this);


        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        cursor.moveToPosition(position);
        @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex("_id"));
        @SuppressLint("Range") String address = cursor.getString(cursor.getColumnIndex("address"));
        holder.asignarDatos(nombre,address);
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    // Para realizar onClick
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }


    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }


    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView tv_atm;
        TextView tv_addres;


        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            tv_atm = itemView.findViewById(R.id.atmCajero);
            tv_addres = itemView.findViewById(R.id.addressCajero);
        }

        public void asignarDatos(String atm, String address) {
            tv_atm.setText("ATM "+atm);
            tv_addres.setText(address);

        }

    }
}