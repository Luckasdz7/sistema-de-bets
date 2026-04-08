// Classe Mãe (Abstrata)
package Principal;


public class Jogos {
    private Double valoraposta;
    private Double ganho;

    public Jogos(Double valoraposta) {
        this.valoraposta = valoraposta;
        this.ganho = 0.0;
    }

    public Double getValorAposta() { return valoraposta; }
    public Double getGanho() { return ganho; }
    public void setGanho(Double ganho) { this.ganho = ganho; }
}