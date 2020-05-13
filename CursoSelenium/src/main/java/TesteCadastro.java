import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteCadastro {

	private WebDriver driver;
	private CampoTreinamentoPage page;
	
	@Before
	public void inicializa() {
		
		
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765)); 
		driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
		//dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);
	}
	
	@After

	public void finaliza() {
		//driver.quit();
	}
	

	@Test
	public void deveRealizarCadastroComSucesso() {
		page.setNome("Kalwan");
		page.setSobrenome("Almeida");
		page.setSexoMasculino();
		page.setComidaPizza();
		page.setEscolaridade("Superior");
		page.setEsporte("Natacao");
		page.cadastrar();
		
		Assert.assertTrue(page.obterResultadoCadastro().startsWith("Cadastrado!"));
		Assert.assertTrue(page.obterNomeCadastro().endsWith("Kalwan"));
		Assert.assertEquals("Sobrenome: Almeida", page.obterSobrenomeCadastro());
		Assert.assertEquals("Sexo: Masculino", page.obterSexoCadastro());
		Assert.assertEquals("Comida: Pizza", page.obterComidaCadastro());
		Assert.assertEquals("Escolaridade: superior",page.obterEscolaridadeCadastro());
		Assert.assertEquals("Esportes: Natacao", page.obterEsportesCadastro());		
	}
	
}
