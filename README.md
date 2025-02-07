### Este projeto permite gerenciar as operações de aluguel e cadastro de livros de uma livraria. Ele foi projetado para ser simples, eficiente e modular, seguindo boas práticas de desenvolvimento.

# Tecnologias Utilizadas
- Java (versão 21.0.5)
- Spring Boot (versão 3.3.6)
- Banco de Dados (PostgreSQL)
- Maven

  

## Recursos
- CRUD de Livros: Permite criar, listar, atualizar e excluir livros.

- Documentação da API: Integrado com Swagger para documentação interativa.

## Serviços
| Método  | Rota            | Descrição                        |
|---------|----------------|----------------------------------|
| `GET`   | `/livraria-api/user`   | Listar todos os usuários         |
| `POST`  | `/livraria-api/user`   | Adicionar um usuário            |
| `PUT`   | `/livraria-api/user` | Alterar um usuário |
| `DELETE`   | `/livraria-api/user` | Deletar um usuário             |
|---------|----------------|----------------------------------|
| `GET`   | `/livraria-api/rent`   | Listar todos os alugueis         |
| `POST`  | `/livraria-api/rent`   | Adicionar um aluguel            |
| `PUT`   | `/livraria-api/rent` | Alterar um aluguel |
| `DELETE`   | `/livraria-api/rent` | Deletar um aluguel             |
|---------|----------------|----------------------------------|
| `GET`   | `/livraria-api/publisher`   | Listar todos os alugueis         |
| `POST`  | `/livraria-api/publisher`   | Adicionar um aluguel            |
| `PUT`   | `/livraria-api/publisher` | Alterar um aluguel |
| `DELETE`   | `/livraria-api/publisher` | Deletar um aluguel             |
|---------|----------------|----------------------------------|
| `GET`   | `/livraria-api/book`   | Listar todos os livros         |
| `POST`  | `/livraria-api/book`   | Adicionar um livro            |
| `PUT`   | `/livraria-api/book` | Alterar um livro |
| `DELETE`   | `/livraria-api/book` | Deletar um livro             |

## Requisitos para Executar o Projeto

- Java 21 instalado

- Maven instalado

- PostgreSQL configurado
