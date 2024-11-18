package com.example.youfitness.dialogo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.example.youfitness.R;

import java.text.SimpleDateFormat;

public class Dialogo extends DialogFragment {

    private final String gmail;

    public Dialogo(String gmail) {
        this.gmail = gmail;
    }

    public Dialog onCreateDialog(Bundle savedInstaceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        //Creamos las vistas i las recuperamos
        View v = inflater.inflate(R.layout.dialog_home, null);
        TextView tvTitul = v.findViewById(R.id.tituloPrincipal);
        TextView emailN = v.findViewById(R.id.emailNegro);
        TextView email = v.findViewById(R.id.emailDialogo);

        //Rellenamos los datos de dialogo_movimiento
        tvTitul.setText("Bienvenido");
        emailN.setText("Has iniciado sesión con el correo:");
        email.setText(String.valueOf(gmail));

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
