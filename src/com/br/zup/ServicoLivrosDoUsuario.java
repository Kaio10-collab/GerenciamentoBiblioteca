package com.br.zup;

import java.util.ArrayList;
import java.util.List;

public class ServicoLivrosDoUsuario {
     private List<LivroDoUsuario> livroDoUsuarios = new ArrayList<>();

     public void cadastrarLivrosDoUsuario(Usuario usuario, List <Livro> livros ){
        LivroDoUsuario livroDoUsuario = new LivroDoUsuario(usuario);
         for (Livro livro: livros) {
             livroDoUsuario.getLivros().add(livro);
         }
         livroDoUsuarios.add(livroDoUsuario);
     }


}
