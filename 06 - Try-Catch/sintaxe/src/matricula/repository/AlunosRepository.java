package matricula.repository;
import matricula.model.Aluno;
import java.util.HashMap;

public class AlunosRepository {

	HashMap<Integer, Aluno> alunosHash = new HashMap<>();
	
public void registrarAlunos(Aluno aluno) {
	alunosHash.put(aluno.getId(), aluno);
}
	
	
public Aluno buscarPorId(int id) {
	return alunosHash.get(id);
}

public void removerPorId(int id) {
	alunosHash.remove(id);
}

public HashMap<Integer, Aluno> listarTodos() {
	return alunosHash;
}
}
