package com.example.lab2_20192733.model;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Cartas {
    private int tamaño;
    private int [][] numerosBingo;
    private boolean [][] marcaBingo;

    public Cartas(int tamaño){
        this.tamaño = tamaño;
        numerosBingo = new int[tamaño][tamaño];
        marcaBingo = new boolean[tamaño][tamaño];
        generarCarta();
    }

    public void generarCarta(){
        Set<Integer> listaNumeros = new HashSet<>();
        Random rand = new Random();

        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                int numeroAleatorio;
                do {
                    numeroAleatorio = rand.nextInt(99) + 1;
                } while (listaNumeros.contains(numeroAleatorio));
                listaNumeros.add(numeroAleatorio);
                numerosBingo[i][j] = numeroAleatorio;
                marcaBingo[i][j] = false;
            }
        }
    }
    public void marcarNumero(int numerselec){

    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int[][] getNumerosBingo() {
        return numerosBingo;
    }

    public void setNumerosBingo(int[][] numerosBingo) {
        this.numerosBingo = numerosBingo;
    }

    public boolean[][] getMarcaBingo() {
        return marcaBingo;
    }

    public void setMarcaBingo(boolean[][] marcaBingo) {
        this.marcaBingo = marcaBingo;
    }
}
