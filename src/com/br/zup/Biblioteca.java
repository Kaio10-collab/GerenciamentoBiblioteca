package com.br.zup;

import java.util.List;

public class Biblioteca {

    private boolean executar = true;
    private ServicoLivros servicoLivros;

    public Biblioteca() {
        servicoLivros = new ServicoLivros();
    }

    private void menu (){

        IO.output("Opção 1: Cadastrar nome do livro\n" +
                "Opção 2: Listar os livros\n" +
                "Opção 3: Buscar o livro por autor\n" +
                "Opção 4: Buscar o livro por editora\n" +
                "Opção 0: Sair do programa");
    }

    public void executar (){
        IO.output("Bem vindo a biblioteca!");
        while (executar){
            menu();
            int option = IO.input().nextInt();
            if(option == 1){
                IO.output("Por favor, forneça as seguintes informações: autor, título, editora, número de exemplares e categoria");
                Livro livro =  servicoLivros.cadastrarNovoLivro(
                        IO.input().nextLine(),
                        IO.input().nextLine(),
                        IO.input().nextLine(),
                        IO.input().nextInt(),
                        IO.input().nextLine()
                );
               IO.output("Livro foi cadastrado \n" + livro.toString());
            }
            else if (option == 2){
                IO.output(servicoLivros.ListarTodosOsLivros());
            }
            else if (option == 3){
                IO.output("Favor informar o nome do autor");
                String autor = IO.input().nextLine();
                List<Livro> livrosPorAutor = servicoLivros.buscarLivroPorAutor(autor);
                IO.output(livrosPorAutor.toString());
            }
            else if (option == 4){
                IO.output("Favor informar o nome da editora");
                String editora = IO.input().nextLine();
                List<Livro> livrosPorEditora = servicoLivros.buscarLivroPorEditora(editora);
                IO.output(livrosPorEditora.toString());
            }
            else if(option == 0){
                executar = false;
            }
        }

    }
}
