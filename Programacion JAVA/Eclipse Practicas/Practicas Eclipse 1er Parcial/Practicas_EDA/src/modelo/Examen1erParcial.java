package modelo;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Examen1erParcial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float p = 0;
		int N = 0;
	
		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		
		System.out.println("Digite el numero de estaturas a registrar");
		N = sc.nextInt();
		int [] estaturas = new int [N];
		ArrayList<Integer> numerosMayores = new ArrayList<>();
		ArrayList<Integer> numerosMenores = new ArrayList<>();
		
		for (int i = 0;i<estaturas.length;i++) {
			System.out.println("Digite estatura: " + (i+1));
			estaturas[i] = sc2.nextInt();
			p = p + estaturas[i];
		}
		    p = p/N;
		System.out.println("El promedio de las estaturas es: " + p);
		
		for (int i = 0;i<estaturas.length;i++) {
			if(estaturas[i]>p) { 
				numerosMayores.add(i);
				
				
			}
			
		}
		for (int i = 0;i<estaturas.length;i++) {
			if(estaturas[i]<p) { 
				
				numerosMenores.add(i);
				
			}
			
		}
		System.out.println("Las personas con estatura mayor al promedio son: " + numerosMayores.size());
		System.out.println("Las personas con estatura menor al promedio son: " + numerosMenores.size());
		
		
	}

}
