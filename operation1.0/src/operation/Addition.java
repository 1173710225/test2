package operation;

public class Addition {
  private int num1;//加数
  private int num2;//被加数
  private int sum;//和

  public Addition(int sum, int a) {
    this.num1 = a;
    this.sum = sum;
    this.num2 = sum - a;
  }

  public int getNum1() {//获取加数
    int a = num1;
    return a;
  }

  public int getNum2() {//获取被加数
    int b = num2;
    return b;
  }

  public int getSum() {//获取和
    int s = sum;
    return s;
  }

  @Override
  public String toString() {
    return num1 + "+" + num2 + "=";
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (this.getClass() != obj.getClass()) {
      return false;
    }

    Addition other = (Addition) obj;
    if (this.getSum() == other.getNum1()
        && (this.getNum1() == other.getNum1() || this.getNum1() == other.getNum2())) {
      return true;
    } else {
      return false;
    }
  }
}
