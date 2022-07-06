package com.example.trabalhofinal;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaAdicionarTarefaApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(TelaInicialApplication.class.getResource("AdicionarTarefa.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Adicionar Tarefa");
        stage.setScene(scene);
        stage.show();
        launch();
    }
}
