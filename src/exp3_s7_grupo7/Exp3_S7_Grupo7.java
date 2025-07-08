
package exp3_s7_grupo7;

/**
 *
 * @author Rai
 */
public class Exp3_S7_Grupo7 {

    public static void main(String[] args) {
        System.out.println("===== PRIME SECURE =====");
        System.out.println("Aplicacion de generacion de numeros primos.");
        System.out.println("");

        // PrimesList: Lista de numeros primos
        PrimesList primeDatabase = new PrimesList();

        // Rangos de generacion de primos para cada hilo
        int rango1Start = 1;
        int rango1End = 50000;
        int rango2Start = 50001;
        int rango2End = 100000;
        int rango3Start = 100001;
        int rango3End = 150000;

        // Hilos generadores de primos por rango
        PrimeGeneratorThread generador1 = new PrimeGeneratorThread(primeDatabase, rango1Start, rango1End);
        PrimeGeneratorThread generador2 = new PrimeGeneratorThread(primeDatabase, rango2Start, rango2End);
        PrimeGeneratorThread generador3 = new PrimeGeneratorThread(primeDatabase, rango3Start, rango3End);

        // Objetos Thread para ejecutar las tareas
        Thread thread1 = new Thread(generador1, "GeneradorHilo-1");
        Thread thread2 = new Thread(generador2, "GeneradorHilo-2");
        Thread thread3 = new Thread(generador3, "GeneradorHilo-3");

        // Inicializar hilos
        System.out.println("Generando numeros primos entre el [1 - 150.000] ...");
        long startTime = System.currentTimeMillis(); // Inicia medicion de tiempo de ejecución
        thread1.start();
        thread2.start();
        thread3.start();

        // Metodo "join" para esperar a que cada hilo termine su ejecucion antes de continuar
        try {            
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.err.println("Un hilo generador fue interrumpido: " + e.getMessage());
            Thread.currentThread().interrupt(); // Cambio a estado "interrumpido"
        }
        long endTime = System.currentTimeMillis(); // Fin de la medicion de tiempo de ejecucion

        System.out.println("Ejecucion terminada!");

        // Total de numeros primos registrados
        System.out.println("\nTotal de numeros primos registrados: " + primeDatabase.getPrimesCount());
        System.out.println("Tiempo total de ejecucion: " + (endTime - startTime) + " ms");
        
        // Validacion: Intento de agregar un numero no primo
        try {
            System.out.println("\n=== Prueba de validacion PRIME SECURE ===");
            System.out.println("Intentando agregar un numero no primo -> 4 ...");
            primeDatabase.add(4); // Agregar el numero 4 (No-Primo)
        } catch (IllegalArgumentException e) {
            System.err.println("Excepcion capturada: " + e.getMessage());
        }

        System.out.println("\nAplicacion finalizada.");
    }
}
