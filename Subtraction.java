package operation;

public class Subtraction {
    private int num1;//减数
    private int num2;//被减数
    private int diff;//差

    public Subtraction(int a, int b){
        this.num1 = a;
        this.num2 = b;
        this.diff = a-b;

    }

    public int getNum1() {//获取减数
        int a = num1;
        return a;
    }

    public int getNum2() {//获取被减数
        int b = num2;
        return b;
    }

    public int getDiff(){//获取差
        int d = diff;
        return d;
    }

    @Override
    public String toString(){
        return num1 + "-" + num2 + "=";
    }



}
