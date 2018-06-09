package SeleniumBrowser;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class Browser {


     public Browser(){ }

    public  ChromeDriver chromeDriver(){
         // atenção com o path
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\usuario\\GitHub\\Java\\AmigabilidadeGenero\\Crawler\\lib\\chromedriver.exe");
         return new ChromeDriver(GetOptionsToCrhome());
     }

     private FirefoxDriver firefoxDriver(){
         // atenção com o path
         System.setProperty("webdriver.gecko.driver", "C:\\Users\\usuario\\IdeaProjects\\AmigabilidadeGenero\\Crawler\\lib\\geckodriver.exe");
         return new FirefoxDriver();
     }


     private  DesiredCapabilities GetOptionsToCrhome() {
         try {
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
             options.addArguments("--disable-extensions");

             DesiredCapabilities optionsToBrowser = DesiredCapabilities.chrome();
             optionsToBrowser.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap);
             optionsToBrowser.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
             optionsToBrowser.setCapability(ChromeOptions.CAPABILITY, options);

             return optionsToBrowser;

         } catch (Exception e) {
             System.out.print(e.getMessage());
             return  new DesiredCapabilities();
         }
     }
}
