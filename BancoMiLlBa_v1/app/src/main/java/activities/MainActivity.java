package activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.bancomillba_v1.R;
import com.example.bancomillba_v1.bd.MiBancoOperacional;
import com.example.bancomillba_v1.pojo.Cliente;

public class MainActivity extends AppCompatActivity {

    private TextView bienvenida;
    private Button btnSalirInicio,btnCambiarContraseña,btnTransferencias,btnMovimientos,btnPosicion;

    MiBancoOperacional bancoOperacional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bienvenida = findViewById(R.id.bienvenida);
        btnSalirInicio = findViewById(R.id.btnSalirInicio);
        btnCambiarContraseña = findViewById(R.id.btnCambiarContraseña);
        btnTransferencias = findViewById(R.id.btnTransferencias);
        btnMovimientos = findViewById(R.id.btnMovimientos);
        btnPosicion = findViewById(R.id.btnPosicion);

        bancoOperacional = MiBancoOperacional.getInstance(this);

        Bundle recibirrDatos = getIntent().getExtras();
        Cliente info = (Cliente) recibirrDatos.getSerializable("Cliente");

        Cliente cAux = bancoOperacional.login(info);

        bienvenida.setText(bienvenida.getText()+" "+info.getNombre());

        btnSalirInicio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent login = new Intent(MainActivity.this, WelcomeActivity.class);
                startActivity(login);
            }

        });

        btnCambiarContraseña.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent login = new Intent(MainActivity.this, ChangePassActivity.class);

                Bundle enviarDatos = new Bundle();
                enviarDatos.putSerializable("Cliente",info);

                login.putExtras(enviarDatos);

                startActivity(login);
            }

        });

        btnTransferencias.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent login = new Intent(MainActivity.this, TransferActivity.class);
                startActivity(login);
            }

        });

        btnPosicion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent login = new Intent(MainActivity.this, GlobalPositionActivity.class);
                Bundle enviarDatos = new Bundle();
                enviarDatos.putSerializable("Cliente",cAux);

                login.putExtras(enviarDatos);
                startActivity(login);
            }
        });

        btnMovimientos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent login = new Intent(MainActivity.this, MovementsActivity.class);

                Bundle enviarDatos = new Bundle();
                enviarDatos.putSerializable("Cliente",cAux);
                login.putExtras(enviarDatos);

                startActivity(login);
            }
        });
    }
}