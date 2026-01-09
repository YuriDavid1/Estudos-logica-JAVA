package sistema.repository;
import java.util.HashMap;
import sistema.model.Livro;

public class LivroRepository {

	HashMap<Integer, Livro> LivrosHash = new HashMap<>();
	
	public void salvarLivro(Livro livro) {
		LivrosHash.put(livro.getId() ,livro);
	}
	
	public Livro buscarLivro(int id) {
		return LivrosHash.get(id);
	}
	
	public void removerLivro(int id) {
		LivrosHash.remove(id);
	}
	
	public HashMap<Integer, Livro> listarLivros() {
		return LivrosHash;
		
	}
	
	
}
