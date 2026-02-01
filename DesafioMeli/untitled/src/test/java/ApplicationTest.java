import com.hackerrank.sample.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
// O use de webEnvironment = RANDOM_PORT evita erro de porta ocupada
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    @Test
    public void contextLoads() {
        // Apenas para garantir que o contexto sobe
    }

    @Test
    public void main() {
        // Para cobrir o método main sem subir um servidor real que conflite
        // Passamos o parâmetro para o Spring não tentar iniciar o servidor web
        Application.main(new String[] {"--spring.main.web-application-type=none"});
    }
}