public class Alunos {
    String nome;
    int matricula;
    int idade;
    Curso c1;

    public Alunos(String nome,int matricula,int idade,Curso c1) {
        this.nome = nome;
        this.matricula = matricula;
        this.idade = idade;
        this.c1 = c1;
    }   
    public String toString() {
        return nome + " " + matricula + " " + idade + " " + c1.getNome();
    }
}
