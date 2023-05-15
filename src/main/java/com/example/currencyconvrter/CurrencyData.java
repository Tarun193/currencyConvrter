package com.example.currencyconvrter;
import java.util.HashMap;

// I have created a separate class for data because in future maybe we want to fetch data from API, so all that logic can go
//in this class
public class CurrencyData {
//    Hashmap for storing data currency data in form of key-value pairs.
    private static final HashMap<String, Double> exChangeRate = new HashMap<>();

//    For initializing data in hashmap.
    private static void initialize() {
//        .put method is used to put data in hashmap
        exChangeRate.put("INR", 0.012);
        exChangeRate.put("CAD", 0.75);
        exChangeRate.put("Euro", 1.10);
        exChangeRate.put("USD", 1.00);
    }

//    For return exchange rate data.
    public static HashMap<String, Double> getExchangeRate(){
        initialize();
        return exChangeRate;
    }

//    Method for converting on based on provide data and return converted amount.
    public static Double calculateExChange(String From, String To, Double Amount){
//        let From = "USD" and To = "INR", get method will get values associated with these keys and put in this equation.
        return (exChangeRate.get(From) * Amount) / exChangeRate.get(To);
    }
}
