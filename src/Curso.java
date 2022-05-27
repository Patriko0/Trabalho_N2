import java.util.ArrayList;

public class Curso {
    static private int new_cursos_id = 0; // * Ira ser atribuido para o id do curso. Sera auto-incrementado, quando
                                          // * surgir um novo curso
    private int id; // * Id do curso
    private String nome; // * Nome do curso
    private String turno; // * Turno do curso
    private ArrayList<Disciplinas> disp = new ArrayList<Disciplinas>(); // * Lista de disciplinas associatas ao curso

    public Curso(String nome, String turno, Disciplinas disp) { // ? Construtor
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

    public String toString() { // ? Ira retornar o id, nome, turno, e todas as disciplinas do curso
        String nome_disp = "";
        for (Disciplinas i : disp) {
            nome_disp += i.getNome() + " | ";
        }

        return String.format("\nId: %d\nCurso: %s\nTurno: %s\nDisciplinas: %s\n", id, nome, turno, nome_disp);
    }

    public String consulta() { // ? Ira retornar o Id e o nome do curso
        return String.format("\nId: %d\nCurso: %s", id, nome);
    }

    public void add_discip(Disciplinas d) { // ? Adiciona uma nova disciplina ao curso
        disp.add(d);
    }

    public void remove_discip(int id_discip) { // ? Remove uma disciplina do curso
        for (int i = 0; i < disp.size(); i++) {
            if (disp.get(i).getId() == id_discip) {
                disp.remove(i);
            }
        }
    }

    public void update(String nome, String turno) { // ? Atualiza o nome e o turno do curso
        this.nome = nome;
        this.turno = turno;
    }
}
