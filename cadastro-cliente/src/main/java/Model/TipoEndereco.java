package Model;

public enum TipoEndereco {

	COMERCIAL(0),RESIDENCIAL(1),COBRANCA(2);
	
	private int valor;
	
	TipoEndereco(int valor) {
		this.setValor(valor);
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
}
