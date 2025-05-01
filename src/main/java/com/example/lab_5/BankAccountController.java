package com.example.lab_5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BankAccountController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label account;
    @FXML
    BankAccount myAcc;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onCreateAccButtonClick() {
        myAcc = new BankAccount();
        account.setText(String.valueOf(BankAccount.accountNumber));
    }

}