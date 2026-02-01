package matricula.service;
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
	        if (matricula.getAluno().getNome() == nomeAluno) {
	            return matricula;
	        }
	    }

	    throw new IllegalArgumentException("Aluno não está matriculado em nenhum curso.");
	}

	
	
}
