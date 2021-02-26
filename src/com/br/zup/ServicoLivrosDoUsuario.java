package com.br.zup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Classe para definir recomendação de livros para o usuário.
 * E também responsável por cadastrar e remover os livros do usuário que deseja lê.
 */
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
         LivroDoUsuario livroDoUsuario = null;
         for (LivroDoUsuario item : livroDoUsuarios) {
             if (item.getUsuario().getEmail().equalsIgnoreCase(usuario.getEmail())){
                 livroDoUsuario = item;
             }
         }
         if (livroDoUsuario != null) {
            return  gerarListaLivrosDoUsuario(livroDoUsuario.getLivros());
         } else {
             throw new Exception("Usuário não localizado!");
         }
     }

     private static String gerarListaLivrosDoUsuario(List<Livro> livros)  {
         String listaLivros = "";
         for (Livro livro: livros) {
             listaLivros += livro.toStringlivroDoUsuario();
         }
         return listaLivros;
     }

     public static List<Livro> recomendarLivroParaUsuario(Usuario usuario) throws Exception {
         List<Livro> livrosDoUsuario = null;
         for (LivroDoUsuario item : livroDoUsuarios) {
             if (item.getUsuario().getEmail().equalsIgnoreCase(usuario.getEmail())){
                 livrosDoUsuario = item.getLivros();
             }
         }
         List<Livro> backupLivroUsuario = new ArrayList<>();
         backupLivroUsuario.addAll(livrosDoUsuario);
         List<Livro> livroCategoriaDistintas = livrosDoUsuario
                 .stream()
                 .distinct()
                 .collect(Collectors.toList());
         HashMap<Categoria, Integer> rankingCategoria = gerarListaDeCategoriaARecomendar(livroCategoriaDistintas);
         calcularMaiorCategoria(rankingCategoria, livroCategoriaDistintas, livrosDoUsuario);
         livrosDoUsuario.clear();
         livrosDoUsuario.addAll(backupLivroUsuario);
         return ServicoLivro.pesquisarLivroPorCategoria(categoriaComMaiorRecorrencia(rankingCategoria));

     }
     private static Categoria categoriaComMaiorRecorrencia(HashMap<Categoria, Integer> rankingCategoria){
         int maiorNoRanking = 0;
         Categoria aMaiorCategoriaCadastradaPeloUsuario = null;
         for (Map.Entry<Categoria, Integer> categoriaARecomendar : rankingCategoria.entrySet()) {
             if (categoriaARecomendar.getValue() > maiorNoRanking) {
                 maiorNoRanking = categoriaARecomendar.getValue();
                 aMaiorCategoriaCadastradaPeloUsuario = categoriaARecomendar.getKey();
             }
         }
         return aMaiorCategoriaCadastradaPeloUsuario;
     }


     private static HashMap<Categoria, Integer> calcularMaiorCategoria(HashMap<Categoria, Integer> maiorCategoria, List <Livro> livros,  List<Livro> livrosDoUsuario ) {
         for (Livro livro : livros) {
             for (Livro livroTotal : livrosDoUsuario) {
                 if (livro.getCategoria() == livroTotal.getCategoria()) {
                     int valorRankingCategoria = maiorCategoria.get(livro.getCategoria()) + 1;
                     maiorCategoria.put(livro.getCategoria(), valorRankingCategoria);
                 }
             }
         }
         return maiorCategoria;
     }

     private static HashMap<Categoria, Integer> gerarListaDeCategoriaARecomendar(List <Livro> livros ){
         HashMap<Categoria, Integer> rankingCategoria = new HashMap<>();
         for (Livro livro : livros) {
             rankingCategoria.put(livro.getCategoria(), 0);
         }
         return rankingCategoria;
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
