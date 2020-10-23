package model;

public class Cargo {

	private Long cargo_id;
	private String cargo_nome;
	
	

	public Long getId() {
		return cargo_id;
	}

	public void setId(Long cargo_id) {
		this.cargo_id = cargo_id;
	}

	public String getCargoNome() {
		return nome;
	}

	public void setCargoNome(String nome) {
		this.nome = nome;
	}

	

	@Override
	public String toString() {
		return "Cargo [func_id=" + func_id + ", nome=" + nome + "]";
	}

}
