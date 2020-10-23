package model;

public class Departamento {

	private Long depart_id;
	private String depart_nome;
	private String func_Id;
	

	public Long getId() {
		return depart_id;
	}

	public void setId(Long depart_id) {
		this.depart_id = depart_id;
	}

	public String getNome() {
		return depart_nome;
	}

	public void setNome(String depart_nome) {
		this.depart_nome = depart_nome;
	}

	public String getFuncId() {
		return func_Id;
	}

	public void setFuncId(String func_Id) {
		this.func_Id = func_Id;
	}

	@Override
	public String toString() {
		return "Departamento [depart_id=" + depart_id + ", depart_nome=" + depart_nome + ", func_Id=" + func_Id + "]";
	}

}
