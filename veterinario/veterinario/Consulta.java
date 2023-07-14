package veterinario;
public class Consulta {
    private String nomeAnimal;
    private String nomeDono;
    private String dataHora;

    public Consulta(String nomeAnimal, String nomeDono, String dataHora) {
        this.nomeAnimal = nomeAnimal;
        this.nomeDono = nomeDono;
        this.dataHora = dataHora;
    }

    // Getters e Setters
    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public String getNomeDono() {
        return nomeDono;
    }

    public void setNomeDono(String nomeDono) {
        this.nomeDono = nomeDono;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }
}
