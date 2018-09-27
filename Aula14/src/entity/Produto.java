package entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Produto {

	private Integer idProduto;
	private String nomeProduto;
	private Double preco;
	private Integer quantidade;
	private String promocao;
	private Double valor;

	public Produto() {

	}

	public Produto(Integer idProduto, String nomeProduto, Double preco,
			Integer quantidade, String promocao, Double valor) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.preco = preco;
		this.quantidade = quantidade;
		this.promocao = promocao;
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nomeProduto="
				+ nomeProduto + ", preco=" + preco + ", quantidade="
				+ quantidade + ", promocao=" + promocao + ", valor=" + valor
				+ "]";
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getPromocao() {
		return promocao;
	}

	public void setPromocao(String promocao) {
		this.promocao = promocao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
