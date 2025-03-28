package main;

import java.util.*;

public class Jugador {
	Scanner sc = new Scanner(System.in);
	private String nombre;
	private int indice;
	private String lado;
	private int extremoIzq;
	private int extremoDer;
	private boolean fichaColocada = false;
	private int indiceInicial;
	ArrayList<FichaDomino> mano;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.mano = new ArrayList<>();
		this.indiceInicial = 0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getIndiceInicial() {
		return indiceInicial;
	}

	public void setIndiceInicial(int indiceInicial) {
		this.indiceInicial = indiceInicial;
	}

	public boolean puedeJugar(LinkedList<FichaDomino> tablero) {
		extremoIzq = tablero.getFirst().getLado1();
		extremoDer = tablero.getLast().getLado2();
		for (FichaDomino ficha : mano) {
			if (ficha.getLado1() == extremoIzq || ficha.getLado2() == extremoIzq || ficha.getLado1() == extremoDer || ficha.getLado2() == extremoDer) {
				return true;
			}
		}
		return false;
	}

	public void jugarFicha(LinkedList<FichaDomino> tablero, Scanner sc) {
		fichaColocada = false;
		while (fichaColocada == false) {
			System.out.print("Seleccione el índice de la ficha que desea jugar: ");
			indice = sc.nextInt();
			while (indice > mano.size() || indice < 1) {
				System.out.println("Error, elige un número del 1 al " + mano.size());
				indice = sc.nextInt();
			}
			indice--;
			FichaDomino ficha = mano.get(indice);
			System.out.print("¿A qué lado desea colocar la ficha? (I: izquierda, D: derecha): ");
			lado = sc.next().toUpperCase();
			while (!lado.equals("I") && !lado.equals("D")) {
				System.out.println("Error, elige I o D");
				lado = sc.nextLine().toUpperCase();
			}
			if (lado.equals("I") && (ficha.getLado1() == tablero.getFirst().getLado1() || ficha.getLado2() == tablero.getFirst().getLado1())) {
				if (ficha.getLado2() != extremoIzq) {
					ficha.voltear();
				}
				tablero.addFirst(ficha);
				mano.remove(indice);
				System.out.println("Ficha colocada a la izquierda.");
				fichaColocada = true;
			} else if (lado.equals("D") && (ficha.getLado1() == tablero.getLast().getLado2() || ficha.getLado2() == tablero.getLast().getLado2())) {
				if (ficha.getLado1() != extremoDer) {
					ficha.voltear();
				}
				tablero.addLast(ficha);
				mano.remove(indice);
				System.out.println("Ficha colocada a la derecha.");
				fichaColocada = true;
			} else {
				System.out.println("La ficha no encaja en el tablero. Inténtalo de nuevo.");
			}
		}
	}
}
