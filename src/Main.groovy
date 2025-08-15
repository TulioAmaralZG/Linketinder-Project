import java.util.Scanner

static void main(String[] args) {

    def scanner = new Scanner(System.in)
    def candidatos = []
    def empresas = []

    def competencias = ['Java', 'Spring framework'];

    //Iniciando os candidatos
    def candidato =  new Candidato('tulio', '11/05/2001', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-505', 'tulio lindo', competencias)
    def candidatoDois =  new Candidato('tulio', '11/05/2001', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-505', 'tulio lindo', competencias)
    def candidatoTres =  new Candidato('tulio', '11/05/2001', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-505', 'tulio lindo', competencias)
    def candidatoQuatro =  new Candidato('tulio', '11/05/2001', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-505', 'tulio lindo', competencias)
    def candidatoCinco =  new Candidato('tulio', '11/05/2001', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-505', 'tulio lindo', competencias)

    candidatos.add(candidato)
    candidatos.add(candidatoDois)
    candidatos.add(candidatoTres)
    candidatos.add(candidatoQuatro)
    candidatos.add(candidatoCinco)

    //iniciando as empresas
    def empresa =  new Judirica('empresaUm', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-504', 'empresa lindo', competencias)
    def empresaDois =  new Judirica('EmpresaDois', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-503', 'empresa lindo', competencias)
    def empresaTres =  new Judirica('EmpresaTres', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-502', 'empresa lindo', competencias)
    def empresaQuatro =  new Judirica('EmpresaQuatro', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-501', 'empresa lindo', competencias)
    def empresaCinco =  new Judirica('EmpresaCinco', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-500', 'empresa lindo', competencias)

    empresas.add(empresa)
    empresas.add(empresaDois)
    empresas.add(empresaTres)
    empresas.add(empresaQuatro)
    empresas.add(empresaCinco)

    def opcao = 0;

    while(opcao != 5) {


        println("-----------------------")
        println("1- Adicionar Usuário")
        println("2- Adicionar Empresa")
        println("3- Listar Empresas")
        println("4- Listar Usuários")
        println("5- Sair")
        println("-----------------------")
        println("Escolha uma opção: ")
        opcao = scanner.nextInt()


        if (opcao == 1) {

        }else if(opcao == 2){

        }else if(opcao == 3){
            empresas.each { juridica ->
                empresa.exibirUsuario()
            }
        }else if(opcao == 4){
            candidatos.each { usuario ->
                candidato.exibirUsuario()
            }
        }else if(opcao == 5){
            println "Opcao Funcionando"
            break
        }else{
            println "Opcao invalida!!"
        }
    }
}