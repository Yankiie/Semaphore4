import java.util.concurrent.Semaphore;

public class Controller extends Thread {
    private int idCarro;
    private Semaphore semaforo;
    private String sentido;

    public Controller(int idCarro, Semaphore semaforo) {
        this.idCarro = idCarro;
        this.semaforo = semaforo;
    }

    public void run() {
        direcao();
        try {
            semaforo.acquire();
            cruzando();
        } catch (Exception e) {
        }
        cruzou();
        semaforo.release();
    }


    private void direcao() {
        if (idCarro == 0) {
            sentido = "norte";
        } else if (idCarro == 1) {
            sentido = "sul";
        } else if (idCarro == 2) {
            sentido = "leste";
        } else if (idCarro == 3) {
            sentido = "oeste";
        }

    }

    private void cruzando() {
        System.out.println("Carro " + idCarro + " esta cruzando em direçăo ao " + sentido);
        try {
            sleep(5000);
        } catch (Exception e) {
        }

    }

    private void cruzou() {
        System.out.println("Carro " + idCarro + "cruzou para o " + sentido);
    }
}

