import java.util.concurrent.Semaphore;


public class Main {
    public static void main(String[] args) {
        int permissoes = 1;
        Semaphore semaforo = new Semaphore(permissoes);
        for (int idCarro = 0; idCarro < 4; idCarro++) {
            Thread tCruza = new Controller(idCarro, semaforo);
            tCruza.start();
        }
    }
}