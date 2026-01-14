package curso.repository;
import curso.model.Curso;
import java.util.HashMap;


public class CursoRepository {

	HashMap<Integer, Curso> cursosHash  = new HashMap <>();
	
	public void criarCurso(Curso curso) {
		cursosHash.put(curso.getId(), curso);
	}
	
	public Curso buscarCurso(int id) {
		return cursosHash.get(id);
	}
	
	public void removerCurso(int id) {
		cursosHash.remove(id);
	}
	
	public HashMap<Integer, Curso> listarCursos (){
		return cursosHash;
	}
	
}
