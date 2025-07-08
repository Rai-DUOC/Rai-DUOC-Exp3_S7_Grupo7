/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exp3_s7_grupo7;

/**
 *
 * @author Rainiero - MnD
 */

public class PrimeGeneratorThread implements Runnable {

    private final PrimesList primesList;
    private final int startRango;
    private final int endRango;

    public PrimeGeneratorThread(PrimesList primesList, int startRange, int endRango) {
        this.primesList = primesList;
        this.startRango = startRange;
        this.endRango = endRango;
    }

    @Override
    public void run() {
        System.out.println("Iniciando generacion en el rango [" + startRango + ", " + endRango + "] por el hilo: " + Thread.currentThread().getName());

        for (int i = startRango; i <= endRango; i++) {
            if (primesList.isPrime(i)) {
                try {
                    synchronized (primesList) {
                        primesList.add(i);
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println("Error al intentar agregar un numero no primo: " + e.getMessage());
                }
            }
        }
        System.out.println("Finalizada generacion en el rango [" + startRango + ", " + endRango + "] por el hilo: " + Thread.currentThread().getName());
    }
}
