package Principal;
import java.util.Random;
import java.lang.Math;

public class Jogos {

	private Double valoraposta;
	private Double ganho;
	Random numrolet = new Random();
	
	public void roleta(int x, Double valoraposta) {
		
		
		int num = numrolet.nextInt(36);
		
		int distancia = Math.abs(x -num);
		Double giroRoleta;
		
		if(distancia > 5) {
			giroRoleta = 0.0;
		}else {
			giroRoleta = valoraposta  * (16/ (1+Math.abs(x -num) ) );
		}
		System.out.println(giroRoleta + ", nuemro da aposta: " + num + "distancia: " + distancia);
	}
	
	public void Dados(int x, int y, Double valaposta) {
		//for(int i = 0; i <3; i++) {
			int xmaquina = numrolet.nextInt( 6); //(i - 6)
			int ymaquina = numrolet.nextInt( 6);//(i - 6)
			Double ganho = 0.0;
			
			
			if((xmaquina == x && ymaquina != y) ||(ymaquina == y && xmaquina != x)) {
				ganho+= 1.2 * valaposta;
			}else if(xmaquina == x && ymaquina == y ) {
				ganho+= 1.7 * valaposta;
			}
			
			System.out.println("ganho: " + ganho + ", x e y da maquina = " + xmaquina + ", " +  ymaquina );
	//	}
	}
	
}
