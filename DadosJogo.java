package Principal;
import java.util.Random;

public class DadosJogo extends Jogos {

	

	Random rand = new Random();
	private int dadox;
	private int dadoy;
	private int nrodadas;
	

	public DadosJogo(double valorAposta, int dadox, int dadoy) {
		super(valorAposta);
		this.dadox = dadox;
		this.dadoy = dadoy;
	}

	public void setnrodadas(int nrodadas) {
		this.nrodadas = nrodadas;
	}
	
	int cpux = rand.nextInt(1,6);
	int cpuy = rand.nextInt(1,6);
	
	public void processarResultado() {
		
		
		
		
		
		if(cpux == dadoy && cpuy == dadoy) {
			setGanho((getValorAposta() * 1));
		}else if((cpux == dadox && cpuy != dadoy) ||(cpuy == dadoy && cpux != dadox)) {
			setGanho((getValorAposta() * 0.5));
		}else {
			setGanho(0.0);
		}
		
		
	}
	

	public int getDadox() {
		return dadox;
	}


	public int getDadoy() {
		return dadoy;
	}

	@Override
	public String toString() {
		return "Roleta - Aposta: R$" + getValorAposta() + "  Dados do jogador: " 
	+getDadox()  + " e "+ getDadoy() + " || Dados escolhidos: " + cpux +" e "+ cpuy+ "\n | Ganho: R$" + getGanho();
	}

}
