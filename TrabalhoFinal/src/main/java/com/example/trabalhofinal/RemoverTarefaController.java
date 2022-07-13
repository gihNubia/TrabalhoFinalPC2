package com.example.trabalhofinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class RemoverTarefaController {

    @FXML
    TextField nome, data;

    @FXML
    RadioButton radioNome, radioData;

    String aux;

    @FXML
    private void presExcluir(ActionEvent event){
        if(radioNome.isSelected()){
            aux = nome.getText();

        } else if (radioData.isSelected()) {
            aux = data.getText();
        }

        //backend
    }
    @FXML
    private void presSair(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("TelaPrincipal.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        window.setTitle("Adicionar Tarefa");
        window.setScene(scene);
        window.show();
    }
}
