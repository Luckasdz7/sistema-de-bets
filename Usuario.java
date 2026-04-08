package Principal;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private List<Aposta> historicoApostas; // Mantemos apenas uma lista

    public Usuario(String nome) {
        this.nome = nome;
        this.historicoApostas = new ArrayList<>(); // Inicializamos a lista corretamente
    }

    public void adicionarAposta(Aposta a) {
        this.historicoApostas.add(a); // Adiciona à lista correta
    }

    public String getNome() { return nome; }

    // Devolvemos a lista que realmente contém os dados
    public List<Aposta> getHistoricoApostas() { 
        return historicoApostas; 
    }
}