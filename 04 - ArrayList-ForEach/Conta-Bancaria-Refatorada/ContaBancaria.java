	package Poo2;
	import java.util.Scanner;
	
	public class ContaBancaria {
	
		Scanner ler = new Scanner (System.in);
		private String titular;
		private double saldo;
		
		public ContaBancaria(String titular) {
			this.titular = titular;
			this.saldo = 0.0;
		}
		
		public void depositar(double deposito) {
		
		if(deposito > 0) {
			saldo += deposito;	
			System.out.println("R$"+deposito + " foram depositados a sua conta.");
			System.out.println("Saldo atual: R$" +saldo);
		}else {
			System.out.println("Insira um valor valido.");
			}
		}
		
		public void sacar(double sacar) {
			if(saldo >= sacar) {
				saldo -=sacar;
				System.out.println("R$" + sacar + " foram retirados de sua conta.");
				System.out.println("Saldo atual: R$" + saldo);
			}else {
				System.out.println("Este valor ultrapassou o seu saldo.");
			}
		}
		
		
		public String consultar() {
			return titular +  "   |    " + saldo;
		}
		
		//GETS
		public String getTitular() {
			return titular;
		}
		
		public double getSaldo() {
			return saldo;
		}
		
		//SETS
		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}
	}
