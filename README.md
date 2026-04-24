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

