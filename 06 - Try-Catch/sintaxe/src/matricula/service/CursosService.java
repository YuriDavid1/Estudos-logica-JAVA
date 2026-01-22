package matricula.service;
import matricula.model.EstadoCurso;
import matricula.repository.CursosRepository;
import matricula.model.Curso;
public class CursosService {

	private CursosRepository repositorio;
	Scanner ler = new Scanner(System.in);
	
	
	
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
	
	public boolean alterarEstado(int id, EstadoCurso curso) {
		Curso curso1 = repositorio.buscarPorId(id);
		if(curso1 == null) {
			throw new IllegalArgumentException("Insira um ID de um curso válido.");
		}
		
		
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
