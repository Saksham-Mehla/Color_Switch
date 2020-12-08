package application;
	
import javafx.application.Application; 
import javafx.scene.Scene;  
import javafx.scene.layout.*; 
import javafx.stage.Stage; 
import javafx.fxml.FXMLLoader;
import javafx.scene.paint.*;

public class ColorSwitch extends Application {
	Game currGame;
	int highScore;
	GenericList<Game> saved;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Color Switch");
			primaryStage.setResizable(false);
			Scene currScene = gameOver();
			primaryStage.setScene(currScene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Scene homeMenu() throws Exception{
		AnchorPane root = FXMLLoader.load(getClass().getResource("HomeMenu.fxml"));
		root.setId("home");
		Scene scene = new Scene(root, 600, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		return scene;
	}
	
	public Scene pauseMenu() throws Exception{
		AnchorPane root = FXMLLoader.load(getClass().getResource("PauseMenu.fxml"));
		root.setId("pause");
		Scene scene = new Scene(root, 600, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		BackGround bg = new BackGround(Color.BLACK); 

		root.setBackground(bg.getBg());
		return scene;
	}
	
	public Scene selectSavedGame() throws Exception{
		AnchorPane root = FXMLLoader.load(getClass().getResource("SelectSavedGame.fxml"));
		root.setId("selectSavedGameMenu");
		Scene scene = new Scene(root, 600, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		BackGround bg = new BackGround(Color.BLACK); 

		root.setBackground(bg.getBg());
		return scene;
	}
	
	public Scene createNewGame() throws Exception {
		AnchorPane root = FXMLLoader.load(getClass().getResource("CreateNewGame.fxml"));
		root.setId("createNewGameMenu");
		Scene scene = new Scene(root, 600, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		BackGround bg = new BackGround(Color.BLACK); 

		root.setBackground(bg.getBg());
		return scene;
	}
	
	public Scene gameOver() throws Exception{
		AnchorPane root = FXMLLoader.load(getClass().getResource("GameOver.fxml"));
		root.setId("gameOverMenu");
		Scene scene = new Scene(root, 600, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		BackGround bg = new BackGround(Color.BLACK); 

		root.setBackground(bg.getBg());
		return scene;
	}
	
	public Scene onExit() throws Exception{
		AnchorPane root = FXMLLoader.load(getClass().getResource("OnExit.fxml"));
		root.setId("onExitMenu");
		Scene scene = new Scene(root, 600, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		BackGround bg = new BackGround(Color.BLACK); 
		root.setBackground(bg.getBg());
		return scene;
	}
	
	public void startNew(String name, int difficulty) {
		currGame = new Game();
		currGame.changeDifficulty(difficulty);
		currGame.setName(name);
		currGame.askToPlay();
	}
	
	public void loadGame() {
		
	}
	
	public void exitCurrGame() {
		
	}
	
	public void pauseGame() {
		
	}
	
	public void saveAndExit(){
		
	}
	
	public void exitApp() {
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
