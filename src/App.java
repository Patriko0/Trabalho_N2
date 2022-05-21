import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Disciplinas> disciplinas = new ArrayList<Disciplinas>();
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        ArrayList<Alunos> alunos = new ArrayList<Alunos>();
        Scanner scan = new Scanner(System.in);

        System.out.println("Sistema Academico - IFCE - Campus Itapipoca");
        boolean continuar = true;

        while (continuar) {
            System.out.println(
                    "Opções:\n   1-Gerenciar Alunos\n   2-Gerenciar Disciplinas\n   3-Gerenciar Cursos\n   4-Sair\n");
            int opc = scan.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Gerenciar Alunos\n");
                    break;
                case 2:
                    while (continuar) {
                        String New_nome;
                        int New_carg_hr;
                        System.out.println("\nGerenciar Disciplinas\n");
                        System.out.println(
                                "Opções:\n   1-Cadastrar Disciplina\n   2-Consultar Disciplina\n   3-Remover disciplina\n   4-Atualizar disciplina\n   5-Voltar ao menu inicial");
                        opc = scan.nextInt();
                        switch (opc) {
                            case 1:
                                System.out.println("\nCadastrar Disciplina\n");
                                scan.nextLine();
                                System.out.println("Escreva o nome da Disciplina: ");
                                New_nome = scan.nextLine();
                                System.out.println("Escreva a carga horaria da disciplina: ");
                                New_carg_hr = scan.nextInt();
                                disciplinas.add(new Disciplinas(New_nome, New_carg_hr));
                                break;
                            case 2:
                                if (disciplinas.size() == 0) {
                                    System.out.println("\nNão existe nenhuma disciplina para ser Consultada!");
                                    break;
                                }
                                System.out.println("\nConsultar Disciplina");
                                for (Disciplinas i : disciplinas) {
                                    System.out.println(i.consulta());
                                }
                                boolean exist = false;
                                while (!exist) {
                                    System.out.println("\nEscreva o ID da disciplina que deseja consultar");
                                    opc = scan.nextInt();
                                    for (int i = 0; i < disciplinas.size(); i++) {
                                        if (disciplinas.get(i).getId() == opc) {
                                            exist = true;
                                            System.out.println(disciplinas.get(i));
                                        }
                                    }
                                    if (!exist) {
                                        System.out.println("\nEscreva um ID valido!");
                                    }
                                }

                                break;
                            case 3:
                                if (disciplinas.size() == 0) {
                                    System.out.println("\nNão existe nenhuma disciplina para ser removida!");
                                    break;
                                }
                                System.out.println("\nRemover Disciplina");
                                for (Disciplinas i : disciplinas) {
                                    System.out.println(i.consulta());
                                }
                                exist = false;
                                while (!exist) {
                                    System.out.println("\nEscreva o ID da disciplina que deseja Deletar");
                                    opc = scan.nextInt();
                                    for (int i = 0; i < disciplinas.size(); i++) {
                                        if (disciplinas.get(i).getId() == opc) {
                                            exist = true;
                                            System.out.println("\nDeletando " + disciplinas.get(i).getNome());
                                            disciplinas.remove(i);
                                        }
                                    }
                                    if (!exist) {
                                        System.out.println("\nEscreva um ID valido!");
                                    }
                                }

                                break;
                            case 4:
                                if (disciplinas.size() == 0) {
                                    System.out.println("\nNão existe nenhuma disciplina para ser Atualizada");
                                    break;
                                }
                                System.out.println("\nAtualizar Disciplina\n");
                                for (Disciplinas i : disciplinas) {
                                    System.out.println(i.consulta());
                                }
                                exist = false;
                                while (!exist) {
                                    System.out.println("\nEscreva o ID da disciplina que deseja Atualizar");
                                    opc = scan.nextInt();
                                    for (int i = 0; i < disciplinas.size(); i++) {
                                        if (disciplinas.get(i).getId() == opc) {
                                            exist = true;
                                            scan.nextLine();
                                            System.out.println("\nEscreve o novo nome para a disciplina");
                                            New_nome = scan.nextLine();
                                            System.out.println("Escreva a nova carga horaria da disciplina");
                                            New_carg_hr = scan.nextInt();
                                            disciplinas.get(i).update(New_nome, New_carg_hr);
                                            System.out.println("\nDisciplina salva com sucesso\n");

                                        }
                                    }
                                    if (!exist) {
                                        System.out.println("\nEscreva um ID valido!");
                                    }
                                }
                                break;
                            case 5:
                                System.out.println("\nVoltando ao menu principal...\n");
                                continuar = false;
                                break;
                            default:
                                System.out.println("\nEscolha uma opcao valida\n");
                                break;
                        }
                    }
                    continuar = true;
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
