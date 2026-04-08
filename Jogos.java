// Classe Mãe (Abstrata)
package Principal;

public abstract class Jogos {
    private double valorAposta;
    private double ganho;

    public Jogos(double valorAposta) {
        this.valorAposta = valorAposta;
        this.ganho = 0.0;
    }

    // Getters e Setters (Encapsulamento)
    public double getValorAposta()
    { 
    	return valorAposta; 
    }
    
    public void setValorAposta(double valorAposta) {
    	this.valorAposta = valorAposta;
    	}
    
    public double getGanho() {
    	return ganho;
    	}

    protected void setGanho(double ganho) { 
    	this.ganho = ganho; 
    	}

    // Método abstrato que as subclasses devem implementar
    public abstract void processarResultado();
    
    @Override
    public abstract String toString();
}