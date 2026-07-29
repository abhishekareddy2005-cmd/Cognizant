import org.junit.Test;
import static org.junit.Assert.*;

public class Exercise1_SetupTest {

    @Test
    public void testJUnitSetup() {
        int result = 2 + 3;
        assertEquals(5, result);
        System.out.println("JUnit is set up and working!");
    }
}
