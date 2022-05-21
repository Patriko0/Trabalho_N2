public class Disciplinas {
    static private int new_id = 0;
    private int id;
    private String nome;
    private int carg_hr;

    public Disciplinas(String nome, int carg_hr) {
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

    public String toString() {

        return String.format("\nId: %d\nDisciplina: %s\nCarga Horaria: %d\n", id, nome, carg_hr);
    }

    public String consulta() {
        return String.format("\nId: %d\nDisciplina: %s", id, nome);
    }

    public void update(String nome, int carg_hr) {
        this.nome = nome;
        this.carg_hr = carg_hr;
    }
}
