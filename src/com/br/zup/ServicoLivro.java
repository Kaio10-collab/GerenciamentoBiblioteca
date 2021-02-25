package com.br.zup;

import java.util.ArrayList;
import java.util.List;


/**
 * responsável por operações de dados dos livros
 * - cadastrar um livro
 * - buscar livro por autor ou editora
 * - listar os livros
 * */
public class ServicoLivro {

    private static List<Livro>livros = new ArrayList<>();

    public static Livro cadastrarNovoLivro(String autor, String titulo, String editora, int exemplares, String categoria){
        Livro novoLivro;
        novoLivro = new Livro( autor, titulo, editora, categoria, exemplares );
        livros.add(novoLivro);
        return novoLivro;
    }

    /**
     * concatena os livros em um único texto
     * para que seja visualizado na tela
     * @return String
     * */
    public static String ListarTodosOsLivros() {
        String livroInformacao = "";
        for(Livro livro : livros) {
            livroInformacao += livro.toString();
        }
        return livroInformacao;
    }

    public static List<Livro> buscarLivroPorAutor(String autor) {
        List<Livro>livrosPesquisados = new ArrayList<>();
        for (Livro livro: livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)){
                livrosPesquisados.add(livro);
            }
        }
        return livrosPesquisados;
    }

    public static List<Livro> buscarLivroPorEditora(String editora) {
        List<Livro>livrosPesquisados = new ArrayList<>();
        for (Livro livro: livros) {
            if (livro.getEditora().equalsIgnoreCase(editora)){
                livrosPesquisados.add(livro);
            }
        }
        return livrosPesquisados;
    }
}