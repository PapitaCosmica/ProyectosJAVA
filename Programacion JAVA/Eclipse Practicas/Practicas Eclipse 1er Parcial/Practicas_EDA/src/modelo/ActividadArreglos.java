package modelo;
import java.util.Scanner;

public class ActividadArreglos {
    public static void main(String[] args) {
        // Crear un array de 10 números
        float[] numeros = new float[10];
        float calificacion = 0;

        // Crear un objeto Scanner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese los valores para el array
        System.out.println("Por favor, ingresa 10 números:");

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
          
        }

        // Cerrar el scanner
        scanner.close();

        // Mostrar los números en la consola
        System.out.println("Los números en el array son:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
            
  
            calificacion = (calificacion + numeros[i]);
            
            
        }
        calificacion = calificacion/10;
        System.out.println("Su calificacion es: " + calificacion);
        
        if(calificacion > 7) { 
        	 System.out.println("Aprobado");
        } else {System.out.println("Reprobado");
        }
        
        float mayor = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > mayor) {
                mayor = numeros[i];
            }
        }
        System.out.println("El número mayor en el array es: " + mayor);
    }
}
