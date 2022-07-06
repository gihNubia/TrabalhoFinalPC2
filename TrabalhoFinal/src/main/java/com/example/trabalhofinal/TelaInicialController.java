package com.example.trabalhofinal;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class TelaInicialController {

    public TelaInicialController(){

    }

    TelaAdicionarTarefaApplication adcTarefa = new TelaAdicionarTarefaApplication();

    @FXML
    Button adicionar, remover, pesData, pesNome, mostrarTd, sair;

    @FXML
    private void pressAdcTarefa(ActionEvent event){
        System.out.println("Tarefa adicionada");
        Stage stage = new Stage();
        //adcTarefa.start(stage);

    }

    @FXML
    private void pressRemoverTarefa(ActionEvent event){

    }

    @FXML
    private void pressPesquisarTarefaNome(ActionEvent event){

    }

    @FXML
    private void pressPesquisarTarefaData(ActionEvent event){

    }

    @FXML
    private void pressMostrarTarefas(ActionEvent event){

    }

    @FXML
    private void pressSair(ActionEvent event){
        Stage stage = (Stage) sair.getScene().getWindow();
        stage.close();
        System.exit(1);
    }

}