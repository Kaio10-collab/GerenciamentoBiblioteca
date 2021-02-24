package com.br.zup;

import java.util.ArrayList;
import java.util.List;

public class ServicoUsuario {
    private List<Usuario> usuarios = new ArrayList();

    public Usuario cadastrarUsuario(String nome, String email)throws Exception{
        if (email.contains("@")){
            Usuario usuario = new Usuario(nome,email);
            usuarios.add(usuario);
            return usuario;
        } else {
            throw new Exception("email não é válido");
        }
    }

    public Usuario pesquisarUsuarioPorEmail(String email) throws Exception {
        Usuario usuario = null;
        for (Usuario item : usuarios) {
            if (item.getEmail().equalsIgnoreCase(email)) {
                usuario = item;
            }
        }
        if (usuario != null) {
            return usuario;
        } else {
            throw new Exception("Usuário não localizado, portanto, não será possível cadastrar livros!");
        }
    }
}
//Cadastrar um novo usuáiro:
//nome, e-mail