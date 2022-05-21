import java.util.HashMap;
import java.util.Map;

public class Alunos {
    String nome;
    int matricula;
    int idade;
    Map<String, Float> notas = new HashMap<String, Float>();
    Curso c1;

    public Alunos(String nome, int matricula, int idade, Curso c1) {
        this.nome = nome;
        this.matricula = matricula;
        this.idade = idade;
        this.c1 = c1;
    }

    public String toString() {
        return "Nome: " + nome + "\nNumero de matricula: " + matricula + "\nIdade: " + idade + "\nCurso: "
                + c1.getNome() + "\n";
    }
}
