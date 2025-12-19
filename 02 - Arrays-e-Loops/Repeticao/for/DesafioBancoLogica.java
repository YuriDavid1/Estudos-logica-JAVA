	package aprendizados;
	
	import java.util.Scanner;
	
	public class DesafioBancoLogica {
		
		//USO GERAL
		static Scanner ler = new Scanner(System.in);
		static double saldo = 1000.0;
		static String[] historico = new String [5];
		static int contador = 0;

		
		public static void main(String[]args) {
		
		//USO APENAS PARA MAIN
		int caso = 0;
		
		while(caso != 5) {
			System.out.println("==========MENU==========");
			System.out.println("[1] Consultar saldo");
			System.out.println("[2] Sacar saldo");
			System.out.println("[3] Depositar saldo");
			System.out.println("[4] Ver extrato");
			System.out.println("[5] Sair da conta");
			System.out.println("Escolha uma das opções:");
			caso = ler.nextInt();
			ler.nextLine();
			
			switch(caso) {
			case 1: 
				consultar();
				break;
				
			case 2: 
				sacar();
				break;
				
			case 3:
				depositar();
				break;
				
			case 4:
				extrato();
				break;
				
			case 5:
				break;
				
				default:
					System.out.println("Selecione uma opção valida (1 A 5)");
				}
			}
		
		}
		
		//FUNÇÕES PARA MAIN
		
		//CASE 1:
		static void consultar() {
			System.out.println("Seu saldo atual é de: " + saldo + "R$");
		}
		
		//CASE 2:
		static void sacar() {
			double saque = 0;
			System.out.println("Digite o valor que deseja sacar:");
			saque = ler.nextDouble();
			ler.nextLine();
			if(saldo>=saque) {
			saldo = saldo - saque;
			if(contador < 5) {
			historico[contador] = saque + "R$ sacados";
			contador++;
			}else {
				System.out.println("Armazenamento do extrato cheio.");
			}
			System.out.println("Saque realizado.");
			System.out.println("Saldo atual: " + saldo + "R$");
			} else {
				System.out.println("Saldo para saque indisponível.");
			}
		}
		
		//CASE 3:
		static void depositar() {
			double deposito = 0;
			System.out.println("Digite o valor que deseja depositar.");
			deposito = ler.nextDouble();
			ler.nextLine();
			if(contador < 5) {
			historico[contador] = deposito + "R$ depositados";
			contador ++;
			}else {
				System.out.println("Armazenamento do extrato cheio.");
			}
			saldo = saldo + deposito;
			System.out.println("Seus " + deposito + "R$ foram depositados.");
			System.out.println("Saldo atual: " + saldo + "R$");
		}
		
		//CASE 4:
		static void extrato() {
			int Ncelula = 0;
			String select = null;
			System.out.println("Digite CELULA se quiser verificar uma expecifica, ou EXTRATO caso queira ver o extrato completo.");
			select = ler.nextLine().toLowerCase();
			if(select.equals("celula")) {
				System.out.println("Selecione, o extrato a qual você deseja: [1/5]");
				Ncelula = ler.nextInt();
				ler.nextLine();
				if(Ncelula <=5) {
					if(historico[Ncelula-1] !=null) {
					System.out.println("Extrato da célula " + Ncelula + "\n" + historico[Ncelula-1]);
						}else {
							System.out.println("Nenhuma transação nesta posição de celula ainda.");
					}
				}else{
						System.out.println("Numero da celula incorreto. Deve ser de 1 a 5.");
					}
			} else if (select.equals ("extrato")){
				System.out.println("Aqui está seu histórico completo:");
				for (int i = 0; i < historico.length; i++) {
					if(historico[i] != null) {
						System.out.println(historico[i]);
					}
				}
			}else {
				System.out.println("Opção incorreta. A opção digitada deve ser CELULA ou EXTRATO.");
			}
			
		}
	}
