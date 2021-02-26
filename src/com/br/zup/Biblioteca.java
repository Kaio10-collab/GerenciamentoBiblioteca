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

    private void menu (){
        IO.output("\u27A4 1: Cadastrar um novo livro na biblioteca \t\t\t" +
                "\u27A4 2: Listar os livros da biblioteca\n" +
                "\u27A4 3: Buscar o livro por autor da biblioteca \t\t\t" +
                "\u27A4 4: Buscar o livro por editora da biblioteca\n" +
                "\u27A4 5: Cadastrar novo Usuário \t\t\t\t\t\t\t" +
                "\u27A4 6: Cadastrar livros que o usuário deseja ler\n" +
                "\u27A4 7: Remover um livro da lista de desejos do usuário\t" +
                "\u27A4 8: Listar os livros da lista de desejos do usuário\n" +
                "\u27A4 9: Recomendar livros para o usuário\t\t\t\t\t" +
                "\u27A4 10: Total de livros cadastros do usuário\n" +
                "\u27A4 0: Sair do programa");
    }

    public void executar () throws Exception {
        IO.output(" \t \uD83D\uDCD6 \u2730 \u2730 \u2730 \u2730 \u2730 Bem-vindo a biblioteca! \u2730 \u2730 \u2730 \u2730 \u2730  \uD83D\uDCD6 \n");
        while (executar) {
            menu();
            int option = IO.input().nextInt();
            if (option == 1) {
                IO.output("Por favor, forneça as seguintes informações: autor, título, editora, número de exemplares e categoria");
                Livro livro =  ServicoLivro.cadastrarNovoLivro(
                        IO.input().nextLine(),
                        IO.input().nextLine(),
                        IO.input().nextLine(),
                        IO.input().nextInt(),
                        getCategoriaLivro(IO.input().nextLine())
                );
               IO.output("Livro foi cadastrado \n" + livro.toString());
            } else if (option == 2){
                IO.output(ServicoLivro.ListarTodosOsLivros());
            } else if (option == 3){
                IO.output("Favor informar o nome do autor");
                List<Livro> livrosPorAutor = ServicoLivro.buscarLivroPorAutor(IO.input().nextLine());
                IO.output(livrosPorAutor.toString());
            } else if (option == 4){
                IO.output("Favor informar o nome da editora");
                List<Livro> livrosPorEditora = ServicoLivro.buscarLivroPorEditora(IO.input().nextLine());
                IO.output(livrosPorEditora.toString());
            } else if(option == 0){
                executar = false;
            } else if (option == 5) {
                IO.output("Por favor, digite um nome e um e-mail: ");
                Usuario usuario = ServicoUsuario.cadastrarUsuario(
                        IO.input().nextLine(),
                        IO.input().nextLine()
                );
                IO.output("\u2713 Usuário cadastro!");
                IO.output(usuario.toString());
            } else if (option == 6) {
                IO.output("Por favor, digite o email do usuário: ");
                Usuario usuario = ServicoUsuario.pesquisarUsuarioPorEmail(IO.input().nextLine());
                List<Livro> livrosUsuario = new ArrayList<>();
                adicionarLivroNaListaDoUsuario(livrosUsuario);
                ServicoLivrosDoUsuario.cadastrarLivrosDoUsuario(usuario, livrosUsuario);
            } else if (option == 7) {
                IO.output("Por favor, informar o e-mail do usuário e o título do livro:");
                Usuario usuario = ServicoUsuario.pesquisarUsuarioPorEmail(IO.input().nextLine());
                Livro livroRemovido = ServicoLivrosDoUsuario.removerLivroDoUsuario(usuario, IO.input().nextLine());
                IO.output("Livro removido: ");
                IO.output(livroRemovido.toString());
            } else if (option == 8) {
                IO.output("Por favor, digite o email do usuário");
                Usuario usuario = ServicoUsuario.pesquisarUsuarioPorEmail(IO.input().nextLine());
                String livros = ServicoLivrosDoUsuario.listarLivroDoUsuario(usuario);
                IO.output(livros);
            } else if (option == 9) {
                IO.output("Qual o seu email, por gentileza? ");
                Usuario usuario = ServicoUsuario.pesquisarUsuarioPorEmail(IO.input().nextLine());
                List<Livro> livros = ServicoLivrosDoUsuario.recomendarLivroParaUsuario(usuario);
                for (Livro livro : livros) {
                    IO.output(livro.toString());
                }
            } else if (option == 10) {
                IO.output("Qual o seu email, por gentileza? ");
                Usuario usuario = ServicoUsuario.pesquisarUsuarioPorEmail(IO.input().nextLine());
                IO.output("Total de livros do usuário ");
                IO.output(usuario.toString());
                IO.output("Total: " + ServicoLivrosDoUsuario.numeroDeLivroDoUsuario(usuario));

            }
        }

    }

    private void adicionarLivroNaListaDoUsuario(List<Livro> livrosUsuario) {
        boolean executarCadastroLivros = true;
        while(executarCadastroLivros) {
            IO.output("Por favor, digite o autor, título e categoria do livro");
            livrosUsuario.add(
                    new Livro(IO.input().nextLine(), IO.input().nextLine(), getCategoriaLivro(IO.input().nextLine()))
            );
            IO.output("Deseja adicionar mais um livro? (Sim/Nao)");
            String resposta = IO.input().nextLine();
            if (resposta.equalsIgnoreCase("nao")) {
                executarCadastroLivros = false;
            }
        }
    }

    private Categoria getCategoriaLivro(String categoria) {
        if (categoria.equalsIgnoreCase("ROMANCE")) {
            return Categoria.ROMANCE;
        } else if (categoria.equalsIgnoreCase("FICCAO_CIENTIFICA")) {
            return Categoria.FICCAO_CIENTIFICA;
        } else if (categoria.equalsIgnoreCase("TI")) {
            return Categoria.TI;
        } else if (categoria.equalsIgnoreCase("ACAO")) {
            return Categoria.ACAO;
        } else if (categoria.equalsIgnoreCase("COMEDIA")) {
            return Categoria.COMEDIA;
        } else if (categoria.equalsIgnoreCase("ARTE")) {
            return Categoria.ARTE;
        } else if (categoria.equalsIgnoreCase("BIOGRAFIA")) {
            return Categoria.BIOGRAFIA;
        } else if (categoria.equalsIgnoreCase("CLASSICO")) {
            return Categoria.CLASSICO;
        } else {
            return Categoria.OUTROS;
        }
    }

    public boolean isExecutar() {
        return executar;
    }
}
