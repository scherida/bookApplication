package com.example.folhapagamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lvLivos;
    Button bNovo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvLivos = findViewById(R.id.lvLivros);
        bNovo = findViewById(R.id.bNovo);

        bNovo.setOnClickListener(view -> {
            startActivity(new Intent(this, CadastroActivity.class));
        });
    }
}