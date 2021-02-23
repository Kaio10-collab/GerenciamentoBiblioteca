package com.br.zup;

import java.util.Scanner;

/**
 * responsável por cuidar da entrada de dados (no teclado)
 * e saída de dados na tela
 * */
public class IO {

    public static Scanner input (){
        return new Scanner(System.in);
    }

    public static void output (String texto){
        System.out.println(texto);
    }
}
