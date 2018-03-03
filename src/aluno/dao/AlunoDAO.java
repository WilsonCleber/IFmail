package aluno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import aluno.dao.ConnectionFactory;
import aluno.models.AlunoModel;

public class AlunoDAO {
	private Connection connection;

	public AlunoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(AlunoModel aluno) {

		String sql = "insert into alunos (matricula, nome, email, endereco, dataNascimento) " + "values (?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, aluno.getMatricula());
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getEmail());
			stmt.setString(4, aluno.getEndereco());

			stmt.setDate(5, new java.sql.Date(aluno.getDataNascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<AlunoModel> getLista() {
		List<AlunoModel> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from alunos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Aluno
				AlunoModel aluno = new AlunoModel();
				aluno.setMatricula(rs.getLong("Matricula"));
				aluno.setNome(rs.getString("nome"));
				aluno.setEmail(rs.getString("email"));
				aluno.setEndereco(rs.getString("endereco"));

				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				aluno.setDataNascimento(data);

				// adicionando o objeto à lista
				result.add(aluno);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean alterar(AlunoModel aluno) {
		String sql = "update alunos set nome=?, email=?, endereco=?," + "dataNascimento=? where matricula=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getEmail());
			stmt.setString(3, aluno.getEndereco());
			stmt.setDate(4, new java.sql.Date(aluno.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, aluno.getMatricula());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(AlunoModel aluno) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from alunos where matricula=?");
			stmt.setLong(1, aluno.getMatricula());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}

}


