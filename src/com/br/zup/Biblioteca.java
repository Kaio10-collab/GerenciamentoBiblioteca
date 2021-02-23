package com.br.zup;

public class Biblioteca {

    private boolean executar = true;
    private ServicoLivros servicoLivros;

    public Biblioteca() {
        servicoLivros = new ServicoLivros();
    }

    private void menu (){
        IO.output("Bem vindo a biblioteca!");
        IO.output("Opção 1: cadastrar nome do livro\n" +
                "Opção 2: listar os livros\n" +
                "Opção 3: buscar o livro por autor\n" +
                "Opção 4: buscar o livro por editora ");
    }
}
