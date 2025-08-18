import org.codehaus.groovy.transform.SourceURIASTTransformation

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class TestCandidato {
    static void main(String[] args) {
        def test = new TestCandidato()
        try {
            test.testCriacaoCandidato()
            test.testCalculoIdade()
            test.testExibicaoUsuario()
            test.testListaCompetenciasVazia()
            println "Todos os testes passaram com sucesso!"
        } catch (AssertionError e) {
            println "Um ou mais testes falharam: ${e.message}"
        }
    }

    void testCriacaoCandidato() {
        def dados = [
                nome: "Tulio Amaral",
                dataNascimento: "11/05/2001",
                email: "tulioamaral@email.com",
                cpf: "123.123.123-00",
                pais: "Brasil",
                estado: "GO",
                cep: "11111-000",
                descricao: "Desenvolvedor Backend",
                competencias: ["Java", "Spring Boot", "Groovy"]
        ]

        def candidato = new Candidato(*dados.values())

        assert "Tulio Amaral" == dados.nome
        assert "tulioamaral@email.com" == dados.email
        assert "123.123.123-00" == dados.cpf
        assert "Brasil" == dados.pais
        assert "GO" == dados.estado
        assert "11111-000" == dados.cep
        assert "Desenvolvedor Backend" == dados.descricao
        assert ["Java", "Spring Boot", "Groovy"] == dados.competencias

        println "Teste Criacao candidato[OK]"
    }

    void testCalculoIdade() {
        def dataNascimento = "11/05/2001"
        def candidato = new Candidato("Teste", dataNascimento, "teste@email.com",
                "111.111.111-11", "Brasil", "SP", "00000-000", "Teste", [])

        def formato = DateTimeFormatter.ofPattern('dd/MM/yyyy')
        def dataNasc = LocalDate.parse(dataNascimento, formato)
        def idadeEsperada = Period.between(dataNasc, LocalDate.now()).getYears()
        def idadeCalculada = candidato.getIdade().toInteger()

        assert idadeCalculada == idadeEsperada
        println "Teste Idade candidato[OK]"
    }

    void testExibicaoUsuario() {
        def originalOut = System.out
        def baos = new ByteArrayOutputStream()
        System.out = new PrintStream(baos)

        try {
            def candidato = new Candidato(
                    "Tulio Amaral",
                    "11/05/2001",
                    "tulioamaral@email.com",
                    "123.123.123-00",
                    "Brasil",
                    "GO",
                    "11111-000",
                    "Desenvolvedor Backend",
                    ["Java", "Spring", "Groovy"]
            )

            candidato.exibirUsuario()

            def output = baos.toString()
            def informacoesEsperadas = [
                    "Nome: Tulio Amaral",
                    "Email: tulioamaral@email.com",
                    "CPF: 123.123.123-00",
                    "Brasil, GO, 11111-000",
                    "Descricao: Desenvolvedor Backend",
                    "Competencias:"
            ]

            informacoesEsperadas.each { info ->
                assert output.contains(info)
            }

        } finally {
            System.out = originalOut
        }
        println "Teste Exibir candidato[OK]"
    }

    void testListaCompetenciasVazia() {
        def candidato = new Candidato(
                "Tulio",
                "11/05/2001",
                "tulioamaral@email.com",
                "1123.123.123-00",
                "Brasil",
                "GO",
                "11111-000",
                "Estudante",
                []
        )

        assert candidato.competencias.isEmpty()
        println "Teste Lista Vazia[OK]"
    }
}