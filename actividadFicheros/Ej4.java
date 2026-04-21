package actividadFicheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class Ej4 {
    public static void main(String[] args) {
        List<Libro> listaLibros = new ArrayList<>();
        String separador = System.getProperty("file.separator");
        String home = System.getProperty("user.home") + separador + "Documents" + separador + "TrabajosDAM";
        System.out.println("Home: " + home);


        File file = new File(home + separador + "libro.txt");
        if (!file.exists()) {
            System.out.println("No existe el libro.txt");
        } else {
            System.out.println("El libros existe");
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String linea;
                while ((linea = br.readLine()) != null){
                    String[] partes = linea.split(";");
                    Libro libro = new Libro(partes[0], partes[1], Double.parseDouble(partes[2].replace(",", ".")));
                    listaLibros.add(libro);
                }
                Collections.sort(listaLibros);
                FileWriter fw = new FileWriter(home + separador + "librosOrdenados.txt");
                FileWriter fw2 = new FileWriter(home + separador + "estadisticas.txt");
                for (Libro libro : listaLibros) {
                    fw.write(libro.toString()+"\n");
                }
                fw.close();

                //List<Libro> librosPrecio = listaLibros.stream().sorted(Comparator.comparing(Libro::getPrecio).reversed()).toList();
                Optional<Libro> libroCaro = listaLibros.stream().max(Comparator.comparing(Libro::getPrecio));
                OptionalDouble promedio = listaLibros.stream().mapToDouble(Libro::getPrecio).average();
                if (libroCaro.isPresent()) {
                    System.out.println("Libro mas caro");
                    System.out.println(libroCaro.toString());
                    fw2.write(libroCaro.get().toString()+"\n");
                }


                if (promedio.isPresent()) {
                    System.out.println("Promedio");
                    System.out.println(promedio.toString());
                    fw2.write(String.valueOf(promedio.getAsDouble())+"\n");
                }

                fw2.close();


            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
