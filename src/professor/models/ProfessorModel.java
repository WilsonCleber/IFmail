package professor.models;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class ProfessorModel {


	private Long matriculap;
	private String nome;
	private String email;
	private String endereco;
	private String disciplina; 
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar dataNascimento;

	public Long getMatriculap() {
		return matriculap;
	}

	public void setMatriculap(Long matriculap) {
		this.matriculap = matriculap;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}	

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



}
