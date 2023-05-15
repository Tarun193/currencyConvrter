package com.example.currencyconvrter;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


import java.util.HashMap;

public class CurrencyConverterController {
    // Grabbing elements from FXML with which I am going to work.
    @FXML
    private ComboBox<String> comboBoxFrom;

    @FXML
    private ComboBox<String> comboBoxTo;

    @FXML
    private TextField Result;

    @FXML
    private TextField Amount;

    // when someone clicks on exit which is in help menu.
    @FXML
    void exitProgram() {
        Platform.exit();
    }

    // for storing exchange rate hash map;
    private final HashMap<String, Double> exChangeRate = CurrencyData.getExchangeRate();

//    Function for handling error if something went wrong while converting
    private void HandleError(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText("Something went wrong, please fill form correctly");
        alert.showAndWait();
    }

//    This function is called when user hit convert button, to convert the currencies and display out put.
    @FXML
    public void Calculate(){
//        Error handling if something went wrong while converting , that will be handle.
        try {
            // Grabbing the currency from which user wants to convert
            String from = comboBoxFrom.getValue();
            // Grabbing the currency to which user wants to convert
            String to = comboBoxTo.getValue();
            // Getting the amount entered ny user in inPut Field
            double amount = Double.parseDouble(Amount.getText());
//            converting values using calculateExchange function from CurrencyData class.
            double result = CurrencyData.calculateExChange(from, to, amount);
//            Displaying result.
            Result.setText(String.format("%.2f", result));
        }
        catch (Exception e){
            HandleError();
        }
    }

    @FXML
    public void Reset(){
        // resting the form when reset button is clicked
        Amount.setText("");
        Result.setText("");
    }
    // This function run when FXML is rendered, and this will add options to comboBox when FXML get render
    public void initialize() {
        exChangeRate.forEach((key, value) -> {
            comboBoxFrom.getItems().add(key);
            comboBoxTo.getItems().add(key);
        });
    }
}