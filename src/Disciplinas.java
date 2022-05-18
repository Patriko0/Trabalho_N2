public class Disciplinas {
    private String nome;
    private int carg_hr;
    private float nota;

    public Disciplinas(String nome,int carg_hr,float nota) {
        this.nome = nome;
        this.carg_hr = carg_hr;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        
        return nome + " " + carg_hr + " " + nota;
    }
}
