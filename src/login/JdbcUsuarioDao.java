package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aluno.dao.ConnectionFactory;

public class JdbcUsuarioDao {
	private Connection connection;

	public void JdvcUsuarioDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Usuario usuario) {

		String sql = "insert into usuario (matricula, senha) " + "values (?, ?);";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setLong(1, usuario.getMatricula());
			stmt.setString(2, usuario.getSenha());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Usuario> getLista() {
		List<Usuario> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from usuario");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Usuario usuario = new Usuario();
				usuario.setMatricula(rs.getLong("Matricula"));
				usuario.setSenha(rs.getString("Senha"));

				
				result.add(usuario);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean existeUsuario(Usuario usuario) {
		
		return false;
	}
}
