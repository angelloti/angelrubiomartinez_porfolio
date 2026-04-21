package actividadFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ej2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        try {
            System.out.println("Ingrese la ruta del archivo");
            String ruta = teclado.nextLine();

            System.out.println("Introduce el texto del archivo");
            String texto = teclado.nextLine();

            File archivo = new File(ruta);

            try (FileWriter fr = new FileWriter(archivo)) {
                fr.write(texto);
            }
            try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
                int codigo;
                while ((codigo = br.read()) != -1) {
                    char letra = (char) codigo;
                    if (Character.isLowerCase(letra)) {
                        System.out.println(Character.toUpperCase(letra));
                    } else if (Character.isUpperCase(letra)) {
                        System.out.println(Character.toLowerCase(letra));
                    }
                    else{
                        System.out.println(letra);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error al leer: " + e.getMessage());
        }
    }
}
