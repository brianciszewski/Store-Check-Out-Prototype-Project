package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller<String> implements Initializable {
    @FXML
    ComboBox comboBoxUPC = new ComboBox();
    @FXML Button btnAddItem = new Button();
    @FXML ListView ListViewTransaction = new ListView();
    @FXML ListView ListViewMerch = new ListView();
    @FXML Label txtTotal = new Label();

    @FXML ListView ListViewOrders = new ListView();
    @FXML Button btnViewOrder = new Button();
    @FXML Label lbl1 = new Label();
    @FXML Label lbl2 = new Label();
    @FXML Label lbl3 = new Label();
    @FXML TextField txtName = new TextField();
    @FXML TextField txtAddress = new TextField();

    private ObservableList<java.lang.String> comboBox1_List = FXCollections
            .observableArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    private ObservableList<java.lang.String> ListViewProductList = FXCollections
            .observableArrayList("IPod", "Headphones", "8GB SD", "HDMI Cable", "Wireless Mouse", "HP Laptop");
    private ObservableList<java.lang.String> orderHistoryList = FXCollections
            .observableArrayList("Order 1: John Doe" , "Order 2: Jane Doe" , "Order 3: Don Joe");
    private ObservableList<String> TransactionList = FXCollections.observableArrayList();
    private double total;
    private String str3 = (String) ("Name: Don Joe\n" + "Address: 6578 Parky Pl\n" + "Purchases: 2\n" +
                "Purchase: HDMI Cable  14.99");
    private String str2 = (String) ("Name: Jane Doe\n" + "Address: 9874 Laney Ln\n" + "Purchases: 1\n" +
                "Purchase: IPod  199.99");
    private String str1 = (String) ("Name: John Doe\n" + "Address: 1234 Roady Rd\n" + "Purchases: 3\n" +
                "Purchase: 2x IPod, Headphones  419.97");



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxUPC.setItems(comboBox1_List);
        ListViewMerch.setItems(ListViewProductList);
        comboBoxUPC.getSelectionModel().selectFirst();
        ListViewOrders.setItems(orderHistoryList);

    }


    public void btnAddItemClicked(ActionEvent actionEvent) {
        String quantity = (String) comboBoxUPC.getValue();
        String item = (String) ListViewMerch.getSelectionModel().getSelectedItem();
        double price;
        if (item.equals("IPod")){
            price = 199.99;
        }
        else if (item.equals("Headphones")){
            price = 19.99;
        }
        else if (item.equals("8GB SD")){
            price = 7.99;
        }
        else if (item.equals("HDMI Cable")){
            price = 14.99;
        }
        else if (item.equals("Wireless Mouse")){
            price = 26.99;
        }
        else if (item.equals("HP Laptop")){
            price = 329.99;
        }
        else{
            price = 0.00;
        }

        String discount = (String) "Bundle Sale.       -5.99";


        price = price * Integer.parseInt((java.lang.String) quantity);
        total += price;
        txtTotal.setText(java.lang.String.valueOf(total));
        String ListEntry = (String) (quantity + " " + item + "  " + price + "\n");
        System.out.println(ListEntry);
        TransactionList.addAll(ListEntry);
        if (Integer.parseInt((java.lang.String) quantity) > 1 && item.equals("HDMI Cable")){
            TransactionList.addAll(discount);
            total -= 5.99;
        }
        ListViewTransaction.setItems(TransactionList);
        System.out.println(total);
    }


    public void btnViewOrderClicked(ActionEvent actionEvent) {

        if (ListViewOrders.getSelectionModel().getSelectedItem() == "Order 1: John Doe"){
            lbl1.setText((java.lang.String) str1);
        }
        else if (ListViewOrders.getSelectionModel().getSelectedItem() == "Order 2: Jane Doe") {
            lbl2.setText((java.lang.String) str2);
        }
        else if (ListViewOrders.getSelectionModel().getSelectedItem() == "Order 3: Don Joe") {
            lbl3.setText((java.lang.String) str3);
        }
        }


    public void lbl1Clicked(MouseEvent mouseEvent) {
        lbl1.setText("");
    }

    public void lbl2Clicked(MouseEvent mouseEvent) {
        lbl2.setText("");
    }

    public void lbl3Clicked(MouseEvent mouseEvent) {
        lbl3.setText("");
    }

    public void btnEditInformationClicked(ActionEvent actionEvent) {
        String name = (String) txtName.getText();
        String address = (String) txtAddress.getText();
        if (ListViewOrders.getSelectionModel().getSelectedItem() == "Order 1: John Doe"){

            lbl1.setText("Name: " + name + "\n" + "Address: " + address + "\n" + "Purchases: 2\n" +
                    "Purchase: HDMI Cable  14.99");
        }
        else if (ListViewOrders.getSelectionModel().getSelectedItem() == "Order 2: Jane Doe") {
            lbl2.setText("Name: " + name + "\n" + "Address: " + address + "\n" + "Purchases: 1\n" +
                    "Purchase: IPod  199.99");
        }
        else if (ListViewOrders.getSelectionModel().getSelectedItem() == "Order 3: Don Joe") {
            lbl3.setText("Name: " + name + "\n" + "Address: " + address + "\n" + "Purchases: 3\n" +
                    "Purchase: 2x IPod, Headphones  419.97");
        }

    }
}
