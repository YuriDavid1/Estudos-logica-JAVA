package Poo2;
import java.util.Scanner;
import java.util.ArrayList;
 
public class MainPessoaLista {

	static Scanner ler = new Scanner(System.in);
	static ArrayList<Pessoa> lista = new ArrayList<>();
	
	public static void main(String[]args) {
	int salvarIdade;
	String salvarNome;
	int menu;
	
		do {
		System.out.println("============== MENU ==============");
		System.out.println("[1] Cadastrar pessoa");
		System.out.println("[2] Listar pessoas");
		System.out.println("[3] Procurar pessoa pelo nome");
		System.out.println("[4] Excluir pessoa");
		System.out.println("[5] Fazer aniversário de alguém");
		System.out.println("[0] Sair");
		System.out.println("Escolha a opção desejada:");
		menu = ler.nextInt(); 
		ler.nextLine();
		
		switch(menu) {
		case 1:
			System.out.println("Insira o nome: ");
			salvarNome = ler.nextLine();
			System.out.println("Insira a idade: ");
			salvarIdade = ler.nextInt();
			ler.nextLine();
			Pessoa pessoas = new Pessoa(salvarNome, salvarIdade);
			lista.add(pessoas);
			System.out.println("Cadastro realizado com sucesso.");
			break;
			
		case 2:
			
			if(lista.size() == 0) {
				System.out.println("Nenhum nome na lista.");
			}else {
			System.out.println("ID |    NOME    |    IDADE");
			for(int i = 0; i < lista.size(); i++) {
			System.out.println(i + "   | " + lista.get(i).nomeGet() + "    | " + lista.get(i).idadeGet());
				}
			}
			break;
			
		case 3:
			System.out.println("Insira o nome da pessoa que deseja buscar: ");
			String nomeBusca = ler.nextLine();
			boolean encontrado = false;
			for(int i = 0; i < lista.size(); i++) {
				if(lista.get(i).nomeGet().equalsIgnoreCase(nomeBusca)) {
					System.out.println(lista.get(i).nomeGet() + " | " + lista.get(i).idadeGet());
					encontrado = true;
				}
				}
			if(!encontrado) {
				System.out.println("Nome não encontrado na lista.");
			}
			break;
			
		case 4:
			int idExcluir;
			if(lista.size() == 0) {
				System.out.println("Nenhum nome na lista.");
			}else {
			System.out.println("ID |    NOME    |    IDADE");
			for(int i = 0; i < lista.size(); i++) {
			System.out.println(i + "   | " + lista.get(i).nomeGet() + "    | " + lista.get(i).idadeGet());
				}
		
			System.out.println("Insira o ID referente a quem deseja excluir: ");
			idExcluir = ler.nextInt();
			ler.nextLine();
			
			if(lista.size() > idExcluir && idExcluir >=0 ){
				lista.remove(idExcluir);
				System.out.println("Pessoa removida com sucesso.");
			}else {
				System.out.println("ID não encontrado.");
				}
			}
				break;
				
		case 5:
			if(lista.size() == 0) {
				System.out.println("Nenhum nome na lista.");
			}else {
			System.out.println("Pessoas Cadastradas");
			System.out.println("ID |    NOME    |    IDADE");
			for(int i = 0; i < lista.size(); i++) {
			System.out.println(i + "   | " + lista.get(i).nomeGet() + "    | " + lista.get(i).idadeGet());
				}
			System.out.println("Insira o ID da pessoa que deseja fazer aniversário");
			int aniversario = ler.nextInt();
			ler.nextLine();
			
			if(aniversario < lista.size() && aniversario >=0) {
				lista.get(aniversario).fazerAniversario();
				System.out.println("Aniversário realizado.");
				System.out.println("Agora " + lista.get(aniversario).nomeGet() + " tem " + lista.get(aniversario).idadeGet() + " anos");
			}else {
				System.out.println("ID não encontrado.");
				}
			}
			break;
			
		case 0:
			System.out.println("Saindo...");
		break;
		
		default:
		System.out.println("Opção invalida. Insira um número válido.");		
				
		}
		
		} while(menu !=0);
		

		}
	}

