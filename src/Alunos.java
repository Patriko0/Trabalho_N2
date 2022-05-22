import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Alunos {
    private String nome;
    private static int num_mat;
    private String matricula;
    private int idade;
    private Map<String, Float> notas = new HashMap<String, Float>();
    private Curso c1;

    public Alunos(String nome, int idade, Curso c1) {
        this.nome = nome;
        this.idade = idade;
        this.c1 = c1;
        for (Disciplinas i : c1.getDisp()) {
            notas.put(i.getNome(), 0.00f);
        }
        num_mat++;
        this.matricula = String.format("2020%d%d", c1.getId(), num_mat);
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String toString() {
        return String.format("\nMatricula: %s\nNome: %s\nIdade: %d\nCurso: %s\n", matricula, nome, idade, c1.getNome());
    }

    public String consulta() {
        return String.format("\nMatricula: %s\nNome: %s\n", matricula, nome);
    }

    public void update(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void update_Nota(String nome_disp, Float new_nota) {
        this.notas.put(nome_disp, new_nota);
    }

    public void change_Curso(Curso c1) {
        ArrayList<String> same_discip = new ArrayList<String>();
        for (int i = 0; i < this.c1.getDisp().size(); i++) {
            for (int j = 0; j < c1.getDisp().size(); j++) {
                if (this.c1.getDisp().get(i).getId() == c1.getDisp().get(j).getId()) {
                    same_discip.add(c1.getDisp().get(j).getNome());
                }
            }
        }

        this.c1 = c1;

    }
}
