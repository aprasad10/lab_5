package com.example.lab_5;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

public class BankAccountController {
    @FXML
    ArrayList<BankAccount> accounts = new ArrayList<>();
    @FXML
    ComboBox<Integer> accountSelector;
    @FXML
    BankAccount selectedAcc;
    @FXML
    private Label account;
    @FXML
    private TextField amount;
    @FXML
    private Label balance;
    @FXML
    private Label print;

    @FXML
    protected void onCreateAccButtonClick() {
        BankAccount newAcc = new BankAccount();
        accounts.add(newAcc);
        selectedAcc = newAcc;
        account.setText(String.valueOf(selectedAcc.getAccountNumber()));
        balance.setText("Balance: " + 0.0);

        accountSelector.getItems().add(newAcc.getAccountNumber());
        accountSelector.setValue(newAcc.getAccountNumber());
    }
    @FXML
    protected void onSelectAccountButtonClick() {
        int accountNumber = accountSelector.getValue();  // Get the selected account number
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                selectedAcc = account;
                balance.setText(String.valueOf("Balance: " + selectedAcc.getBalance()));
            }
        }
    }
    @FXML
    protected void onDepositButtonClick() {
        try {
            String input = amount.getText();
            if (input == null || input.trim().isEmpty()) {
                throw new NumberFormatException("Amount field is empty.");
            }
            Double amt = Double.parseDouble(amount.getText());
            selectedAcc.deposit(amt);
            balance.setText("Balance: " + String.format("%.2f", selectedAcc.getBalance()));
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
        selectedAcc.withdraw(amt);
        balance.setText("Balance: " + String.format("%.2f", selectedAcc.getBalance()));
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
            print.setText(selectedAcc.getStatement());
        }
        catch(Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
}