package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;


public class TestesTriangulo {


    @BeforeClass
    public static void setUpTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\dev\\drivers\\chromedriver.exe.");

    }

    //Metodo testa se os valores inseridos formam um triangulo equilatero corretamente
    @Test
    public void VerificarTrianguloEquilatero() {
        WebDriver navegador = new ChromeDriver();
        navegador.get("http://www.vanilton.net/triangulo/");
        navegador.findElement(By.name("V1")).sendKeys("10");
        navegador.findElement(By.name("V2")).sendKeys("10");
        navegador.findElement(By.name("V3")).sendKeys("10");
        navegador.findElement(By.name("V3")).sendKeys(Keys.ENTER);
        String verifica = navegador.findElement(By.cssSelector("body > div:nth-child(7)")).getText();
        assertEquals("Equilátero", verifica);
        navegador.quit();
    }

    //Metodo testa se os valores inseridos formam um triangulo isosceles corretamente
    @Test
    public void VerificarTrianguloIsosceles() {
        WebDriver navegador = new ChromeDriver();
        navegador.get("http://www.vanilton.net/triangulo/");
        navegador.findElement(By.name("V1")).sendKeys("10");
        navegador.findElement(By.name("V2")).sendKeys("10");
        navegador.findElement(By.name("V3")).sendKeys("20");
        navegador.findElement(By.name("V3")).sendKeys(Keys.ENTER);
        String verifica = navegador.findElement(By.cssSelector("body > div:nth-child(7)")).getText();

        assertEquals("Isósceles", verifica);
        navegador.quit();

    }

    //Metodo testa se os valores inseridos formam um triangulo escaleno corretamente
    @Test
    public void VerificarTrianguloEscaleno() {
        WebDriver navegador = new ChromeDriver();
        navegador.get("http://www.vanilton.net/triangulo/");
        navegador.findElement(By.name("V1")).sendKeys("10");
        navegador.findElement(By.name("V2")).sendKeys("5");
        navegador.findElement(By.name("V3")).sendKeys("25");
        navegador.findElement(By.name("V3")).sendKeys(Keys.ENTER);
        String verifica = navegador.findElement(By.cssSelector("body > div:nth-child(7)")).getText();
        assertEquals("Escaleno", verifica);
        navegador.quit();

    }

    //Metodo testa se os valores inseridos trazem a imagem correta do triangulo
    @Test
    public void VerificarImagemTrianguloEscaleno() {
        WebDriver navegador = new ChromeDriver();

        navegador.get("http://www.vanilton.net/triangulo/");

        navegador.findElement(By.name("V1")).sendKeys("10");
        navegador.findElement(By.name("V2")).sendKeys("5");
        navegador.findElement(By.name("V3")).sendKeys("25");
        navegador.findElement(By.name("V3")).sendKeys(Keys.ENTER);
        WebElement element = navegador.findElement(By.tagName("img"));
        String imageSrc = element.getAttribute("src");
        assertEquals("http://www.vanilton.net/triangulo/escaleno.png", imageSrc);
        navegador.quit();
 }

    //Metodo testa se os valores inseridos trazem a imagem correta do triangulo
    @Test
    public void VerificarImagemTrianguloIsosceles() {
        WebDriver navegador = new ChromeDriver();

        navegador.get("http://www.vanilton.net/triangulo/");

        navegador.findElement(By.name("V1")).sendKeys("10");
        navegador.findElement(By.name("V2")).sendKeys("10");
        navegador.findElement(By.name("V3")).sendKeys("20");
        navegador.findElement(By.name("V3")).sendKeys(Keys.ENTER);
        WebElement element = navegador.findElement(By.tagName("img"));
        String imageSrc = element.getAttribute("src");
        assertEquals("http://www.vanilton.net/triangulo/isosceles.png", imageSrc);
        navegador.quit();
    }

    //Metodo testa se os valores inseridos trazem a imagem correta do triangulo
    @Test
    public void VerificarImagemTrianguloEquilatero() {
        WebDriver navegador = new ChromeDriver();
        navegador.get("http://www.vanilton.net/triangulo/");
        navegador.findElement(By.name("V1")).sendKeys("10");
        navegador.findElement(By.name("V2")).sendKeys("10");
        navegador.findElement(By.name("V3")).sendKeys("10");
        navegador.findElement(By.name("V3")).sendKeys(Keys.ENTER);
        WebElement element = navegador.findElement(By.tagName("img"));
        String imageSrc = element.getAttribute("src");
        assertEquals("http://www.vanilton.net/triangulo/equilatero.png", imageSrc);
        navegador.quit();
    }

    //Metodo testa se os valores inseridos possuem valor 0
    //não há mensagem de erro para campos com valores nulos
    @Test
    public void VerificarCampoComValorZero() {
        WebDriver navegador = new ChromeDriver();
        navegador.get("http://www.vanilton.net/triangulo/");
        navegador.findElement(By.name("V1")).sendKeys("10");
        navegador.findElement(By.name("V2")).sendKeys("0");
        navegador.findElement(By.name("V3")).sendKeys("10");
        navegador.findElement(By.name("V3")).sendKeys(Keys.ENTER);
        WebElement verifica = navegador.findElement(By.tagName("img"));
            if(verifica.isDisplayed()){
                fail("Campo com valor 0 não deveria ser aceito");
            }
        navegador.quit();
    }

    //Metodo testa se os valores inseridos possuem valor negativos
    //não há mensagem de erro para campos com valores nagativos

    @Test
    public void VerificarCampoComValorNegativo() {
        WebDriver navegador = new ChromeDriver();

        navegador.get("http://www.vanilton.net/triangulo/");

        navegador.findElement(By.name("V1")).sendKeys("10");
        navegador.findElement(By.name("V2")).sendKeys("10");
        navegador.findElement(By.name("V3")).sendKeys("-10");
        navegador.findElement(By.name("V3")).sendKeys(Keys.ENTER);
        WebElement verifica = navegador.findElement(By.tagName("img"));
        if(verifica.isDisplayed()){
            fail("Campo com valor negativo não deveria ser aceito");
        }
        navegador.quit();
    }

    //Metodo testa se os valores inseridos satisfazem a condição para formar um triangulo
    @Test
    public void VerificarDesigualdadeTriangular() {
        WebDriver navegador = new ChromeDriver();

        navegador.get("http://www.vanilton.net/triangulo/");

        navegador.findElement(By.name("V1")).sendKeys("5");
        navegador.findElement(By.name("V2")).sendKeys("2");
        navegador.findElement(By.name("V3")).sendKeys("1");
        navegador.findElement(By.name("V3")).sendKeys(Keys.ENTER);
        WebElement verifica = navegador.findElement(By.tagName("img"));
        if(verifica.isDisplayed()){
            fail("Não é possível formar um triângulo, nenhuma imagem deveria ser mostrada");
        }
        navegador.quit();
    }

    //Metodo testa se os valores inseridos possuem campo vazio
    //não há mensagem de erro para campos vazios
    @Test
    public void VerificarCampoVazio() {
        /*WebDriver navegador = new ChromeDriver();

        navegador.get("http://www.vanilton.net/triangulo/");

        navegador.findElement(By.name("V1")).sendKeys("10");
        navegador.findElement(By.name("V2")).sendKeys("");
        navegador.findElement(By.name("V3")).sendKeys("");
        navegador.findElement(By.name("V3")).sendKeys(Keys.ENTER);
        navegador.quit();*/
    }




}
