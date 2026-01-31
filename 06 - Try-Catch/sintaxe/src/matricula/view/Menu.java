		package matricula.view;
		import java.util.InputMismatchException;
import java.util.Scanner;
	
	import matricula.model.Aluno;
import matricula.model.Curso;
import matricula.model.Matricula;
import matricula.repository.AlunosRepository;
	import matricula.repository.CursosRepository;
	import matricula.repository.MatriculaRepository;
	import matricula.service.AlunoService;
	import matricula.service.CursosService;
	import matricula.service.MatriculaService;
		
		public class Menu {
		
			private AlunoService alunoService;
			private CursosService cursoService;
			private MatriculaService matriculaService;
			private Scanner ler = new Scanner(System.in);
			private int total = 0;
			
			public Menu() {
				AlunosRepository alunoRepositorio = new AlunosRepository();
				alunoService = new AlunoService(alunoRepositorio);
				CursosRepository cursosRepositorio = new CursosRepository();
				cursoService = new CursosService(cursosRepositorio);
				MatriculaRepository matriculaRepositorio = new MatriculaRepository();
				matriculaService = new MatriculaService(matriculaRepositorio, alunoRepositorio, cursosRepositorio);
			}
			
			public void exibirMenu() {
				int opcao = 0;
		
			do {
			System.out.println("==========BEM-VINDO==========");
			System.out.println("[1] Aluno");
			System.out.println("[2] Cursos");
			System.out.println("[3] Matricula");
			System.out.println("Insira uma das opções para acessar mais informações sobre.");
			opcao = ler.nextInt();
			ler.nextLine();
			
			switch(opcao) {
			case 1 -> System.out.println("[1] ");
	
			default -> System.out.println("Insira uma opção válida");
			}
			
			}while(opcao !=0);
		
			}
			
			public void menuAluno() {
				int opcaoAluno;
				do {
				System.out.println("[1] Cadastrar aluno");
				System.out.println("[2] Buscar aluno");
				System.out.println("[3] Remover aluno");
				System.out.println("[4] Listar todos os alunos");
				System.out.println("[0] Voltar");
				System.out.println("Insira a opção desejada:");
				opcaoAluno = ler.nextInt();
				ler.nextLine();
				
				switch(opcaoAluno) {
				case 1 -> {
					try {
				System.out.println("Insira o ID do aluno: ");
				int id = ler.nextInt();
				ler.nextLine();
				
				System.out.println("Insira o nome do aluno: ");
				String nome = ler.nextLine();
				
				System.out.println("Insira a idade do aluno: ");
				int idade = ler.nextInt();
				ler.nextLine();
				
				Aluno aluno = new Aluno (id, nome, idade);
				alunoService.cadastrarAluno(aluno);
				System.out.println("Aluno cadastrado com sucesso.");
				}catch(IllegalArgumentException e) {
					System.out.println("Erro: " +e.getMessage());
				}catch(Exception e) {
					System.out.println("Erro inesperado.");
					}
				}
				
				case 2 -> {
				    try {
				        System.out.println("Insira o nome do aluno:");
				        String nome = ler.nextLine();

				        // Busca o aluno
				        Aluno aluno = alunoService.buscarPorNome(nome);

				        System.out.println("ID: " + aluno.getId());
				        System.out.println("Nome: " + aluno.getNome());
				        System.out.println("Idade: " + aluno.getIdade());

				        // Tenta buscar matrícula do aluno
				        try {
				            Matricula matricula = matriculaService.buscarPorAlunoId(aluno.getId());
				            Curso curso = matricula.getCurso();

				            System.out.println("Cursando: " + curso.getNome());

				        } catch (IllegalArgumentException e) {
				            // Aluno existe, mas não está matriculado
				            System.out.println("Cursando: nenhum curso");
				        }

				    } catch (IllegalArgumentException e) {
				        System.out.println("Erro: " + e.getMessage());
				    } catch (Exception e) {
				        System.out.println("Erro inesperado.");
				    }
				}

				case 3 ->{
					try {
						System.out.println("Insira o nome do aluno:");
						String nome = ler.nextLine();
						Aluno aluno = alunoService.buscarPorNome(nome);
						alunoService.removerAluno(aluno.getId());
						System.out.println("Aluno removido com êxito.");
					}catch(IllegalArgumentException e){
						System.out.println("Erro: " + e.getMessage());
						}catch(Exception e) {
						System.out.println("Erro inesperado.");
						}
					}
				
				case 4 ->{
				for(Aluno aluno: alunoService.listarTodos().values()) {
					System.out.println("Nome: " +  aluno.getNome() + 
							           "Idade: " + aluno.getIdade());
					total++;
				}
				System.out.println("Quantidade total de alunos: " + total);
					}
				}
				}while(opcaoAluno != 0);
			}
		}
		
		
