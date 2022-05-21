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
                        boolean exist;
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
                                exist = false;
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
                    while (continuar) {
                        String New_nome;
                        String New_turno;
                        boolean exist = false;
                        System.out.println("\nGerenciar Cursos\n");
                        System.out.println(
                                "Opções:\n   1-Cadastrar Curso\n   2-Consultar Curso\n   3-Remover Curso\n   4-Atualizar Curso\n   5-Adicionar nova disciplina a um Curso\n   6-Remover uma disciplina de um Curso\n   7-Voltar ao menu inicial");
                        opc = scan.nextInt();
                        switch (opc) {
                            case 1:
                                if (disciplinas.size() == 0) {
                                    System.out.println("Nao existe nenhuma disciplina cadastrada");
                                    break;
                                }
                                System.out.println("\nCadastrar Curso\n");
                                scan.nextLine();
                                System.out.println("Escreva o nome do Curso: ");
                                New_nome = scan.nextLine();
                                System.out.println("Escreva o turno do Curso: ");
                                New_turno = scan.nextLine();

                                for (Disciplinas i : disciplinas) {
                                    System.out.println(i.consulta());
                                }

                                while (!exist) {
                                    System.out.println("\nEscreva o Id da disciplina que deseja colocar inicialmente");
                                    opc = scan.nextInt();
                                    for (int i = 0; i < disciplinas.size(); i++) {
                                        if (opc == disciplinas.get(i).getId()) {
                                            exist = true;
                                            cursos.add(new Curso(New_nome, New_turno, disciplinas.get(i)));
                                        }
                                    }
                                    if (!exist) {
                                        System.out.println("\nEscreva um ID de disciplina valido!");
                                    }
                                }
                                break;
                            case 2:
                                if (cursos.size() == 0) {
                                    System.out.println("\nNão existe nenhum Curso para ser Consultada!");
                                    break;
                                }
                                System.out.println("\nConsultar Curso");
                                for (Curso i : cursos) {
                                    System.out.println(i.consulta());
                                }
                                exist = false;
                                while (!exist) {
                                    System.out.println("\nEscreva o ID do Curso que deseja consultar");
                                    opc = scan.nextInt();
                                    for (int i = 0; i < cursos.size(); i++) {
                                        if (cursos.get(i).getId() == opc) {
                                            exist = true;
                                            System.out.println(cursos.get(i));
                                        }
                                    }
                                    if (!exist) {
                                        System.out.println("\nEscreva um ID valido!");
                                    }
                                }

                                break;
                            case 3:
                                if (cursos.size() == 0) {
                                    System.out.println("\nNão existe nenhum Curso para ser removida!");
                                    break;
                                }
                                System.out.println("\nRemover Curso");
                                for (Curso i : cursos) {
                                    System.out.println(i.consulta());
                                }
                                exist = false;
                                while (!exist) {
                                    System.out.println("\nEscreva o ID do Curso que deseja Deletar");
                                    opc = scan.nextInt();
                                    for (int i = 0; i < cursos.size(); i++) {
                                        if (cursos.get(i).getId() == opc) {
                                            exist = true;
                                            System.out.println("\nDeletando " + cursos.get(i).getNome());
                                            cursos.remove(i);
                                        }
                                    }
                                    if (!exist) {
                                        System.out.println("\nEscreva um ID valido!");
                                    }
                                }

                                break;
                            case 4:
                                if (cursos.size() == 0) {
                                    System.out.println("\nNão existe nenhum Curso para ser Atualizada");
                                    break;
                                }
                                System.out.println("\nAtualizar Curso\n");

                                for (Curso i : cursos) {
                                    System.out.println(i.consulta());
                                }

                                exist = false;
                                while (!exist) {
                                    System.out.println("\nEscreva o ID do curso que deseja Atualizar");
                                    opc = scan.nextInt();
                                    for (int i = 0; i < cursos.size(); i++) {
                                        if (cursos.get(i).getId() == opc) {
                                            exist = true;
                                            scan.nextLine();
                                            System.out.println("\nEscreve o novo nome para o Curso");
                                            New_nome = scan.nextLine();
                                            System.out.println("Escreva a novo turno do curso");
                                            New_turno = scan.nextLine();
                                            cursos.get(i).update(New_nome, New_turno);

                                        }
                                    }
                                    if (!exist) {
                                        System.out.println("\nEscreva um ID valido!");
                                    }
                                }
                                break;
                            case 5:
                                if (cursos.size() == 0) {
                                    System.out.println("\nNão existe nenhum Curso para colocar uma nova disciplina!");
                                    break;
                                }
                                System.out.println("\nAdicionar nova disciplina a um Curso\n");

                                for (Curso i : cursos) {
                                    System.out.println(i.consulta());
                                }
                                exist = false;
                                while (!exist) {
                                    System.out.println(
                                            "\nEscreva o ID do curso que deseja adicionar uma nova disciplina");
                                    opc = scan.nextInt();
                                    for (int i = 0; i < cursos.size(); i++) {
                                        if (cursos.get(i).getId() == opc) {
                                            exist = true;

                                            for (Disciplinas e : disciplinas) {
                                                System.out.println(e.consulta());
                                            }

                                            boolean exist_discip = false;

                                            while (!exist_discip) {
                                                System.out
                                                        .println(
                                                                "\nDigite o ID da disciplina que deseja ser adicionada");
                                                opc = scan.nextInt();
                                                for (int j = 0; j < disciplinas.size(); j++) {
                                                    if (disciplinas.get(j).getId() == opc) {
                                                        exist_discip = true;
                                                        cursos.get(i).add_discip(disciplinas.get(j));
                                                    }
                                                }
                                                if (!exist_discip) {
                                                    System.out.println("Escreva um ID valido!");
                                                }
                                            }
                                        }
                                    }
                                    if (!exist) {
                                        System.out.println("\nEscreva um ID valido!");
                                    }
                                }
                                break;
                            case 6:
                                if (cursos.size() == 0) {
                                    System.out.println("\nNão existe nenhum Curso para remover uma disciplina!");
                                    break;
                                }
                                System.out.println("\nRemover uma disciplina de um Curso\n");

                                for (Curso i : cursos) {
                                    System.out.println(i.consulta());
                                }
                                exist = false;
                                while (!exist) {
                                    System.out.println(
                                            "\nEscreva o ID do curso que deseja remover uma disciplina");
                                    opc = scan.nextInt();
                                    for (int i = 0; i < cursos.size(); i++) {
                                        if (cursos.get(i).getId() == opc) {
                                            exist = true;

                                            for (Disciplinas e : cursos.get(i).getDisp()) {
                                                System.out.println(e.consulta());
                                            }

                                            boolean exist_discip = false;

                                            while (!exist_discip) {
                                                System.out
                                                        .println(
                                                                "\nDigite o ID da disciplina que voce deseja remover");
                                                opc = scan.nextInt();
                                                for (int j = 0; j < cursos.get(i).getDisp().size(); j++) {
                                                    if (cursos.get(i).getDisp().get(j).getId() == opc) {
                                                        exist_discip = true;
                                                        cursos.get(i)
                                                                .remove_discip(cursos.get(i).getDisp().get(j).getId());
                                                    }
                                                }
                                                if (!exist_discip) {
                                                    System.out.println("Escreva um ID valido!");
                                                }
                                            }
                                        }
                                    }
                                    if (!exist) {
                                        System.out.println("\nEscreva um ID valido!");
                                    }
                                }
                                break;
                            case 7:
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
