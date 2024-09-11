# Desafio ACT

Este é um projeto de testes automatizados utilizando Selenium + Cucumber em Java para validar o checkout de uma loja.

## Estrutura de Pastas

```
desafio-ACT
└───src
    └───test
        ├───java
        │   └───com.act
        │       └───steps
        └───resources
            └───feature

```

- A pasta `steps` contém as definições do que cada step faz.

- A pasta `feature` contém os testes escritos em gherkin.

## Configuração do Ambiente

O projeto utiliza o Selenium para automação de testes web. Para executar os testes, você precisa ter o JDK instalado.

Você pode fazer o download do JDK no seguinte link: [https://www.oracle.com/br/java/technologies/downloads/](https://sites.google.com/a/chromium.org/chromedriver/downloads)

### MVN
O projeto utiliza o Maven como gerenciador de dependências e para executar os testes.

## Dependências

O projeto utiliza o Gerenciador de Dependências MVN para gerenciar suas dependências. As dependências estão configuradas no arquivo `pom.xml` na raiz do projeto.

As principais dependências incluídas são:
- JUnit: Framework para escrever e executar testes unitários em Java.
- Selenium: Biblioteca para automação de testes web.
- Cucumber: Biblioteca para escrita de testes em gherkin