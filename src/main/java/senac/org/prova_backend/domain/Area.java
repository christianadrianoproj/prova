package senac.org.prova_backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
*
* @author Christian
*/

@Entity
@Table(name="tb_area")
public class Area {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="id_area")
	private Integer idArea;
	
	@NotNull
	@Column(length = 150)	
	private String nome;
	
	@NotNull
	private Double orcamentoMinimo;
	
	@NotNull
	private Double orcamentoMaximo;

	public Integer getIdArea() {
		return idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getOrcamentoMinimo() {
		return orcamentoMinimo;
	}

	public void setOrcamentoMinimo(Double orcamentoMinimo) {
		this.orcamentoMinimo = orcamentoMinimo;
	}

	public Double getOrcamentoMaximo() {
		return orcamentoMaximo;
	}

	public void setOrcamentoMaximo(Double orcamentoMaximo) {
		this.orcamentoMaximo = orcamentoMaximo;
	}

}
