package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<Character, String> mapa = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String texto;
        while (!".".equals((texto = br.readLine().trim().toLowerCase()))){
            StringTokenizer st = new StringTokenizer(texto);
            StringTokenizer st2 = new StringTokenizer(texto);
            mapa = MapaMaioresPalavras(st);
            StringBuilder buffer = TextoModificado(mapa, st2);
            System.out.println(buffer);
            System.out.println(mapa.size());
            Stream<Map.Entry<Character, String>> sorted = mapa.entrySet().stream().sorted(Map.Entry.comparingByKey());
            sorted.forEach((entrada)->{ System.out.println(entrada.getKey()+". = "+entrada.getValue()); });
        }



    }
    public static Map MapaMaioresPalavras(StringTokenizer st){

        Map<String, Integer> mapavariaveis = new TreeMap<>();
        Map<Character, Integer> mapaOrdenado = new TreeMap<>();
        Map<Character, String> mapa2 = new TreeMap<>();
        String token;


        while (st.hasMoreTokens()){
            int quantidadeCaracter;
            token = st.nextToken();

            if(token.length()>2){
                if(token.endsWith(".") && token.length()>3){
                    token = token.replace(".","");
                    if(mapavariaveis.containsKey(token)){
                        quantidadeCaracter = mapavariaveis.get(token) + (token.length()-2);
                        mapavariaveis.put(token,quantidadeCaracter);
                        break;
                    }
                    else {
                        quantidadeCaracter = token.length()-2;
                        mapavariaveis.put(token, quantidadeCaracter);
                        break;
                    }
                }
                else if(mapavariaveis.containsKey(token)){
                    quantidadeCaracter = mapavariaveis.get(token) + (token.length()-2);
                    mapavariaveis.put(token,quantidadeCaracter);
                }
                else {
                    quantidadeCaracter = token.length()-2;
                    mapavariaveis.put(token, quantidadeCaracter);
                }
            }
        }


        mapavariaveis.entrySet().stream().forEach((entrada)->{

            if(mapa2.containsKey(entrada.getKey().charAt(0)))
            {
                if(mapaOrdenado.get(entrada.getKey().charAt(0))<entrada.getValue()){
                    mapa2.put(entrada.getKey().charAt(0), entrada.getKey());
                    mapaOrdenado.put(entrada.getKey().charAt(0), entrada.getValue());
                }
            }
            else{
                mapa2.put(entrada.getKey().charAt(0), entrada.getKey());
                mapaOrdenado.put(entrada.getKey().charAt(0), entrada.getValue());
            }
            //mapa2.put(entrada.getKey().charAt(0), entrada.getKey());
            //System.out.println(entrada.getKey());
        });
        return  mapa2;

    }
    public static StringBuilder TextoModificado(Map mapa, StringTokenizer st){

        String token, string2;
        StringBuilder strBuilder = new StringBuilder("");

        while (st.hasMoreTokens()){
            token = st.nextToken();
            string2 = TrocarPalavras(mapa, token);
            strBuilder.append(string2);
            //if(token.endsWith(".")){ return strBuilder; }
        }
        return strBuilder;
    }
    public static String TrocarPalavras(Map mapa, String palavra){
        String juncao ="";

        Character key = palavra.charAt(0);
        if(mapa.containsKey(key)){
            String comp = (mapa.get(key)).toString();
            if(palavra.endsWith(".") && palavra.length()>2){
                if(palavra.replace(".","").equals(comp)){
                    juncao = key+".";}
                else{
                    palavra.replace(".","");
                    juncao = palavra;
                }
            }
            else if(comp.equals(palavra) ){
                juncao = key+". ";
            }

            else {
                juncao = palavra+" ";
            }
        }
        else if (palavra.endsWith(".")){
            palavra.replace(".","");
            juncao = palavra;
        }
        else {
            juncao = palavra+" ";
        }
        return juncao;
    }
}

