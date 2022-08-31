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
import java.time.LocalDate;
import java.time.Period;
import java.util.StringTokenizer;

public class ReporteEdad {

    public static void main(String[] args) {

        FileReader fin = null;
        BufferedReader in = null;

        try {
            fin = new FileReader("vendors-data.csv");
            in = new BufferedReader( fin );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String registro = null;

        try {
            registro = in.readLine();
            while ( (registro = in.readLine()) != null ) {

                StringTokenizer st = new StringTokenizer(registro,"," );
                //System.out.println( registro );

                // Separar cada uno de los campos
                String cve = st.nextToken();
                String name = st.nextToken();
                String dob = st.nextToken();
                String state = st.nextToken();

                int age = getAge(dob);
                if(age >= 30)
                    System.out.format("%2.2s %-25.25s %-2.2s %-15.15s%n",cve,name,age,state);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    Calcula la edad del vendedor
     */
    public static int getAge(String fecha) {
        // posición de las / en la fecha
        int p = fecha.indexOf("/");
        int q = fecha.lastIndexOf("/");

        // separar los componentes de la fecha
        String month = fecha.substring(0, p);
        String day = fecha.substring(p+1,q);
        String year = fecha.substring(q + 1);

        // corregir las fechas de 2 digitos
        if( year.length() == 2 ) {
            if(Integer.parseInt(year) > 21 ) {
                // Si year es mayor a 21, es fecha de 1900
                year = "19"+year;
            } else {
                year = "20"+year;
            }
        }

        // Crear una fecha con los datos
        LocalDate dob = LocalDate.of(Integer.parseInt(year),
                Integer.parseInt(month),
                Integer.parseInt(day));

        // La fecha de hoy
        LocalDate now = LocalDate.now();

        // Calcular la diferencia en años entre las fechas
        int age = Period.between(dob, now).getYears();

        return age;
    }
}
