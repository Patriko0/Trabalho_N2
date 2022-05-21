import java.util.ArrayList;

public class Curso {
    static private int new_cursos_id = 0;
    private int id;
    private String nome;
    private String turno;
    ArrayList<Disciplinas> disp = new ArrayList<Disciplinas>();

    public Curso(String nome, String turno, Disciplinas disp) {
        this.nome = nome;
        this.turno = turno;
        this.disp.add(disp);
        new_cursos_id++;
        id = new_cursos_id;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Disciplinas> getDisp() {
        return disp;
    }

    public void setNewDisp(Disciplinas disp) {
        this.disp.add(disp);
    }

    public String toString() {
        String nome_disp = "";
        for (Disciplinas i : disp) {
            nome_disp += i.getNome() + " | ";
        }

        return String.format("\nId: %d\nCurso: %s\nTurno: %s\nDisciplinas: %s\n", id, nome, turno, nome_disp);
    }

    public String consulta() {
        return String.format("\nId: %d\nCurso: %s", id, nome);
    }

    public void add_discip(Disciplinas d) {
        disp.add(d);
    }

    public void remove_discip(int id_discip) {
        for (int i = 0; i < disp.size(); i++) {
            if (disp.get(i).getId() == id_discip) {
                disp.remove(i);
            }
        }
    }

    public void update(String nome, String turno) {
        this.nome = nome;
        this.turno = turno;
    }
}
