package Principal;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class GerenciadorArquivo {
    
    // Método estático para que não precise instanciar a classe toda hora
    public static boolean salvarRelatorio(Usuario usuario) {
        String nomeArquivo = "dados_apostas_" + usuario.getNome() + ".txt";
        
        try (FileWriter fw = new FileWriter(nomeArquivo);
             PrintWriter out = new PrintWriter(fw)) {
            
            out.println("RELATÓRIO DO JOGADOR: " + usuario.getNome());
            out.println("========================================");
            
            for (Aposta a : usuario.getHistorico()) {
                out.println(a.toString());
            }
            
            return true; // Sucesso
            
        } catch (IOException e) {
            System.err.println("Erro técnico ao acessar o disco: " + e.getMessage());
            return false; // Falha
        }
    }
}
