package br.com.devinhouse.jogo.enums;

public enum Motivacao {
	VINGANCA(1, "VINGAN�A"), 
	GLORIA(2, "GL�RIA");
	
	private int id;
    private String motivacao;

    Motivacao(int id, String motivacao) {
        this.id = id;
        this.motivacao = motivacao;
    }

    public int getId() {
        return id;
    }

    public String getMotivacao() {
        return motivacao;
    }
    
    public static String getMotivacao(int id) {
        return  Motivacao.values()[id].getMotivacao();
    }
}
