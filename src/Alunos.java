import java.util.HashMap;
import java.util.Map;

public class Alunos {
    private String nome; // * Nome do aluno
    private static int newMat; // * Numero que ira complementar a matricula. Ira se incrementar toda vez que um
                               // * novo aluno surgir
    private int matricula; // * Numero de matricula do curso
    private int idade; // * Idade do aluno
    private Map<String, Float> notas = new HashMap<String, Float>(); // * Mapa para as notas dos alunos. A chave sera o
                                                                     // * nome da disciplina e a chave sera o valor da
                                                                     // * nota da disciplina

    private Curso curso; // * Curso do aluno

    public Alunos(String nome, int idade, Curso curso) { // ? Construtor
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;

        for (Disciplinas i : curso.getDisp()) {
            notas.put(i.getNome(), 0.00f);
        }

        newMat++;
        this.matricula = 2022 * 10000 + curso.getId() * 100 + newMat;

    }

    public String getNome() {
        return nome;

    }

    public Curso getCurso() {
        return curso;
    }

    public int getMatricula() {
        return matricula;
    }

    public Map<String, Float> getNotas() {
        return notas;
    }

    public String getValnotas() {

        String n = "";

        for (String i : notas.keySet()) {
            n += "\n" + i + " --- " + notas.get(i) + "\n";
        }

        return n;
    }

    public String getDiscips() {

        String discips = "";

        for (Disciplinas i : curso.getDisp()) {
            discips += "\n" + i.getNome() + "\n";
        }
        return discips;
    }

    public String toString() { // ? Vai retornar a matricula, nome, idade, e nome do curso do aluno em uma
                               // ? String
        return String.format("\nMatricula: %s\nNome: %s\nIdade: %d\nCurso: %s\n", matricula, nome, idade,
                curso.getNome());
    }

    public String consulta() { // ? Ira retornar a matricula e o nome do aluno em uma string
        return String.format("\nMatricula: %s\nNome: %s\n", matricula, nome);
    }

    public void update(String nome, int idade) { // ? Vai atualizar o nome do aluno e a idade
        this.nome = nome;
        this.idade = idade;
    }

    public void updateNota(String nome_disp, Float new_nota) { // ? Vai atualizar a nota de uma disciplina do aluno
        this.notas.put(nome_disp, new_nota);
    }

    public boolean updateDiscips(String nome_discip) { // ? Atualiza as disciplinas do aluno
        if (notas.containsKey(nome_discip)) {
            notas.remove(nome_discip);
            return true;
        }

        return false;
    }

    public void changeCurso(Curso curso) { // ? Vai mudar o curso de um aluno
        boolean exist;
        for (int i = 0; i < this.curso.getDisp().size(); i++) {
            exist = false;
            for (int j = 0; j < curso.getDisp().size(); j++) {
                if (this.curso.getDisp().get(i).getId() == curso.getDisp().get(j).getId()) {
                    exist = true;
                }
                if (!(notas.containsKey(curso.getDisp().get(j).getNome()))) {
                    notas.put(curso.getDisp().get(j).getNome(), 0.00f);
                }
            }
            if (!exist) {
                notas.remove(this.curso.getDisp().get(i).getNome());
            }
        }
        this.curso = curso;
    }
}
