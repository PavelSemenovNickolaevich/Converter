package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField text_field;

    @FXML
    private ChoiceBox<String> choise_mass;

    @FXML
    private Label output_ton;

    @FXML
    private Label output_kg;

    @FXML
    private Label output_gr;

    private String strNum = "";

    private static final String ton = "Тонна";
    private static final String kilo = "Килограмм";
    private static final String gram = "Грамм";
    boolean isTon;

    @FXML
    void initialize() {
//        Pattern p = Pattern.compile("(\\d+\\.?\\d*)?");
//        text_field.textProperty().addListener((observable, oldValue, newValue) -> {
//            if (!p.matcher(newValue).matches()) text_field.setText(oldValue);
//        });

        choise_mass.getItems().add(ton);
        choise_mass.getItems().add(kilo);
        choise_mass.getItems().add(gram);
        choise_mass.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
           //     System.out.println(newValue);
                if(newValue.equals(ton)) {
                    String input = text_field.getText();
                    float data = Float.parseFloat(input);
                    float newTon = 0.0f;
                    newTon = data * 1000;
                    output_ton.setText(Float.toString(newTon));
                    System.out.println(newTon);
                } else {
                    isTon =false;
                }
            }
        });
//        output_ton.setText(convert());
//        output_kg.setText(ton);
//        output_gr.setText(ton);

    }

//    private void convert() {
//        String input = text_field.getText();
//        float data = Float.parseFloat(input);
//        float newTon = 0.0f;
//        if(isTon) {
//            newTon = data * 1000;
//        }
//        display(newTon);
//
//    }
//
//    private void display(float newTon) {
//        System.out.println(newTon);
//    }
}
