
package Principal;
import java.util.Random;

public class Roleta extends Jogos {
    private int numeroEscolhido;

    public Roleta(double valorAposta, int numeroEscolhido) {
        super(valorAposta);
        this.numeroEscolhido = numeroEscolhido;
    }

    @Override
    public void processarResultado() {
        Random rand = new Random();
        int sorteado = rand.nextInt(37); // 0 a 36
        int distancia = Math.abs(numeroEscolhido - sorteado);
        
        if (distancia <= 5) {
            setGanho(getValorAposta() * (16.0 / (1 + distancia)));
        } else {
            setGanho(0.0);
        }
    }

    @Override
    public String toString() {
        return "Roleta - Aposta: R$" + getValorAposta() + " | Ganho: R$" + getGanho();
    }
}