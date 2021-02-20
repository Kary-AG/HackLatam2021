import java.util.*;
import java.io.*;

class Frecuencia {
    private static ArrayList<String> Palabra(String archivo) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        StringBuilder sb = new StringBuilder();

        while((linea = br.readLine()) != null){
            sb.append(linea).append(" ");
        }
        String contenido = sb.toString();

        contenido = contenido.toLowerCase();
        contenido = contenido.replaceAll("\\.", "");
        contenido = contenido.replaceAll("\\,", "");

        String a[] = contenido.split("\\s+");

        ArrayList<String> lista = new ArrayList<String>();
        int i = 0;
        while(i < a.length) {
            lista.add(a[i]);
            i++;
        }
        return lista;
    }

    private static void frecuenciaPalabra(ArrayList<String> lista) {
        Set<String> st = new HashSet<String>(lista);
        for (String s : st) {
            if(Collections.frequency(lista, s) < 5) {
                continue;
            }
            if(s.equals("a") || s.equals("e") || s.equals("o") || s.equals("y") || s.equals("hacer") 
            || s.equals("con") || s.equals("las") || s.equals("por") || s.equals("pero") || s.equals("los")
            || s.equals("para") || s.equals("del") || s.equals("una") || s.equals("más") || s.equals("mas") 
            || s.equals("que") || s.equals("qué") || s.equals("de") || s.equals("el") || s.equals("en") 
            || s.equals("es") || s.equals("la") || s.equals("lo") || s.equals("no") || s.equals("se") 
            || s.equals("si") || s.equals("me") || s.equals("sé") || s.equals("ya") || s.equals("tal") 
            || s.equals("como") || s.equals("un") || s.equals("sean") || s.equals("sin") || s.equals("entre") 
            || s.equals("al") || s.equals("sea") || s.equals("así") || s.equals("puede") || s.equals("creo") 
            || s.equals("vez") || s.equals("también") || s.equals("tus") ) {
                continue;
            }
            System.out.println(s + ": " + Collections.frequency(lista, s));
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.out.println("Uso: java Frecuencia.java <archivo>");
            return;
        }
        String arg = args[args.length-1];

        ArrayList<String> lista = new ArrayList<String>();
        lista = Palabra(arg);
        frecuenciaPalabra(lista);
    }
}