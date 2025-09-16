class Vaga {

    String nome
    String descricao
    List <String> competencias
    int empresa_id


    Vaga(String nome, String descricao, List<String> competencias, int empresa_id){
        this.nome = nome;
        this.descricao = descricao;
        this.competencias = competencias;
        this.empresa_id = empresa_id;
    }

    String getDescricao() {
        return descricao
    }

    List<String> getCompetencias() {
        return competencias
    }

    void setCompetencias(List<String> competencias) {
        this.competencias = competencias
    }

    void setDescricao(String descricao) {
        this.descricao = descricao
    }

    String getNome() {
        return nome
    }

    void setNome(String nome) {
        this.nome = nome
    }
}
