package Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pessoa implements Serializable{

	private static final long serialVersionUID = -8901121838786564263L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Date dtnasc;
	private String email;
	
	@Enumerated(EnumType.ORDINAL)
	private Genero genero;
	
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
		
	public Pessoa(String nome, Date dtnasc, String email, Genero genero) {
		super();
		this.nome = nome;
		this.dtnasc = dtnasc;
		this.email = email;
		this.genero = genero;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDtnasc() {
		return dtnasc;
	}
	public void setDtnasc(Date dtnasc) {
		this.dtnasc = dtnasc;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", dtnasc=" + dtnasc + ", email=" + email + ", genero=" + genero
				+ "]";
	}
	
	
}
