import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.zip.DataFormatException

class Candidato implements Pessoa {
    String nome
    LocalDate dataNascimento //calcular a idade
    String email
    String cpf
    String pais
    String estado
    String cep
    String descricao
    List <String> competencias


    Candidato(String nome, String dataNascimento, String email, String cpf, String pais, String estado, String cep, String descricao, List<String> competencias){
        try {
            this.nome = nome;
            def formato = DateTimeFormatter.ofPattern('dd/MM/yyyy')
            this.dataNascimento = LocalDate.parse(dataNascimento, formato)
            this.email = email;
            this.cpf = cpf;
            this.pais = pais;
            this.estado = estado;
            this.cep = cep;
            this.descricao = descricao;
            this.competencias = competencias;
        }catch(DataFormatException e){
            throw new IllegalArgumentException("Data esta em um formato invalido.")
        }catch(Exception e){
            throw new RuntimeException("Erro ao criar Candidado!!")
        }
    }


    @Override
    String getRG() {
        return null
    }

    @Override
    void setRG(String rg) {

    }

    @Override
    String getIdade(){
        if(this.dataNascimento){
            return String.valueOf(Period.between(this.dataNascimento, LocalDate.now()).getYears())
        }
        return "0"
    }

    @Override
    void setIdade(String idade) {

    }

    @Override
    void setEstado() {

    }

    @Override
    String getCEP() {
        return null
    }

    @Override
    void setCEP(String cep) {

    }

    @Override
    void setCompetencias(List<String> competencia) {

    }

    @Override
    void exibirUsuario() {
        println "Nome: " + this.nome
        println "Email: " + this.email
        println "Idade: " + this.getIdade()
        println "CPF: " + this.cpf
        println this.pais + ", "+ this.estado +", "+ this.cep
        println "Descricao: " + this.descricao
        println "Competencias: " + this.competencias.each { competencia ->
            print "$competencia "
        }

        println "\n---------------------"
    }
}
