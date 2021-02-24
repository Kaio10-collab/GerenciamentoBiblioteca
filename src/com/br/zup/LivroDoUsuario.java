package com.br.zup;

import java.util.ArrayList;
import java.util.List;

public class LivroDoUsuario {

    private Usuario usuario;
    private List<Livro> livros = new ArrayList<>();

    public LivroDoUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
