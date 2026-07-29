import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class Mockito_Exercise1_MockingTest {

    @Test
    public void testExternalApi() {
     
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);


        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

       
        assertEquals("Mock Data", result);
        System.out.println("Mocking test passed! Result: " + result);
    }
}
