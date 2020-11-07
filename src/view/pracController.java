package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import operation.Countdown;
import operation.Creater;

import java.util.ArrayList;
import java.util.List;

public class pracController {
  Creater cre = new Creater();
  int time=3;


  private boolean flag = false;//作为按钮是否可用的标志
  private boolean isFlag = false;//作为设置时间是否完成的标志
  private List<Label> labels = new ArrayList<>();//存储所有显示算式的 Label
  private List<Label> juds = new ArrayList<>();//存储所有显示✔或X的Label
  private List<TextField> texts = new ArrayList<>();//存储所有用于输入答案的Textfield


  @FXML
  private TextField restfake;//遮蔽时间美化界面

  @FXML
  private Label labeltime;

  @FXML
  public TextField resttime;//显示时间

  @FXML
  private TextField gettime;

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
    labeltime.setVisible(false);

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
        t.setVisible(false);
        texts.add(t);
        pane.getChildren().add(jud);
        pane.getChildren().add(l);
        pane.getChildren().add(t);
      }
    }
  }


  @FXML
  void start(ActionEvent event) throws Exception {

    if (!flag) {
      labeltime.setVisible(false);
      gettime.setVisible(false);
      if(!gettime.getText().isEmpty()){
        time=Integer.parseInt(gettime.getText());
      }
      Countdown countdown = new Countdown(time,this);
      flag = true;
      cre.newAdd();//随机生成5个加法式
      cre.newSub();//随机生成5个减法
      restfake.setVisible(false);
      //将式子显示
      for(int i=0; i<10; i++){
        texts.get(i).setVisible(true);
        juds.get(i).setVisible(true);
        labels.get(i).setVisible(true);
        juds.get(i).setText("");
        if(i<5) {
          labels.get(i).setText(cre.getAdd(i).toString());
        }else {
          labels.get(i).setText(cre.getSub(i-5).toString());
        }
      }
      countdown.start();
    }
  }

  @FXML//判断答案是否正确
  public void judge(ActionEvent event){ ;
    if(flag){
      isFlag=false;
      flag = false;
      restfake.setVisible(true);
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

  //设置限时时间的长度
  @FXML
  void setTime(ActionEvent event) {
    if(!isFlag&&!flag){
      for (int i=0; i<10; i++){
        texts.get(i).setVisible(false);
        labels.get(i).setVisible(false);
        juds.get(i).setVisible(false);
      }
      isFlag=true;
      labeltime.setVisible(true);
      gettime.setVisible(true);
    }
  }
}

