package br.com.devinhouse.jogo.personagens;

public abstract class Personagem {
	private int pontosDeSaude;
	private int pontosDeAtaque;
	private int pontosDeDefesa;
	
	public Personagem(int pontosDeAtaque, int pontosDeDefesa, int pontosDeSaude) {
		this.pontosDeAtaque = pontosDeAtaque;
		this.pontosDeDefesa = pontosDeDefesa;
		this.pontosDeSaude = pontosDeSaude;
	}
	
	public int sofreDano(int forcaAtaqueSofrido, boolean danoCritico) {
		if (forcaAtaqueSofrido <= this.pontosDeDefesa) {
			return 0;
		}
		
		int qtdDanoSofrido = forcaAtaqueSofrido;
		
		if (!danoCritico) {
			qtdDanoSofrido -= this.pontosDeDefesa;
		}
		
		this.pontosDeSaude -= qtdDanoSofrido;
		
		return qtdDanoSofrido;
	}
	
	public int getPontosDeSaude() {
		return this.pontosDeSaude;
	}

	public int getPontosDeAtaque() {
		return this.pontosDeAtaque;
	}

	public void aumentaPontosDeDefesa(int acrescimo) {
		this.pontosDeDefesa += acrescimo;
	}
	
	public void curaTodasAsFeridas(int saudeMaxima) {
		this.pontosDeSaude = saudeMaxima;
	}

	public boolean estaMorto() {
		return this.getPontosDeSaude() < 1;
	}
	
}

