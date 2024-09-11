package com.act.steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Checkout {
    public Checkout() {}

    private WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Dado("que faço o login com {string} e {string}")
    public void queFacoLogin(String usuario, String senha) {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys(usuario);
        driver.findElement(By.id("password")).sendKeys(senha);
        driver.findElement(By.id("login-button")).click();
    }

    @Quando("ordeno os itens em ordem descrescente")
    public void ordenoItensDescrescente() {
        WebElement comboBox = driver.findElement(By.cssSelector("select[data-test='product-sort-container']"));
        Select select = new Select(comboBox);
        select.selectByVisibleText("Name (Z to A)");
    }

    @Entao("o primeiro produto é o {string}")
    public void primeiroProduto(String produto) {
        assertEquals(produto, driver.findElement(By.cssSelector(".inventory_item_name")).getText());
    }

    @Dado("adiciono o {string} no carrinho")
    public void adicionoProdutoCarrinho(String produto) {
        driver.findElement(By.xpath("//div[text()='" + produto + "']/../../../div[2]/button")).click();
    }

    @Dado("o {string} está na lista de compra")
    public void produtoEstaNaListaCompra(String produto) {
        driver.findElement(By.id("shopping_cart_container")).click();
        assertEquals("Your Cart", driver.findElement(By.cssSelector(".title")).getText());
        assertEquals(produto, driver.findElement(By.cssSelector(".inventory_item_name")).getText());
    }

    @Dado("finalizo o preenchimento do destinatário")
    public void finalizoPreenchimentoDestinatario() {
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Palloma");
        driver.findElement(By.id("last-name")).sendKeys("Lima");
        driver.findElement(By.id("postal-code")).sendKeys("12345987");
        driver.findElement(By.id("continue")).click();
    }

    @Dado("finalizo o checkout")
    public void finalizoCheckout() {
        driver.findElement(By.id("finish")).click();
    }

    @Dado("a mensagem de checkout com sucesso é exibida")
    public void mensagemCheckoutSucesso() {
        assertEquals("Thank you for your order!", driver.findElement(By.cssSelector("h2")).getText());
    }

    @Dado("a mensagem de erro é exibida")
    public void mensagemCheckoutErro() {
        assertEquals("Error: Last Name is required", driver.findElement(By.cssSelector("h3")).getText());
    }


}
