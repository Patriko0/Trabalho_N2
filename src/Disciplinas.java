public class Disciplinas {
    static private int qts_disc = 0;
    private int id;
    private String nome;
    private int carg_hr;
    private float nota;

    public Disciplinas(String nome,int carg_hr,float nota) {
        this.nome = nome;
        this.carg_hr = carg_hr;
        this.nota = nota;
        qts_disc++;
        id = qts_disc;
    }

    public String getNome() {
        return nome;
    }

    public String toString() {
        
        return "Id: "+id+"\nDisciplina: "+ nome + "\nCarga Horaria: " + carg_hr + "\nNota: " + nota + "\n";
    }
}
