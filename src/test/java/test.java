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
}