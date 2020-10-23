package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Cargo;
import model.Departamento;
import model.Historico_Depart;
import model.Funcionario;

public class CardifDAO {

	private Connection connection;

	public CardifDAO() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(Funcionario funcionario) {
		try {
			String sql = "insert into Funcionario (nome, cargo) values (?,?)";
																				
																				
			// Retorna o obejto de instrução
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, funcionario.getNome()); // Parâmetro sendo
														// adicionados
			insert.setString(2, funcionario.getCargoId());
			insert.execute();// SQL sendo excutado no banco de dados
			connection.commit();// salva no banco

		} catch (Exception e) {
			try {
				connection.rollback();// reverte operação caso tenha erros
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
	}
   
	 public Funcionario buscar(Long func_id) throws Exception {
		Funcionario retorno = new Funcionario();
		String sql = "select * from Funcionario where func_id = " + func_id; 

		PreparedStatement statement = connection.prepareStatement(sql);
																		
		ResultSet resultado = statement.executeQuery();
														

		while (resultado.next()) { 

			retorno.setId(resultado.getLong("func_id"));												
			retorno.setNome(resultado.getString("Func_Nome"));
			retorno.setCargoId(resultado.getString("Cardo_Id"));

		}
		return retorno;
	}
	

	public void atualizar(Funcionario funcionario) {
		try {
			
			String sql = "update Funcionario set Func_Nome = ? where id = " + funcionario.getId();

			PreparedStatement statement = connection.prepareStatement(sql); 																			
																			
			statement.setString(1, funcionario.getNome()); 											
														

			statement.execute(); // Executando a atualização
			connection.commit(); // Comitando/Gravando no banco de dados

		} catch (Exception e) {
			try {
				connection.rollback();// Reverte caso dê algum erro
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public void deletar(Long func_id) {
		try {

			String sql = "delete from Funcionario where Func_Id = " + func_id; 
																		
			PreparedStatement preparedStatement = connection.prepareStatement(sql); 
			preparedStatement.execute();// Executando no banco de dados
			connection.commit();// Efetuando o commit/gravando no banco de dados

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();

		}
	}

	public List<String> listaFuncDepart(Long depart_id) {

		List<String> list = new ArrayList<String>();

		String sql = " SELECT F.Func_Nome, D.Depart_Nome ";
	        	sql += " FROM Departamento D, Funcionario F, Func_Depart FD ";
				sql += " WHERE D.Depart_Id = ? ";
				sql += " AND F.Func_Id = FD.Func_Id ";
				sql += " AND D.Depart_Id = FD.Depart_Id ";
		
		try {

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Funcionario funcionario = new Funcionario();
				Departamento departamento = new Departamento();
				
				funcionario.setNome(resultSet.getString("Func_Nome"));
				departamento.setDepartamento(resultSet.getString("Depart_Nome"));
				

				list.add(funcionario, departamento);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}
	
	
	
	public List<String> listaHistoricoDepartUser(Long func_id) {

		List<String> list = new ArrayList<String>();

		String sql = SELECT F.Func_Nome, D.Depart_Nome, HD.Data_Ini, HD.Data_Fim";
				sql += FROM Departamento D, Funcionario F, Historico_Depart HD";
				sql +=WHERE F.Func_Id = ?";
				sql +=  AND F.Func_Id = HD.Func_Id";
				sql +=  AND D.Depart_Id = HD.Depart_Id";
				sql +=ORDER BY HD.Data_Ini ASC";
		
		try {

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Funcionario funcionario = new Funcionario();
				Departamento departamento = new Departamento();
				Historico_Depart historico_Depart = new Historico_Depart();
				
				funcionario.setNome(resultSet.getString("Func_Nome"));
				departamento.setDepartamento(resultSet.getString("Depart_Nome"));
				historico_Depart.setDataInicio(resultSet.getString("Data_Ini"));
				historico_Depart.setDataFim(resultSet.getString("Data_Fim"));
				

				list.add(funcionario, departamento, historico_Depart);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}
	
	public List<String> listaChefeDepart(Long func_id) {

		List<String> list = new ArrayList<String>();
		String sql = "SELECT F.Func_Nome, D.Depart_Nome, C.Cargo_Nome";
				sql += "FROM Departamento D, Funcionario F, Func_Depart FD, Cargo C";
				sql +="WHERE F.Func_Id = ?";
				sql += " AND F.Func_Id = FD.Func_Id ";
				sql += " AND D.Depart_Id = FD.depart_id";
				sql += " AND C.Cargo_Id = F.Cargo_Id";
				
		try {

			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Funcionario funcionario = new Funcionario();
				Departamento departamento = new Departamento();
				Cargo cargo = new Cargo();
				
				funcionario.setNome(resultSet.getString("Func_Nome"));
				departamento.setDepartamento(resultSet.getString("Depart_Nome"));
				cargo.setCargoNome(resultSet.getString("Cargo_Nome"));

				list.add(funcionario, departamento, cargo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

}
