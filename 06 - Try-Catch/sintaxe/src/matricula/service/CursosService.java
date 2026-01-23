package matricula.service;
import matricula.model.EstadoCurso;
import matricula.repository.CursosRepository;

import java.util.HashMap;

import matricula.model.Curso;
public class CursosService {

	private CursosRepository repositorio;
		
	public CursosService(CursosRepository repostiorio) {
		this.repositorio = repositorio;
	}
	//Verificação da criação de curso
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
	
	//Verificação do buscar por id
	public Curso buscarPorId(int id) {
		if(repositorio.buscarPorId(id) == null) {
			throw new IllegalArgumentException("Insira um ID válido.");
		}
		
		return repositorio.buscarPorId(id);
	}
	
	//Verificação de remoção de curso
	public boolean removerCurso(int id) {
		if(repositorio.buscarPorId(id) == null) {
			throw new IllegalArgumentException("Id inexistente.");
		}
		
		repositorio.removerPorId(id);
		return true;
	}
	
	public boolean alterarEstado(int id, EstadoCurso estado) {
		Curso curso = repositorio.buscarPorId(id);
		if(curso == null) {
			throw new IllegalArgumentException("Insira um ID de um curso válido.");
		}
		//Verifica se o estado é cancelado
		if(curso.getEstado() == EstadoCurso.CANCELADO) {
			throw new IllegalArgumentException("Não é possível alterar o estado de um curso cancelado.");
		}
		//Se o estado for o mesmo, não faz nada
		if(curso.getEstado() == estado) {
			throw new IllegalArgumentException("O estado que você inseriu é o mesmo atual.");
		}
		
		curso.setEstado(estado);
		System.out.println("Estado definido com sucesso.");
		return true;
	}
	
	//Listar todos
	
	public HashMap<Integer, Curso> listarCursos(){
		return repositorio.listarTodos();	}
	
}
