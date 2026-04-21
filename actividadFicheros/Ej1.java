package actividadFicheros;

import java.io.*;
import java.util.Scanner;

public class Ej1 {
    public static void main(String[] args) {
        String separador = System.getProperty("file.separator");
        String home = System.getProperty("user.home")+separador+"Documents"+separador+"TrabajosDAM";
        System.out.println("Home: "+home);
        File file = new File(home+separador+"Ejercicio1.txt");

        try {
            PrintStream escribirFichero = new PrintStream(file);
            escribirFichero.println("Esto es una prueba");
            escribirFichero.println("Esta es la segunda linea");
            escribirFichero.close();

            FileReader leer = new FileReader(file);
            int caracter;
            while((caracter = leer.read()) != -1){
                if (((char) caracter) != ' '){
                    System.out.print((char) caracter);
                }
            }
            System.out.println();
            leer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
