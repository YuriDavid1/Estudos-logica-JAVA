package matricula.service;
import java.util.HashMap;

import matricula.model.Aluno;
import matricula.model.Curso;
import matricula.model.Matricula;
import matricula.repository.AlunosRepository;
import matricula.repository.CursosRepository;
import matricula.repository.MatriculaRepository;

public class MatriculaService {

	private MatriculaRepository matriculaRepositorio;
	private AlunosRepository alunoRepositorio;
	private CursosRepository cursosRepositorio;
	
public MatriculaService(MatriculaRepository repositorio, AlunosRepository alunoRepositorio, CursosRepository cursosRepositorio) {
	this.matriculaRepositorio = repositorio;
	this.alunoRepositorio = alunoRepositorio;
	this.cursosRepositorio = cursosRepositorio;
}
	
	
	public boolean criarMatricula(int idMatricula, int idAluno, int idCurso) {
	//Verificações da MATRICULA
	if(idMatricula <= 0) {
		throw new IllegalArgumentException("O ID deve ser válido.");
	}
	if(matriculaRepositorio.buscarPorId(idMatricula) != null) {
		throw new IllegalArgumentException("O ID inserido já está em uso.");
	}
	//Verificações do ALUNO
	Aluno aluno = alunoRepositorio.buscarPorId(idAluno);
	if(aluno == null) {
		throw new IllegalArgumentException("O Aluno inserido não foi encontrado.");
	}
	
	//Verificações do Curso
	Curso curso = cursosRepositorio.buscarPorId(idCurso);
	if(curso == null) {
		throw new IllegalArgumentException("Este curso não existe.");
	}

	Matricula matricula = new Matricula(idMatricula, aluno, curso);
	matriculaRepositorio.criarMatricula(matricula);
	return true;	
	}
	
	public Matricula buscarPorId(int id) {
		if(matriculaRepositorio.buscarPorId(id) == null) {
			throw new IllegalArgumentException("Este ID é inválido.");
		}
		return matriculaRepositorio.buscarPorId(id);
	}
	
	public Matricula buscarPorAluno(String nomeAluno) {

	    for (Matricula matricula : matriculaRepositorio.listarTodos().values()) {
	        if (matricula.getAluno().getNome().equalsIgnoreCase(nomeAluno)) {
	            return matricula;
	        }
	    }

	    throw new IllegalArgumentException("Aluno não está matriculado em nenhum curso.");
	}

	public void removerMatricula(String nomeAluno, String nomeCurso) {
		Aluno aluno = alunoRepositorio.buscarAlunoPorNome(nomeAluno);
		if(aluno == null) {
			throw new IllegalArgumentException("Aluno não encontrado");
		}
		Curso curso = cursosRepositorio.buscarCursoPorNome(nomeCurso);
		if(curso == null) {
			throw new IllegalArgumentException("Curso não encontrado");
		}
		
		for(Matricula matricula : matriculaRepositorio.listarTodos().values()) {
			if(matricula.getAluno().getId() == aluno.getId() &&
				matricula.getCurso().getId() == curso.getId()) {
				matriculaRepositorio.removerMatricula(matricula.getId());
				return;
			}
		}
		throw new IllegalArgumentException("Matricula não encontrada");
	}
		
	public HashMap<Integer, Matricula> listarTodas(){
		return matriculaRepositorio.listarTodos();
	}
}