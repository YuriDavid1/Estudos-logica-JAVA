package jogos.repository;
import java.util.HashMap;
import java.util.Map;
import jogos.model.Usuario;

public class UsuarioRepository {

	Map<Integer, Usuario> usuarios = new HashMap<>();

	public void criarUsuario(Usuario usuario) {
	usuarios.put(usuario.getId(), usuario);
	}
	
	public Usuario buscarUsuId(int id) {
		return usuarios.get(id);
	}
	
	public Usuario buscarUsuNome(String nome) {
		for(Usuario usu : usuarios.values()) {
			if(usu.getNome().equalsIgnoreCase(nome)){
			return usu;
			}
		}
		return null;
	}
}