package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import operation.Creater;

import java.util.ArrayList;
import java.util.List;

public class pracController {
  Creater cre = new Creater();

  boolean flag = false;//作为按钮是否可用的标志

  List<Label> labels = new ArrayList<>();//存储所有显示算式的 Label
  List<Label> juds = new ArrayList<>();//存储所有显示✔或X的Label
  List<TextField> texts = new ArrayList<>();//存储所有用于输入答案的Textfield


  @FXML
  private Button stabut;

  @FXML
  private AnchorPane pane;

  @FXML
  void cd0000(ActionEvent event) {

  }

  @FXML
  private void initialize() {//初始化界面布局
    double height = pane.getPrefHeight();
    double width = pane.getPrefWidth();
    double x = pane.getLayoutX();
    double y = pane.getLayoutY();

    double xspan = width / 5;//pane宽的1/5
    double yspan = height / 5;//pane高的1/5

    //画出Label与text来显示算式
    for(int j = 1; j < 3; j++){
      for(int i = 0; i < 5; i++){
        Label l = new Label("");
        l.setLayoutX(x + (2 * j - 1) * xspan);
        l.setLayoutY(y + i * yspan);
        labels.add(l);
        Label jud = new Label("");
        jud.setLayoutX(x + (2 * j - 1) * xspan+125);
        jud.setLayoutY(y + i * yspan);
        juds.add(jud);
        TextField t = new TextField();
        t.setPrefSize(64,30);
        t.setLayoutX(x + (2 * j - 1) * xspan+58);
        t.setLayoutY(y + i * yspan);
        texts.add(t);
        pane.getChildren().add(jud);
        pane.getChildren().add(l);
        pane.getChildren().add(t);
      }

    }


  }

  @FXML
  void start(ActionEvent event) {
    if (!flag) {
      flag = true;
      cre.newAdd();//随机生成5个加法式
      cre.newSub();//随机生成5个减法

      //将式子显示
      for(int i=0; i<10; i++){
        juds.get(i).setText("");
        if(i<5) {
          labels.get(i).setText(cre.getAdd(i).toString());
        }else {
          labels.get(i).setText(cre.getSub(i-5).toString());
        }
      }
      System.out.println("okk");
    }
  }

  @FXML//判断答案是否正确
  void judge(ActionEvent event) {
    if(flag){
      flag = false;
      for(int i=0; i< 10; i++){
        if(i < 5){
          if(!texts.get(i).getText().isEmpty() && Integer.parseInt(texts.get(i).getText()) == cre.getAdd(i).getSum()){
            juds.get(i).setText("✔");
          }else{
            juds.get(i).setText("X");
          }
        }else{
          if(!texts.get(i).getText().isEmpty() && Integer.parseInt(texts.get(i).getText()) == cre.getSub(i-5).getDiff()){
            juds.get(i).setText("✔");
          }else {
            juds.get(i).setText("X");
          }
        }

      }
    }
    cre.dele();//删除本页所有题目
  }

}

