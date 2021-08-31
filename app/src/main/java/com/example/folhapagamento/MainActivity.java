package com.example.folhapagamento;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.folhapagamento.model.LivroDAO;

public class MainActivity extends AppCompatActivity {

    ListView lvLivros;
    Button bNovo;

    LivroDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvLivros = findViewById(R.id.lvLivros);
        bNovo = findViewById(R.id.bNovo);

        dao = new LivroDAO();

        bNovo.setOnClickListener(v -> {

            startActivity(new Intent(this, CadastroActivity.class));

        });

        // setar ação de clique nos itens da lista
        lvLivros.setOnItemClickListener((parent, view, position, id) -> {

            Intent intent = new Intent(this, DetalhesActivity.class);
            intent.putExtra("position", position);

            startActivity(intent);

        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        lvLivros.setAdapter(new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                dao.getListaLivros()
        ));

    }
}