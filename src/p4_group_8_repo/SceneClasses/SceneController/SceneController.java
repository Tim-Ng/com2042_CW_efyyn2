package p4_group_8_repo.SceneClasses.SceneController;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import p4_group_8_repo.SceneClasses.gameSceneClasses.GameScene;
import p4_group_8_repo.SceneClasses.HighScore.GetHighScoreScene;

import java.util.HashMap;

/***
 * This is the class to control the Scenes
 */
public class SceneController {
    /***
     * Hold the HashMap of the Scene for pages that are not game or high score pages
     */
    private HashMap<String, Scene> scenePageFinder = new HashMap<String, Scene>();
    /***
     * Hold the HashMap of the GameScene for game pages
     */
    private HashMap<String, GameScene> sceneGameFinder = new HashMap<String, GameScene>();
    /***
     * Hold the HashMap of the GetHighScoreScene for high score pages
     */
    private HashMap<String, GetHighScoreScene> sceneHighScoreFinder = new HashMap<String, GetHighScoreScene>();
    /***
     * To hold the stage of the primaryState
     */
    private Stage primaryStage;

    /***
     * To set the variable of the primaryStage
     * @param primaryStage the primaryStage which holds the main scene
     */
    public SceneController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.getIcons().add(new Image("file:src/p4_group_8_repo/Assets/GameObjects/icon-frogger-pixel-512x512.png"));
        primaryStage.setTitle("Frogger: 20107125");
        primaryStage.setResizable(false);
    }

    /***
     * To start the pages that are not game or high score scenes
     * @param whichScene Key for the scene
     */
    public void startPageScene(String whichScene){
        primaryStage.setScene(this.scenePageFinder.get(whichScene));
        primaryStage.show();
    }
    /***
     * To start the pages that are not game or high score scenes
     * @param whichScene Key for the scene
     */
    public void startGameScene(String whichScene){
        this.sceneGameFinder.get(whichScene).start();
        primaryStage.setScene(this.sceneGameFinder.get(whichScene).getScene());
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    /***
     * To start the game scenes
     * @param whichScene Key for the game scenes
     */
    public void startHighScoreScene(String whichScene){
        primaryStage.setScene(this.sceneHighScoreFinder.get(whichScene).getScene());
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    /***
     * To start the high score pages
     * @param whichScene Key for the high score scenes
     * @param Points the data for the new incoming point.
     */
    public void startHighScoreScene(String whichScene,int Points){
        primaryStage.setScene(this.sceneHighScoreFinder.get(whichScene).getScene(Points));
        primaryStage.show();
        primaryStage.setResizable(false);
    }
    public int getHighestScore(String whichScene){
        return this.sceneHighScoreFinder.get(whichScene).getHighestScore();
    }
    /***
     * To set the pages that are not game or high score scenes into scenePageFinder
     * @param inputKey the Key to set
     * @param scene the Scene to link with the key
     */
    public void setPageMap(String inputKey, Scene scene) {
        this.scenePageFinder.put(inputKey, scene);
    }

    /***
     * To set the game scenes into scenePageFinder
     * @param inputKey the Key to set
     * @param gameScene the game Scene Interface to link with the key
     */
    public void setGameMap(String inputKey, GameScene gameScene){this.sceneGameFinder.put(inputKey,gameScene);}
    /***
     * To set the high score scenes into sceneHighScoreFinder
     * @param inputKey the Key to set
     * @param getHighScoreScene the get high score scene Interface to link with the key
     */
    public void setHighScoreMap(String inputKey, GetHighScoreScene getHighScoreScene){this.sceneHighScoreFinder.put(inputKey,getHighScoreScene);}
}
