package com.br.zup;

public class InformaçõesDoLivro {

    private String autor;
    private String título;
    private String editora;
    private String categoria;
    private int exemplares;

    public InformaçõesDoLivro(String autor, String título, String editora, String categoria, int exemplares) {
        this.autor = autor;
        this.título = título;
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

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String título) {
        this.título = título;
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
}