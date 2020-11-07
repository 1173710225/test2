package operation;

//对C4的4个文件进行修改 文件之一：clone仓库\test2\src\operation\Creater.java

import java.util.*;

public class Creater {
  private List<Addition> adds = new ArrayList<>();
  private List<Subtraction> subtractions = new ArrayList<>();
  private Set<Integer> set = new HashSet<>();

  // 生成5个不重复的加法算式
  public void newAdd() {
    while (set.size() < 5) {// 生成5个不重复的整数
      int temp = (int) (Math.random() * 101);
      set.add(temp);
    }

    for (Integer a : set) {
      int b = (int) (Math.random() * 101);
      Addition oper;
      if (a > b) {
        oper = new Addition(a, b);
      } else {
        oper = new Addition(b, a);
      }
      adds.add(oper);
    }
    System.out.println(adds);
    set.clear();
  }

  //生成5个不重复的减法算式
  public void newSub(){
    while (set.size() < 5){
      int temp = (int)(Math.random() * 101);
      set.add(temp);
    }
    for(Integer a : set){
      int b = (int)(Math.random() * 101);
      Subtraction subtraction;
      if(a > b) {
        subtraction = new Subtraction(a, b);
      }else {
        subtraction = new Subtraction(b, a);
      }
      subtractions.add(subtraction);
    }
    set.clear();
  }

  // 取出第n个式子
  public Addition getAdd(int i) {
    Addition ad = adds.get(i);
    return ad;
  }

  public Subtraction getSub(int i){
    Subtraction sub = subtractions.get(i);
    return sub;
  }

  public void dele(){
    adds.clear();
    subtractions.clear();
  }



}
