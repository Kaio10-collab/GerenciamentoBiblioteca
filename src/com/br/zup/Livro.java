package com.br.zup;

import java.util.Objects;

/**
 * modelo de dados dos livros da biblioteca
 *
 * */
public class Livro {

    private String autor;
    private String titulo;
    private String editora;
    private Categoria categoria;
    private int exemplares;

    public Livro() {
    }

    public Livro(String autor, String titulo, String editora, Categoria categoria, int exemplares) {
        this.autor = autor;
        this.titulo = titulo;
        this.editora = editora;
        this.categoria = categoria;
        this.exemplares = exemplares;
    }

    public Livro(String autor, String titulo, Categoria categoria) {
        this.autor = autor;
        this.titulo = titulo;
        this.categoria = categoria;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getExemplares() {
        return exemplares;
    }

    public void setExemplares(int exemplares) {
        this.exemplares = exemplares;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return categoria == livro.categoria;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoria);
    }

    @Override
    public String toString() {
        return "=======================================================" +
                "\nautor: " + autor +
                "\ntitulo: " + titulo +
                "\neditora: " + editora +
                "\ncategoria: " + categoria +
                "\nexemplares: " + exemplares +
                "\n=======================================================\n";
    }
}