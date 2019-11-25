package senac.org.prova_backend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
*
* @author Christian
*/

@Entity
@Table(name="tb_projeto")
public class Projeto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="id_projeto")
	private Integer idProjeto;
	
	@NotNull
	@Column(length = 200)	
	private String nome;
	
	@NotNull
	private Double prazo;
	
	@NotNull	
	private Double orcamento;
	
	@ManyToOne
	@JoinColumn(name="id_area")	
	private Area area;

	public Integer getIdProjeto() {
		return idProjeto;
	}

	public void setIdProjeto(Integer idProjeto) {
		this.idProjeto = idProjeto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPrazo() {
		return prazo;
	}

	public void setPrazo(Double prazo) {
		this.prazo = prazo;
	}

	public Double getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Double orcamento) {
		this.orcamento = orcamento;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}	
		
}
