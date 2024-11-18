package activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import com.example.bancomillba_v1.R;

public class WelcomeActivity extends AppCompatActivity {

    private Button btnBienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        btnBienvenida = findViewById(R.id.Entrar);

        btnBienvenida.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent login = new Intent(WelcomeActivity.this, Activity_login.class);
                startActivity(login);
            }

        });
    }
}