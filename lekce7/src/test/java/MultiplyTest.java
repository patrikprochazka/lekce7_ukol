import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyTest {

    @Test
    public void testMultiplicationA(){
        int a = 8;
        int b = 7;
        assertEquals(56, Main.multiply(a, b));
    }

    @Test
    public void testMultiplicationB(){
        int a = 4;
        int b = 11;
        assertEquals(44, Main.multiply(a, b));
    }



}
