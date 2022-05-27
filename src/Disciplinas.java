public class Disciplinas {
    static private int new_id = 0; // * Ira ser atribuido para o id da disciplina. Sera auto-incrementado, quando
                                   // * surgir uma nova disciplina
    private int id; // * Id da disciplina
    private String nome; // * Nome da disciplina
    private int carg_hr; // * Carga horaria da disciplina

    public Disciplinas(String nome, int carg_hr) { // ? Construtor
        this.nome = nome;
        this.carg_hr = carg_hr;
        new_id++;
        id = new_id;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public void setCarg_hr(int carg_hr) {
        this.carg_hr = carg_hr;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString() { // ? Ira retornar o Id, o nome da , e a carga horaria da disciplina

        return String.format("\nId: %d\nDisciplina: %s\nCarga Horaria: %d\n", id, nome, carg_hr);
    }

    public String consulta() { // ? Ira retornar o Id e o nome da disciplina
        return String.format("\nId: %d\nDisciplina: %s", id, nome);
    }

    public void update(String nome, int carg_hr) { // ? Atualiza o nome e a carga horaria da disciplina
        this.nome = nome;
        this.carg_hr = carg_hr;
    }
}
