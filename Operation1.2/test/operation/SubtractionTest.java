package operation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubtractionTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getNum1() {
        Subtraction sub = new Subtraction(100,99);
        assert sub.getNum1()==100;
    }

    @Test
    public void getNum2() {
        Subtraction sub = new Subtraction(100,99);
        assert sub.getNum2()==99;
    }

    @Test
    public void getDiff() {
        Subtraction sub = new Subtraction(100,99);
        assert sub.getDiff()==1;
    }
}