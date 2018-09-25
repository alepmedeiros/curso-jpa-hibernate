package Model;

public enum Genero {

	FEMENINO(0),MASCULINO(1);
	
	private int valor;
	
	Genero(int valor) {
		this.setValor(valor);
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
}
