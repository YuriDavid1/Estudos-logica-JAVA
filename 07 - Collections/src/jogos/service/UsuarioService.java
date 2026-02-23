package jogos.service;
import jogos.repository.UsuarioRepository;

import java.util.List;

import jogos.model.Emprestimo;
import jogos.model.Usuario;

public class UsuarioService {

	UsuarioRepository repositorio;
	
	public UsuarioService(UsuarioRepository repositorio) {
		this.repositorio = repositorio;
	}
	
	public void registrarUsuario(Usuario usuario) {
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
			throw new IllegalArgumentException("Usuário já registrado com este nome.");
		}
		repositorio.criarUsuario(usuario);
	}
	
	public Usuario buscarUsuId(int id) {
		Usuario usu = repositorio.buscarUsuId(id);
		if(usu == null) {
			throw new IllegalArgumentException("Usuario não encontrado.");
		}
		return usu;
	}
	
	public Usuario buscarUsuNome(String nome) {
		Usuario usu = repositorio.buscarUsuNome(nome);
		if(usu == null) {
			throw new IllegalArgumentException("Usuário não encontrado.");
		}
		return usu;
	}
	
	public List<Emprestimo> listarHistorico(String nomeUsu){
		Usuario usu = repositorio.buscarUsuNome(nomeUsu);
		
		if(usu == null) {
			throw new IllegalArgumentException("Usuário não encontrado.");
	    }
	    if (usu.getHistorico().isEmpty()) {
	        throw new IllegalArgumentException("Usuário não possui empréstimos.");
	    } 
	    return usu.getHistorico();
		}
		
	}

