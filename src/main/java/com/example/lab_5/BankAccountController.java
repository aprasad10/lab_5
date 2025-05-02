package com.example.lab_5;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BankAccountController {
    @FXML
    private Label account;
    @FXML
    BankAccount myAcc;
    @FXML
    private TextField amount;
    @FXML
    private Label balance;
    @FXML
    private Label print;

    @FXML
    protected void onCreateAccButtonClick() {
        myAcc = new BankAccount();
        account.setText(String.valueOf(BankAccount.accountNumber));
        balance.setText("Balance: " + 0.0);
    }
    @FXML
    protected void onDepositButtonClick() {
        Double amt = Double.parseDouble(amount.getText());
        try {
            myAcc.deposit(amt);
            balance.setText(String.format("Balance: " + String.valueOf(myAcc.getBalance())));
        }
        catch(Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    @FXML
    protected void onWithdrawButtonClick() {
        Double amt = Double.parseDouble(amount.getText());
        try {
            myAcc.withdraw(amt);
            balance.setText(String.format("Balance: " + String.valueOf(myAcc.getBalance())));
        }
        catch(Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    @FXML
    protected void onStatementButtonClick() {
        print.setText(myAcc.getStatement());
    }
}