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

    public static Livro cadastrarNovoLivro(String autor, String titulo, String editora, int exemplares, Categoria categoria){
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

    public static List<Livro> buscarLivroPorAutor(String autor) throws Exception {
        List<Livro>livrosPesquisados = new ArrayList<>();
        for (Livro livro: livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)){
                livrosPesquisados.add(livro);
            }
        }
        if (!livrosPesquisados.isEmpty()) {
            return livrosPesquisados;
        } else {
            throw new Exception("Nenhum livro foi localizado pelo autor " + autor);
        }
    }

    public static List<Livro> buscarLivroPorEditora(String editora) throws Exception {
        List<Livro>livrosPesquisados = new ArrayList<>();
        for (Livro livro: livros) {
            if (livro.getEditora().equalsIgnoreCase(editora)){
                livrosPesquisados.add(livro);
            }
        }
        if (!livrosPesquisados.isEmpty()) {
            return livrosPesquisados;
        } else {
            throw new Exception("Nenhum livro foi localizado com a editora  " + editora);
        }
    }

    public static List<Livro> pesquisarLivroPorCategoria(Categoria categoria) throws Exception {
        List<Livro> livrosPorCategoria = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getCategoria() == categoria) {
                livrosPorCategoria.add(livro);
            }
        }
        if (!livrosPorCategoria.isEmpty()) {
            return livrosPorCategoria;
        } else {
            throw new Exception("Nenhumm livro na biblioteca foi localizado com a categoria " + categoria);
        }
    }
}