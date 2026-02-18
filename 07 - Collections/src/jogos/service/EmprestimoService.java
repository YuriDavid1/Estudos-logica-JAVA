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

        if (repositorio.buscarPorId(idEmprestimo) != null) {
            throw new IllegalArgumentException("ID de empréstimo já existente.");
        }

        Usuario usuario = usuarioService.buscarUsuNome(nomeUsu);
        Jogo jogo = jogoService.buscarUsuNome(nomeJogo);

        if (!jogo.isDisponivel()) {
            throw new IllegalArgumentException("Jogo indisponível.");
        }

        Emprestimo emprestimo = new Emprestimo(idEmprestimo, usuario, jogo);
        jogo.setDisponivel(false);
        usuario.adicionarEmprestimo(emprestimo);
        repositorio.salvar(emprestimo);
    }

    public void finalizarEmprestimo(int idEmprestimo) {
        Emprestimo emprestimo = repositorio.buscarPorId(idEmprestimo);
        if (emprestimo == null) {
            throw new IllegalArgumentException("Empréstimo não encontrado.");
        }

        if (!emprestimo.getAtivo()) {
            throw new IllegalArgumentException("Empréstimo já finalizado.");
        }
        emprestimo.setAtivo(false);
        emprestimo.getJogo().setDisponivel(true);
    }

    public List<Emprestimo> listarAtivos() {
        List<Emprestimo> ativos = repositorio.listarAtivos();

        if (ativos.isEmpty()) {
            throw new IllegalArgumentException("Nenhum empréstimo ativo.");
        }

        return ativos;
    }

    public List<Emprestimo> listarTodos() {
        return repositorio.listarTodos();
    }
}
