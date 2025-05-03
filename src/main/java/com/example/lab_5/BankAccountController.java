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
        try {
            String input = amount.getText();
            if (input == null || input.trim().isEmpty()) {
                throw new NumberFormatException("Amount field is empty.");
            }
            Double amt = Double.parseDouble(amount.getText());
            myAcc.deposit(amt);
            balance.setText("Balance: " + String.format("%.2f", myAcc.getBalance()));
        }
        catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid number for amount.");
            alert.showAndWait();
        }
        catch(Exception ex) {
            Alert nada = new Alert(Alert.AlertType.ERROR);
            nada.setTitle("Error");
            nada.setContentText(ex.getMessage());
            nada.showAndWait();
        }
    }
    @FXML
    protected void onWithdrawButtonClick() {
        try {
            String input = amount.getText();
            if (input == null || input.trim().isEmpty()) {
                throw new NumberFormatException("Amount field is empty.");
            }
        Double amt = Double.parseDouble(amount.getText());
        myAcc.withdraw(amt);
        balance.setText("Balance: " + String.format("%.2f", myAcc.getBalance()));
        }
        catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Input");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid number for amount.");
            alert.showAndWait();
        }
        catch(Exception ex) {
            Alert nada = new Alert(Alert.AlertType.ERROR);
            nada.setTitle("Error");
            nada.setContentText(ex.getMessage());
            nada.showAndWait();
        }
    }
    @FXML
    protected void onStatementButtonClick() {
        try {
            print.setText(myAcc.getStatement());
        }
        catch(Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}