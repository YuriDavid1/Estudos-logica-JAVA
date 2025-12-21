package Poo;

public class Carro {

	private String modelo;
	private int ano;
	private double preco;
	
	
	// GETS
	public String getModelo() {
		return modelo;
	}
	
	public int getAno() {
		return ano;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public Carro(String modelo, int ano, double preco) {
		this.modelo = modelo;
		this.ano = ano;
		this.preco = preco;
	}
	
	//SETS
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	void Informacoes () {
		System.out.println("Carro: " + modelo + " Ano: " + ano + " Preço: " + preco);
		}
}
