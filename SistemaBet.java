package Principal;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class SistemaBet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario usuario = null;

        while (true) {
            System.out.println("\n--- SISTEMA DE BETS ---");
            System.out.println("1. Cadastrar Usuário e Apostar");
            System.out.println("2. Exibir Histórico");
            System.out.println("3. Salvar em Arquivo Texto");
            System.out.println("4. Sair");
            int opcao = sc.nextInt();

            if (opcao == 1) {
                sc.nextLine();
                if (usuario == null) {
                    System.out.print("Nome do Jogador: ");
                    usuario = new Usuario(sc.nextLine());
                }

                System.out.println("Escolha o jogo: 1.Roleta | 2.Dados");
                int tipo = sc.nextInt();
                
                double valor;

                if (tipo == 1) {
                    System.out.print("Escolha um número (0-36): ");
                    int num = sc.nextInt();
                    System.out.print("Valor da Aposta: ");
                    valor = sc.nextDouble();
                    Roleta r = new Roleta(valor, num);
                   
                    r.processarResultado();
                    usuario.adicionarAposta(new Aposta(r, "08/04/2026"));
                    System.out.println("Resultado: " + r.getGanho());
                }else {
                	char decision;
                	do {
                	
                		for(int i = 0; i < 3; i++) {
                			
                			System.out.println("RODADA "+  (i + 1) + "DE 3");
                			System.out.println("Escolha um lado do dado de 1 a " + (6 -  i));
                			int x = sc.nextInt();
                			System.out.println("Escolha novamente um lado do dado de 1 a " + (6 -  i));
                			int y = sc.nextInt();
                			System.out.println("Selecione o valor da aposta, min 5 reais");
                			valor = sc.nextDouble();
                			
                			DadosJogo dados = new DadosJogo(valor, x, y);
                			dados.processarResultado();
                			usuario.adicionarAposta(new Aposta(dados, "08/04/2026"));
                			 System.out.println("Resultado: " + dados.getGanho());
                		}
                		System.out.println("Quer continuar? s/n");
                	 decision = sc.next().charAt(0);
                		
                	}while(decision == 's');
                	
                	
                	
                	
                	
                }
                
            } 
            else if (opcao == 2 && usuario != null) {
                System.out.println("Usuário: " + usuario.getNome());
                for (Aposta a : usuario.getHistoricoApostas()) {
                    System.out.println(a);
                }
            } 
            else if (opcao == 3 && usuario != null) {
                try (PrintWriter out = new PrintWriter(new FileWriter("relatorio_bets.txt"))) {
                    out.println("RELATÓRIO DE APOSTAS - " + usuario.getNome());
                    for (Aposta a : usuario.getHistoricoApostas()) {
                        out.println(a);
                    }
                    System.out.println("Dados salvos com sucesso!");
                } catch (Exception e) {
                    System.out.println("Erro ao salvar arquivo.");
                }
            } 
            else if (opcao == 4) break;
        }
        sc.close();
    }
}