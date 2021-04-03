package br.com.devinhouse.jogo.enums;

public enum Arma {
	ESPADA(5, "Espada", "com sua espada"), 
	MACHADO(5, "Machado", "com seu machado"),
	MARTELO(5, "Martelo", "com seu martelo"),
	CLAVA(5, "Clava", "com sua clava"),
	ARCO(5, "Arco-e-flecha", "com seu arco, a flecha atingiu"),
	BESTA(5, "Besta", "com sua besta, o virote atingiu"),
	CAJADO(5, "Cajado", "com seu cajado, lançando uma bola de fogo"),
	LIVRO(5, "Livro de magias", "absorvendo energia do livro com uma mão e liberando com a outra"),
	ARMADILHA(2, "Armadilha", null),
	MACHADO_DUPLO(7, "Machado de Lâmina Dupla", null);
	
	private int poderDeAtaque;
    private String nome;
    private String mensagemDeAtaque;

	Arma(int poderDeAtaque, String nome, String mensagemDeAtaque) {
        this.poderDeAtaque = poderDeAtaque;
        this.nome = nome;
        this.mensagemDeAtaque = mensagemDeAtaque;
    }

    public int getPoderDeAtaque() {
        return this.poderDeAtaque;
    }

    public String getNome() {
        return this.nome;
    }
    
    public String getMensagemDeAtaque() {
    	return this.mensagemDeAtaque;
    }
}
