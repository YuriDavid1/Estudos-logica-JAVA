package doList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[]args) {

        Scanner ler = new Scanner(System.in);
        HashMap<String, Boolean> tarefas = new HashMap<>();

        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n--- TODO LIST ---");
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Concluir Tarefa");
            System.out.println("3. Listar Tudo");
            System.out.println("4. Sair");
            System.out.print("Escolha: ");
            opcao = ler.nextInt();
            ler.nextLine(); 

            switch (opcao) {
            case 1:
                System.out.print("Digite a tarefa: ");
                String novaTarefa = ler.nextLine();

                tarefas.put(novaTarefa, false);
                System.out.println("Tarefa adicionada!");
                break;

            case 2:
                System.out.print("Qual tarefa você concluiu? (Digite o nome exato): ");
                String tarefaConcluida = ler.nextLine();

                if (tarefas.containsKey(tarefaConcluida) ) {
                    tarefas.put(tarefaConcluida, true);
                    System.out.println("Parabéns! Tarefa concluída.");
                } else {
                    System.out.println("Tarefa não encontrada!");
                }
                break;

            case 3:
                System.out.println("\n--- Lista de Tarefas ---");
                System.out.println(tarefas); 
                break;

            case 4:
                System.out.println("Saindo...");
                break;

            default:
                System.out.println("Opção inválida!");
            }
        }
    }
}