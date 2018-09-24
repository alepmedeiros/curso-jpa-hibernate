package Model;

public enum Genero {

	FEMENINO('F'),MASCULINO('M');
	
	private char valor;
	
	Genero(char valor) {
		this.setValor(valor);
	}

	public char getValor() {
		return valor;
	}

	public void setValor(char valor) {
		this.valor = valor;
	}
	
}
