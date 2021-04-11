package com.company;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String linha;
        String token;
        int quantidade;

        while(!(linha= br.readLine()).equals("0")){
            StringTokenizer st = new StringTokenizer(linha);

            if(st.hasMoreTokens()){
                token = st.nextToken();
                quantidade = Integer.parseInt(token);
                String[]array = new String[quantidade];
                for (int i=0; i<quantidade;i++){
                    array[i] = (br.readLine());
                }
                if(TipoConjunto(array)==true){
                    System.out.println("Conjunto Bom");
                }
                else {
                    System.out.println("Conjunto Ruim");
                }

            }

        }


    }
    public static boolean TipoConjunto(String[] arraypalavras){
        boolean conjbom = true;

        for(int i =0; i< arraypalavras.length;i++){
            for(int j =0; j< arraypalavras.length;j++){
                if(i!=j && arraypalavras[i].startsWith(arraypalavras[j])){
                    conjbom = false;
                }
            }
        }
        return conjbom;
    }

}