package curso.view;

import curso.model.Curso;
import curso.model.EstadoCurso;
import curso.repository.CursoRepository;
import curso.service.CursoService;

import java.util.Scanner;
import java.util.Map;

public class Menu {

    private Scanner scanner = new Scanner(System.in);
    private CursoService cursoService;

    public Menu() {
        CursoRepository repository = new CursoRepository();
        this.cursoService = new CursoService(repository);
    }

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE CURSOS =====");
            System.out.println("1 - Cadastrar curso");
            System.out.println("2 - Buscar curso por ID");
            System.out.println("3 - Alterar estado do curso");
            System.out.println("4 - Listar cursos");
            System.out.println("5 - Remover curso");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarCurso();
                    break;

                case 2:
                    buscarCurso();
                    break;

                case 3:
                    alterarEstadoCurso();
                    break;

                case 4:
                    listarCursos();
                    break;

                case 5:
                    removerCurso();
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    // ==========================
    // MÉTODOS DO MENU
    // ==========================

    private void cadastrarCurso() {
        System.out.println("\n--- CADASTRAR CURSO ---");

        System.out.print("ID do curso: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome do curso: ");
        String nome = scanner.nextLine();

        System.out.print("Carga horária: ");
        int cargaHoraria = scanner.nextInt();
        scanner.nextLine();

        Curso curso = new Curso(id, nome, cargaHoraria);
        cursoService.criarCurso(curso);
    }

    private void buscarCurso() {
        System.out.println("\n--- BUSCAR CURSO ---");

        System.out.print("ID do curso: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Curso curso = cursoService.buscarPorId(id);

        if (curso != null) {
            System.out.println("ID: " + curso.getId());
            System.out.println("Nome: " + curso.getNome());
            System.out.println("Carga Horária: " + curso.getCargaHoraria());
            System.out.println("Estado: " + curso.getEstado());
        }
    }

    private void alterarEstadoCurso() {
        System.out.println("\n--- ALTERAR ESTADO DO CURSO ---");

        System.out.print("ID do curso: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Curso curso = cursoService.buscarPorId(id);
        if (curso == null) {
            return;
        }

        System.out.println("Estado atual: " + curso.getEstado());
        System.out.println("1 - ATIVO");
        System.out.println("2 - INATIVO");
        System.out.println("3 - CANCELADO");
        System.out.print("Novo estado: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        EstadoCurso novoEstado = null;

        switch (opcao) {
            case 1 -> novoEstado = EstadoCurso.ATIVO;
            case 2 -> novoEstado = EstadoCurso.INATIVO;
            case 3 -> novoEstado = EstadoCurso.CANCELADO;
            default -> {
                System.out.println("Estado inválido.");
                return;
            }
        }

        curso.setEstado(novoEstado);
        System.out.println("Estado alterado com sucesso.");
    }

    private void listarCursos() {
        System.out.println("\n--- LISTA DE CURSOS ---");

        Map<Integer, Curso> cursos = cursoService.listarCursos();

        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
            return;
        }

        for (Curso curso : cursos.values()) {
            System.out.println(
                curso.getId() + " | " +
                curso.getNome() + " | " +
                curso.getCargaHoraria() + "h | " +
                curso.getEstado()
            );
        }
    }

    private void removerCurso() {
        System.out.println("\n--- REMOVER CURSO ---");

        System.out.print("ID do curso: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        cursoService.removerCurso(id);
    }
}
