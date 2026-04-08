package Principal;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private List<Aposta> historico;
    private List<Aposta> historicoApostas;

    public Usuario(String nome) {
        this.nome = nome;
        this.historico = new ArrayList<>();
    }

    public void adicionarAposta(Aposta a) {
        this.historico.add(a);
    }

    public String getNome() { return nome; }
    public List<Aposta> getHistorico() { return historico; }
    public List<Aposta> getHistoricoApostas() { return historicoApostas; }
}