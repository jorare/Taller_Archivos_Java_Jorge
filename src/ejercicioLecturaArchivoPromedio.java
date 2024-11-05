// Se importa libreria
import java.io.*;

public class ejercicioLecturaArchivoPromedio {
    public static void main(String[] args) {

        //Se define la ruta del archivo y se crea un objeto File para representar el archivo
        String ruta = "D:/Fundamentos de Programacion/Ejercicios en Clase/Taller_Archivos_Java_Jorge/test.txt";
        File file = new File(ruta);

        //Se verifica si el archivo exisste
        if (!file.exists()) {
            System.out.println("La ruta del archivo es incorrecta");
            return;
        }

        // Se utiliza dentro de un try un BufferedReader para leer el archivo para que se cierre automaticamente despues de la ejecución
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            // Se inicializan variables de programa que va a realizar el calculo del promedio, el numero mayor y el menor
            String linea;
            int suma = 0;
            int i = 0;
            int maximo = Integer.MIN_VALUE;
            int minimo = Integer.MAX_VALUE;

            while ((linea = br.readLine()) != null) {

                // Se elimian espacios en blanco en los extremos dela linea
                linea = linea.trim();
                if (linea.chars().allMatch(Character::isDigit)) {

                    // Conviernte a numeros enteros
                    int numero = Integer.parseInt(linea);

                    //Calulo de numero mayor, numero menor y promedio
                    suma += numero;
                    i++;
                    if (numero > maximo) {
                        maximo = numero;
                    }
                    if (numero < minimo) {
                        minimo = numero;
                    }
                }
            }

            if (i > 0) {

                double promedio = (double) suma / i;

                System.out.println("El promedio de notas es: " + promedio);
                System.out.println("La nota mayor es: " + maximo);
                System.out.println("La nota menor es: " + minimo);

            } else {
                System.out.println("El archivo no contiene información valida o está vacío");
            }

            // Excepciones para errores en caso que el archivo no tenga valores validos
        } catch (IOException e) {

            System.out.println("Error al leer el archivo: " + e.getMessage());

        } catch (NumberFormatException e) {

            System.out.println("El archivo no contiene datos numericos.");
        }
    }
}