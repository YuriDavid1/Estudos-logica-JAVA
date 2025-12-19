package aprendizados;

import java.util.Scanner;

public class DesafioScanner_Variaveis {

	public static void main(String[]args) {
	Scanner ler = new Scanner(System.in);
	
	int caso = 0;
			
	//ENQUANTO O WHILE FOR DIFERENTE DE 1 EXECUTE ISSO:
	while(caso != 1) {
	System.out.println("Selecione uma opção:");
	System.out.println("[0] To-do-list");
	System.out.println("[1] Sair do aplicativo");
	System.out.println("Digite o numero das opções requeridas:");
	
	//Recebe um novo valor
	caso = ler.nextInt();
	ler.nextLine();
	
	switch(caso) {
	case 0:
	System.out.println("Nome da tarefa:");
	String tarefa = ler.nextLine();
	
	System.out.println("Descrição da tarefa:");
	String descricao = ler.nextLine();
	
	System.out.println("Tempo estimado em horas:");
	int tempo = ler.nextInt();
	
	int minutos = tempo*60;
	
	System.out.println("=========================");
	System.out.println("Tarefa: " + tarefa);
	System.out.println("Descrição: " + descricao);
	System.out.println("Minutos: " + minutos);
	System.out.println("=========================");
	break;
	
	case 1: 
		break;
		
		default:
			System.out.println("Selecione uma opção que seja valida.");
		}	
	}
	ler.close();

	
}
}
