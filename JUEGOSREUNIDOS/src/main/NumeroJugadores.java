package main;

import java.util.ArrayList;
import java.util.Scanner;

public class NumeroJugadores {
	Scanner sc = new Scanner (System.in);
    private int numJugadores;
    ArrayList<Jugador> jugadores = new ArrayList<>();
    
	public NumeroJugadores (int numJugadores) {
		this.numJugadores = numJugadores;
	}
	
	public NumeroJugadores () {
		
	}

	public int getNumJugadores() {
		return numJugadores;
	}

	public void setNumJugadores(int numJugadores) {
		this.numJugadores = numJugadores;
	}
	
	public int establecerNumeroJugadores() {
    System.out.print("Ingrese el número de jugadores (2-4): ");
    numJugadores = sc.nextInt();
    while (numJugadores < 2 || numJugadores > 4) {
		System.out.println("\nEso no es una respuesta válida.");
	    System.out.print("Ingrese el número de jugadores (2-4): ");
	    numJugadores = sc.nextInt();
    }
    for (int i = 0; i < numJugadores; i++) {
        jugadores.add(new Jugador("Jugador " + (i + 1)));
    }
    return numJugadores;
	}
}
