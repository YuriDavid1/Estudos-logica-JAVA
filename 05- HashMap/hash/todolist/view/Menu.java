package todolist.view;
import todolist.repository.TarefaRepository;
import todolist.service.TarefaService;
import todolist.model.Tarefa;
import java.util.Scanner;

public class Menu {
	
		private Scanner ler = new Scanner(System.in);
		private TarefaService tarefaService;
		private Tarefa tarefa;
		
		
		
		public Menu() {
			TarefaRepository repositorio = new TarefaRepository();
			tarefaService = new TarefaService (repositorio);
		}
		
		public void exibirMenu() {
	int  opcao = 0;
		
	do {
		System.out.println("========== To-Do-List ==========");
		System.out.println("[1] Adicionar tarefa");
		System.out.println("[2] Remover tarefa");
		System.out.println("[3] Buscar tarefa especifica");
		System.out.println("[4] Listar todas as tarefas");
		System.out.println("[5] Marcar tarefa como concluida.");
		System.out.println("[0] Sair");
		System.out.println("Insira uma das opções: ");
		opcao = ler.nextInt();
		ler.nextLine();
		
		switch(opcao) {
		case 1:
			System.out.println("Insira um numero para a tarefa:");
			int num = ler.nextInt();
			ler.nextLine();
			System.out.println("Descrição da tarefa:");
			String descricao = ler.nextLine();
			Tarefa salvar = new Tarefa(num, descricao);
			tarefaService.salvarTarefa(salvar);
			break;
			
		case 2:
			System.out.println("Insira o ID da tarefa que deseja remover:");
			int remover = ler.nextInt();
			tarefaService.removerTarefaVerifi(remover);
			break;
			
		case 3:
			System.out.println("Insira o ID da tarefa que deseja buscar:");
			int id = ler.nextInt();
			Tarefa tarefaEncontrada = tarefaService.buscarTarefaID(id);
			  if (tarefaEncontrada == null) {
			        System.out.println("Tarefa não encontrada.");
			    } else {
	        System.out.println("ID: " + tarefaEncontrada.getId());
		    System.out.println("Descrição: " + tarefaEncontrada.getDescricao());
			System.out.println("Concluída: " + tarefaEncontrada.getEstado());
			   }
			
			break;
			
		case 4:
			 if (tarefaService.listarTodos().isEmpty()) {
		     System.out.println("Nenhuma tarefa cadastrada.");
			 }else {
			 for (Tarefa tarefa : tarefaService.listarTodos().values()) {
			 System.out.println("ID: " + tarefa.getId());
			 System.out.println("Descrição: " + tarefa.getDescricao());
			 if (tarefa.getEstado() == true) {
				 System.out.println("Concluída: Sim");
			 }else {
				 System.out.println("Concluida: Não");
			 }
			 System.out.println("-----------------------------");
			        }
			    }
			break;
			
		case 5:
			System.out.println("Insira o ID da tarefa que desesja marcar como concluido:");
			int conc = ler.nextInt();
			ler.nextLine();
			tarefaService.tarefaConcluida(conc);
			break;
			
		case 0:
			System.out.println("Saindo...");
			break;
		default:
			System.out.println("Opção invalida. Insira uma opção correta.");
			break;
		}
		}while(opcao != 0);
	}
}
