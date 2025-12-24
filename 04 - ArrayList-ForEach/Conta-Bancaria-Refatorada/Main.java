package Poo2;
import java.util.Scanner;

public class Main {

	public static void main(String[]args) {
		Scanner ler = new Scanner(System.in);
		int menu = 0;
		
		ContaBancaria cliente = new ContaBancaria("Yuri");


		while(menu !=4) {
			System.out.println("----------MENU----------");
			System.out.println("[1] Depositar");
			System.out.println("[2] Sacar");
			System.out.println("[3] Consultar");
			System.out.println("[4] Sair");
			System.out.println("Insira uma das opções acima.");
			menu = ler.nextInt();
			ler.nextLine();
			
		switch(menu) {
		case 1:
			double valor;
			System.out.println("Insira o valor que deseja depositar.");
			valor = ler.nextDouble();
			ler.nextLine();
			cliente.depositar(valor);
			break;
			
		case 2:
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
			}	
		}
	}
}
