import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Juridica implements Pessoa{

    String nome
    String email
    String cnpj
    String pais
    String estado
    String cep
    String descricao
    List <String> competencias

    Juridica(String nome, String email, String cnpj, String pais, String estado, String cep, String descricao, List<String> competencias){
        this.nome = nome;
        this.email = email;
        this.cnpj = cnpj;
        this.pais = pais;
        this.estado = estado;
        this.cep = cep;
        this.descricao = descricao;
        this.competencias = competencias;
    }

    @Override
    String getNome() {
        return this.nome
    }

    @Override
    void setNome(String nome) {

    }

    @Override
    String getEmail() {
        return this.email
    }

    @Override
    void setEmail(String email) {

    }

    @Override
    String getRG() {
        return this.cnpj
    }

    @Override
    void setRG(String rg) {

    }

    @Override
    String getIdade() {
        return this.idade
    }

    @Override
    void setIdade(String idade) {

    }

    @Override
    String getEstado() {
        return this.estado
    }

    @Override
    void setEstado() {

    }

    @Override
    String getCEP() {
        return this.cep
    }

    @Override
    void setCEP(String cep) {

    }

    @Override
    String getDescricao() {
        return this.descricao
    }

    @Override
    void setDescricao(String descricao) {

    }

    @Override
    List<String> getCompetencias() {
        return []
    }

    @Override
    void setCompetencias(List<String> competencia) {
        // Implementation here
    }

    @Override
    void exibirUsuario() {
        println "Pessoa Juridica"
        println "Nome: ${this.nome}"
        println "Email Corporativo: " + this.email
        println "CPF: " + this.cnpj
        println this.pais + ", "+ this.estado +", "+ this.cep
        println "Descricao: " + this.descricao
        println "Competencias: " + this.competencias.each { competencia ->
            print "$competencia "
        }

        println "\n---------------------"
    }
}
