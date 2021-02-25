package com.br.zup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
         return verificarRemocaoDoLivroDoUsuario(livroDoUsuario, removido, titulo);
     }

     private static Livro verificarRemocaoDoLivroDoUsuario(LivroDoUsuario livroDoUsuario, Livro removido, String titulo) throws Exception {
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

     public static List<Livro> recomendarLivroParaUsuario(Usuario usuario) {
         List<Livro> livrosDoUsuario = null;
         for (LivroDoUsuario item : livroDoUsuarios) {
             if (item.getUsuario().getEmail().equalsIgnoreCase(usuario.getEmail())){
                 livrosDoUsuario = item.getLivros();
             }
         }

         List<Livro> livroCategoriaDistintas = livrosDoUsuario
                 .stream()
                 .distinct()
                 .collect(Collectors.toList());
         HashMap<Categoria, Integer> rankingCategoria = new HashMap<>();

         for (Livro livro : livroCategoriaDistintas) {
             rankingCategoria.put(livro.getCategoria(), 0);
         }

         for (Livro livro : livroCategoriaDistintas) {
             for (Livro livroTotal : livrosDoUsuario) {
                 if (livro.getCategoria() == livroTotal.getCategoria()) {
                     int valorRankingCategoria = rankingCategoria.get(livro.getCategoria()) + 1;
                     rankingCategoria.put(livro.getCategoria(), valorRankingCategoria);
                 }
             }
         }

         int maiorNoRanking = 0;
         Categoria aMaiorCategoriaCadastradaPeloUsuario = null;
         for (Map.Entry<Categoria, Integer> categoriaARecomendar : rankingCategoria.entrySet()) {
            if (categoriaARecomendar.getValue() > maiorNoRanking) {
                maiorNoRanking = categoriaARecomendar.getValue();
                aMaiorCategoriaCadastradaPeloUsuario = categoriaARecomendar.getKey();
            }
         }

         return ServicoLivro.pesquisarLivroPorCategoria(aMaiorCategoriaCadastradaPeloUsuario);

     }

     public static int numeroDeLivroDoUsuario(Usuario usuario) throws Exception {
         for(LivroDoUsuario livroDoUsuario : livroDoUsuarios) {
             if (livroDoUsuario.getUsuario().equals(usuario)) {
                 return livroDoUsuario.getLivros().size();
             }
         }
         throw new Exception("Usuário não possui livros cadastrados!");
     }
}
