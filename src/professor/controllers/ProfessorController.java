package professor.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import professor.dao.ProfessorDAO;
import professor.models.ProfessorModel;

@Controller
public class ProfessorController {

	

		@RequestMapping("professor/formp")
		public String form() {
			System.out.println("Acessando formulario de professor:");
			return "professor/formp";
		}

		@RequestMapping(value = "professor", method = RequestMethod.POST)
		public String gravar(ProfessorModel professor) {
			System.out.println("Acessando o metodo de gravar um professor!");
			System.out.println("Matricula: " + professor.getMatriculap());
			System.out.println("Nome: " + professor.getNome());
			System.out.println("Email: " + professor.getEmail());
			System.out.println("Endereço: " + professor.getEndereco());
			System.out.println("Disciplina: " + professor.getDisciplina());
			System.out.println("Data de nascimento: " + professor.getDataNascimento());

			ProfessorDAO dao = new ProfessorDAO();
			dao.inserir(professor);

			return "professor/okp";
		}

		@RequestMapping(value = "professor", method = RequestMethod.GET)
		public ModelAndView listar() {
			ProfessorDAO dao = new ProfessorDAO();
			List<ProfessorModel> professor = dao.getLista();

			ModelAndView modelAndView = new ModelAndView("professor/listar");
			modelAndView.addObject("professor", professor);
			return modelAndView;
		}

		@RequestMapping(value = "professor/remover")
		public ModelAndView remover(ProfessorModel professor) {
			ProfessorDAO dao = new ProfessorDAO();
			dao.remover(professor);

			return listar();

		}
	 
		@RequestMapping(value="professor/alterar")
		public ModelAndView alterar(ProfessorModel professor) {
			ProfessorDAO dao = new ProfessorDAO();
			dao.alterar(professor);
			
			return listar();
	}
	}
