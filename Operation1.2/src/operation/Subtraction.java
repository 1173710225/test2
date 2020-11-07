package operation;

public class Subtraction {//减法类
    private int num1;//减数
    private int num2;//被减数
    private int diff;//差

    public Subtraction(int a, int b){
        this.num1 = a;
        this.num2 = b;
        this.diff = a-b;

    }

    public int getNum1() {
        int a = num1;
        return a;
    }

    public int getNum2() {
        int b = num2;
        return b;
    }

    public int getDiff(){
        int d = diff;
        return d;
    }

    @Override
    public String toString(){
        return num1 + "-" + num2 + "=";
    }



}
