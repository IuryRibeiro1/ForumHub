# 📚 ForumHub API

API REST desenvolvida em **Java** com **Spring Boot** para gerenciamento de tópicos e autores, incluindo autenticação JWT e controle de acesso com **Spring Security**.

---

## 🚀 Tecnologias Utilizadas

### **Java 17+**
- Linguagem principal do projeto.
- Utilizada para a construção da API e lógica de negócios.

### **Spring Boot**
- Framework que agiliza a criação de aplicações Java.
- Permite configurar o servidor embutido (Tomcat) e as dependências de forma simplificada.

### **Spring Data JPA**
- Facilita a persistência e consulta de dados no banco de dados usando **repositórios**.
- Converte entidades Java em tabelas no banco de dados de forma automática.

### **Hibernate**
- Implementação padrão da especificação **JPA**.
- Responsável pelo mapeamento objeto-relacional (ORM).

### **Spring Security**
- Implementa autenticação e autorização na aplicação.
- Garante que apenas usuários autenticados e autorizados acessem determinados endpoints.

### **JWT (JSON Web Token)**
- Protocolo de autenticação que gera tokens assinados.
- Após o login, o usuário recebe um token que deve ser enviado no header das requisições subsequentes.

### **Validation API (Jakarta Validation)**
- Valida automaticamente os dados recebidos em requisições usando anotações como `@NotNull`, `@NotBlank`, `@Email`.

### **Lombok**
- Reduz código boilerplate (getters, setters, construtores, etc.) com anotações como `@Getter`, `@AllArgsConstructor`, `@NoArgsConstructor`.

### **Banco de Dados**
- Pode ser utilizado **PostgreSQL** ou **MySQL** (dependendo da configuração do `application.properties`).
- Conexão gerenciada pelo Spring Boot via DataSource.

---

## 📂 Estrutura do Projeto



---

## 🔐 Autenticação JWT

1. **Login**
   - O usuário envia suas credenciais (`email` e `senha`) para o endpoint `/login`.
   - Se válidas, a API gera um **JWT Token** e retorna ao usuário.

2. **Acesso protegido**
   - O usuário deve enviar o token no **header**:
     ```
     Authorization: Bearer <token>
     ```
   - O Spring Security valida o token antes de processar a requisição.

---

## 📌 Funcionalidades

- **Cadastrar Autor**
- **Cadastrar Tópico**
- **Listar Tópicos**
- **Atualizar Tópico**
- **Excluir Tópico**
- **Autenticar Usuário via JWT**
- **Proteger Endpoints com Spring Security**

---

## ⚙️ Como Executar o Projeto

1. **Clonar o repositório**
   ```bash
   git clone https://github.com/seu-usuario/forumhub.git


#Requisições

POST /login
Content-Type: application/json

{
  "email": "usuario@email.com",
  "senha": "123456"
}

*** ***

POST /topicos
Authorization: Bearer <token>
Content-Type: application/json

{
  "titulo": "Dúvida sobre Spring Boot",
  "mensagem": "Como implementar autenticação JWT?",
  "autor": {
    "nome": "João",
    "email": "joao@email.com"
  },
  "curso": "Java"
}
