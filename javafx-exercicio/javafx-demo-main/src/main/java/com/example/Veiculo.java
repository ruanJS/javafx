package com.example;

import javafx.scene.control.ListView;

public record Veiculo(String proprietario,String valor,String modelo, String marca, Categoria categoria) {

}

enum Categoria 
{
    Carro,
    Moto,
    Outro
}

