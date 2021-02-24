package com.br.zup;

import java.util.ArrayList;
import java.util.List;

/**
* classe de serviços do usuário
* pode cadastrar e buscar o usuários
* */
public class ServicoUsuario {
    private static List<Usuario> usuarios = new ArrayList();

    public static Usuario cadastrarUsuario(String nome, String email)throws Exception{
        if (email.contains("@")){
            Usuario usuario = new Usuario(nome,email);
            usuarios.add(usuario);
            return usuario;
        } else {
            throw new Exception("email não é válido");
        }
    }

    public static Usuario pesquisarUsuarioPorEmail(String email) throws Exception {
        Usuario usuario = null;
        for (Usuario item : usuarios) {
            if (item.getEmail().equalsIgnoreCase(email)) {
                usuario = item;
            }
        }
        if (usuario != null) {
            return usuario;
        } else {
            throw new Exception("Usuário não localizado");
        }
    }
}