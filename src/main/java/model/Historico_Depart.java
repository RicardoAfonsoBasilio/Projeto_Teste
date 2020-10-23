package model;

public class Historico_Depart {

	private Long depart_id;
	private Long func_id;
	private Date dataInicio;
	private Date dataFim;
	

	public Long getIdFunc() {
		return func_id;
	}

	public void setIdFunc(Long func_id) {
		this.func_id = func_id;
	}
	public Long getIdDepart() {
		return depart_id;
	}

	public void setIdDepart(Long depart_id) {
		this.depart_id = depart_id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	@Override
	public String toString() {
		return "Funcionario [func_id=" + func_id + ", depart_id=" + depart_id + ", dataInicio=" + dataInicio + ", dataFim=" + dataFim + "]";
	}

}
