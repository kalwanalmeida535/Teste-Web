import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteGoogle {
	
	private WebDriver driver;
	
	@Before
	
	public void inicializa() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765)); 
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		
	}
	
	@After
	
	public void finaliza() {
		
		driver.quit();
}
	
	
	@Test
		
		public void deveInteragirComJanelasSemTitulo() {
			
			
			
			driver.findElement(By.id("buttonPopUpHard")).click();
			System.out.println(driver.getWindowHandle());
			System.out.println(driver.getWindowHandles());
			driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
			driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
			driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
			driver.findElement(By.tagName("textarea")).sendKeys("E agora?");

	}
	
}
 