# Sistema de Gerenciamento de Candidatos e Empresas

Sistema desenvolvido em Groovy para gerenciamento de candidatos e empresas, permitindo o cadastro e listagem de informações de forma organizada.

## 🚀 Funcionalidades

- Cadastro de candidatos com informações pessoais e profissionais
- Cadastro de empresas (pessoas jurídicas)
- Listagem de candidatos cadastrados
- Listagem de empresas cadastradas
- Interface de linha de comando (CLI) interativa

## 📋 Estrutura do Projeto

O projeto é composto pelos seguintes arquivos principais:

- `Main.groovy` - Ponto de entrada da aplicação, contendo o menu principal
- `Pessoa.groovy` - Interface base para pessoas (físicas e jurídicas)
- `Candidato.groovy` - Implementação de pessoa física (candidato)
- `Judirica.groovy` - Implementação de pessoa jurídica (empresa)

## 🛠️ Como Executar

1. Certifique-se de ter o Groovy instalado em sua máquina
2. Navegue até o diretório do projeto
3. Execute o comando:
   ```
   groovy src/Main.groovy
   ```

## 📝 Menu de Opções

1. **Adicionar Usuário** - Cadastra um novo candidato
2. **Adicionar Empresa** - Cadastra uma nova empresa
3. **Listar Empresas** - Exibe todas as empresas cadastradas
4. **Listar Usuários** - Exibe todos os candidatos cadastrados
5. **Sair** - Encerra a aplicação

## 📋 Estrutura de Dados

### Candidato (Pessoa Física)
- Nome
- Data de Nascimento
- E-mail
- CPF
- País
- Estado
- CEP
- Descrição
- Lista de competências

### Empresa (Pessoa Jurídica)
- Nome
- E-mail Corporativo
- CNPJ
- País
- Estado
- CEP
- Descrição
- Lista de competências/áreas de atuação

## 🧑‍💻 Desenvolvedor

- **Nome:** Tulio Fernandes Amaral
- **Email:** [Seu email]
- **GitHub:** [Seu perfil do GitHub]

## 📄 Licença

Este projeto está sob a licença [MIT](LICENSE).
