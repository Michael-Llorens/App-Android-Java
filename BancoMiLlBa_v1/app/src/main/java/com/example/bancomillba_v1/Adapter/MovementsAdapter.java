package com.example.bancomillba_v1.Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bancomillba_v1.R;
import com.example.bancomillba_v1.pojo.Movimiento;

import java.util.ArrayList;

public class MovementsAdapter extends RecyclerView.Adapter<MovementsAdapter.MovementsViewHolder> implements View.OnClickListener{

    private ArrayList<Movimiento> listaMovimientos;

    private View.OnClickListener listener;

    public MovementsAdapter(ArrayList<Movimiento> listaMovimientos) {
        this.listaMovimientos = listaMovimientos;
    }

    @NonNull
    @Override
    public MovementsAdapter.MovementsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Creamos una nueva vista
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_ingresos, null, false);

        //Para realizar el OncLickx
        view.setOnClickListener(this);

        // Para que cada ítem ocupe el match_parent
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);

        return new MovementsAdapter.MovementsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovementsAdapter.MovementsViewHolder holder, int position) {
        holder.asignarDatos(listaMovimientos.get(position));
    }

    @Override
    public int getItemCount() {

        return listaMovimientos.size();
    }

    //Creamos el seter el OnClickListener
    public void setOnclickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v);
        }
    }

    public class MovementsViewHolder extends RecyclerView.ViewHolder {

        TextView titulo, subtitulo;
        CardView cv_cuenta;

        public MovementsViewHolder(@NonNull View itemView) {
            super(itemView);

            cv_cuenta = itemView.findViewById(R.id.cvIngresos);
            titulo = itemView.findViewById(R.id.titulo);
            subtitulo = itemView.findViewById(R.id.subtitulo);
        }

        public void asignarDatos(Movimiento movimiento) {

            titulo.setText(movimiento.getDescripcion());

            if (movimiento.getImporte() < 0){
                subtitulo.setTextColor(Color.RED);
            }else{
                subtitulo.setTextColor(Color.GREEN);
            }
            subtitulo.setText(Float.toString(movimiento.getImporte()));

        }
    }
}
