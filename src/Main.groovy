import java.util.Scanner

static void main(String[] args) {

    def scanner = new Scanner(System.in)
    def candidatos = []
    def empresas = []

    def competencias = ['Java', 'Spring framework'];

    //Iniciando os candidatos
    def candidatoUm = new Candidato('tulio', '11/05/2001', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-505', 'tulio lindo', competencias)
    def candidatoDois = new Candidato('tulio', '11/05/2001', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-505', 'tulio lindo', competencias)
    def candidatoTres = new Candidato('tulio', '11/05/2001', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-505', 'tulio lindo', competencias)
    def candidatoQuatro = new Candidato('tulio', '11/05/2001', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-505', 'tulio lindo', competencias)
    def candidatoCinco = new Candidato('tulio', '11/05/2001', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-505', 'tulio lindo', competencias)

    candidatos.add(candidatoUm)
    candidatos.add(candidatoDois)
    candidatos.add(candidatoTres)
    candidatos.add(candidatoQuatro)
    candidatos.add(candidatoCinco)

    //iniciando as empresas
    def empresaUm =  new Judirica('empresaUm', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-504', 'empresa lindo', competencias)
    def empresaDois =  new Judirica('EmpresaDois', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-503', 'empresa lindo', competencias)
    def empresaTres =  new Judirica('EmpresaTres', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-502', 'empresa lindo', competencias)
    def empresaQuatro =  new Judirica('EmpresaQuatro', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-501', 'empresa lindo', competencias)
    def empresaCinco =  new Judirica('EmpresaCinco', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-500', 'empresa lindo', competencias)

    empresas.add(empresaUm)
    empresas.add(empresaDois)
    empresas.add(empresaTres)
    empresas.add(empresaQuatro)
    empresas.add(empresaCinco)

    def opcao = 0;

    //Funcionalidades programa
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
            scanner.nextLine()
            def valorParaObjeto = []

            print("Adicionando usuario ")
            println("\nNome: ")
            valorParaObjeto.add(scanner.nextLine())
            print("\nData de Nascimento: ")
            valorParaObjeto.add(scanner.nextLine())
            print("\nEmail: ")
            valorParaObjeto.add(scanner.nextLine())
            print("\nCPF: ")
            valorParaObjeto.add(scanner.nextLine())
            print("\nPais:")
            valorParaObjeto.add(scanner.nextLine())
            print("\nEstado: ")
            valorParaObjeto.add(scanner.nextLine())
            print("\nCEP: ")
            valorParaObjeto.add(scanner.nextLine())
            print("\nDescricao: ")
            valorParaObjeto.add(scanner.nextLine())
            print("\nCompetencias: (Separe por ,)")
            valorParaObjeto.add(scanner.nextLine().split(',').collect(){it.trim()})

            valorParaObjeto.eachWithIndex{ valor, index ->
                println("[$index] $valor (${valor?.class?.simpleName})")
            }

            try{
                def adicionandoCandidato = new Candidato(
                        valorParaObjeto[0] as String,
                        valorParaObjeto[1] as String,
                        valorParaObjeto[2] as String,
                        valorParaObjeto[3] as String,
                        valorParaObjeto[4] as String,
                        valorParaObjeto[5] as String,
                        valorParaObjeto[6] as String,
                        valorParaObjeto[7] as String,
                        valorParaObjeto[8] as List<String>
                )
                candidatos.add(adicionandoCandidato)
            }catch(Exception e){
                println "Erro: ${e.message}"
            }


        }
        else if(opcao == 2){
            scanner.nextLine()
            def valorParaObjeto = []

            print("Adicionando usuario ")
            println("\nNome: ")
            valorParaObjeto.add(scanner.nextLine())
            print("\nEmail Corporativo: ")
            valorParaObjeto.add(scanner.nextLine())
            print("\nCNPJ: ")
            valorParaObjeto.add(scanner.nextLine())
            print("\nPais:")
            valorParaObjeto.add(scanner.nextLine())
            print("\nEstado: ")
            valorParaObjeto.add(scanner.nextLine())
            print("\nCEP: ")
            valorParaObjeto.add(scanner.nextLine())
            print("\nDescricao: ")
            valorParaObjeto.add(scanner.nextLine())
            print("\nCompetencias: (Separe por ,)")
            valorParaObjeto.add(scanner.nextLine().split(',').collect(){it.trim()})

            valorParaObjeto.eachWithIndex{ valor, index ->
                println("[$index] $valor (${valor?.class?.simpleName})")
            }

            try{
                def adicionandoEmpresa = new Judirica(
                        valorParaObjeto[0] as String,
                        valorParaObjeto[1] as String,
                        valorParaObjeto[2] as String,
                        valorParaObjeto[3] as String,
                        valorParaObjeto[4] as String,
                        valorParaObjeto[5] as String,
                        valorParaObjeto[6] as String,
                        valorParaObjeto[7] as List<String>
                )
                empresas.add(adicionandoEmpresa)
            }catch(Exception e){
                println "Erro: ${e.message}"
            }
        }else if(opcao == 3){
            empresas.each { empresa ->
                empresa.exibirUsuario()
            }
        }else if(opcao == 4){
            candidatos.each { candidato ->
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