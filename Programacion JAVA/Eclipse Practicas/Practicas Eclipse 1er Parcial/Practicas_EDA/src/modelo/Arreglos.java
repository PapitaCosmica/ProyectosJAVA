package modelo;

public class Arreglos {

	public static void main(String[] args) {
		
		int [] numeros = new int [100];
		int suma = 0;
		for (int x = 1; x < 101; x++) {
			
			
			for (int y = 0; y < 100; y++) {
				numeros[y] = x++;
				 suma = suma + numeros[y];
				 System.out.println(y + " = " + numeros[y]);
			
			}
			
		}
		 System.out.println( "su suma es = " + suma);
		 for (int z = 2; z < 100; z+=2) {
			 System.out.println("Los numeros pares son: " + z);
			 
		 }
	}

}
