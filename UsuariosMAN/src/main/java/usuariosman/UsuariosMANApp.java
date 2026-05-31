package usuariosman;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UsuariosMANApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UsuariosMANApp.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 736, 576);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
