		package matricula.view;
		import java.util.Scanner;
	
	import matricula.model.Aluno;
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
				System.out.println("Insira o número de matricula do aluno: ");
				int id = ler.nextInt();
				ler.nextLine();
				System.out.println("Insira o nome do aluno: ");
				String nome = ler.nextLine();
				System.out.println("Insira a idade do aluno: ");
				int idade = ler.nextInt();
				ler.nextLine();
				Aluno aluno = new Aluno (id, nome, idade);
				alunoService.cadastrarAluno(aluno);
				}
				default -> {  System.out.println("Insira uma opção válida.");
						}
					}
				}while(opcaoAluno != 0);
			}
		}
			
		
