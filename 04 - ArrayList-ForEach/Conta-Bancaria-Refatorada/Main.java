package Poo2;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[]args) {
		
		ArrayList<ContaBancaria> contas = new ArrayList<>();
		Scanner ler = new Scanner(System.in);
		int menu = 0;
		
		do {
			System.out.println("==========  MENU  ==========");
			System.out.println("[1] Cadastrar conta");
			System.out.println("[2] Listar contas");
			System.out.println("[3] Depositar");
			System.out.println("[4] Sacar");
			System.out.println("[5] Sair");
			System.out.println("Insira uma opção valida: ");
			menu = ler.nextInt();
			ler.nextLine();
			
			switch(menu) {
			case 1:
				System.out.println("Insira o nome do titular: ");
				String titular = ler.nextLine();
				ContaBancaria pessoa = new ContaBancaria(titular);
				contas.add(pessoa);
				int id = contas.size() -1;
				System.out.println("Numero da conta: " + id);
				
				break;
				
			case 2:
				System.out.println("========== LISTA DE CONTAS ==========");
				System.out.println("ID  |   " + "|   Titular   " + "|   Saldo   ");
				for(int i = 0; i<contas.size(); i++) {
					System.out.println(i + "  |   " +  contas.get(i).consultar());
				}
				
				break;
				
			case 3:
				System.out.println("Insira o numero da conta (ID)");
				id = ler.nextInt();
				ler.nextLine();
				if(id >= 0 && id < contas.size()) {
					System.out.println("Insira o valor que deseja depositar:");
					double deposito = ler.nextDouble();
					ler.nextLine();
					contas.get(id).depositar(deposito);					
					
				}else {
					System.out.println("Insira um ID de conta válido.");
				}				
				break;
				
			case 4:
				System.out.println("Insira o numero da da conta (ID)");
				id = ler.nextInt();
				ler.nextLine();
				if(id >=0 && id < contas.size()) {
					System.out.println("Insira o valor que deseja sacar: ");
					double saque = ler.nextDouble();
					ler.nextLine();
					contas.get(id).sacar(saque);
				}else {
					System.out.println("Insira um ID de conta válido.");
				}
				
				break;
				
			case 5:
				System.out.println("Saindo. Até mais...");
				break;
				
			default:
				System.out.println("Opção incorreta. Insira uma opção valida.");
			}
			
		}while(menu !=5);
		
	}
	
}
