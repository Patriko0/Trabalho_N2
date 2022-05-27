import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Disciplinas> disciplinas = new ArrayList<Disciplinas>(); // * Tabela de disciplinas
        ArrayList<Curso> cursos = new ArrayList<Curso>(); // * Tabela de cursos
        ArrayList<Alunos> alunos = new ArrayList<Alunos>(); // * Tabela de alunos

        Scanner scan = new Scanner(System.in);

        disciplinas.add(new Disciplinas("Default discip", 80));
        cursos.add(new Curso("Default curso", "Manha", disciplinas.get(0)));
        alunos.add(new Alunos("Defalt aluno", 15, cursos.get(0)));

        System.out.println("Sistema Academico - IFCE - Campus Itapipoca");
        boolean continuar = true;

        while (continuar) {
            System.out.println(
                    "Opções:\n   1-Gerenciar Alunos\n   2-Gerenciar Disciplinas\n   3-Gerenciar Cursos\n   4-Sair\n");
            int opc = scan.nextInt();
            switch (opc) {
                case 1: // * Gerenciar alunos
                    while (continuar) {
                        String New_nome;
                        String verif_discip;
                        int verif_mat;
                        int New_idade;
                        float new_nota;
                        boolean exist = false;
                        System.out.println("Gerenciar Alunos\n");
                        System.out.println(
                                "Opções:\n   1-Cadastrar Aluno\n   2-Consultar Aluno\n   3-Remover Aluno\n   4-Atualizar Aluno\n   5-Mostrar notas\n   6-Atualizar notas\n   7-Mudar o curso do aluno\n   8-Voltar ao menu inicial");
                        opc = scan.nextInt();
                        switch (opc) {
                            case 1: // ? Cadastrar aluno
                                if (cursos.size() == 0) {
                                    System.out.println("\nNão existe nenhum curso cadastrado!\n");
                                    break;
                                }
                                System.out.println("\nCadastrar Aluno\n");

                                scan.nextLine();
                                System.out.println("Escreva o nome do aluno: ");
                                New_nome = scan.nextLine();
                                System.out.println("Escreva a idade do aluno: ");
                                New_idade = scan.nextInt();

                                for (Curso i : cursos) {
                                    System.out.println(i.consulta());
                                }

                                exist = false;

                                while (!exist) {
                                    System.out.println("\nEscreva o Id do Curso que deseja matricular o aluno");
                                    opc = scan.nextInt();
                                    for (int i = 0; i < cursos.size(); i++) {
                                        if (opc == cursos.get(i).getId()) {
                                            exist = true;
                                            alunos.add(new Alunos(New_nome, New_idade, cursos.get(i)));
                                        }
                                    }
                                    if (!exist) {
                                        System.out.println("\nEscreva um ID do curso valido!");
                                    }
                                }

                                break;

                            case 2: // ? Consultar aluno

                                if (alunos.size() == 0) {
                                    System.out.println("\nNão existe nenhum aluno para ser consultado!\n");
                                    break;
                                }

                                System.out.println("\nConsultar Aluno\n");

                                for (Alunos i : alunos) {
                                    System.out.println(i.consulta());
                                }

                                exist = false;
                                scan.nextLine();
                                while (!exist) {

                                    System.out.println("\nEscreva o numero da matricula do aluno que deseja consultar");
                                    verif_mat = scan.nextInt();
                                    for (int i = 0; i < alunos.size(); i++) {
                                        if (alunos.get(i).getMatricula() == verif_mat) {
                                            exist = true;
                                            System.out.println(alunos.get(i));
                                        }
                                    }
                                    if (!exist) {
                                        System.out.println("\nEscreva um ID valido!");
                                    }
                                }

                                break;
                            case 3: // ? Remover aluno
                                if (alunos.size() == 0) {
                                    System.out.println("\nNão existe nenhum aluno para ser removida!");
                                    break;
                                }
                                System.out.println("\nRemover Aluno");
                                for (Alunos i : alunos) {
                                    System.out.println(i.consulta());
                                }
                                exist = false;
                                while (!exist) {
                                    scan.nextLine();
                                    System.out.println("Escreva o numero de matricula do aluno que deseja Deletar");
                                    verif_mat = scan.nextInt();
                                    for (int i = 0; i < alunos.size(); i++) {
                                        if (alunos.get(i).getMatricula() == verif_mat) {
                                            exist = true;
                                            System.out.println("\nDeletando " + alunos.get(i).getNome());
                                            alunos.remove(i);
                                        }
                                    }
                                    if (!exist) {
                                        System.out.println("\nEscreva um ID valido!");
                                    }
                                }
                                break;

                            case 4: // ? Atualizar aluno
                                if (alunos.size() == 0) {
                                    System.out.println("\nNão existe nenhum Aluno para ser Atualizada");
                                    break;
                                }

                                System.out.println("\nAtualizar Aluno\n");

                                for (Alunos i : alunos) {
                                    System.out.println(i.consulta());
                                }

                                exist = false;
                                while (!exist) {
                                    scan.nextLine();
                                    System.out.println("\nEscreva o numero de matricula do aluno que deseja Atualizar");
                                    verif_mat = scan.nextInt();
                                    for (int i = 0; i < alunos.size(); i++) {
                                        if (alunos.get(i).getMatricula() == verif_mat) {
                                            exist = true;
                                            scan.nextLine();
                                            System.out.println("\nEscreve o novo nome para o aluno");
                                            New_nome = scan.nextLine();
                                            System.out.println("Escreva a nova idade do aluno");
                                            New_idade = scan.nextInt();
                                            alunos.get(i).update(New_nome, New_idade);
                                            System.out.println("\nAluno salvo com sucesso\n");

                                        }
                                    }
                                    if (!exist) {
                                        System.out.println("\nEscreva um numero de matricula valido!");
                                    }
                                }
                                break;

                            case 5: // ? Mostrar notas
                                if (alunos.size() == 0) {
                                    System.out.println("\nNão existe nenhum Aluno para mostrar as notas");
                                    break;
                                }

                                System.out.println("\nMostrar notas");

                                for (Alunos i : alunos) {
                                    System.out.println(i.consulta());
                                }

                                exist = false;
                                while (!exist) {
                                    scan.nextLine();
                                    System.out.println(
                                            "Escreva o numero de matricula do aluno que deseja mostrar as notas");
                                    verif_mat = scan.nextInt();
                                    for (int i = 0; i < alunos.size(); i++) {
                                        if (alunos.get(i).getMatricula() == verif_mat) {
                                            exist = true;
                                            System.out.println("\n" + alunos.get(i).getNome());
                                            System.out.println(alunos.get(i).getValnotas());
                                        }
                                    }
                                    if (!exist) {
                                        System.out.println("\nEscreva um numero de matricula valido!");
                                    }
                                }
                                break;

                            case 6: // ? Atualizar notas
                                if (alunos.size() == 0) {
                                    System.out.println("\nNão existe nenhum Aluno para atualizar as notas");
                                    break;
                                }

                                System.out.println("Atualizar notas");

                                for (Alunos i : alunos) {
                                    System.out.println(i.consulta());
                                }

                                exist = false;
                                while (!exist) {
                                    scan.nextLine();
                                    System.out.println(
                                            "Escreva o numero de matricula do aluno que deseja atualizar a nota");
                                    verif_mat = scan.nextInt();
                                    for (int i = 0; i < alunos.size(); i++) {
                                        if (alunos.get(i).getMatricula() == verif_mat) {
                                            scan.nextLine();
                                            while (!exist) {
                                                System.out.println(alunos.get(i).getDiscips());
                                                System.out.println(
                                                        "Escreva o nome da disciplina que deseja colocar uma nota");
                                                verif_discip = scan.nextLine();
                                                if (alunos.get(i).getNotas().containsKey(verif_discip)) {
                                                    exist = true;
                                                    System.out.println("Escreva a nova nota de " + verif_discip);
                                                    new_nota = scan.nextFloat();
                                                    alunos.get(i).updateNota(verif_discip, new_nota);
                                                }
                                            }
                                            exist = true;
                                        }
                                    }
                                    if (!exist) {
                                        System.out.println("\nEscreva um numero de matricula valido!");
                                    }
                                }
                                break;

                            case 7: // ? Mudar curso
                                if (alunos.size() == 0) {
                                    System.out.println("\nNão existe nenhum Aluno para mudar o curso");
                                    break;
                                }

                                System.out.println("Mudar curso de um Aluno");

                                for (Alunos i : alunos) {
                                    System.out.println(i.consulta());
                                }

                                exist = false;
                                while (!exist) {
                                    System.out.println(
                                            "Escreva o numero de matricula do aluno que deseja mudar de curso");
                                    verif_mat = scan.nextInt();
                                    for (int i = 0; i < alunos.size(); i++) {
                                        if (alunos.get(i).getMatricula() == verif_mat) {
                                            for (Curso e : cursos) {
                                                System.out.println(e.consulta());
                                            }
                                            while (!exist) {
                                                System.out.println("Escreva o id do curso que deseja mudar");
                                                opc = scan.nextInt();
                                                for (int j = 0; j < cursos.size(); j++) {
                                                    if (opc == cursos.get(j).getId()) {
                                                        System.out.println(
                                                                "Mudando de " + alunos.get(i).getCurso().getNome()
                                                                        + " para " + cursos.get(j).getNome());
                                                        alunos.get(i).changeCurso(cursos.get(j));
                                                        exist = true;
                                                    }
                                                }
                                            }
                                            exist = true;
                                        }
                                    }
                                    if (!exist) {
                                        System.out.println("\nEscreva um numero de matricula valido!");
                                    }
                                }

                                break;

                            case 8: // ! Sair
                                System.out.println("\nVoltando ao menu principal...\n");
                                continuar = false;
                                break;

                            default:
                                System.out.println("\nDigite umma opcao valida!\n");
                                break;
                        }
                    }
                    continuar = true;
                    break;
                case 2: // * Gerenciar Disciplinas
                    while (continuar) {
                        String New_nome;
                        int New_carg_hr;
                        boolean exist = false;
                        System.out.println("\nGerenciar Disciplinas\n");
                        System.out.println(
                                "Opções:\n   1-Cadastrar Disciplina\n   2-Consultar Disciplina\n   3-Remover disciplina\n   4-Atualizar disciplina\n   5-Voltar ao menu inicial");
                        opc = scan.nextInt();
                        switch (opc) {
                            case 1: // ? Cadastrar disciplina
                                System.out.println("\nCadastrar Disciplina\n");
                                scan.nextLine();
                                System.out.println("Escreva o nome da Disciplina: ");
                                New_nome = scan.nextLine();
                                System.out.println("Escreva a carga horaria da disciplina: ");
                                New_carg_hr = scan.nextInt();
                                disciplinas.add(new Disciplinas(New_nome, New_carg_hr));
                                break;
                            case 2: // ? Consultar disciplina
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
                            case 3: // ? Remover disciplina
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
                            case 4: // ? Atualizar disciplina
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
                            case 5: // ! Sair
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
                case 3: // * Gerenciar cursos
                    while (continuar) {
                        String New_nome;
                        String New_turno;
                        boolean exist = false;
                        System.out.println("\nGerenciar Cursos\n");
                        System.out.println(
                                "Opções:\n   1-Cadastrar Curso\n   2-Consultar Curso\n   3-Remover Curso\n   4-Atualizar Curso\n   5-Adicionar nova disciplina a um Curso\n   6-Remover uma disciplina de um Curso\n   7-Voltar ao menu inicial");
                        opc = scan.nextInt();
                        switch (opc) {
                            case 1: // ? Cadastrar disciplina
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
                            case 2: // ? Consultar curso
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
                            case 3: // ? Remover curso
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
                            case 4: // ? Atualizar curso
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
                            case 5: // ? Adicionar nova disciplina
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
                            case 6: // ? Remover uma disciplina
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
                            case 7: // ! Sair
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
                case 4: // ! Fechar o programa
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
