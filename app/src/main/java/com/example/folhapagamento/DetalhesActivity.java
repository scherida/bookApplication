package com.example.folhapagamento;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.folhapagamento.model.Livro;
import com.example.folhapagamento.model.LivroDAO;

public class DetalhesActivity extends AppCompatActivity {

    TextView tvTitulo;
    TextView tvAutor;
    TextView tvAno;
    LivroDAO dao;
    Button bExcluir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        tvTitulo = findViewById(R.id.tvTitulo);
        tvAutor = findViewById(R.id.tvAutor);
        tvAno = findViewById(R.id.tvAno);
        bExcluir = findViewById(R.id.bExcluir);

        dao = new LivroDAO();

        Intent intent = getIntent(); // recebe a intent de outra activity

        // tenta armazenar o valor inteiro chamado 'position' da intent recebida
        int position = intent.getIntExtra("position", -1);

        // verificar se o valor recebido não é válido (-1)
        if(position == -1) { finish(); } // se for -1, matamos a activity atual para para previnir erros

        // se não for -1, então vou receber da lista de livros o livro que está na posição indicada
        Livro livro = dao.getLivro(position);

        // setar dados do livro recebido para os text views
        tvTitulo.setText(livro.getTitulo());
        tvAutor.setText(livro.getAutor());
        tvAno.setText("Ano de publicação: " + livro.getAno());

        bExcluir.setOnClickListener(v ->{

            // caixa de diálogo para confirmar exclusão de livro
            new AlertDialog.Builder(this)
                    .setTitle("Excluir Livro")
                    .setMessage("Tem certeza que deseja excluir este livro?")
                    .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dao.excluir(position);
                            finish();
                        }
                    }).setNegativeButton("Não", null).show();
        });


    }
}