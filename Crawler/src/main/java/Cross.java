package main.java;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class Cross {

    public static WebDriver webDiver;
    public static String strXpath;
    public static  WebElement searchBox;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\usuario\\IdeaProjects\\Crawler\\lib\\chromedriver.exe");


        ChromeOptions options = new ChromeOptions();

        HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>();
        options.addArguments("test-type");
        options.addArguments("start-maximized");
        options.addArguments("--js-flags=--expose-gc");
        options.addArguments("--enable-precise-memory-info");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        options.addArguments("test-type=browser");
        options.addArguments("disable-infobars");
        options.addArguments("--disable-extensions"); // to disable browser extension popup

        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);

        webDiver = new ChromeDriver(cap);
        webDiver.get("https://as1.trt3.jus.br/juris/consultaBaseCompleta.htm");
        //webDiver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        searchBox = webDiver.findElement(By.id("campo:buscaTextualTodasPalavras"));
        searchBox.sendKeys("assédio");
       // Thread.sleep(4000);
        searchBox = webDiver.findElement(By.id("campo:buscaTextualExpressao"));
        searchBox.sendKeys("moral");
       // Thread.sleep(4000);
        searchBox = webDiver.findElement(By.id("campo:buscaTextualQualquer"));
        searchBox.sendKeys("mulher");
        //Thread.sleep(4000);
        searchBox = webDiver.findElement(By.id("campo:buscaTextualNenhuma"));
        searchBox.sendKeys(searchBox.getText());
        searchBox = webDiver.findElement(By.id("campo:verifyCaptcha"));
        searchBox.sendKeys(searchBox.getText());
        searchBox = webDiver.findElement(By.id("campo:pesquisar"));
        searchBox.sendKeys("não sei");
        //Thread.sleep(4000);
        searchBox.click();

        //searchBox.submit();



      /*  for (int i = 1; i <= 5; i++) {
            strXpath = "//a[@class='f1' and text()='" + i + "']";
            webDiver.findElement(By.xpath(strXpath)).click();
            Thread.sleep(4000);
        }*/
    }
}