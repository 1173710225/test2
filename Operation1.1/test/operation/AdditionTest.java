package operation;


public class AdditionTest {

    @org.junit.Test
    public void getNum1() {
        Addition a = new Addition(40,3);
        assert a.getNum1() == 3;
    }

    @org.junit.Test
    public void getNum2() {
        Addition a = new Addition(40,3);
        assert a.getNum2() == 37;
    }

    @org.junit.Test
    public void getSum() {
        Addition a = new Addition(40,3);
        assert a.getSum() == 40;
    }


}