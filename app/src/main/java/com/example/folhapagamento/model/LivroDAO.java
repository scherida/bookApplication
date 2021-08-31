package com.example.folhapagamento.model;

import java.util.ArrayList;
import java.util.List;

public class LivroDAO {

    private static List<Livro> listaLivros = new ArrayList<>();

    public void salvar(Livro livro){
        listaLivros.add(livro);
    }

    public List<Livro> getListaLivros(){
        return listaLivros;
    }

    public void excluir(int p){
        listaLivros.remove(p);
    }

    public Livro getLivro(int p){
        return listaLivros.get(p);
    }
}
