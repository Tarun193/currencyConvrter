module com.example.currencyconvrter {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.currencyconvrter to javafx.fxml;
    exports com.example.currencyconvrter;
}