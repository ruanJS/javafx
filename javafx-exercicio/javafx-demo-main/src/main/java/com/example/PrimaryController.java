package com.example;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PrimaryController {
    
    @FXML RadioButton rdCarro;
    @FXML RadioButton rdMoto;
    @FXML RadioButton rdOutro;
    @FXML Button btnSalvar; 
    @FXML Button btnApagar; 
    @FXML Button btnEditar; 
    @FXML ListView<Veiculo> listVeic;
    @FXML TextField txtProp;
    @FXML TextField txtMarca;
    @FXML TextField txtValor;
    @FXML TextField txtModelo;

    ArrayList<Veiculo> veiculos = new ArrayList<>();
    

    public void adicionarVeiculo(){

        var categoria = Categoria.Carro;
    
            
            if(rdCarro.isSelected())
                categoria = Categoria.Carro;

            if(rdMoto.isSelected())
                categoria = Categoria.Moto;

            if(rdOutro.isSelected())
                categoria = Categoria.Outro;

                var veiculo = new Veiculo (
            txtProp.getText(),
            txtValor.getText(),
            txtMarca.getText(),
            txtModelo.getText(),
            categoria
            );

            veiculos.add(veiculo);
            
            atualizarTela();
            
        }
    
        private void atualizarTela(){
            listVeic.getItems().clear();
            for(var veiculo : veiculos){
                listVeic.getItems().add(veiculo);
            }
        }

        public void apagar(){
            Alert mensagem = new Alert(AlertType.CONFIRMATION);
            mensagem.setTitle("Aviso");
            mensagem.setHeaderText("Confirmação");
            mensagem.setContentText("Tem certeza que quer apagar esse veiculo?");
            var resposta = mensagem.showAndWait();

            if (resposta.isPresent() && resposta.get().equals(ButtonType.OK)){
                var veiculo = listVeic.getSelectionModel().getSelectedItem();
                veiculos.remove(veiculo);
                atualizarTela();
            }

        }

        public void editar(){
            var veiculos1 = listVeic.getSelectionModel().getSelectedItem();
    
            
            txtProp.setText(veiculos1.proprietario());
            txtModelo.setText(veiculos1.modelo());
            txtMarca.setText(veiculos1.marca());
            txtValor.setText(veiculos1.valor());
            
            if(veiculos1.categoria() == Categoria.Carro)
                rdCarro.setSelected(true);
            if(veiculos1.categoria() == Categoria.Moto)
                rdMoto.setSelected(true);
            if(veiculos1.categoria() == Categoria.Outro)
                rdOutro.setSelected(true);
    
            
            Alert mensagem2Alert = new Alert(AlertType.CONFIRMATION);
            mensagem2Alert.setHeaderText("Atenção!");
            mensagem2Alert.setContentText("Você quer mesmo editar?");
            var resposta =  mensagem2Alert.showAndWait();
            
    
            if(resposta.isPresent() && resposta.get().equals(ButtonType.OK)){
                atualizarTela();


            }
        }
    }
    

    


    

    

    
    

