import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Disciplinas> disciplinas = new ArrayList<Disciplinas>();
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        ArrayList<Alunos> Alunos = new ArrayList<Alunos>();

        disciplinas.add(new Disciplinas("Redes", 40, 3.4f));
        disciplinas.add(new Disciplinas("Montagem e Manutenção", 60, 9.6f));
        cursos.add(new Curso("Informática", "Manhã", disciplinas.get(1)));
        System.out.println(disciplinas);

    }
}
