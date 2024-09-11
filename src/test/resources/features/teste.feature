# encoding: iso-8859-1
# language: pt

@Checkout
Funcionalidade: Checkout

  @Sucesso
  Cenario: Realizar o checkout após ordernar a lista de produtos
    Dado que faço o login com "performance_glitch_user" e "secret_sauce"
    Quando ordeno os itens em ordem descrescente
    Entao o primeiro produto é o "Test.allTheThings() T-Shirt (Red)"
    Quando adiciono o "Test.allTheThings() T-Shirt (Red)" no carrinho
    Entao o "Test.allTheThings() T-Shirt (Red)" está na lista de compra
    Quando finalizo o preenchimento do destinatário
    E finalizo o checkout
    Entao a mensagem de checkout com sucesso é exibida

  @Error
  Cenario: Não deve realizar o checkout com erro
    Dado que faço o login com "problem_user" e "secret_sauce"
    Quando adiciono o "Sauce Labs Backpack" no carrinho
    Entao o "Sauce Labs Backpack" está na lista de compra
    Quando finalizo o preenchimento do destinatário
    Entao a mensagem de erro é exibida

  @Sucesso
  Cenario: Realizar o cadastro no site
    Dado que eu entro no site do Sauce demo
    Quando clico no botão cadastrar
    Entao Irá abrir uma pagina de cadastro
