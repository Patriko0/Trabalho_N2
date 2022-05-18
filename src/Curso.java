import java.util.ArrayList;
public class Curso {
    private int id;
    private String nome;    
    private String turno;
    ArrayList<Disciplinas> disp = new ArrayList<Disciplinas>();

    public Curso(String nome, String turno, Disciplinas disp) {
        this.nome = nome;
        this.turno = turno;
        this.disp.add(disp);
    }

    public String getNome() {
        return nome;
    }

    public void setNewDisp(Disciplinas disp) {
        this.disp.add(disp);
    }

    @Override
    public String toString() {
        String nome_disp = null;
        for (Disciplinas i : disp) {
            nome_disp += i.getNome() + " ";
        }
        return nome+" "+turno+" " + nome_disp;
    }
}
