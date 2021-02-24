package com.br.zup;

import java.util.ArrayList;
import java.util.List;

public class ServicoLivrosDoUsuario {
     private static List<LivroDoUsuario> livroDoUsuarios = new ArrayList<>();

     public static void cadastrarLivrosDoUsuario(Usuario usuario, List <Livro> livros ) throws Exception {
        LivroDoUsuario livroDoUsuario = new LivroDoUsuario(usuario);
         for (Livro livro: livros) {
             livroDoUsuario.getLivros().add(livro);
         }
         livroDoUsuarios.add(livroDoUsuario);
     }

     public static Livro removerLivroDoUsuario(Usuario usuario, String titulo ) throws Exception {
         LivroDoUsuario livroDoUsuario = null;
         Livro removido = null;
         for (LivroDoUsuario item : livroDoUsuarios) {
             if (item.getUsuario().getEmail().equalsIgnoreCase(usuario.getEmail())){
                 livroDoUsuario = item;
             }
         }
         if (livroDoUsuario != null){
             for (Livro livro : livroDoUsuario.getLivros()) {
                 if(livro.getTitulo().equalsIgnoreCase(titulo)){
                     removido = livro;
                 }
             }
             if(removido != null){
                 livroDoUsuario.getLivros().remove(removido);
                 return removido;
             }
             else{
                 throw new Exception("Livro não localizado");
             }
         }else{
             throw new Exception("Usuário não localizado");
         }
     }

     public static String listarLivroDoUsuario(Usuario usuario) throws Exception {
         String listaLivros = "";
         LivroDoUsuario livroDoUsuario = null;
         for (LivroDoUsuario item : livroDoUsuarios) {
             if (item.getUsuario().getEmail().equalsIgnoreCase(usuario.getEmail())){
                 livroDoUsuario = item;
             }
         }
         if (livroDoUsuario != null) {
             for (Livro livro: livroDoUsuario.getLivros()) {
                 listaLivros += livro.toString();
             }
             return listaLivros;
         } else {
             throw new Exception("Usuário não localizado!");
         }
     }
}
