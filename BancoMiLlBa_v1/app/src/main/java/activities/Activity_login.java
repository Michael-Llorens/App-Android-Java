package activities;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bancomillba_v1.R;
import com.example.bancomillba_v1.bd.MiBancoOperacional;
import com.example.bancomillba_v1.pojo.Cliente;

public class Activity_login extends AppCompatActivity {

    private Button btnEnviar, btnSalir;
    private EditText Usuario,contraseña;

    MiBancoOperacional bancoOperacional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnEnviar = findViewById(R.id.btnEntrar);
        btnSalir = findViewById(R.id.btnSalir);
        Usuario = (EditText)findViewById(R.id.Usuario);
        contraseña = findViewById(R.id.Password);

        //Se crea el objeto para poder conectarse a la base de datos
        bancoOperacional = MiBancoOperacional.getInstance(this);



        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cliente c = new Cliente();
                c.setNif(Usuario.getText().toString());
                c.setClaveSeguridad(contraseña.getText().toString());
                Cliente cAux = bancoOperacional.login(c);

                if (cAux == null){
                    Toast.makeText(Activity_login.this, "Error, cliente no registrado", Toast.LENGTH_SHORT).show();
                }else {
                    Intent inicio = new Intent(Activity_login.this, MainActivity.class);

                    Bundle enviarDatos = new Bundle();
                    enviarDatos.putSerializable("Cliente",cAux);

                    inicio.putExtras(enviarDatos);
                    startActivity(inicio);
                }

            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent salir = new Intent(Activity_login.this, WelcomeActivity.class);
                startActivity(salir);
            }
        });


    }


}