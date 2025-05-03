package com.example.lab_5;

import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
/**
 * Bank Account Controller
 * @author Ashley Prasad (BankAccountController)
 * @since 05/02/2025
 */
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

    /**
     * CreateAccButtonClick() creates a new account every time the button is clicked on, and the new account
     * is then added to a list of accounts called accounts. A variable holds the current account called selectedAcc.
     * Account label is updated to be the accounts number, balance is intitialized to 0.
     * The ComboBox is also a list that allows the reader to select from and switch across accounts, and is updated every click.
     */
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

    /**
     * onSelectAccountButtonClick() allows user to click on the ComboBox button and select an account from the updated
     * list--when doing so, the balance is then changed to what the selected accounts current balance is.
     */
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

    /**
     * onDepositButtonClick() deposits an amount into the account balance, balance label is then updated
     * combining the current balance with the deposited amount.
     * Try and catch are also implemented to catch any errors where deposit is pressed before account is created
     * and where there is no amount given to be deposited.
     */
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

    /**
     * onWithdrawButtonClick() withdraws an amount from the account balance, balance label is then updated
     * subtracting the withdrawn amount from the current balance.
     * Try and catch are also implemented to catch any errors where withdraw is pressed before account is created
     * and where there is no amount given to be withdrawn.
     */
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

    /**
     * onStatementButtonClick() returns the transaction history for deposits/withdraws with printed date.
     * Try and catch is implemented to give an alert in case the button is clicked on before the account is
     * created.
     */
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