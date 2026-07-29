import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class Mockito_Exercise2_VerifyTest {

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Some Data");

        MyService service = new MyService(mockApi);
        service.fetchData();

        verify(mockApi).getData();
        System.out.println("Verify interaction test passed!");
    }
}
