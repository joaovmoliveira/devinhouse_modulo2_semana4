package br.com.devinhouse.faculdade.gastos;

public class Professor extends Funcionario {
	private int horasDeAula;
	private int qtdDisciplinas;
	
	@Override
	public double getGastos() {
		return this.getSalario() + this.horasDeAula*10;
	}
	
	@Override
	public String getInfo() {
		return String.format("%s%nTeve %d horas de aula.", 
				super.getInfo(), this.horasDeAula);
	}

	public int getHorasDeAula() {
		return horasDeAula;
	}

	public void setHorasDeAula(int horasDeAula) {
		this.horasDeAula = horasDeAula;
	}

	public int getQtdDisciplinas() {
		return qtdDisciplinas;
	}

	public void setQtdDisciplinas(int qtdDisciplinas) {
		this.qtdDisciplinas = qtdDisciplinas;
	}
}
