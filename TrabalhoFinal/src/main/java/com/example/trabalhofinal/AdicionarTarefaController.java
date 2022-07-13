package com.example.trabalhofinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AdicionarTarefaController {

    @FXML
    private TextField nome, data, hora, descricao;

    String txtNome = "", txtData = "", txtHora = "", txtDescricao = "";


    @FXML
    private void presAdc(ActionEvent event){
        txtNome = nome.getText();
        txtData = data.getText();
        txtHora = hora.getText();
        txtDescricao = descricao.getText();

        //backend

        txtNome = "";
        txtData = "";
        txtHora = "";
        txtDescricao = "";
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
