package Model;

public enum TipoPessoa {

	FORNECEDOR(0),CLIENTE(1);
	
	private int valor;
	
	TipoPessoa(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}
	
}
