/*
Juvera Rodriguez Walter Alejandro
 */
package Practica1_Vendors;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

public class Edad_Vendors {
    public static void main(String[] args) {
        FileReader fin = null;
        BufferedReader in = null;
        try {
            fin = new FileReader("vendors.csv");
            in = new BufferedReader(fin);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String registro = null;

        try {
            registro = in.readLine();

            while ((registro = in.readLine()) != null) {
                String[] datos = registro.split(",");
                String cve = datos[0];
                String nombre = datos[1];
                String fdn = datos[2];
                int edad = getEdad(fdn);
                System.out.printf("Nombre: %-25.25s Edad: %2.2s  %n", nombre, edad);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getEdad(String fecha) {
        String[] datos = fecha.split("/");
        String mes = datos[0];
        String dia = datos[1];
        String año = datos[2];
        if (año.length() == 2) {
            if (Integer.parseInt(año) > 21) {
                año = "19" + año;
            } else {
                año = "20" + año;
            }
        }

        LocalDate fdn = LocalDate.of(Integer.parseInt(año),
                Integer.parseInt(mes),
                Integer.parseInt(dia));

        LocalDate actualidad = LocalDate.now();

        int edad = Period.between(fdn, actualidad).getYears();

        return edad;
    }
}
