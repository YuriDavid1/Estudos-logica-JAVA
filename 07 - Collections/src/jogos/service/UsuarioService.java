package jogos.service;
import jogos.repository.UsuarioRepository;
import jogos.model.Usuario;

public class UsuarioService {

	UsuarioRepository repositorio;
	
	public UsuarioService(UsuarioRepository repositorio) {
		this.repositorio = repositorio;
	}
	
	public boolean registrarUsuario(Usuario usuario) {
		if(usuario.getId() <= 0) {
			throw new IllegalArgumentException("O Id deve ser positivo");
		}
		if(repositorio.buscarUsuId(usuario.getId()) != null) {
			throw new IllegalArgumentException("Id já registrado");
		}
		if(usuario.getNome()  == null || usuario.getNome().isEmpty()) {
			throw new IllegalArgumentException("O nome não pode estar vázio.");
		}
		if(repositorio.buscarUsuNome(usuario.getNome()) != null) {
			throw new IllegalArgumentException("Jogo já registrado com este nome.");
		}
		repositorio.criarUsuario(usuario);
		return true;
	}
	
	public boolean buscarUsuId(int id) {
		Usuario usu = repositorio.buscarUsuId(id);
		if(usu == null) {
			throw new IllegalArgumentException("Usuario não encontrado.");
		}
		repositorio.buscarUsuId(id);
		return true;
	}
	
	public boolean buscarUsuNome(String nome) {
		Usuario usu = repositorio.buscarUsuNome(nome);
		if(usu == null) {
			throw new IllegalArgumentException("Usuário não encontrado.");
		}
		repositorio.buscarUsuNome(nome);
		return true;
	}
}
