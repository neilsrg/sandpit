package au.com.prince.bean;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    Parser parser = new Parser();

    @Test
    public void testGetIdNumberSuccess() throws Throwable {
        String result = parser.getIdNumber("cw1234");
        assertEquals("The string is not the same!", "1234", result);
    }

    @Test
    public void testGetIdNumberFailed() throws Throwable {
        String result = parser.getIdNumber("c");
        result.contains("String index out of range: -1");
    }
}
