package model;

public class Funcionario {

	private Long func_id;
	private String nome;
	private String cargo_id;
	

	public Long getId() {
		return func_id;
	}

	public void setId(Long func_id) {
		this.func_id = func_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargoId() {
		return cargo_id;
	}

	public void setCargoId(String cargo_id) {
		this.cargo_id = cargo_id;
	}

	@Override
	public String toString() {
		return "Funcionario [func_id=" + func_id + ", nome=" + nome + ", cargo_id=" + cargo_id + "]";
	}

}
