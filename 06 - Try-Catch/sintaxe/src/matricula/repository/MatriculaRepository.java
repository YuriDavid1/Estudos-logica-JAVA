package matricula.repository;
import matricula.model.Aluno;
import matricula.model.Curso;
import matricula.model.Matricula;
import java.util.HashMap;

public class MatriculaRepository {

	HashMap<Integer, Matricula> matriculaHash = new HashMap<>();
	
	public void criarMatricula(Matricula matricula) {
		matriculaHash.put(matricula.getId(), matricula);
	}
	
	public Matricula buscarPorId(int id) {
		return matriculaHash.get(id);
	}
	
	public HashMap<Integer, Matricula> listarTodos(){
		return matriculaHash;
	}
	
	public Matricula removerMatricula(int id) {
		return matriculaHash.remove(id);
	}
}