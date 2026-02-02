package matricula.service;
import matricula.model.EstadoCurso;
import matricula.repository.CursosRepository;

import java.util.HashMap;
import java.util.NoSuchElementException;

import matricula.model.Aluno;
import matricula.model.Curso;
public class CursosService {

	private CursosRepository repositorio;
		
	public CursosService(CursosRepository repostiorio) {
		this.repositorio = repositorio;
	}
	public boolean criarCurso(Curso curso) {
	if(curso.getId() <= 0) {
		throw new IllegalArgumentException("ID já cadastrado");
	}
	
	if(repositorio.buscarPorId(curso.getId()) != null) {
		throw new IllegalArgumentException("ID já cadastrado");
	}
	
	if(curso.getNome() == null || curso.getNome().isEmpty()) {
		throw new IllegalArgumentException("É obrigatório fornecer um nome ao curso");
	}
		
	if(curso.getCargaHoraria() <= 0) {
		throw new IllegalArgumentException("Carga horária invalida.");
	}
	
	repositorio.registrarCursos(curso);
	return true;	
	}
	
	public Curso buscarPorId(int id) {
		if(repositorio.buscarPorId(id) == null) {
			throw new NoSuchElementException("Curso não encontrado");
		}
		
		return repositorio.buscarPorId(id);
	}
	
	public boolean removerCurso(int id) {
		if(repositorio.buscarPorId(id) == null) {
			throw new NoSuchElementException("Curso não encontrado.");
		}
		
		repositorio.removerPorId(id);
		return true;
	}
	
	public boolean alterarEstado(int id, EstadoCurso estado) {
		Curso curso = repositorio.buscarPorId(id);
		if(curso == null) {
			throw new IllegalArgumentException("Insira um ID de um curso válido.");
		}
		if(curso.getEstado() == EstadoCurso.CANCELADO) {
			throw new IllegalArgumentException("Não é possível alterar o estado de um curso cancelado.");
		}
		if(curso.getEstado() == estado) {
			throw new IllegalArgumentException("O estado que você inseriu é o mesmo atual.");
		}
		
		curso.setEstado(estado);
		System.out.println("Estado definido com sucesso.");
		return true;
	}
		
	public HashMap<Integer, Curso> listarCursos(){
		return repositorio.listarTodos();	}

	
	public Curso buscarPorNome(String nome) {
		Curso curso = repositorio.buscarCursoPorNome(nome);
		if(curso == null ) {
			throw new IllegalArgumentException("Aluno não encontrado");
		}
		return repositorio.buscarCursoPorNome(nome);
	}
	
}