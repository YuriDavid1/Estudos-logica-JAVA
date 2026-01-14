package curso.service;
import curso.model.Curso;
import curso.model.EstadoCurso;
import curso.repository.CursoRepository;


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
	
}
