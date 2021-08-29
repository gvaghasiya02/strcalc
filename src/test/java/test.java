import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

public class test {
    calc calc;
    //1st case
    @Before
    public void init() {
        calc = new calc();
    }

    @Test
    public void isEmptyCheck() {
        assertEquals(0, calc.add(""));
    }

    @Test
    public void isSingleValue() {
        assertEquals(1, calc.add("1"));
    }

    //2nd case
    @Test
    public void sofMultipleValue() {
        assertEquals(15,calc.add("1,2,8,4"));
    }

    //3rd case
    @Test
    public void sofMultipleValueNewLine() {
        assertEquals(50,calc.add("20\n10\n19,1"));
    }

    @Test
    public void allNewLine() {
        assertEquals(0,calc.add("\n\n\n\n"));
    }
}