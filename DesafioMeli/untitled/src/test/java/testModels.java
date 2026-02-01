import com.hackerrank.sample.model.Smartphone;
import org.junit.Test;
import static org.junit.Assert.*;

public class testModels {

    @Test
    public void testModels() {
        Smartphone s1 = new Smartphone();
        s1.setId(1L);
        s1.setName("Test");

        Smartphone s2 = new Smartphone();
        s2.setId(1L);
        s2.setName("Test");

        // Testa Equals e HashCode (cobertura do Lombok)
        assertEquals(s1, s2);
        assertEquals(s1.hashCode(), s2.hashCode());
        assertNotNull(s1.toString());

        // Testa Getters específicos (Record já está coberto, mas Entity não)
        s1.setBatteryCapacity("5000mAh");
        assertEquals("5000mAh", s1.getBatteryCapacity());
    }

    @Test
    public void testLombokDataBranches() {
        Smartphone s1 = new Smartphone();
        s1.setId(1L);

        // Testa equals com nulo (Cobre uma ramificação do @Data)
        assertNotEquals(null, s1);

        // Testa equals com outro tipo de objeto (Cobre outra ramificação)
        assertNotEquals("String", s1);

        // Testa equals com o próprio objeto
        assertEquals(s1, s1);

        // Testa hashCode consistente
        int initialHash = s1.hashCode();
        assertEquals(initialHash, s1.hashCode());
    }
}