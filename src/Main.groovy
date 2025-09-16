import javax.xml.crypto.Data
import java.util.Scanner

static void main(String[] args) {

    def db = new DataBase()
    db.init()


    def scanner = new Scanner(System.in)

    def competencias = ['Java', 'Spring framework'];

    //Iniciando os candidatos
    def candidatoUm = new Candidato('tulio', '11/05/2001', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-505', 'tulio lindo', competencias)
    def candidatoDois = new Candidato('tulio', '11/05/2001', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-505', 'tulio lindo', competencias)
    def candidatoTres = new Candidato('tulio', '11/05/2001', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-505', 'tulio lindo', competencias)
    def candidatoQuatro = new Candidato('tulio', '11/05/2001', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-505', 'tulio lindo', competencias)
    def candidatoCinco = new Candidato('tulio', '11/05/2001', 'tulio.famaral1@gmail.com', '123.456.789-00', 'Brasil', 'GO', '74690-505', 'tulio lindo', competencias)

    db.insertUsuario(candidatoUm)
    db.insertUsuario(candidatoDois)
    db.insertUsuario(candidatoTres)
    db.insertUsuario(candidatoQuatro)
    db.insertUsuario(candidatoCinco)

    //iniciando as empresas
    def empresaUm =  new Juridica('empresaUm', 'tulio.famaral1@gmail.com', '12345678900', 'Brasil', 'GO', '74690504', 'empresa lindo', competencias)
    def empresaDois =  new Juridica('EmpresaDois', 'tulio.famaral1@gmail.com', '12345678900', 'Brasil', 'GO', '74690503', 'empresa lindo', competencias)
    def empresaTres =  new Juridica('EmpresaTres', 'tulio.famaral1@gmail.com', '12345678900', 'Brasil', 'GO', '74690502', 'empresa lindo', competencias)
    def empresaQuatro =  new Juridica('EmpresaQuatro', 'tulio.famaral1@gmail.com', '12345678900', 'Brasil', 'GO', '74690501', 'empresa lindo', competencias)
    def empresaCinco =  new Juridica('EmpresaCinco', 'tulio.famaral1@gmail.com', '12345678900', 'Brasil', 'GO', '74690500', 'empresa lindo', competencias)

    db.insertEmpresa(empresaUm)
    db.insertEmpresa(empresaDois)
    db.insertEmpresa(empresaTres)
    db.insertEmpresa(empresaQuatro)
    db.insertEmpresa(empresaCinco)

    def opcao = 0;
    def modoUsuario = 0;
    def nomeUsuario = ""

    //Funcionalidades programa
    while(opcao != 5) {

        while(modoUsuario == 0){
            println("Escolha um modo de visualização:")
            println("1- Candidato")
            println("2- Empresa")
            println("3- Vaga")
            modoUsuario = scanner.nextInt()
        }

        if(modoUsuario == 1){
            nomeUsuario = "Candidato"
        }
        else if(modoUsuario == 2){
            nomeUsuario = "Empresa"
        }
        else if(modoUsuario == 3){
            nomeUsuario = "Vaga"
        }

        println("-----------------------")
        println("1 - Adicionar ${nomeUsuario}")
        println("2 - Listar ${nomeUsuario}")
        println("3 - Atualizar ${nomeUsuario}")
        println("4 - Deletar ${nomeUsuario}")
        println("5 - Sair")
        println("6 - Trocar modo de visualização")
        println("-----------------------")
        println("Escolha uma opção: ")
        opcao = scanner.nextInt()


        switch(opcao){
            case 1:
                scanner.nextLine()
                def valorParaObjeto = []

                print("Adicionando ${nomeUsuario} ")
                println("\nNome: ")
                valorParaObjeto.add(scanner.nextLine())

                if(modoUsuario == 1 || modoUsuario == 2){

                    if(nomeUsuario == 1){
                        print("\nData de Nascimento: ")
                        valorParaObjeto.add(scanner.nextLine())
                    }

                    print("\nEmail: ")
                    valorParaObjeto.add(scanner.nextLine())

                    if(nomeUsuario == 1){
                        print("\nCPF: ")
                        valorParaObjeto.add(scanner.nextLine())
                    }else(nomeUsuario == 2){
                        print("\nCNPJ: ")
                        valorParaObjeto.add(scanner.nextLine())
                    }
                    print("\nPais:")
                    valorParaObjeto.add(scanner.nextLine())
                    print("\nEstado: ")
                    valorParaObjeto.add(scanner.nextLine())
                    print("\nCEP: ")
                    valorParaObjeto.add(scanner.nextLine())
                }

                print("\nDescricao: ")
                valorParaObjeto.add(scanner.nextLine())

                print("\nCompetencias: (Separe por ,)")
                valorParaObjeto.add(scanner.nextLine().split(',').collect(){it.trim()})

                if(modoUsuario == 3){
                    print("\nEmpresa: ")
                    valorParaObjeto.add(scanner.nextLine())
                }

                valorParaObjeto.eachWithIndex{ valor, index ->
                    println("[$index] $valor (${valor?.class?.simpleName})")
                }

                if(modoUsuario == 1) {
                    try {
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
                        db.insertUsuario(adicionandoCandidato)
                    } catch (Exception e) {
                        println "Erro: ${e.message}"
                    }
                }
                else if(modoUsuario == 2){
                    try{
                        def adicionandoEmpresa = new Juridica(
                                valorParaObjeto[0] as String,
                                valorParaObjeto[1] as String,
                                valorParaObjeto[2] as String,
                                valorParaObjeto[3] as String,
                                valorParaObjeto[4] as String,
                                valorParaObjeto[5] as String,
                                valorParaObjeto[6] as String,
                                valorParaObjeto[7] as List<String>
                        )
                        db.insertEmpresa(adicionandoEmpresa)
                    }catch(Exception e){
                        println "Erro: ${e.message}"
                    }
                }
                else if(modoUsuario == 3){
                    try{
                        def adicionandoVaga = new Vaga(
                                valorParaObjeto[0] as String,
                                valorParaObjeto[1] as String,
                                valorParaObjeto[2] as List<String>,
                                valorParaObjeto[3] as int
                        )
                        db.insertVaga(adicionandoVaga)
                    }catch(Exception e){
                        println "Erro: ${e.message}"
                    }
                }


                break;
            case 2:
                if(modoUsuario == 1){
                    db.selectUsuario()
                }else if(modoUsuario == 2){
                    db.selectEmpresa()
                }else if(modoUsuario == 3){
                    db.selectVaga()
                }else{
                    println "Opcao invalida!!"
                }
                break;
            case 3:
                switch(modoUsuario){
                    case 1: // Atualizar Candidato
                        int idUsuario = -1
                        while(true){
                            db.selectUsuario()
                            println("\nDigite o ID do usuário que deseja atualizar (ou 0 para voltar):")
                            idUsuario = scanner.nextInt()
                            scanner.nextLine() //

                            if(idUsuario == 0) break

                            def novosDados = []
                            println("\nDigite os novos dados (deixe em branco para manter o valor atual):")

                            print("Nome: ")
                            novosDados[0] = scanner.nextLine()

                            print("Data de Nascimento (DD/MM/AAAA): ")
                            novosDados[1] = scanner.nextLine()

                            print("Email: ")
                            novosDados[2] = scanner.nextLine()

                            print("CPF: ")
                            novosDados[3] = scanner.nextLine()

                            print("País: ")
                            novosDados[4] = scanner.nextLine()

                            print("Estado: ")
                            novosDados[5] = scanner.nextLine()

                            print("CEP: ")
                            novosDados[6] = scanner.nextLine()

                            print("Descrição: ")
                            novosDados[7] = scanner.nextLine()

                            def candidatoAtualizado = new Candidato(
                                    novosDados[0],
                                    novosDados[1],
                                    novosDados[2],
                                    novosDados[3],
                                    novosDados[4],
                                    novosDados[5],
                                    novosDados[6],
                                    novosDados[7],
                                    []
                            )

                            boolean sucesso = db.updateUsuario(candidatoAtualizado, idUsuario)

                            if(sucesso) {
                                println("\nUsuário atualizado com sucesso!")
                            } else {
                                println("\nErro ao atualizar o usuário. Verifique se o ID é válido.")
                            }

                            println("\nPressione Enter para continuar...")
                            scanner.nextLine()
                        }
                        break;
                    case 2:
                        int idEmpresa = -1
                        while(true){
                            db.selectEmpresa()
                            println("\nDigite o ID do empresa que deseja atualizar (ou 0 para voltar):")
                            idEmpresa = scanner.nextInt()
                            scanner.nextLine() //

                            if(idEmpresa == 0) break

                            def novosDados = []
                            println("\nDigite os novos dados (deixe em branco para manter o valor atual):")

                            print("Nome: ")
                            novosDados[0] = scanner.nextLine()

                            print("Email: ")
                            novosDados[1] = scanner.nextLine()

                            print("CPF: ")
                            novosDados[2] = scanner.nextLine()

                            print("País: ")
                            novosDados[3] = scanner.nextLine()

                            print("Estado: ")
                            novosDados[4] = scanner.nextLine()

                            print("CEP: ")
                            novosDados[5] = scanner.nextLine()

                            print("Descrição: ")
                            novosDados[6] = scanner.nextLine()


                            def candidatoAtualizado = new Candidato(
                                    novosDados[0],
                                    novosDados[1],
                                    novosDados[2],
                                    novosDados[3],
                                    novosDados[4],
                                    novosDados[5],
                                    novosDados[6],
                                    []
                            )

                            boolean sucesso = db.updateEmpresa(candidatoAtualizado, idEmpresa)

                            if(sucesso) {
                                println("\nUsuário atualizado com sucesso!")
                            } else {
                                println("\nErro ao atualizar o usuário. Verifique se o ID é válido.")
                            }

                            println("\nPressione Enter para continuar...")
                            scanner.nextLine()
                        }
                        break;
                    case 3:
                        int idVaga = -1
                        while(true){
                            db.selectVaga()
                            println("\nDigite o ID do vaga que deseja atualizar (ou 0 para voltar):")
                            idVaga = scanner.nextInt()
                            scanner.nextLine() //

                            if(idVaga == 0) break

                            def novosDados = []
                            println("\nDigite os novos dados (deixe em branco para manter o valor atual):")

                            print("Nome: ")
                            novosDados[0] = scanner.nextLine()

                            print("Descrição: ")
                            novosDados[6] = scanner.nextLine()


                            def vagaAtualizada = new Candidato(
                                    novosDados[0],
                                    novosDados[1],
                                    novosDados[2],
                                    []
                            )

                            boolean sucesso = db.updateVaga(vagaAtualizada, idVaga)

                            if(sucesso) {
                                println("\nUsuário atualizado com sucesso!")
                            } else {
                                println("\nErro ao atualizar o usuário. Verifique se o ID é válido.")
                            }

                            println("\nPressione Enter para continuar...")
                            scanner.nextLine()
                        }
                        break;
                    default:
                        println("Opção inválida!!!")
                        break;
                }
                break;
            case 4:
                switch(modoUsuario){
                    case 1:
                        db.selectUsuario()

                        int idUsuario = -1

                        println("Digite o ID do usuário que deseja deletar (ou 0 para voltar): ");
                        idUsuario = scanner.nextInt();

                        db.deleteUsuario(idUsuario)
                        break;
                    case 2:
                        db.selectEmpresa();

                        int idEmpresa = -1

                        println("Digite o ID do usuário que deseja deletar (ou 0 para voltar): ");
                        idEmpresa = scanner.nextInt();

                        db.deleteEmpresa(idEmpresa)
                        break;
                    case 3:
                        db.selectVaga();

                        int idVaga = -1

                        println("Digite o ID do usuário que deseja deletar (ou 0 para voltar): ");
                        idVaga = scanner.nextInt();

                        db.deleteVaga(idVaga)
                        break;
                    default:
                        println("Opção inválida!!!")
                        break;
                }
                break;
            case 5:
                println "Deslogando..."
                break;
            case 6:
                println("Trocando o modo de visualizaCão...")
                modoUsuario = 0
                break;
            default:
                println("Opção inválida! Tente novamente.")
                break;
        }

    }
}