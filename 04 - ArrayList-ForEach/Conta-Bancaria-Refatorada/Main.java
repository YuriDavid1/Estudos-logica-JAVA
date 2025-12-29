	package Poo2;
	import java.util.Scanner;
	
	public class Main {
	
		public static void main(String[]args) {
			
			Scanner ler = new Scanner(System.in);
			BancoService banco = new BancoService();
			
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
					banco.cadastrarConta(titular);
					
					break;
					
				case 2:
					banco.listarContas();
					break;
					
					
				case 3:
					System.out.println("Insira o numero da conta (ID)");
					int id = ler.nextInt();
					ler.nextLine();
					System.out.println("Insira o valor que deseja depositar:");
					double valor = ler.nextDouble();
					ler.nextLine();
					banco.depositarConta(id, valor);
					break;
					
					
				case 4:
					System.out.println("Insira o numero da da conta (ID)");
					id = ler.nextInt();
					ler.nextLine();
					System.out.println("Insira o valor que deseja sacar: ");
					double saque = ler.nextDouble();
					ler.nextLine();
					banco.sacarConta(id, saque);					
					break;
					
				case 5:
					System.out.println("Saindo. Até mais...");
					break;
				
				default:
					System.out.println("Opção incorreta. Insira uma opção valida.");
				}
				
			}while(menu !=5);
			ler.close();
		}
		
	}
