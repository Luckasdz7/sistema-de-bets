package Principal;

import java.util.List;
import java.util.Scanner;

public class SistemaBet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario usuario = null; // Objeto principal (1)

        while (true) {
            // 1. O menu aparece para o usuário
            System.out.println("\n--- SISTEMA DE BETS ---");
            System.out.println("1. Cadastrar Usuário e Apostar");
            System.out.println("2. Exibir Histórico");
            System.out.println("3. Salvar em Arquivo Texto");
            System.out.println("4. Sair");
            
            int opcao = sc.nextInt(); // Lê a opção escolhida

            // 2. O sistema verifica qual opção foi digitada
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
                  			
                  			DadosJogo dados = new DadosJogo(valor, x, y, i);
                  			dados.processarResultado();
                  			usuario.adicionarAposta(new Aposta(dados, "08/04/2026"));
                  			 System.out.println("Resultado: " + dados.getGanho());
                  		}
                  		System.out.println("Quer continuar? s/n");
                  	 decision = sc.next().charAt(0);
                  		
                  	}while(decision == 's');
                  	
                  	
                  	
                  	
                  	
                  }
                  
            } 
            else if (opcao == 2) {
            	if (usuario != null) {
                    System.out.println("\n========== HISTÓRICO DE " + usuario.getNome().toUpperCase() + " ==========");
                    
                    // 2. Obtém a lista de apostas do utilizador
                    List<Aposta> lista = usuario.getHistoricoApostas();

                    // 3. Verifica se a lista está vazia
                    if (lista.isEmpty()) {
                        System.out.println("Ainda não foram realizadas apostas.");
                    } else {
                        // 4. Percorre a lista e imprime cada aposta
                        // O Java chama automaticamente o método toString() de cada Aposta
                        for (Aposta a : lista) {
                            System.out.println(a.toString());
                            System.out.println("-----------------------------------------");
                        }//
                    }
                } else {
                    System.out.println("Erro: Nenhum jogador foi cadastrado ainda. Use a opção 1 primeiro.");
                }
            } 
            
            // AQUI ENTRA O CÓDIGO DA OPÇÃO 3:
            else if (opcao == 3) {
                if (usuario != null) {
                    System.out.println("Gravando dados no arquivo...");
                    
                    // Chama a classe especialista que criamos separada
                    boolean sucesso = GerenciadorArquivo.salvarRelatorio(usuario);
                    
                    if (sucesso) {
                        System.out.println("Arquivo gerado com sucesso!");
                    } else {
                        System.out.println("Falha crítica ao salvar os dados.");
                    }
                } else {
                    System.out.println("Não há usuário cadastrado para salvar.");
                }
            } 
            
            else if (opcao == 4) {
                System.out.println("Saindo...");
                break; // Encerra o programa
            }
        }
        sc.close();
    }
}