package jogos.service;

import java.util.List;

import jogos.model.Emprestimo;
import jogos.model.Usuario;
import jogos.model.Jogo;
import jogos.repository.EmprestimoRepository;

public class EmprestimoService {

    private EmprestimoRepository repositorio;
    private UsuarioService usuarioService;
    private JogoService jogoService;

    public EmprestimoService(EmprestimoRepository repositorio, UsuarioService usuarioService, JogoService jogoService) {
        this.repositorio = repositorio;
        this.usuarioService = usuarioService;
        this.jogoService = jogoService;
    }

    public void criarEmprestimo(int idEmprestimo, String nomeUsu, String nomeJogo) {
    	if(repositorio.buscarPorId(idEmprestimo) != null) {
    		throw new IllegalArgumentException("Id inserido já registrado");
    	}
    	Jogo jogo = jogoService.buscarUsuNome(nomeJogo);
    	if(!jogo.isDisponivel()) {
    		throw new IllegalArgumentException("O jogo não está disponível para empréstimo.");
    	}
    	Usuario usuario = usuarioService.buscarUsuNome(nomeUsu);
    	Emprestimo emprestimo = new Emprestimo(idEmprestimo, usuario, jogo);
    	jogo.setDisponivel(false);
    	usuario.adicionarEmprestimo(emprestimo);
    	repositorio.salvar(emprestimo);
      
    }

    public void finalizarEmprestimo(int idEmprestimo) {
    	Emprestimo emprestimo = repositorio.buscarPorId(idEmprestimo);    	
    	if(emprestimo == null) {
    	throw new IllegalArgumentException("O emprestimo inserido não foi encontrado");
    	}   	
    	if(!emprestimo.getAtivo()) {
    		throw new IllegalArgumentException("O emprestimo está inativo");
    	}
    	emprestimo.setAtivo(false);
    	emprestimo.getJogo().setDisponivel(true);
    }

    public List<Emprestimo> listarAtivos() {
        List<Emprestimo> ativos = repositorio.listarAtivos();
    	if(ativos == null) {
    		throw new IllegalArgumentException("Nenhum emprestimo ativo.");
    	}
    	
        return ativos;
    }

    public List<Emprestimo> listarTodos() {
    	return repositorio.listarTodos();
    }
}