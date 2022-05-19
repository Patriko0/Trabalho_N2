import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Disciplinas> disciplinas = new ArrayList<Disciplinas>();
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        ArrayList<Alunos> alunos = new ArrayList<Alunos>();
        Scanner scan = new Scanner(System.in);

        cursos.add(new Curso("informatica", "manha", disp))

        System.out.println("Sistema Academico - IFCE - Campus Itapipoca");
        boolean continuar = true;


        while (continuar) {
            System.out.println("Opções:\n   1-Gerenciar Alunos\n   2-Gerenciar Disciplinas\n   3-Gerenciar Cursos\n   4-Sair\n");
            int opc = scan.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Gerenciar Alunos\n");
                    break;
                case 2:
                    System.out.println("Gerenciar Disciplinas\n");
                    break;
                case 3:
                    System.out.println("Gerenciar Cursos\n");
                    break;
                case 4:
                    System.out.println("Saindo...\n");
                    continuar = false;
                    break;
                default:
                    System.out.println("Escolha uma opcao valida\n");
                    break;
            }
        }
        scan.close();
    }
}
