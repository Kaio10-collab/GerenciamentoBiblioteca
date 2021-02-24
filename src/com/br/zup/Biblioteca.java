package com.br.zup;

import java.util.List;

/**
 * objeto responsável por executar o programa
 * - listar o menu ao usuário
 * - obter dados do usuário
 * - apresentar os resultados ao usuário
 *
 * */
public class Biblioteca {

    private boolean executar = true;
    private ServicoLivros servicoLivros;
    private ServicoUsuario servicoUsuario;

    public Biblioteca() {
        servicoLivros = new ServicoLivros();
        servicoUsuario = new ServicoUsuario();
    }

    private void menu (){
        IO.output("Opção 1: Cadastrar nome do livro\n" +
                "Opção 2: Listar os livros\n" +
                "Opção 3: Buscar o livro por autor\n" +
                "Opção 4: Buscar o livro por editora\n" +
                "Opção 5: Cadastrar Usuário\n" +
                "Opção 0: Sair do programa");
    }

    public void executar () throws Exception {
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
                List<Livro> livrosPorAutor = servicoLivros.buscarLivroPorAutor(IO.input().nextLine());
                IO.output(livrosPorAutor.toString());
            }
            else if (option == 4){
                IO.output("Favor informar o nome da editora");
                List<Livro> livrosPorEditora = servicoLivros.buscarLivroPorEditora(IO.input().nextLine());
                IO.output(livrosPorEditora.toString());
            }else if(option == 0){
                executar = false;
            } else if (option == 5) {
                IO.output("Por favor, digite um nome e um e-mail: ");
                Usuario usuario = servicoUsuario.cadastrarUsuario(
                        IO.input().nextLine(),
                        IO.input().nextLine()
                );
                IO.output("Usuário cadastro!");
                IO.output(usuario.toString());
            }
        }

    }
}
