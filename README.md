# aluno-api 
Api desenvolvida para Apresentação de um Teste.

# Resumo e Status 
A aplicação consiste em fazer uma API para fazer um cadastro de Alunos,
com as seguintes funcionalidades desenvolvidas:

- Buscar todos os alunos - OK
- Buscar um aluno - OK
- Cadastrar um aluno - OK
- Atualizar um aluno - OK
- Exluir um aluno - OK

# Tecnologias e frameworks utilizados

- Sprint Boot (STS)
  Desenvolvimento da Aplicação

- Maven
  Gerenciador de Pacotes

- H2 
  Banco de dados em memória

- JPA 
  Para a camada de persistencia

- Swagger  
  Para documentar a API

- Postman
  Para testes na API
 
- GIT
  Para controle de versão.

# Acesso ao Swagger
  http://localhost:8000/swagger-ui.html

# Explicação dos pacotes criados:

- br.com.jantorno.alunoapi:
  contem a classe de inicial para iniciar a execução do projeto.

- br.com.jantorno.alunoapi.config:
  contem a classe com a configuração do swagger.

- br.com.jantorno.alunoapi.domain:
  pacote que contem as classes de model da aplicação (Cliente, Produto).
 
- br.com.jantorno.alunoapi.handler:
  contem uma classe handler para lidar com exeptions.

- br.com.jantorno.alunoapi.repository:
  pacote que contem o padrão Repository para realizar a persistencia com o banco de dados.

- br.com.jantorno.alunoapi.resources:
  contem os controllers da aplicação, responsaveis pelo mapeamento dos recursos da API.

- br.com.jantorno.alunoapi.services:
  classes que contem a regra de negócio da aplicação

- br.com.jantorno.alunoapi.services.exceptions:
  classes de exceptions.

# Exemplos de Endpoints da API

- GET - http://localhost:8000/aluno
  Retorna uma lista com informações de todos os alunos

- GET - http://localhost::8000/aluno/1
  Retorna informações do aluno de código 1

- POST - http://localhost:8000/aluno
  Inclui um Aluno

- PUT - http://localhost:8000/aluno/1
  Atualiza dados do aluno de código 1.

- DELETE - http://localhost:8000/aluno/1
  Exclui o aluno de código 3
