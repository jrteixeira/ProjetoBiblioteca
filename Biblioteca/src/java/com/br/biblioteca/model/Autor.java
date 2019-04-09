
package com.br.biblioteca.model;




import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "id_autor", sequenceName = "id_autor", allocationSize = 1, initialValue = 1 )
public class Autor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "id_autor")
	private Integer id;
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
