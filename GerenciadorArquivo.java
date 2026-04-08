package Principal;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class GerenciadorArquivo {
    
    public static boolean salvarRelatorio(Usuario usuario) {
        // 1. Pega a pasta principal do seu computador (ex: C:\Users\SeuNome)
        String home = System.getProperty("user.home");
        
        // 2. Monta o caminho: Home + Documentos + a sua pasta dados_apostas
        // File.separator serve para funcionar tanto em Windows quanto em Linux/Mac
        String caminhoPasta = home + File.separator + "Documents" + File.separator + "dados_apostas";
        
        // 3. Cria a referência para a pasta
        File pasta = new File(caminhoPasta);
        
        // Se por algum motivo a pasta não existir (ou você deletar), o código cria ela de novo
        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        // 4. Monta o caminho completo do arquivo .txt
        String nomeArquivo = caminhoPasta + File.separator + "relatorio_" + usuario.getNome() + ".txt";
        
        try (FileWriter fw = new FileWriter(nomeArquivo);
             PrintWriter out = new PrintWriter(fw)) {
            
            out.println("RELATÓRIO DO JOGADOR: " + usuario.getNome());
            out.println("========================================");
            
            // Usando o método que você tem no seu Usuario.java
            for (Aposta a : usuario.getHistoricoApostas()) {
                out.println(a.toString());
            }
            
            return true; 
            
        } catch (IOException e) {
            System.err.println("Erro ao salvar: " + e.getMessage());
            return false;
        }
    }
}
