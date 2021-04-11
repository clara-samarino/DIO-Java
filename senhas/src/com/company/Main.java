package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        String senha, senha2, senha3;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while ((senha = br.readLine()) != null){
            senha2 = senha;
            senha3 = senha;

            boolean tamanho = false;
            boolean numero = false;
            boolean maiuscula = false;
            boolean minuscula = false;
            boolean ncaracespecial = false;
            if (senha.length() > 5 && senha.length() < 33) {
                tamanho = true;
                if (!senha2.toLowerCase().equals(senha)) {
                    maiuscula = true;
                    if (!senha3.toUpperCase().equals(senha)) {
                        minuscula = true;
                        if (!senha.matches(".*\\s.*") && !senha.matches(".*\\W.*")) {
                            ncaracespecial = true;
                            if (senha.matches(".*[0-9].*")) {
                                numero = true;
                            }
                        }
                    }
                }
            }
            if (tamanho && numero && maiuscula && minuscula && ncaracespecial) {
                System.out.println("Senha valida.");
            } else {
                System.out.println("Senha invalida.");
            }
        }


    }
}
