# Projeto Java Web Spring Boot e Spring AI com OpenAI
O projeto <b>Spring AI</b> incorpora recursos e funcionalidade de Inteligência Artificial no desenvolvimento de aplicações Java de forma simples e rápida.
O projeto <b>Spring AI</b> traz suporte para integração com os principais modelos de IA do mercado como o <b>OpenAI ChatGPT</b>, <b>Azure OpenAI</b>, <b>Amazon Bedrock</b>, <b>GoogleAI Gemini</b>, <b>Ollama</b>, <b>MistralAI</b> que icluem API's para chat, geração de imagem, incorporação, suporte para API síncrona e assíncrona, além de API Chat Completion que unifica a comunicação com modelos de IA disponíveis.

# Sumário
- [Arquitetura básica da aplicação](#arquitetura-básica-da-aplicação)
- [Pré-requisitos](#pré-requisitos)
- [Configurar o projeto](#configurar-o-projeto)
- [Desenvolvimento da aplicação](#desenvolvimento-da-aplicação)
- [Instalação](#Instalação)
- [Endpoints](#Endpoints)

# Arquitetura básica da aplicação

Essa aplicação ilustra a criação de uma <b>Bookstore Assistant AI</b> utilizando <b>Spring Boot</b> e <b>Spring AI</b> fazendo a integração através da plataforma <b>OpenAI</b> conforme ilustrado abaixo. 
![Bookstore Assistant AI](https://github.com/heliohdd/bookstore-assistant-ai/assets/54555214/eeba24fb-b200-4563-a9a2-371294dc7ee5)


# Pré-requisitos
1. Ter uma conta na plataforma [OpenAI](https://platform.openai.com/api-keys).
2. Criar uma "secret key" no campo `API keys`.
3. Inserir a secret key no parâmetro <b>spring.ai.openai.pai-key</b> no arquivo <b>aplication.properties</b> pelo `STS`.

# Configurar o projeto
- Criar projeto Maven usando [Spring Initializr](https://start.spring.io/) e importar no STS.

- Selecionar as dependências para `Spring Web` e `OpenAI` selecionando `Java 21` e o `Maven` como gerenciador de dependências.

- Sugestão: acrescentar no .gitignore:

```yml
.vscode
.metadata
.mvn

mvnw
mvnw.cmd
```
# Desenvolvimento da aplicação
- Criar os endpoints `/informations`, `/reviews` e `/stream/informations` na uri `/bookstore` no arquivo `BookstoreAssistantController` conforme disponível no repositório deste projeto em [Bookstore Assistant AI](https://github.com/heliohdd/bookstore-assistant-ai).
# Instalação
- Clonar repositório `git@github.com:heliohdd/bookstore-assistant-ai.git`
- Fazer o build do projeto `./mvnw clean package`
- Subir a aplicação `java -jar /target/bookstore-assistant-ai-0.0.1-SNAPSHOT.jar`
- Conferir o resultado da API usando o `Postman` em `http://localhost:8080` com os endpoints abaixo
# Endpoints

| HTTP Verb | Endpoint                       | Ação                                                                       |
| --------- | ------------------------------ | -------------------------------------------------------------------------- |
| GET       | /bookstore/informations        | Recebe informação geral sobre algum livro na forma de String               |
| GET       | /bookstore/reviews             | Recebe resumo de um livro e biografia do autor na forma de Prompt Template |
| GET       | /bookstore/stream/informations | Recebe informação geral sobre algum livro na forma assíncrona WebFlux      |
