/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exp3_s7_grupo7;

import java.util.ArrayList;

public class PrimesList extends ArrayList<Integer> {

    /**
     * Verificar si el numero es primo: 
     * NO SON PRIMOS: 
     *      numeros igual o menor a 1.
     *      numeros con residuo == 0.
     *
     * @param numero: numero entero a verificar
     * @return : true es primo; false no es primo
     */
    public boolean isPrime(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i * i <= numero; i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sobrescribir metodo add para que solo agrege numeros primos:
     *
     * @param elemento El numero a añadir a la lista.
     * @return : true si el elemento fue añadido exitosamente.
     * @throws IllegalArgumentException si el numero no es primo.
     */
    @Override
    public boolean add(Integer elemento) {
        if (!isPrime(elemento)) {
            throw new IllegalArgumentException("No se puede agregar el numero " + elemento + " ya que no es primo.");
        }
        return super.add(elemento);
    }

    /**
     * Sobrescribe el metodo remove de la clase 'ArrayList'. No se implementa
     * logica de eliminacion de primos, ya que se limito agregar solo numeros
     * primos en metodo isPrime.
     *
     * @param o El objeto a eliminar de la lissta.
     * @return true si el objeto fue encontrado y eliminado.
     */
    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    /**
     * Despliega la cantidad de numeros primos agregados a lista.
     *
     * @return : Cantidad de numeros primos en la lista.
     */
    public int getPrimesCount() {
        return size();
    }
}
