package main;

import java.util.*;

public class ConjuntoFichas {
    private ArrayList<FichaDomino> fichas;
    private Random random = new Random();
    private int posicion;

    public ConjuntoFichas() {
        fichas = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            for (int j = i; j <= 6; j++) {
                fichas.add(new FichaDomino(i, j));
            }
        }
    }

    public void barajar() {
        for (int i = fichas.size() - 1; i > 0; i--) {
            posicion = random.nextInt(i + 1);
            FichaDomino temp = fichas.get(posicion);
            fichas.set(posicion, fichas.get(i));
            fichas.set(i, temp);
        }
    }

    public FichaDomino sacarFicha() {
        return !fichas.isEmpty() ? fichas.remove(0) : null;
    }

    public boolean estaVacio() {
        return fichas.isEmpty();
    }
}
