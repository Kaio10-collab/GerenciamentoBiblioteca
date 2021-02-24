package com.br.zup;

import java.util.ArrayList;
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
    private ServicoLivrosDoUsuario servicoLivrosDoUsuario;

    public Biblioteca() {
        servicoLivros = new ServicoLivros();
        servicoUsuario = new ServicoUsuario();
        servicoLivrosDoUsuario = new ServicoLivrosDoUsuario();
    }

    private void menu (){
        IO.output("Opção 1: Cadastrar nome do livro\n" +
                "Opção 2: Listar os livros\n" +
                "Opção 3: Buscar o livro por autor\n" +
                "Opção 4: Buscar o livro por editora\n" +
                "Opção 5: Cadastrar Usuário\n" +
                "Opção 6: Cadastrar livros que o usuário deseja ler\n" +
                "Opção 7: Remover um livro da lista de desejos do usuário\n" +
                "Opção 8: Listar os livros da lista de desejos do usuário\n" +
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
            } else if (option == 6) {
                IO.output("Por favor, digite o email do usuário: ");
                Usuario usuario = servicoUsuario.pesquisarUsuarioPorEmail(IO.input().nextLine());
                List<Livro> livrosUsuario = new ArrayList<>();

                boolean executarCadastroLivros = true;
                while(executarCadastroLivros) {
                    IO.output("Por favor, digite o autor, título e categoria do livro");
                    livrosUsuario.add(
                            new Livro(IO.input().nextLine(), IO.input().nextLine(), IO.input().nextLine())
                    );
                    IO.output("Deseja adicionar mais um livro? (Sim/Nao)");
                    String resposta = IO.input().nextLine();
                    if (resposta.equalsIgnoreCase("nao")) {
                        executarCadastroLivros = false;
                    }
                }
                servicoLivrosDoUsuario.cadastrarLivrosDoUsuario(usuario, livrosUsuario);
            } else if (option == 7) {
                IO.output("Por favor, informar o e-mail do usuário e o título do livro:");
                Usuario usuario = servicoUsuario.pesquisarUsuarioPorEmail(IO.input().nextLine());
                Livro livroRemovido = servicoLivrosDoUsuario.removerLivroDoUsuario(usuario, IO.input().nextLine());
                IO.output("Livro removido: ");
                IO.output(livroRemovido.toString());
            } else if (option == 8) {
                IO.output("Por favor, digite o email do usuário");
                Usuario usuario = servicoUsuario.pesquisarUsuarioPorEmail(IO.input().nextLine());
                String livros = servicoLivrosDoUsuario.listarLivroDoUsuario(usuario);
                IO.output(livros);
            }
        }

    }
}
