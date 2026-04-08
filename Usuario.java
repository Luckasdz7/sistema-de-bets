package Principal;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private List<Aposta> historicoApostas;

    public Usuario(String nome) {
        this.nome = nome;
        this.historicoApostas = new ArrayList<>();
    }

    public void adicionarAposta(Aposta aposta) {
        this.historicoApostas.add(aposta);
    }

    public String getNome() { return nome; }
    public List<Aposta> getHistoricoApostas() { return historicoApostas; }
}
