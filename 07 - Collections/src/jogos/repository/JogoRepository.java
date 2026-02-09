package jogos.repository;
import java.util.Map;
import java.util.HashMap;
import jogos.model.Jogo;
public class JogoRepository {

	Map<Integer, Jogo> jogos = new HashMap <>();
	
	public void registrarJogo(Jogo jogo) {
		jogos.put(jogo.getId(), jogo);
	}
	
	public Jogo buscarPorId(int id) {
		return jogos.get(id);
	}

	public Jogo buscarPorNome(String nome) {
	for(Jogo jogo : jogos.values()) {
	if(jogo.getNome().equalsIgnoreCase(nome)) {
		return jogo;
		}
	}
	return null;
	}
	
	public Map<Integer, Jogo> listarTodos() {
		return jogos;
	}
	
}
