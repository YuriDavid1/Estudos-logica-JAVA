/* Objetivo:
O objetivo é criar um sistema para uma pequena loja. Diferente do banco, onde você gerenciava apenas um saldo, aqui você terá que gerenciar múltiplos produtos.  você terá que usar a lógica de Arrays Paralelos.

Você é o desenvolvedor de uma loja de conveniência. O dono precisa de um sistema para controlar até 10 produtos.

Requisitos Técnicos:
Modularização: O main deve ter apenas o Menu. Todo o resto deve estar em métodos (cadastrarProduto, listarEstoque, venderProduto, etc.).
Validações: Não permitir estoque negativo.

Funcionalidades do Menu:

Cadastrar Produto:
O usuário digita o nome, a quantidade inicial e o preço.
O sistema deve procurar a primeira posição vazia (null) no array para salvar.
Se o array estiver cheio (10 produtos), avisar o usuário.

Mostrar uma lista formatada:
ID | Nome | Qtd | Preço.
Exemplo: 1 | Coca-Cola | 50 | R$ 5.50.

Vender Produto:
O usuário digita o ID (índice ou número na lista) do produto e a Quantidade que quer comprar.
O sistema verifica se tem estoque suficiente.
Se tiver, diminui o estoque e mostra o valor Total da Venda

Relatório de Patrimônio:
Percorrer os arrays e calcular quanto dinheiro a loja tem parado em mercadoria (Estoque) de todos os produtos).

Sair*/
package aprendizados;

import java.util.Scanner;
public class desafioGeral {

	static Scanner ler = new Scanner(System.in);
	static String[] nome = new String [10];
	static int[] qtd = new int [10];
	static double[] preco = new double [10];
	static int id =1;
	//MAIN
	public static void main(String[]args) {
	int menu = 0;	
		while (menu !=5) {
			System.out.println("----------MENU----------");
			System.out.println("[1] Cadastrar Produto");
			System.out.println("[2] Mostrar Lista dos Produtos");
			System.out.println("[3] Vender produto");
			System.out.println("[4] Relatório do Patrimônio");
			System.out.println("[5] Sair");
			System.out.println("Selecione uma das opções acima:");
			menu = ler.nextInt();
			ler.nextLine();
			
			switch(menu){
				case 1: 
					cadastrarProduto();
				break;
			
				case 2: 
					listarProdutos();
				break;
				
				case 3: 
					venderProduto();
				break;
				
				case 4: 
					relatorio();
				break;
				
				case 5:
					break;
			
					default: 
						System.out.println("Selecione uma opção que seja valida.");
			}
		}
	}
	
	static void cadastrarProduto() {
	boolean cadastrou = false;
	
	for(int i=0; i<nome.length; i++) {
		if(nome[i] == null) {
			System.out.println("Insira o nome do Produto");
			nome[i] = ler.nextLine();
			
			System.out.println("Insira a Quantidade de Produtos no estoque");
			qtd[i] = ler.nextInt();
			ler.nextLine();
			
			System.out.println("Insira o valor do Produto");
			preco[i] = ler.nextDouble();
			ler.nextLine();
			
			System.out.println("Produto cadastrado com sucesso.");
			cadastrou = true;
			break;
		}

			}
				
	if(cadastrou == false) {
			System.out.println("O Estoque de Produtos esta cheio.");
	}
		}	
	
	static void listarProdutos() {
		for(int i = 0; i<nome.length; i++) {
			if(nome[i] != null) {
				System.out.println("ID  |  NOME  |  QTD  |  PREÇO");
				System.out.println(i+1  +nome[i] +  qtd[i]+ preco[i]);
				}
			
		}
	}
	static void venderProduto() {
		int IDvender;
		int qtdvender;
		double valor;
		System.out.println("Digite o ID do produto para venda:");
		IDvender = ler.nextInt()-1;
		ler.nextLine();
		if(IDvender >= 0 && IDvender < nome.length) {
			System.out.println("Insira o numero que deseja vender:");
			qtdvender = ler.nextInt();
			ler.nextLine();
			if(qtd[IDvender] >= qtdvender) {
				qtd[IDvender] -= qtdvender;
				valor = qtdvender * preco[IDvender];
				System.out.println("Valor total da venda:");
				System.out.println(valor + "R$");
			}else {
				System.out.println("Estoque insuficiente para o numero de vendas.");
				System.out.println("Total do estoque: " + qtd[IDvender]);
			}
		}else { 				
			System.out.println("Digite um ID valido. Consulte a Lista para ver os ID'S disponíveis.");
		}
	}
	
	static void relatorio() {	
		System.out.println("=== RELATÓRIO DE PATRIMÔNIO ===");
		double totalloja = 0.0;
		double valorparcial;
		
		for(int i=0; i< nome.length; i++) {
		valorparcial = qtd[i] * preco[i];
		totalloja = totalloja + valorparcial;
		}
		System.out.println("Valor total: " + totalloja);
	}
}
