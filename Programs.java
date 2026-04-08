package Principal;

import java.util.Scanner;

public class Programs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		Jogos jogo = new Jogos();
		
		/*int x = sc.nextInt();
		
		Double aposta = sc.nextDouble();
		jogo.roleta(x, aposta);*/
		
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		Double aposta = sc.nextDouble();
		jogo.Dados(x, y, aposta);
	}

}
