package Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pessoa implements Serializable{

	private static final long serialVersionUID = -8901121838786564263L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_pessoa")
	@SequenceGenerator(name = "id_pessoa", sequenceName = "id_pessoa", allocationSize = 1, initialValue = 1)
	private Long id;
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Date dtnasc;
	private String email;
	
	@Enumerated(EnumType.ORDINAL)
	private Genero genero;
	
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
}
