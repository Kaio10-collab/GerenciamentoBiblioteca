package com.br.zup;

/**
 * @author Grupo 1 - Equipe Kanaro
 */

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        while(biblioteca.isExecutar()) {
            try {
                biblioteca.executar();
            } catch (Exception e) {
                IO.output(e.getMessage());
            }
        }
    }
}
