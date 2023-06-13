// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class PruebasWebAppTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() throws MalformedURLException {
    System.out.println("Iniciando setUp");
    //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.safari());
    //driver = new RemoteWebDriver(new URL("http://lab.zalenium:4444/wd/hub"), DesiredCapabilities.chrome());
    driver = new RemoteWebDriver(new URL("http://lab.zalenium:4444/wd/hub"), DesiredCapabilities.firefox());
    
    /* 
    System.setProperty("webdriver.chrome.whitelistedIps", "");
    System.setProperty("java.net.preferIPv4Stack", "true");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--verbose");
    options.addArguments("--disable-setuid-sandbox");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-ipv6");
    options.addArguments("--whitelisted-ips=''");
    options.setCapability("networkConnectionEnabled", true);
    driver = new RemoteWebDriver(new URL("http://lab.zalenium:4444/wd/hub"), options);
    */
  
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void pruebasWebApp() {
    System.out.println("Iniciando prueba");


    
    boolean continuar = true;
    int contador=0;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds());

    while (continuar) {
      driver.get("http://lab.tomcat:8080/pruebasWebApp/");
      driver.manage().window().setSize(new Dimension(2880, 1325));  
      driver.findElement(By.id("nombre")).sendKeys("usuario");
      driver.findElement(By.id("contrasena")).sendKeys("password");
      WebElement botonAutenticar = wait.until(ExpectedConditions.elementToBeClickable(By.id("autenticar")));
      //botonAutenticar.click();
      botonAutenticar.sendKeys(Keys.RETURN);
      //WebElement h2Element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h2")));
      WebElement h2Element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("paginaAutenticado")));
      String h2Text = h2Element.getText();
      String contenidoPagina ="Autenticado";
      System.out.println("Texto del elemento h2: " + h2Text);
      //assertEquals(h2Text, contenidoPagina);
  


      if (contador == 19) {
        continuar = false;  // Detener el bucle después de 10 iteraciones
      }
      contador++;
      }
   
  }
}
