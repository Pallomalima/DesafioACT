# encoding: iso-8859-1
# language: pt

@Checkout
Funcionalidade: Checkout

  @Sucesso
  Cenario: Realizar o checkout ap�s ordernar a lista de produtos
    Dado que fa�o o login com "performance_glitch_user" e "secret_sauce"
    Quando ordeno os itens em ordem descrescente
    Entao o primeiro produto � o "Test.allTheThings() T-Shirt (Red)"
    Quando adiciono o "Test.allTheThings() T-Shirt (Red)" no carrinho
    Entao o "Test.allTheThings() T-Shirt (Red)" est� na lista de compra
    Quando finalizo o preenchimento do destinat�rio
    E finalizo o checkout
    Entao a mensagem de checkout com sucesso � exibida

  @Error
  Cenario: N�o deve realizar o checkout com erro
    Dado que fa�o o login com "problem_user" e "secret_sauce"
    Quando adiciono o "Sauce Labs Backpack" no carrinho
    Entao o "Sauce Labs Backpack" est� na lista de compra
    Quando finalizo o preenchimento do destinat�rio
    Entao a mensagem de erro � exibida

  @Sucesso
  Cenario: Realizar o cadastro no site
    Dado que eu entro no site do Sauce demo
    Quando clico no bot�o cadastrar
    Entao Ir� abrir uma pagina de cadastro
