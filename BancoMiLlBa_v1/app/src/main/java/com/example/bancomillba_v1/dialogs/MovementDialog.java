package com.example.bancomillba_v1.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.example.bancomillba_v1.R;
import com.example.bancomillba_v1.pojo.Movimiento;

import java.text.SimpleDateFormat;
import java.util.zip.Inflater;

public class MovementDialog extends DialogFragment {

    private Movimiento movimiento;

    public MovementDialog(Movimiento movimiento){
        this.movimiento = movimiento;
    }

    //preguntar


    public Dialog onCreateDialog(Bundle savedInstaceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        //Creamos las vistas i las recuperamos
        View v = inflater.inflate(R.layout.dialog_moviment,null);
        TextView tvTitul = v.findViewById(R.id.tituloPrincipal);
        TextView tvFrom = v.findViewById(R.id.dialogo_tv_from);
        TextView tvTo = v.findViewById(R.id.dialogo_tv_to);
        TextView tvAmount = v.findViewById(R.id.dialogo_tv_amount);
        TextView tvDate = v.findViewById(R.id.dialogo_tv_date);

        //Rellenamos los datos de dialogo_movimiento
        tvDate.setText(new SimpleDateFormat("dd-MM-yyyy").format(movimiento.getFechaOperacion()));
        tvTitul.setText(movimiento.getDescripcion());
        tvFrom.setText(movimiento.getCuentaOrigen().getNumeroCuenta());
        tvTo.setText(movimiento.getCuentaDestino().getNumeroCuenta());

        if (movimiento.getImporte()<0)
            tvAmount.setTextColor(Color.RED);
        else
            tvAmount.setTextColor(Color.GREEN);

        tvAmount.setText(String.valueOf(movimiento.getImporte()));

        //Aqui creamosos el dialogo
        builder.setView(v).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        return builder.create();

    }

}
