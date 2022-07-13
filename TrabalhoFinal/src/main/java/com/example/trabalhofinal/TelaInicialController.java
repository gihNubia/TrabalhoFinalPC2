package com.example.trabalhofinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TelaInicialController implements Initializable{

    public TelaInicialController(){

    }


    @FXML
    Button adicionar, remover, pesData, pesNome, mostrarTd, sair;

    @FXML
    private void pressAdcTarefa(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("AdicionarTarefa.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        window.setTitle("Adicionar Tarefa");
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void pressRemoverTarefa(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("RemoverTarefa.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        window.setTitle("Adicionar Tarefa");
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void pressPesquisarTarefaNome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PesquisarPorNome.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        window.setTitle("Adicionar Tarefa");
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void pressPesquisarTarefaData(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PesquisarPorData.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        window.setTitle("Adicionar Tarefa");
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void pressMostrarTarefas(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("MostrarTodasAsTarefas.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        window.setTitle("Adicionar Tarefa");
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void pressSair(ActionEvent event){
        Stage stage = (Stage) sair.getScene().getWindow();
        stage.close();
        System.exit(1);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}