import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TesteFrameEJanelas {
	
	private DSL dsl;

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
	public void deveInteragirComFrames() {
		
		driver.switchTo().frame("frame1");
		driver.findElement(By.id("FrameButton")).click();
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		Assert.assertEquals("Frame OK!", msg);
		alert.accept();	
		driver.switchTo().defaultContent(); // o deafultContent � para voltar a pagina padrao.
		driver.findElement(By.id("elementosForm:nome")).sendKeys(msg);
	
	}
	
		@Test
		public void deveInteragirComJanela() {
			
			driver.findElement(By.id("buttonPopUpEasy")).click();
			driver.switchTo().window("Popup");
			driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
			driver.close();
			driver.switchTo().window("");
			driver.findElement(By.tagName("textarea")).sendKeys("e agora?");

		}

		@Test
		public void deveInteragirComJanelasSemTitulo() {
			
			driver.findElement(By.id("buttonPopUpHard")).click();
			System.out.println(driver.getWindowHandle());// Principal
			System.out.println(driver.getWindowHandles());//para varias janelas
			driver.switchTo().window((String)driver.getWindowHandles().toArray()[1]);
			driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
			driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
			driver.findElement(By.tagName("textarea")).sendKeys("E agora?");

		}
		
		@Test
		public void deveInteragirComFrameEscondido() {
			
			dsl.entrarFrame("frame2");
			WebElement frame = driver.findElement(By.id("frame2"));
			dsl.executarJS("window.scrollBy(0, argument[0])", frame.getLocation().y);
			
			
			dsl.clicarBotao("frameButton");
			String msg = dsl.alertaObterTextoEAceita();
			Assert.assertEquals("Frame OK!", msg );
		}
		
		
}
