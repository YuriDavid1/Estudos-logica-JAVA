package matricula.service;
import java.util.HashMap;

import matricula.model.Aluno;
import matricula.repository.AlunosRepository;


public class AlunoService {

	private AlunosRepository repositorio;
	
	public AlunoService(AlunosRepository repositorio) {
		this.repositorio = repositorio;
	}
	
	public boolean cadastrarAluno(Aluno aluno) {
	if(aluno.getId() <= 0) {
		throw new IllegalArgumentException("Erro. Insira um ID válido.");
	}
	
	if(repositorio.buscarPorId(aluno.getId()) != null) {
		throw new IllegalArgumentException("O ID inserido já está em uso.");
	}
	
	if(aluno.getNome() == null || aluno.getNome().isEmpty()) {
		throw new IllegalArgumentException("É obrigatório inserir o nome do aluno.");
	}
	
	if(aluno.getIdade() <= 0) {
		throw new IllegalArgumentException("Obrigatório inserir uma idade valida.");
	}
	
	System.out.println("Cadastro realizado.");
	repositorio.registrarAlunos(aluno);
	return true;
	}
	
	public Aluno buscarPorId(int id) {
	Aluno aluno = repositorio.buscarPorId(id);
	if(aluno == null) {
		throw new IllegalArgumentException("Insira um ID existente.");
	}
	return repositorio.buscarPorId(id);
	}
	
	public boolean removerAluno(int id) {
		if(repositorio.buscarPorId(id) == null) {
			throw new IllegalArgumentException("O Id inserido é invalido.");
		}
		repositorio.removerPorId(id);
		return true;
	}
	
	public HashMap<Integer, Aluno> listarTodos(){
		return repositorio.listarTodos();
	}
	
	public Aluno buscarPorNome(String nome) {
		Aluno aluno = repositorio.buscarAlunoPorNome(nome);
		if(aluno == null ) {
			throw new IllegalArgumentException("Aluno não encontrado");
		}
		return repositorio.buscarAlunoPorNome(nome);
	}
	
	
}
