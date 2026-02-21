package jogos.view;
import jogos.service.*;
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
    	
    	}while(opcao != 0);
    	}
	
}
