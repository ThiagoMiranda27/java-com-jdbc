package com.curso.java2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.curso.java2.model.Funcionario;

public class FuncionarioDAO {

	private Connection con = null;

	public void adicionarFuncionarios(Funcionario funcionario) {
		try {
			con = Dao.getConnection();

			String sql = "INSERT INTO funcinario(nome, data_nascimento, setor_id) VALUES(? ? ?)";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, funcionario.getNome());
			stmt.setObject(2, funcionario.getDataNascimento());
			stmt.setLong(3, funcionario.getSetorId());

			stmt.execute();
			System.out.println("\nFuncionario Adicionado no Banco de Dados\n");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Dao.closeConnection(con);
		}
	}

	public void alterarFuncionario(Funcionario funcionario) {
		try {
			con = Dao.getConnection();

			String sql = "UPDATE funcionario SET nome = ? WHERE id_funcioanario = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, funcionario.getNome());
			stmt.setLong(2, funcionario.getIdSeto());

			stmt.execute();
			System.out.println("\nFuncionario Alterado no Banco de Dados\n");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Dao.closeConnection(con);
		}
	}

	public void deletarFuncionario(Long funcionarioId) {
		try {
			con = Dao.getConnection();

			String sql = "DELETE FROM Funcionario WHERE id_funcionario = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setLong(1, funcionarioId);

			stmt.execute();
			System.out.println("\nFuncionario Removido no Banco de Dados\n");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Dao.closeConnection(con);
		}
	}

	public List<Funcionario> listarFuncionario() {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();

		String sql = "SELECT id_funcinario, nome FROM funcionario";

		try {
			con = Dao.getConnection();

			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Funcionario funcionario = new Funcionario();
				funcionario.setIdFuncionario(rs.getLong("id_funcionario"));
				funcionario.setNome(rs.getString("nome"));

				funcionarios.add(funcionario);
			}

			rs.close();

			return funcionarios;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			return funcionarios;
		}

	}

	public Funcionario buscarFuncionarioPeloId(Long funcionarioId) {
		Funcionario funcionario = new Funcionario();

		try {
			con = Dao.getConnection();

			String sql = "SELECT nome, data_nascinemento, setor_id FROM funcionario WHERE id_funcionario = ?;
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setLong(1, funcionarioId);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				funcionario.setIdFuncionario(rs.getLong("id_funcionario"));
				funcionario.setNome(rs.getString("nome"));
			}

			rs.close();

			return funcionario;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Dao.closeConnection(con);
			return funcionario;
		}
	}
}
