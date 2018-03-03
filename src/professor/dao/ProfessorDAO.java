package professor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import aluno.dao.ConnectionFactory;
import professor.models.ProfessorModel;

public class ProfessorDAO {
	private Connection connection;

	public ProfessorDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(ProfessorModel professor) {

		String sql = "insert into professor (matriculap, nome, email, endereco, dataNascimento, disciplina) " + "values (?, ?, ?, ?, ?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, professor.getMatriculap());
			stmt.setString(2, professor.getNome());
			stmt.setString(3, professor.getEmail());
			stmt.setString(4, professor.getEndereco());
			stmt.setString(5, professor.getDisciplina());

			stmt.setDate(6, new java.sql.Date(professor.getDataNascimento().getTimeInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<ProfessorModel> getLista() {
		List<ProfessorModel> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from professor");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto professor
				ProfessorModel professor = new ProfessorModel();
				professor.setMatriculap(rs.getLong("Matriculap"));
				professor.setNome(rs.getString("nome"));
				professor.setEmail(rs.getString("email"));
				professor.setEndereco(rs.getString("endereco"));
				professor.setDisciplina(rs.getString("disciplina"));

				// montando a data através do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				professor.setDataNascimento(data);

				// adicionando o objeto à lista
				result.add(professor);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean alterar(ProfessorModel professor) {
		String sql = "update professor set nome=?, email=?, endereco=?, dataNascimento=?, disciplina=?, where matriculap=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, professor.getNome());
			stmt.setString(2, professor.getEmail());
			stmt.setString(3, professor.getEndereco());
			stmt.setString(4, professor.getDisciplina());
			stmt.setDate(5, new java.sql.Date(professor.getDataNascimento().getTimeInMillis()));
			stmt.setLong(6, professor.getMatriculap());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(ProfessorModel professor) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from professor where matriculap=?");
			stmt.setLong(1, professor.getMatriculap());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
		return true;
	}

}

