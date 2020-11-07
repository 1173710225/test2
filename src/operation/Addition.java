package operation;

//对C4的4个文件进行修改 文件之一：clone仓库\test2\src\operation\Addition.java

public class Addition {
  private int num1;
  private int num2;
  private int sum;

  public Addition(int sum, int a) {
    this.num1 = a;
    this.sum = sum;
    this.num2 = sum - a;
  }

  public int getNum1() {
    int a = num1;
    return a;
  }

  public int getNum2() {
    int b = num2;
    return b;
  }

  public int getSum() {
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
