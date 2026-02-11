## 📚 Sistema Escolar com JDBC 

### 📌 Descrição do Projeto

Este projeto consiste em um **Sistema Escolar desenvolvido em Java**, utilizando **JDBC** para conexão com banco de dados **MySQL**.
O projeto evoluiu de um simples cadastro para um CRUD completo, servindo como base para aplicar os seguintes conceitos:

* Programação orientada a objetos (POO)
* Persistência de dados com JDBC
* Uso de DAO (Data Access Object)
* Integração com banco de dados relacional
* Estruturação de projetos com Maven

---

## ⚙️ Funcionalidades (CRUD Completo)

O sistema realiza as quatro operações básicas (Create, Read, Update, Delete) para as seguintes entidades:

### 👨‍🎓 Gerenciamento de Alunos
Cadastrar: Registro de novos alunos associados a uma turma.

Listar: Consulta de todos os alunos no banco de dados.

Atualizar: Edição de informações de alunos existentes.

Excluir: Remoção de alunos com validação de ID.

### 🏫 Gerenciamento de Turmas
Cadastrar: Criação de novas turmas com nome e período.

Listar: Visualização de todas as turmas disponíveis.

Atualizar: Modificação de dados das turmas.

Excluir: Remoção de turmas do sistema.

### 💡 Destaque: Implementado tratamento para IDs inexistentes. Se o usuário tentar modificar ou deletar um registro que não existe, o sistema emitirá um aviso amigável, evitando falhas silenciosas ou erros genéricos de SQL.

---

## 🛠️ Tecnologias Utilizadas

* **Java 21**
* **JDBC (Java Database Connectivity)**
* **MySQL**
* **Maven**
* **IntelliJ IDEA** (ou qualquer IDE Java)

---

## 📂 Estrutura do Projeto

```
src/
 └── main/
     └── java/
         └── org.example/
             ├── Main.java
             ├── aluno/
             │   └── Aluno.java
             ├── turma/
             │   └── Turma.java
             ├── dao/
             │   ├── AlunoDao.java
             │   └── TurmaDao.java
             └── conexao/
                 └── ConexaoBanco.java
```

---

## ⚙️ Funcionalidades

* 📌 Cadastro de Turmas (nome e período)
* 📌 Cadastro de Alunos
* 📌 Associação de alunos a uma turma
* 📌 Persistência dos dados em banco MySQL
* 📌 Menu interativo via terminal

---

## 🗄️ Banco de Dados

O sistema utiliza um banco MySQL chamado:

```
db_sistema_escolar
```

### Exemplo de tabelas:

```sql
CREATE TABLE turmas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_turma VARCHAR(100),
    periodo VARCHAR(20)
);

CREATE TABLE alunos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome_aluno VARCHAR(100),
    email VARCHAR(100),
    id_turma INT,
    FOREIGN KEY (id_turma) REFERENCES turmas(id)
);
```

---

## 🔌 Conexão com o Banco

A conexão é realizada através da classe `ConexaoBanco`, utilizando JDBC:

* URL: `jdbc:mysql://localhost:3306/db_sistema_escolar`
* Driver: `mysql-connector-j`
* Autenticação configurada no código (usuário e senha)

---

## ▶️ Como Executar o Projeto

1. Clone este repositório
2. Configure o banco de dados MySQL
3. Ajuste usuário e senha no arquivo `ConexaoBanco.java`
4. Execute a classe `Main`
5. Interaja com o sistema pelo terminal

---

## 🎯 Objetivo Educacional

Este projeto foi desenvolvido com fins **educacionais**, visando consolidar conhecimentos em:

* Java
* JDBC
* Banco de Dados
* Boas práticas de organização de código

---

## Demonstração do Projeto

![Sistema Escolar com JDBC](https://github.com/user-attachments/assets/65294a9e-5802-47fe-a780-15d6e2532257)

---
:octocat:   SOBRE A DESENVOLVEDORA  

![Isabela Marques](https://github.com/user-attachments/assets/76a8e0d4-8a08-45cd-9e9b-18f70cc0122c)

🎓 Isabela Cavalcante Marques  

<p align="left">
  <a href="https://www.linkedin.com/in/isabela-cavalcante-marques-9a91863a8" target="_blank">
    <img src="https://img.shields.io/badge/-LinkedIn-blue?style=flat-square&logo=Linkedin&logoColor=white" alt="LinkedIn">
  </a>
</p>
