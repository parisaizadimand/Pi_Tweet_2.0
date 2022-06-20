package ir.pi.project.view.myPage.lists.blacklist;

import ir.pi.project.config.addresses.FXMLConfig;
import ir.pi.project.controller.myPage.lists.blacklist.BlacklistComponentLogic;
import ir.pi.project.view.MainController;
import ir.pi.project.view.myPage.MyPagePageController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BlacklistController implements Initializable {
    @FXML
    ScrollPane scroller;

    MyPagePageController myPagePageController;
    FXMLConfig fxmlConfig;

    {
        try {
            fxmlConfig = new FXMLConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMyPagePageController(MyPagePageController myPagePageController) {

        this.myPagePageController = myPagePageController;
    }

    public void back(){
        MainController.back();
    }
    public void mainMenu(){
        try {
            MainController.loadMainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void update(List<Integer> blacklist) {
        try {

            VBox content = new VBox(5);
            scroller.setContent(content);
            scroller.setFitToWidth(true);

            for (int i = 0; i < blacklist.size(); i++) {
                FXMLLoader fxmlLoader=new FXMLLoader(MainController.class.getResource(fxmlConfig.getBlacklistComponent()));
                AnchorPane anchorPane=fxmlLoader.load();
                content.getChildren().add(anchorPane);
                new BlacklistComponentLogic(fxmlLoader.getController(),blacklist.get(i),content,myPagePageController);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
