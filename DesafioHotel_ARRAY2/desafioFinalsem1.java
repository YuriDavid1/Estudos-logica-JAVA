	package aprendizados;
	import java.util.Scanner;
	
	public class desafioFinalsem1 {
	
		static Scanner ler = new Scanner(System.in);
		static int[] quartos = new int[10];
		static int[] dias = new int[10];
		static String[] nome = new String[10];
		static double fixo = 120.00;
		public static void main(String[]args) {
			
			int menu = 0;
			
			System.out.println("----------BEM VINDO----------");
					
			while(menu != 5) {
				System.out.println("[1] Realizar Check-in");
				System.out.println("[2] Realizar Check-out");
				System.out.println("[3] Mapa de Ocupação");
				System.out.println("[4] Relatório de Faturamento");
				System.out.println("[5] Sair");
				menu = ler.nextInt();
				ler.nextLine();
				
				switch(menu) {
				case 1:
					checkin();
					break;
					
				case 2:
					checkout();
					break;
					
				case 3:
					mapa();
					break;
					
				case 4:
					relatorio();
					break;
					
				case 5:
					break;
					
					default:
						System.out.println("Insira uma opção valida. [1 A 5].");
				}
			}
		}
		
		static void checkin() {
			int salvar = 0;
			
			System.out.println("Insira o Quarto Desejado>");
			salvar = ler.nextInt();
			ler.nextLine();
			
			if(salvar <=10 && salvar >=1) {
			if(quartos[salvar-1] == 0) {
				System.out.println("Quarto Disponível.");
				System.out.println("Insira Seu Nome");
				nome[salvar-1] = ler.nextLine();
				System.out.println("Insira a Quantidade de Dias que ficara Hospedado:");
				dias[salvar-1] = ler.nextInt();
				ler.nextLine();
				if(dias[salvar-1] >= 1) {
					System.out.println("Quarto Reservado com Sucesso.");
					quartos[salvar-1] = 1;
				}else {
					System.out.println("Insira um Numero de Dias Valido.");
				}
				}else {
					System.out.println("Quarto já Ocupado.");
				}
			}else{
				System.out.println("Insira um Quarto Existente. [1 A 10]");
			}
		}
		
		static void checkout() {
			int salvarout = 0;
			double  valorparcial;
			
			System.out.println("Insira o Número do Quarto.");
			salvarout = ler.nextInt();
			ler.nextLine();
		
			if(quartos[salvarout-1] == 1) {
				valorparcial = dias[salvarout] * fixo;
				System.out.println("Hospede " + nome[salvarout] + " fez check-out." + "\nTotal a Pagar: R$" + valorparcial );
				quartos[salvarout] = 0;
			}else {
				System.out.println("O Quarto Inserido já Está Vázio.");
			}
		}
		
		static void mapa() {
			System.out.println("Lista dos Quartos");
			
			for(int i = 0; i<quartos.length; i++) {
				if(quartos[i] == 0) {
					System.out.println("Quarto " + (i+1) + ": [LIVRE]");
				}else {
					System.out.println("Quarto " + (i+1) + ": " + nome[i] + " - " + dias[i] + " Dias");
				}
			}
			
		}
		
		static void relatorio() {
			double valortotal = 0;
			double valorpartido = 0;
			
			for(int i = 0; i<quartos.length; i++) {
				valorpartido = dias[i] * fixo;
				valortotal += valorpartido;
					
			}
			System.out.println("Faturamento Total Previsto: " + valortotal + "R$");
			
		}
		
	}
