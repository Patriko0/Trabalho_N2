import java.util.ArrayList;

public class Curso {
    static private int qts_cursos = 0;
    private int id;
    private String nome;
    private String turno;
    ArrayList<Disciplinas> disp = new ArrayList<Disciplinas>();

    public Curso(String nome, String turno, Disciplinas disp) {
        this.nome = nome;
        this.turno = turno;
        this.disp.add(disp);
        qts_cursos++;
        id = qts_cursos;
    }

    public String getNome() {
        return nome;
    }

    public void setNewDisp(Disciplinas disp) {
        this.disp.add(disp);
    }

    public String toString() {
        String nome_disp = "";
        for (Disciplinas i : disp) {
            nome_disp += i.getNome() + " | ";
        }
        return "Id: "+ id + "\nCurso: " + nome + "\nTurno: " + turno + "\nDisciplinas: " + nome_disp+ "\n";
    }
}
