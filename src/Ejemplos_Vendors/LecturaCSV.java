/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejemplos_Vendors;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class LecturaCSV {

    public static void main(String[] args) {

        FileReader fin = null;
        BufferedReader in = null;

        try {
            fin = new FileReader("vendors-data.csv");
            in = new BufferedReader( fin );
        } catch (FileNotFoundException e) {
            System.out.println( e.getMessage() );
            System.exit(1);
        }

        String registro = null;

        try {
            // Leer la primera linea y descartar
            registro = in.readLine();
            while ( (registro = in.readLine()) != null ) {  // leer cada linea del archivo
                StringTokenizer st = new StringTokenizer(registro,"," );
                System.out.println( registro );
                while ( st.hasMoreTokens() )  {
                    String campo = st.nextToken();
                    System.out.format("\t%s %n",campo );
                }
            }
            in.close();
        } catch (IOException e) {
            System.out.println( e.getMessage() );
            System.exit(1);
        }
    }
}
