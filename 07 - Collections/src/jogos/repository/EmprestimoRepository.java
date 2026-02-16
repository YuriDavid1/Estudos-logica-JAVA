package jogos.repository;
import jogos.model.Emprestimo;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmprestimoRepository {

	Map<Integer, Emprestimo> emprestimoHash = new HashMap<>();
	
	public void realizarEmprestimo(Emprestimo emprestimo) {
	emprestimoHash.put(emprestimo.getId(), emprestimo);
	}
	
	public void buscarId(int id) {
	emprestimoHash.get(id);
	}
	
	public List<Emprestimo> listarAtivos() {
	    List<Emprestimo> ativos = new ArrayList<>();

	    for (Emprestimo e : emprestimoHash.values()) {
	        if (e.getAtivo()) {
	            ativos.add(e);
	        }
	    }
	    return ativos;
	}
	
	public List<Emprestimo> listarTodos(){
		return new ArrayList<>(emprestimoHash.values());		
	}
}
