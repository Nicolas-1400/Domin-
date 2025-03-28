package main;

import java.util.Scanner;

public class Menu {
	Scanner sc = new Scanner (System.in);
	private int respuestaMenu;
	
	public Menu (int respuestaMenu) {
		this.respuestaMenu = respuestaMenu;
	}
	
	public Menu (){
		
	}
	
	public String toString () {
		String instrucciones = "";
		instrucciones = "\n/////INSTRUCCIONES DEL JUEGO://///" 
			+ "\nEl juego consta de un total de 28 piezas, en cada una de las cuales se representa un par de valores posibles." 
			+ "\nRequiere de mínimo 2 jugadores y máximo 4."
			+ "\n\n/////PASOS/////"
			+ "\n1. A cada jugador se le dan 7 fichas. Una vez todos tienen 7 fichas, empieza el juego."
			+ "\n2. Empieza el jugador colocando la ficha doble más alta, comenzando desde el 6/6 y hacia abajo, si no hay ninguna ficha doble, empieza la ficha con la mayor suma de sus lados."
			+ "\n3. Despúes de que el primer jugador haya colocado su ficha, el siguiente jugador debe colocar una ficha que coincida con uno de los lados de la ficha que ya está en el tablero."
			+ "\n4. Si un jugador no tiene una ficha de dominó que coincida con los extremos de las que están en el tablero, saca una del montón de fichas que sobraron. "
			+ "\n   Si la ficha que saca coincide con los extremos de las fichas en el tablero, la coloca. Si no, pasa su turno."
			+ "\n   Si no quedan fichas en el montón, el jugador pasa sin poner ficha."
			+ "\n5. Gana la partida el jugador que logre quedarse sin fichas."
			+ "\n6. Si ningún jugador puede poner ficha, se hace una suma de los números de las fichas restantes de cada jugador."
			+ " Y gana la partida el jugador con la menor suma."
			+ "\n";
			return instrucciones;
	}
	
	public void imprimirMenu () {
		boolean bucleMenu = true;
		System.out.println("/////BIENVENIDO AL JUEGO DEL DOMINÓ/////");
		while (bucleMenu == true) {
			System.out.println("\n¿Qué quieres hacer?");
			System.out.println("1. Jugar");
			System.out.println("2. Instrucciones");
			System.out.println("3. Salir");
			respuestaMenu = sc.nextInt();
			while (respuestaMenu < 1 || respuestaMenu > 3) {
				System.out.println("\nEso no es una respuesta válida.");
				System.out.println("\n¿Qué quieres hacer?");
				System.out.println("1. Jugar");
				System.out.println("2. Instrucciones");
				System.out.println("3. Salir");
				respuestaMenu = sc.nextInt();
			}
			if (respuestaMenu == 1) {
				Juego juego = new Juego();
				juego.jugar();
			}
			if (respuestaMenu == 2) {
				System.out.println(toString());
			}
			if (respuestaMenu == 3) {
				System.out.println("\nSaliendo del juego");
				bucleMenu = false;
			}
		}
	}

}