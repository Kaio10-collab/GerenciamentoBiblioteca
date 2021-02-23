package com.br.zup;

public class Livro {

    private String autor;
    private String titulo;
    private String editora;
    private String categoria;
    private int exemplares;

    public Livro(String autor, String titulo, String editora, String categoria, int exemplares) {
        this.autor = autor;
        this.titulo = titulo;
        this.editora = editora;
        this.categoria = categoria;
        this.exemplares = exemplares;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getExemplares() {
        return exemplares;
    }

    public void setExemplares(int exemplares) {
        this.exemplares = exemplares;
    }

    @Override
    public String toString() {
        return "=======================================================" +
                "\nautor: " + autor +
                "\ntitulo: " + titulo +
                "\neditora: " + editora +
                "\ncategoria: " + categoria +
                "\nexemplares: " + exemplares +
                "\n======================================================\n";
    }
}