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
        assertEquals(10,calc.add("1,2,3,4"));
    }

    //3rd case
    @Test
    public void sofMultipleValueNewLine() {
        assertEquals(7,calc.add("1\n2\n3,1"));
    }

    @Test
    public void allNewLine() {
        assertEquals(0,calc.add("\n\n\n"));
    }
    //4th and 6th case
    @Test
    public void diffDelimiters() {
        assertEquals(6,calc.add("//;\n3;1;2"));
    }
    @Test
    public void greaterThanThousandIgnored() {
        assertEquals(33,calc.add("1,7,1003,25"));
    }
    //negative number cases
    @Test
    public void negativeNumbers() {
        try {
            calc.add("-2");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative numbers are not allowed to use: -2",e.getMessage());
        }
    }
    @Test
    public void negativeNumbersList() {
        try {
            calc.add("-2,5,7,-1");
        } catch (IllegalArgumentException e) {
            assertEquals("Negative numbers are not allowed to use: -2,-1",e.getMessage());
        }
    }
    //extra test cases
    @Test
    public void extraCase1() {
        assertEquals(10,calc.add("//[;][,][*]\n1;2,3*4"));
    }

    @Test
    public void extraCase2() {
        assertEquals(14,calc.add("//[**][++][,][;]\n1**2,3++8"));
    }

}