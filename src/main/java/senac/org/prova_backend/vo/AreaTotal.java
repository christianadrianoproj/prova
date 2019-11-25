package senac.org.prova_backend.vo;

/**
*
* @author Christian
*/

public class AreaTotal {
	private String area;
	private Double orcamentoTotal;
	private Double prazoMedio;
	private Long quantidade;
	
	
	public AreaTotal(String area, Double orcamentoTotal, Long quantidade, Double prazoMedio) {
		super();
		this.area = area;
		this.orcamentoTotal = orcamentoTotal;
		this.prazoMedio = prazoMedio;
		this.quantidade = quantidade;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public Double getOrcamentoTotal() {
		return orcamentoTotal;
	}


	public void setOrcamentoTotal(Double orcamentoTotal) {
		this.orcamentoTotal = orcamentoTotal;
	}


	public Double getPrazoMedio() {
		return prazoMedio;
	}


	public void setPrazoMedio(Double prazoMedio) {
		this.prazoMedio = prazoMedio;
	}


	public Long getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
		
}
