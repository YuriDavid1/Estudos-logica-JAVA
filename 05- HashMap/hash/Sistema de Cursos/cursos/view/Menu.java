package sistema.view;
import sistema.model.Livro;
import sistema.repository.LivroRepository;
import sistema.service.LivroService;
import java.util.Scanner;

public class Menu {

	private Scanner ler = new Scanner(System.in);
	private LivroService livroService;
	
	public Menu() {
		LivroRepository repositorio = new LivroRepository();
		livroService = new LivroService (repositorio);
	}
	
	public void exibirMenu() {
		int  opcao = 0;
	
	
	do {
        System.out.println("\n=== SISTEMA DE BIBLIOTECA ===");
        System.out.println("1 - Cadastrar livro");
        System.out.println("2 - Remover livro");
        System.out.println("3 - Buscar livro por ID");
        System.out.println("4 - Emprestar livro");
        System.out.println("5 - Devolver livro");
        System.out.println("6 - Listar livros");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");

        opcao = ler.nextInt();
        ler.nextLine();

        switch(opcao) {
        case 1:
        System.out.println("Insira o ID do livro:");
        int id = ler.nextInt();
        ler.nextLine();
        	
        System.out.println("Insira o titulo do Livro: ");
        String titulo = ler.nextLine();
        
        System.out.println("Insira o nome do autor: ");
        String autor = ler.nextLine();
        
        Livro salvar = new Livro(id, titulo, autor);
        livroService.cadastrarLivro(salvar);
        	break;
        	
        	
        case 2:
        	System.out.println("Insira o ID do livro que deseja remover: ");
        	id = ler.nextInt();
        	ler.nextLine();
        	livroService.removerLivro(id);        	
        	break;
        	
        	
        case 3:
        	System.out.println("Insira o ID do livro que deseja buscar:");
        	id = ler.nextInt();
        	ler.nextLine();
        	Livro livrosalvar = livroService.buscarLivro(id);
        	if(livrosalvar != null) {
        	System.out.println("ID: " +livrosalvar.getId());
        	System.out.println("Titulo: " +livrosalvar.getTitulo());
        	System.out.println("Autor: " +livrosalvar.getAutor());
        	}else {
        		System.out.println("Livro não encontrado.");
        	}
        	break;
        	
        case 4:
        	System.out.println("Insira o ID do livro que deseja emprestar:");
        	id = ler.nextInt();
        	ler.nextLine();
        	livroService.emprestarLivro(id);
        	break;
        	
        	
        case 5:
        	System.out.println("Insira o ID do livro que deseja devolver: ");
        	id = ler.nextInt();
        	ler.nextLine();
        	livroService.devolverLivro(id);
        	break;
        	
        	
        case 6:
            if (livroService.listarLivro().isEmpty()) {
                System.out.println("Nenhum livro cadastrado.");
            } else {
                for (Livro livro : livroService.listarLivro().values()) {
                    System.out.println(
                        livro.getId() + " | " +
                        livro.getTitulo() + " | " +
                        livro.getAutor() + " | Emprestado: " +
                        livro.getEmprestado()
                    );
                }
            }
        	
        	break;
        	
        	
        case 0: 
        	System.out.println("Saindo...");
        	break;
        
        	
        default:
        	System.out.println("Opção invalida.");
        break;
        
        }
		
		}while(opcao!=0);
	
	}
}
