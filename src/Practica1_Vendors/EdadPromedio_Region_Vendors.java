/*
Juvera Rodriguez Walter Alejandro
 */
package Practica1_Vendors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class EdadPromedio_Region_Vendors {
    public static void main(String[] args) {


        try {
            ArrayList<String> Lineas = new ArrayList<>();
            ArrayList<String> Estados = new ArrayList<>();
            ArrayList<Double> Edades = new ArrayList<>();
            FileReader fin = new FileReader("vendors.csv");
            BufferedReader in = new BufferedReader(fin);
            String linea = in.readLine();
            while ((linea = in.readLine()) != null) {
                Lineas.add(linea);
                if (!Estados.contains(linea.split(",")[3])) {
                    Estados.add(linea.split(",")[3]);

                }    
            }
            fin.close();
            in.close();
            for (int i = 0; i < Estados.size(); i++) {
                int edad = 0;
                int repeticiones = 0;
                for (int j = 0; j < Lineas.size(); j++) {
                    if (Lineas.get(j).split(",")[3].equals(Estados.get(i))) {
                        edad += Edad_Vendors.getEdad(Lineas.get(j).split(",")[2]);
                        repeticiones++;
                    }
                }
                Edades.add((double) edad/repeticiones);
            }
            for (int i = 0; i < Edades.size(); i++) {
                System.out.printf("Edad Promedio: %05.2f Estado: %-13s \n", Edades.get(i), Estados.get(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
