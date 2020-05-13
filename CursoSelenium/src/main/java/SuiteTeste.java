import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// vai rodar todas as classes 
@RunWith(Suite.class)
@SuiteClasses({	
	TesteCadastro.class,
	TesteRegrasCadastro.class,
	TesteCampoTreinamento.class,
})
public class SuiteTeste {

}
