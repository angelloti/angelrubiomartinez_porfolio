package actividadFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio3 {
    public static void main(String[] args) {
        String separador = System.getProperty("file.separator");
        String home = System.getProperty("user.home")+separador+"Documents"+separador+"Programación";
        System.out.println(home+separador+"archivoGigante.txt");
        File file = new File(home+separador+"archivoGigante.txt");
        if(!file.exists()){
            System.out.println("No existe el archivoGigante.txt");
        }
        else {
            System.out.println("El archivoGigante existe");
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                br.lines().filter(line -> line.contains("ERROR")).limit(10).forEach(System.out::println);
            }
            catch (IOException e){
                e.getMessage();
            }
        }

    }
}
