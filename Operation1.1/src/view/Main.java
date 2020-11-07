package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage arg0) throws Exception {
    // TODO Auto-generated method stub
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(Main.class.getResource("prac.fxml"));
    AnchorPane login = (AnchorPane) loader.load();
    pracController controller = loader.getController();
    Scene scene = new Scene(login);
    arg0.setScene(scene);
    arg0.show();
  }

  public static void main(String[] args) {
    launch(args);
  }


}
