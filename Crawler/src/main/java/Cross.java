package main.java;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import SeleniumBrowser.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;


public class Cross {


    public static WebElement searchBox;
    private static List<String> listUrls;

    public static void main(String[] args) {
        JusBrasilModern();
    }

    private static void JusBrasilModern() {
        WebDriver webDiver = new Browser().chromeDriver();
        try {
            webDiver.get("https://www.jusbrasil.com.br/jurisprudencia/busca?q=assédio+2017");

           // if (webDiver.findElements(By.className("content-body chrome-67 windows")).i)
           //     webDiver.get("https://www.jusbrasil.com.br/jurisprudencia/busca?q=assédio+2017");

            WebElement select = webDiver.findElement(By.className("SearchResults-documents"));
            List<WebElement> opt = select.findElements(By.tagName("div"));
            listUrls = new ArrayList<String>();
            for (WebElement option : opt) {
                searchBox = option.findElement(By.className("BaseSnippetWrapper-title"));
                //searchBox = searchBox.findElement(By.tagName("a"));
                //listUrls.add(searchBox.getAttribute("href"));
                listUrls.add(searchBox.getText());
            }

            webDiver.close();

        } catch (Exception e) {
            webDiver.close();
            System.out.print(e.getMessage());
        }
    }

    private static void JusBrasilOld() {
        WebDriver webDiver = new Browser().chromeDriver();
        try {

            webDiver.get("https://www.jusbrasil.com.br/jurisprudencia/busca?q=assédio+2017");
            // implementar
            webDiver.close();

        } catch (Exception e) {
            webDiver.close();
            System.out.print(e.getMessage());
        }
    }
}