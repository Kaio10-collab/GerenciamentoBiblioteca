package com.br.zup;

import java.util.ArrayList;
import java.util.List;

public class ServicoLivros {

    private List<InformacoesDoLivro>livros = new ArrayList<>();

    public InformacoesDoLivro cadastrarNovoLivro(String autor, String titulo, String editora, int exemplares, String categoria){
        InformacoesDoLivro novoLivro;
        novoLivro = new InformacoesDoLivro( autor, titulo, editora, categoria, exemplares );
        livros.add(novoLivro);
        return novoLivro;
    }

    public String ListarTodosOsLivros() {
        String livroInformacao = "";
        for(InformacoesDoLivro livro : livros) {
            livroInformacao += livros.toString();
        }
        return livroInformacao;
    }

    public List<InformacoesDoLivro> buscarLivroPorAutor(String autor) {
        List<InformacoesDoLivro>livrosPesquisados = new ArrayList<>();
        for (InformacoesDoLivro livro: livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)){
                livrosPesquisados.add(livro);
            }
        }
        return livrosPesquisados;
    }

    public List<InformacoesDoLivro> buscarLivroPorEditora(String editora) {

    }


}
