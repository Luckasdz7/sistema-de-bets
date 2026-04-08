package Principal;
import java.util.Random;

public class DadosJogo extends Jogos {
    private int dadox, dadoy, nrodadas, cpux, cpuy;
    Random rand = new Random();

    public DadosJogo(double valorAposta, int dadox, int dadoy, int nrodadas) {
        super(valorAposta);
        this.dadox = dadox;
        this.dadoy = dadoy;
        this.nrodadas = nrodadas;
    }

    public void processarResultado() {
        // Os números da máquina devem ser gerados aqui dentro!
        // rand.nextInt(limite) gera de 0 até limite-1, por isso o +1
        int limite = 6 - nrodadas; 
        this.cpux = rand.nextInt(limite) + 1;
        this.cpuy = rand.nextInt(limite) + 1;

        // Corrigido: comparando x com x e y com y
        if(cpux == dadox && cpuy == dadoy) {
            setGanho((getValorAposta() * 1.2) - (nrodadas * 2));
        } else if(cpux == dadox || cpuy == dadoy) {
            setGanho(getValorAposta() * 0.2);
        } else {
            setGanho(0.0);
        }
    }

    @Override
    public String toString() {
        return "JOGO DE DADOS - Rodada: " + (nrodadas + 1) + 
               "\nSeus dados: [" + dadox + ", " + dadoy + "] | Máquina: [" + cpux + ", " + cpuy + "]" +
               "\nGanho: R$ " + getGanho();
    }
}