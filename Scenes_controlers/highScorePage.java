package p4_group_8_repo.Scenes_controlers;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import p4_group_8_repo.Main;
import p4_group_8_repo.Object_Controlers.MyStage;
import p4_group_8_repo.Scenes_controlers.HighScoreControlers.HighscoreManager;

import java.awt.*;

public class highScorePage {
    private Main main;
    private MyStage highScorePageStage;
    private Scene highScoreScene;
    public highScorePage(Main main,String whichHighScore_file,String codeKey){
        this.main = main;
        HighscoreManager highScoreManager = new HighscoreManager(whichHighScore_file);
        setScene(highScoreManager,false,0,codeKey);
    }
    public highScorePage(Main main,int getPoints,String whichHighScore_file,String codeKey){
        this.main = main;
        HighscoreManager highScoreManager = new HighscoreManager(whichHighScore_file);
        highScoreManager.addScore(getPoints);
        setScene(highScoreManager,true,getPoints,codeKey);
    }
    private void setScene(HighscoreManager highscoreManager,boolean viewing,int getPoints,String codeKey){
        System.out.print(highscoreManager.getHighscoreString());
        highScorePageStage = new MyStage();

        ButtonClass BackButtonClass = new ButtonClass("file:src/p4_group_8_repo/Assets/ButtonImages/BackButton.png",120,30,0,0);
        Button BackButton = BackButtonClass.getButton();

        //Text
        if (viewing){
            Label YoureScore = new Label(Integer.toString(getPoints));
            YoureScore.setLayoutX(300);
            YoureScore.setLayoutY(300);
            highScorePageStage.getChildren().addAll(YoureScore);
        }
        Label Top10Scores = new Label("Top 10 Scores\n"+highscoreManager.getHighscoreString());
        Top10Scores.setFont(new Font(40));
        Top10Scores.setMinWidth(400);
        Top10Scores.setMinHeight(700);
        Top10Scores.setLayoutX(175);
        Top10Scores.setLayoutY(100);

        highScorePageStage.getChildren().addAll(BackButton,Top10Scores);
        highScorePageStage.start();
        BackButton.setOnAction(e->main.setScene("Main_Scene"));

        highScoreScene = new Scene(highScorePageStage,600,800);
        main.setMap(codeKey,highScoreScene);
    }
}
