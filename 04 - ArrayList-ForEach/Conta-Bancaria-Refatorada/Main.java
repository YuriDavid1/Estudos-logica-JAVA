package Poo2;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[]args) {
		Scanner ler = new Scanner(System.in);
		int menu = 0;
		
		ArrayList<ContaBancaria> contas = new ArrayList<>();
		
		while(menu !=5) {
			System.out.println("----------MENU----------");
			System.out.println("[1] Cadastrar Conta");
			System.out.println("[2] Listar Contas");
			System.out.println("[3] Depositar");
			System.out.println("[4] Sacar");
			System.out.println("[5] Sair");
			System.out.println("Insira uma das opções acima.");
			menu = ler.nextInt();
			ler.nextLine();
			
		switch(menu) {
		case 1:
			System.out.println("Insira o Nome do Titular: ");
			String titu = ler.nextLine();
			ContaBancaria novaConta = new ContaBancaria(titu);
			contas.add(novaConta);
			int indice = contas.size();
			System.out.println("Numero da Conta: " +  indice);
			
		/*case 2:
			double valorsaque;
			System.out.println("Insira o valor que deseja sacar.");
			valorsaque = ler.nextDouble();
			ler.nextLine();
			cliente.sacar(valorsaque);
			break;
			
		case 3:
		cliente.consultarSaldo();		
		break;
		
		case 4: 
			System.out.println("Encerrando...");
			break;
			
			default:
				System.out.println("Insira um número valido ao menu.");
				*/
			}	
		}
	}
}
