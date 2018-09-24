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
import javax.persistence.ManyToMany;
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
	
	@ManyToMany(targetEntity = Endereco.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
