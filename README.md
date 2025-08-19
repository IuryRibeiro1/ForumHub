# 📚 ForumHub API

API REST desenvolvida em Java com Spring Boot para gerenciamento de tópicos e autores, incluindo autenticação JWT e controle de acesso com Spring Security.
Agora os tópicos são associados automaticamente ao usuário autenticado, sem necessidade de informar manualmente o autorId.**.

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

- Controller → Endpoints REST da API (ForumController, etc.)

- Entities → Entidades JPA (Topicos, Autor, Usuario, Resposta)

- Repository → Repositórios Spring Data (TopicosRepositorio, AutorRepositorio, UsuarioRepositorio)

- Security → Configuração de autenticação JWT e roles (ROLE_USER, ROLE_ADMIN)

- Dto → Classes de transferência de dados (DadosTopicos, DadosAutor, AtualizarTopico)

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

##Fluxo de criação de Tópicos
1. - Usuário loga via `/login` e recebe um token JWT
2. - Ao criar um tópico, o token é enviado no header
3. - No back-end, o ForumController:
   - Pega o login do usuário autenticado via:
     SecurityContextHolder.getContext().getAuthentication().getName()
   - Busca o `Usuário` pelo login no UsuarioRepositorio
   - Obtém o `Autor` vinculado a esse usuário
   - Associa o `Autor` ao novo `Topico`
   - Salva o tópico no banco com o `autor_id`  

## ⚙️ Como Executar o Projeto

1. **Clonar o repositório**
```bash
git clone https://github.com/seu-usuario/forumhub.git
```
2. ##Configurar banco de dados no `application.properties`

3. ##Realizar Login
```bash
POST /login
Content-Type: application/json

{
"login": "usuario123",
"senha": "123456"
}
```
4. ##Criar Tópico
```bash
POST /topico
Authorization: Bearer <token>
Content-Type: application/json

{
"titulo": "Dúvida sobre Spring Boot",
"mensagem": "Como implementar autenticação JWT?",
"curso": "Java"
}
```
5. ##Listar Tópicos
```bash
Authorization: Bearer <token>
GET /topico?page=0&size=10

Ou

Get/topico
```
6. ##Atualizar Tópico
```bash
Authorization: Bearer <token>

PUT/topico/{id}
{
"id" : 1,
"titulo" : "Importância do estudo",
"mensagem" : "Estudar faz bem para alma e espírito, além de engrandecer o ser humano como profissional e pessoa",
"curso" : "Análise e desenvolvimento de sistemas"
}
```

8. ##Excluir Tópico
```bash
Authorization: Bearer <token>
DELETE /topico/{id}


