package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        multiplicacaoSimples();
        menorEposicao();
        numerosImpares();
    }

    public static void multiplicacaoSimples() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int b = Integer.parseInt(st.nextToken());
        int total = a * b; // Altere o valor da variável com o cálculo esperado
        System.out.println("PROD = " + total);
    }

    public static void menorEposicao() throws IOException {
        Scanner leitor = new Scanner(System.in);
        int N = leitor.nextInt();
        int[] X = new int[N];
        int menor = 0, posMenor = 0;
        for (int i = 0; i < N; i++) {
            X[i] = leitor.nextInt();
            if (i == 0) {
                menor = X[i];
                posMenor = i;
            } else if (X[i] < menor) {
                menor = X[i];
                posMenor = i;
            }
        }
        System.out.println("Menor valor: " + menor);
        System.out.println("Posicao: " + posMenor);

    }

    public static void numerosImpares() {
        Scanner entrada = new Scanner(System.in);
        int num = entrada.nextInt();
        for(int i = 1; i <= num; i = i +2){
            System.out.println(i);

        }

    }
}

