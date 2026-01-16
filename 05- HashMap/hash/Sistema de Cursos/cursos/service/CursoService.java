package curso.service;
import curso.model.Curso;
import curso.model.EstadoCurso;
import curso.repository.CursoRepository;
import java.util.HashMap;


public class CursoService {

	private CursoRepository repositorio;
	
	public CursoService(CursoRepository repositorio) {
		this.repositorio = repositorio;
	}
	
	public boolean criarCurso(Curso curso) {
		if(curso.getId() <= 0) {
			System.out.println("Insira um ID de curso valido");
			return false;
		}
		
		if(repositorio.buscarCurso(curso.getId()) != null){
			System.out.println("ID de curso já registrado.");
			return false;
		}
		
		if(curso.getNome() == null || curso.getNome().isEmpty()) {
			System.out.println("É obrigatório fornecer um nome ao curso.");
			return false;
		}
		if(curso.getCargaHoraria() == 0 || curso.getCargaHoraria() <= 0 ) {
			System.out.println("É obrigatório fornecer uma carga horaria válida.");
			return false;
		}
		System.out.println("Curso registrado com êxito.");
		repositorio.criarCurso(curso);
		return true;
	}
	
	public boolean removerCurso(int id) {
		if(repositorio.buscarCurso(id) == null) {
		System.out.println("ID de curso inexistente.");
			return false;
		}
		System.out.println("Curso removido com êxito.");
		repositorio.removerCurso(id);
		return true;
	}
	
	
	public Curso buscarPorId(int id) {
		if(repositorio.buscarCurso(id) == null) {
			System.out.println("ID de Curso inexistente.");
		}
		return repositorio.buscarCurso(id);
	}		
	
	
	public boolean alterarEstado(int id, EstadoCurso estado) {
		Curso curso = repositorio.buscarCurso(id);
				//Verifica se o curso existe
		if(curso == null) {
			System.out.println("Curso não encontrado.");
			return false;
		}
		//Verifica se o estado é cancelado
		if(curso.getEstado() == EstadoCurso.CANCELADO) {
			System.out.println("Não é possível alterar o estado de um curso cancelado.");
			return false;
		}
		//Se o estado for o mesmo, não faz nada
		if(curso.getEstado() == estado) {
		System.out.println("O curso já esta neste estado.");
		return false;
	}
	
		curso.setEstado(estado);	
		System.out.println("Estado alterado com sucesso.");
		return true;
	}
	
	public HashMap<Integer, Curso> listarCursos() {
	    return repositorio.listarCursos();
	}

	
}