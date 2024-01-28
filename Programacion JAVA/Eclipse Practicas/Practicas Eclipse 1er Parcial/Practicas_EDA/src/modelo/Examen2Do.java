package modelo;
import java.util.Arrays;
import java.util.Scanner;


public class Examen2Do {
	public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 Scanner sc1 = new Scanner(System.in);
	 Scanner sc2 = new Scanner(System.in);
	 Scanner sc3 = new Scanner(System.in);
	 Scanner sc4 = new Scanner(System.in);
	 Scanner sc5 = new Scanner(System.in);
	 int m = 0;
	 int mm = 0;
	 int n = 0;
		int N = 0;
		int n1 = 0;
		int N1 = 0;
	 
	 
	 
	 System.out.println("Ingrese el tamano de su matriz A");
	
	
	n = sc.nextInt();
    N = sc1.nextInt();
    m = n * N;
    
	
	   int[][] matrizA = new int[n][N];
	   
	   System.out.println("Ingrese el tamano de su matriz B");
	   
	   
		n1 = sc2.nextInt();
	    N1 = sc3.nextInt();
	    mm = n * N;
       int[][] matrizB = new int[n1][N1];
       
       //Asignar tamanos de matriz
		 
       int filasA = matrizA.length;
       int columnasA = matrizA[0].length;
       int filasB = matrizB.length;
       int columnasB = matrizB[0].length;

   
      
       //Asignar valores para las matices
       Sys
	   		 for (int z = 0; z < matrizA.length; z++) {
	   			 System.out.print(   "Columna " + (z + 1) + ": ");
	   	         matrizA[p][z] = sc4.nextInt();
	   	   tem.out.println("Escribe "+ m +" numeros");
		 int p = 0;
		 
		 for (; p < matrizA.length; p++) {
	            System.out.print("Fila " + (p + 1) + ": ");
	            
	   	        }
	   	
	        }
		 
		 
	    System.out.println("Escribe "+ mm +" numeros");
	      int pp = 0;
		 
		 for (; pp < matrizB.length; pp++) {
	            System.out.print("Fila " + (pp + 1) + ": ");
	            
	   		 for (int zz = 0; zz < matrizB.length; zz++) {
	   			 System.out.print(   "Columna " + (zz + 1) + ": ");
	   	         matrizB[pp][zz] = sc5.nextInt();
	   	   
	   	        }
	   	
	        }
		 
		
	        
	      //Asignar una matriz para meter el resultado 
	        
	        int[][] matrizResultado = new int[filasA][columnasB];
// hacer la multiplicacion de matrices
	       
	        for (int i = 0; i < filasA; i++) {
	            for (int j = 0; j < columnasB; j++) {
	                int suma = 0;
	                for (int k = 0; k < columnasA; k++) {
	                    suma += matrizA[i][k] * matrizB[k][j];
	                }
	                matrizResultado[i][j] = suma;
	            }
	        }

	//Imprimir el resultado de la matriz
	        System.out.println("Matriz Resultado:");
	        for (int i = 0; i < filasA; i++) {
	            for (int j = 0; j < columnasB; j++) {
	                System.out.print(matrizResultado[i][j] + " ");
	            }
	            System.out.println();

}
}
}
