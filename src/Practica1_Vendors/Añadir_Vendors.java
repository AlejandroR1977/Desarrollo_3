/*
Juvera Rodriguez Walter Alejandro
 */
package Practica1_Vendors;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Añadir_Vendors {
    public static void main(String[] args) {
        try {
            ArrayList<String> Lineas = new ArrayList<>();
            FileReader fin = new FileReader("vendors.csv");
            BufferedReader in = new BufferedReader(fin);
            String record = in.readLine();
            Scanner sc = new Scanner(System.in);
            
            while ((record = in.readLine()) != null) {
                Lineas.add(record);
            }
            int cve = Integer.parseInt(Lineas.get(Lineas.size() - 1).split(",")[0]) + 1;
            System.out.println("Ingresa los datos solicitados: ");
            System.out.print("Ingresa el nombre del vendedor(Máximo 35 caracteres): ");
            String name = sc.nextLine();
            System.out.println("Ingresa la fecha de Nacimiento: ");
            System.out.print("Ingresa el número del mes: ");
            int mes =sc.nextInt();
            sc.nextLine();
            System.out.print("Ingresa el número del día: ");
            int dia =sc.nextInt();
            sc.nextLine();
            System.out.print("Ingresa el año con un formato de 4 dígitos: ");
            int año=sc.nextInt();
            sc.nextLine();
            System.out.print("Ingresa la Región del vendedor(Máximo 15 caracteres): ");
            String region =sc.nextLine();
            System.out.println("Se han capturado todos los datos: ");
            System.out.printf("%03d %-35s %02d/%02d/%4d %-15s",cve,name,mes,dia,año,region);
            FileOutputStream fos = new FileOutputStream("./src/practica1/vendors.csv",true);
            fos.write(String.format("%d,%s,%02d/%02d/%04d,%s\n",cve,name,mes,dia,año,region).getBytes());
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
