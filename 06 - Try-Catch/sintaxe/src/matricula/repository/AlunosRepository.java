package matricula.repository;
import matricula.model.Aluno;
import matricula.model.Curso;
import java.util.HashMap;

public class AlunosRepository {

	HashMap<Integer, Aluno> alunosHash = new HashMap<>();
	HashMap<Integer, Curso> cursosHash = new HashMap<>();
	
public void registrarAlunos(Aluno aluno) {
	alunosHash.put(aluno.getId(), aluno);
}
	

public void registrarCursos(Curso curso) {
	cursosHash.put(curso.getId(), curso);
}
	
public void buscarPorId() {
	
}

public void removerPorId() {
	
}

public void listarTodos() {
	
}
}
