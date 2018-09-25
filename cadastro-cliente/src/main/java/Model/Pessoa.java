package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 2777360442921224707L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencePessoa")
	@SequenceGenerator(name = "sequencePessoa", sequenceName = "id_pessoa", allocationSize=1)
	private Integer id;
	
	@Column(length = 80)
	private String nome;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column
	@Enumerated(EnumType.ORDINAL)
	private Genero genero;
	
	@Column(nullable=false, columnDefinition = "Integer default 1")
	@Enumerated(EnumType.ORDINAL)
	private TipoPessoa tipo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa", targetEntity = Endereco.class, fetch = FetchType.LAZY)
	private List<Endereco> enderecos;
	
	public Pessoa() {
		enderecos = new ArrayList<Endereco>();
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public TipoPessoa getTipo() {
		return tipo;
	}


	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}


	public List<Endereco> getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
}
