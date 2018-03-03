package aluno.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import aluno.dao.AlunoDAO;
import aluno.models.AlunoModel;

@Controller
public class AlunoController {

	

		@RequestMapping("aluno/form")
		public String form() {
			System.out.println("Acessando formulario de alunos:");
			return "aluno/form";
		}

		@RequestMapping(value = "aluno", method = RequestMethod.POST)
		public String gravar(AlunoModel aluno) {
			System.out.println("Acessando o metodo de gravar um aluno!");
			System.out.println("Matricula: " + aluno.getMatricula());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Email: " + aluno.getEmail());
			System.out.println("Endereço: " + aluno.getEndereco());
			System.out.println("Data de nascimento: " + aluno.getDataNascimento());

			AlunoDAO dao = new AlunoDAO();
			dao.inserir(aluno);

			return "aluno/ok";
		}

		@RequestMapping(value = "aluno", method = RequestMethod.GET)
		public ModelAndView listar() {
			AlunoDAO dao = new AlunoDAO();
			List<AlunoModel> aluno = dao.getLista();

			ModelAndView modelAndView = new ModelAndView("aluno/listar");
			modelAndView.addObject("aluno", aluno);
			return modelAndView;
		}

		@RequestMapping(value = "aluno/remover")
		public ModelAndView remover(AlunoModel aluno) {
			AlunoDAO dao = new AlunoDAO();
			dao.remover(aluno);

			return listar();

		}
	 
		@RequestMapping(value="aluno/alterar")
		public ModelAndView alterar(AlunoModel aluno) {
			AlunoDAO dao = new AlunoDAO();
			dao.alterar(aluno);
			
			return listar();
	}
	}
