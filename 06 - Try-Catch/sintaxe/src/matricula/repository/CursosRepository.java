package matricula.repository;
import java.util.HashMap;
import matricula.model.Curso;

public class CursosRepository {

	HashMap<Integer, Curso> cursosHash = new HashMap<>();
	
	public void registrarCursos(Curso curso) {
		cursosHash.put(curso.getId(), curso);
	}
		
	public Curso buscarPorId(int id) {
		return cursosHash.get(id);
	}

	public void removerPorId(int id) {
	 cursosHash.remove(id);
	}
	
	public HashMap<Integer, Curso> listarTodos() {
	return cursosHash;
	}
	
	public Curso buscarCursoPorNome(String nome) {
		for(Curso curso : cursosHash.values()) {
			if(curso.getNome().equalsIgnoreCase(nome)) {
				return curso;
			}
		}
		return null;
	}
}
