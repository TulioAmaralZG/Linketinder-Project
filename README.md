# 🚀 Linketinder - Plataforma de Conexão Profissional

Sistema desenvolvido em Groovy para conectar candidatos a oportunidades de emprego em empresas, com funcionalidades completas de CRUD e gerenciamento de vagas.

## 🌟 Funcionalidades

- **Cadastro e Gerenciamento de Candidatos**
  - Cadastro de informações pessoais e profissionais
  - Atualização de dados
  - Exclusão de cadastro
  - Listagem de candidatos

- **Cadastro e Gerenciamento de Empresas**
  - Cadastro de dados cadastrais
  - Atualização de informações
  - Exclusão de cadastro
  - Listagem de empresas

- **Gerenciamento de Vagas**
  - Cadastro de vagas com descrição e competências necessárias
  - Atualização de vagas
  - Exclusão de vagas
  - Listagem de vagas disponíveis

- **Funcionalidades de Match**
  - Sistema de curtidas entre candidatos e vagas
  - Visualização de matches

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: Groovy
- **Banco de Dados**: PostgreSQL
- **Gerenciamento de Dependências**: Gradle
- **Interface**: Linha de Comando (CLI)

## 🏗️ Estrutura do Projeto

```
Linketinder-Project/
├── src/
│   ├── Candidato.groovy      # Classe de modelo para candidatos
│   ├── DataBase.groovy       # Classe de conexão e operações no banco de dados
│   ├── Judirica.groovy       # Classe de modelo para empresas (pessoas jurídicas)
│   ├── Main.groovy           # Ponto de entrada da aplicação
│   └── Vaga.groovy           # Classe de modelo para vagas
├── frontend/                 # Frontend da aplicação (em desenvolvimento)
└── lib/                      # Dependências do projeto
```

## 🗄️ Estrutura do Banco de Dados

O banco de dados PostgreSQL é composto pelas seguintes tabelas:

- `usuarios`: Armazena informações dos candidatos
- `empresas`: Armazena informações das empresas
- `vagas`: Armazena as vagas de emprego
- `competencias`: Armazena as competências disponíveis
- `usuarios_competencias`: Relaciona usuários com suas competências
- `vagas_competencias`: Relaciona vagas com as competências necessárias
- `curtida_match`: Gerencia os matches entre candidatos e vagas

## 🚀 Como Executar

### Pré-requisitos

- Java JDK 8 ou superior
- PostgreSQL 10 ou superior
- Groovy 3.0 ou superior
- Conta de banco de dados PostgreSQL com permissões para criar bancos e tabelas

### Configuração Inicial

1. Clone o repositório:
   ```bash
   git clone https://github.com/TulioAmaralZG/Linketinder-Project.git
   cd Linketinder-Project
   ```

2. Configure o banco de dados:
   - Crie um banco de dados chamado `linketinder` no PostgreSQL
   - Atualize as credenciais de acesso no arquivo `DataBase.groovy`

3. Execute o script de inicialização do banco de dados (as tabelas são criadas automaticamente na primeira execução)

### Executando a Aplicação

```bash
groovy src/Main.groovy
```

## 📝 Menu Principal

1. **Criar** - Adiciona um novo registro (candidato, empresa ou vaga)
2. **Listar** - Lista registros existentes
3. **Atualizar** - Atualiza um registro existente
4. **Deletar** - Remove um registro
5. **Sair** - Encerra a aplicação

## 🤝 Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e enviar pull requests.

## 📄 Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

## ✨ Desenvolvedor

- **Túlio Amaral** - [GitHub](https://github.com/TulioAmaralZG)
