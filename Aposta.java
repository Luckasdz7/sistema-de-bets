package Principal;



public class Aposta {
    private Jogos jogo;
    private String data;

    public Aposta(Jogos jogo, String data) {
        this.jogo = jogo;
        this.data = data;
    }

    public Jogos getJogo() { return jogo; }
    
    @Override
    public String toString() {
        return "Data: " + data + " | " + jogo.toString();
    }
}