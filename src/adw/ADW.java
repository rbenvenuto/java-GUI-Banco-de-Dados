/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adw;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author rbenvenuto
 */
public class ADW extends Application {
    
    private Button btnCadastrar;
    
    public AdwRootFrameController adwController;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AdwRootFrame.fxml"));
        Parent rootStage = (Parent) fxmlLoader.load();
        
        adwController = (AdwRootFrameController) fxmlLoader.getController();
        
        primaryStage.setTitle("ADW - Software Developers");
        
        Scene scene = new Scene(rootStage);
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
