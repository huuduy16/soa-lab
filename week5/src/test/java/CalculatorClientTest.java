import com.calculatorsoap.client.CalculatorClient;
import com.calculatorsoap.client.CalculatorClientConfig;
import com.calculatorsoap.client.gen.CalculatorResponse;
import com.calculatorsoap.client.gen.Expression;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CalculatorClientConfig.class, loader = AnnotationConfigContextLoader.class)
public class CalculatorClientTest {

    @Test
    public void test3add5equal8() {
        Expression value = new Expression();
        value.setNum0(3.0);
        value.setNum1(5.0);
        value.setOperator("+");

        CalculatorClient client = new CalculatorClient();
        client.setDefaultUri("http://localhost:8080/ws");
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.calculator.client.gen");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);

        CalculatorResponse response = client.getResult(value);
        Assertions.assertEquals("3.0 + 5.0 = 8.0", response.getResult());
    }
}
