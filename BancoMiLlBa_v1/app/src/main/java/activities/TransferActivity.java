package activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.bancomillba_v1.R;

public class TransferActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner opcionCuenta;
    private Spinner opcionCuenta2;
    private  Spinner selecMoneda;
    private View contenedorSnniper;
    private View contenedorCuentaNueva;
    private Button btnEnviar;
    private Button btnCancelar;
    private String tipo;
    private String cuentaSelect;
    private EditText c;
    private EditText cant;
    private String cantidad;

    final String[] opcion = new  String[] {"€","$"};
    final String[] datos = new String[] {"ES60-2100-0418-40-1234567891","ES25-2100-0418-40-1234567891","ES97-2100-0418-40-1234567891","ES08-2100-0418-40-1234567891"};
    final String[] datos2 = new String[] {"ES60-2100-0418-40-1234567891","ES25-2100-0418-40-1234567891","ES97-2100-0418-40-1234567891","ES08-2100-0418-40-1234567891"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        opcionCuenta = findViewById(R.id.opcionCuenta);
        opcionCuenta2 = findViewById(R.id.opcionCuenta2);
        selecMoneda = findViewById(R.id.moneda);
        contenedorSnniper = findViewById(R.id.cuentaProp);
        contenedorCuentaNueva = findViewById(R.id.cuentaAje);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnCancelar = findViewById(R.id.btnCancelar);
        cant = findViewById(R.id.cantidad);
        c = findViewById(R.id.cuentaNueva);


        cantidad = String.valueOf(cant.getText());

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos2);
        adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opcion);
        adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        opcionCuenta.setAdapter(adaptador);
        opcionCuenta2.setAdapter(adaptador1);
        selecMoneda.setAdapter(adaptador2);

        btnEnviar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"Cuenta origen:\n"+
                        opcionCuenta.getSelectedItem().toString()+"\nA "+tipo+"\n"+
                        cuentaSelect+"\nImporte: "+cantidad+selecMoneda.getSelectedItem().
                        toString(), Toast.LENGTH_SHORT).show();

                onBackPressed();
            }

        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent login = new Intent(TransferActivity.this, TransferActivity.class);
                startActivity(login);
            }

        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onRadioButtonCliked(View view) {

        boolean marcado = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.propia:
                if (marcado) {
                    mostrarParticular(false);
                    tipo = "Cuenta propia:";
                    cuentaSelect = opcionCuenta2.getSelectedItem().toString();
                }
                break;

            case R.id.ajena:
                if (marcado) {
                    mostrarParticular(true);
                    tipo = "Cuenta ajena:";
                    cuentaSelect = c.getText().toString();
                }
                break;
        }
    }

    private void mostrarParticular(boolean b) {
        contenedorCuentaNueva.setVisibility(b ? View.VISIBLE : View.GONE);
        contenedorSnniper.setVisibility(b ? View.GONE : View.VISIBLE);
    }

}
