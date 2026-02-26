package jogos.view;
import jogos.model.Emprestimo;
import jogos.model.Jogo;
import jogos.model.Usuario;
import jogos.service.*;

import java.util.List;
import java.util.Scanner;
public class Menu {
	
	private Scanner ler = new Scanner(System.in);
    private EmprestimoService emprestimoService;
    private UsuarioService usuarioService;
    private JogoService jogoService;

    public Menu(EmprestimoService emprestimoService, UsuarioService usuarioService, JogoService jogoService) {
        this.emprestimoService = emprestimoService;
        this.usuarioService = usuarioService;
        this.jogoService = jogoService;
    }
    
    public void menuGeral() {
		int opcao;
		do {
    	System.out.println("----------BEM VINDO----------");
    	System.out.println("[1] Cadastrar jogo");
    	System.out.println("[2] Cadastrar usuario");
    	System.out.println("[3] Emprestar jogo");
    	System.out.println("[4] Finalizar emprestimo");
    	System.out.println("[5] Listar jogos");
    	System.out.println("[6] Ver historico de usuario");
    	System.out.println("[0] Sair");
    	System.out.println("Insira uma das opcoes acima: ");
    	opcao = ler.nextInt();
    	ler.nextLine();
    	
    	switch(opcao) {
    	case 1 ->{
    		try {
    		System.out.println("Insira o ID: ");
    		int id = ler.nextInt();
    		ler.nextLine();
    		System.out.println("Insira o nome do jogo: ");
    		String nome = ler.nextLine();
    		System.out.println("Insira o genero do jogo: ");
    		String genero = ler.nextLine();
    		Jogo jogo = new Jogo (id, nome, genero);
    		jogoService.registrarJogo(jogo);
    		System.out.println("Jogo registrado.");
    		}catch(Exception e) {
    			System.out.println("Erro: " + e.getMessage());
    		}
    		}
    	
    	case 2 ->{
    		try {
    		System.out.println("Insira o ID: ");
    		int id = ler.nextInt();
    		ler.nextLine();
    		System.out.println("Insira o nome do usuário");
    		String nome = ler.nextLine();
    		Usuario usuario = new Usuario(id, nome);
    		usuarioService.registrarUsuario(usuario);
    		System.out.println("Usuario registrado.");
    		}catch(Exception e) {
    			 System.out.println("Erro: " + e.getMessage());
    		}
    	}
    	
    	case 3 ->{
    		try {
    		System.out.println("Insira o ID do emprestimo: ");
    		int id = ler.nextInt();
    		ler.nextLine();
    		System.out.println("Insira o nome do usuario: ");
    		String nome = ler.nextLine();
    		System.out.println("Insira o nome do jogo que deseja alugar: ");
    		String nomeJ = ler.nextLine();
    		emprestimoService.criarEmprestimo(id, nome, nomeJ);
    		System.out.println("Emprestimo realizado.");
    		}catch(Exception e) {
    			 System.out.println("Erro: " + e.getMessage());
    		}
    		}
    	
    	case 4 ->{
    		try {
    		System.out.println("Insira o ID do emprestimo");
    		int id = ler.nextInt();
    		ler.nextLine();
    		emprestimoService.finalizarEmprestimo(id);
    		System.out.println("Emprestimo finalizado.");
    		}catch(Exception e) {
    			 System.out.println("Erro: " + e.getMessage());
    		}
    		}
    	
    	case 5 ->{
    		try {
    			List<Jogo> jogos = jogoService.listarJogos();
    			 if (jogos.isEmpty()) {
                     System.out.println("Nenhum jogo cadastrado.");
    			 } else {
                     System.out.println("\n--- Lista de Jogos ---");
    			for(Jogo jogo : jogos) {
    				System.out.println("ID: " + jogo.getId() +
                            " | Nome: " + jogo.getNome() +
                            " | Genero: " + jogo.getGenero() +
                            " | Disponivel: " + jogo.isDisponivel());
    				}
    			 }
    		}catch(Exception e) {
    			System.out.println(e.getMessage());
    		}
    	}
    	
    	case 6 ->{
    		try{
    		System.out.println("Insira o nome do usuário que deseja:");
    		String nome = ler.nextLine();
    		
    		List<Emprestimo> historico = usuarioService.listarHistorico(nome);
    		if (historico.isEmpty()) {
                System.out.println("Nenhum emprestimo encontrado.");
            } else {
                System.out.println("\n--- Historico ---");
    		for(Emprestimo e : historico) {
    			System.out.println("ID: " + e.getId() +
    		            		   " | Jogo: " + e.getJogo().getNome() +
    		            		   " | Ativo: " + e.getAtivo());
    		    }
            }
    	}catch(Exception e) {
    	    System.out.println("Erro: " + e.getMessage());
    		}
    	}
    		
    	
    	case 0 ->{
    		System.out.println("Saindo...");
    	}
    	
    	default ->{
    		System.out.println("Opção inválida.");
    		}
    	}
    	
    	}while(opcao != 0);
    	}
	
}
