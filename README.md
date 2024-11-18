# Sistema de Gerenciamento de Frota

Sistema web para gerenciamento de frota de veículos, desenvolvido em Java com Spring Boot.

## Funcionalidades

- Cadastro e gestão de motoristas
- Cadastro e gestão de veículos (elétricos e combustão)
- Registro e acompanhamento de viagens
- Relatórios de consumo e desempenho
- API REST documentada com Swagger
- Interface web responsiva com Bootstrap

## Tecnologias

- Java 21
- Spring Boot 3.3
- Spring Data JPA
- H2 Database
- JSP + JSTL
- Bootstrap 5
- Maven

## Estrutura do Projeto

- `model/domain`: Entidades do domínio (Driver, Vehicle, Trip etc)
- `model/repository`: Interfaces de repositório Spring Data
- `model/service`: Camada de serviços
- `controller`: Controllers REST e MVC
- `webapp/WEB-INF/jsp`: Views JSP

## Executando o Projeto

1. Clone o repositório
2. Execute: `mvn spring-boot:run`
3. Acesse: `http://localhost:8080`

## API REST

A API REST está disponível em `/api` com endpoints para:

- `/api/drivers`: Gestão de motoristas
- `/api/vehicles`: Gestão de veículos
- `/api/trips`: Gestão de viagens

Documentação completa disponível via Swagger UI.

## Carregamento Inicial

O sistema possui um carregador automático (`Loader.java`) que popula o banco de dados com dados iniciais de:

- Motoristas
- Veículos elétricos
- Veículos a combustão
- Viagens

## Autor

Paulo Weber
