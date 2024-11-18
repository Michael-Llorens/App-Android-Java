package Adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bancomillba_v1.R;
import com.example.bancomillba_v1.pojo.Cuenta;

import java.util.ArrayList;

public class AccounsAdapter extends RecyclerView.Adapter<AccounsAdapter.CuentasViewHolder> implements View.OnClickListener {

    private ArrayList<Cuenta> listaCuentas;

    public AccounsAdapter(ArrayList<Cuenta> listaCuentas){
        this.listaCuentas = listaCuentas;
    }

    @NonNull
    @Override
    public AccounsAdapter.CuentasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Creamos una nueva vista
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_cuentas, null, false);

        // Para que cada ítem ocupe el match_parent
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);

        return new CuentasViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CuentasViewHolder holder, int position) {
        holder.asignarDatos(listaCuentas.get(position));

    }

    @Override
    public int getItemCount() {
        return listaCuentas.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class CuentasViewHolder extends RecyclerView.ViewHolder {

        TextView titulo, subtitulo;
        CardView cv_cuenta;

        public CuentasViewHolder(@NonNull View itemView) {
            super(itemView);

            cv_cuenta = itemView.findViewById(R.id.cvCuentas);
            titulo = itemView.findViewById(R.id.numCuenta);
            subtitulo = itemView.findViewById(R.id.saldoCuenta);
        }

        public void asignarDatos(Cuenta c) {

            titulo.setText(c.getBanco() + "-" + c.getSucursal() + "-" + c.getDc() + "-" + c.getNumeroCuenta());

            if (c.getSaldoActual() < 0){
                subtitulo.setTextColor(Color.RED);
            }else{
                subtitulo.setTextColor(Color.GREEN);
            }
            subtitulo.setText(Float.toString(c.getSaldoActual()));
        }
    }
}
