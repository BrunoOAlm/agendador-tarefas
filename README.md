# 📦 Microsserviço - Agendador de Tarefas

Este projeto faz parte de um sistema distribuído de Agendador de Tarefas baseado em arquitetura de microsserviços.

Ele é responsável por uma funcionalidade específica dentro do domínio do sistema, atuando de forma independente e comunicando-se com outros serviços quando necessário.

---

## 📌 Sobre o projeto

Este microsserviço foi desenvolvido para compor o sistema de Agendador de Tarefas, seguindo princípios de separação de responsabilidades e escalabilidade.

Cada serviço do sistema possui uma responsabilidade bem definida, permitindo maior flexibilidade, manutenção e escalabilidade.

---

## 📌 Responsabilidades deste serviço

- Gerenciar regras de negócio específicas do domínio
- Persistência de dados relacionados ao seu contexto
- Expor APIs REST para consumo do BFF ou outros serviços
- Garantir independência em relação aos demais microsserviços

---

## 📌 Arquitetura do sistema

Este microsserviço faz parte da arquitetura distribuída:

Frontend → BFF → Microsserviços

---

## 📌 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Gradle
- Docker 
- Git / GitHub

- ## 📌 Estrutura do projeto


controller/
service/
client (Feign Clients)
config/
dto/


---

## 📌 Objetivo do projeto

Este projeto foi desenvolvido para praticar arquitetura de sistemas distribuídos, utilizando o padrão BFF para melhorar a organização e comunicação entre frontend e microsserviços.

---

## 📌 Aprendizados

- Arquitetura BFF (Backend For Frontend)
- Comunicação entre microsserviços
- Organização de sistemas distribuídos
- Uso de OpenFeign
- Separação de responsabilidades
- Estruturação de backend escalável


## 📌 Autor

Desenvolvido por Bruno Almeida  
Projeto de estudo focado em arquitetura de backend e microsserviços

