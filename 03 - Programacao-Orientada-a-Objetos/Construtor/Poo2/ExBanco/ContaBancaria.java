package Poo2;


public class ContaBancaria {
	
	private String titular;
	private double saldo;
	
	public ContaBancaria(String titular) {
		this.titular = titular;
		this.saldo = 0.0;
	}
	
	public void depositar(double valor) {
		saldo += valor;
		System.out.println("Depósito de R$" + valor + " realizado para " + titular);
	}
	
	public void sacar(double valor) {		
		if(valor <= saldo) {
			saldo -=valor;
			System.out.println("Saque de R$" + valor + " Realizado comm Sucesso."); 
		}else {
			System.out.println("Saldo insuficiente para saque.");
		}
	}
	
	public void consultarSaldo() {
	System.out.println("Titular: " + titular + " | " + "Saldo: " + saldo);
	}
	
}
