package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

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

    private static final String ton = "Тонна";
    private static final String kilogram = "Килограмм";
    private static final String gram = "Грамм";
    float t = 0;
    float kg = 0;
    float gr = 0;

    @FXML
    void initialize() {
        Pattern p = Pattern.compile("(\\d+\\.?\\d*)?");
        text_field.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!p.matcher(newValue).matches()) text_field.setText(oldValue);
        });

        choise_mass.getItems().add(ton);
        choise_mass.getItems().add(kilogram);
        choise_mass.getItems().add(gram);
        choise_mass.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                String input = text_field.getText();
                float data = Float.parseFloat(input);
                if (newValue.equals(ton)) {
                    calculateTon(data, data * 1000, data * 1000000);
                    output();
                } else if (newValue.equals(kilogram)) {
                    calculateTon(data / 1000, data, data * 1000);
                    output();
                } else if (newValue.equals(gram)) {
                    calculateTon(data / 1000000, data / 1000, data);
                    output();
                }
            }
        });
    }

    private void calculateTon(float ton, float kg, float gr) {
        this.t = ton;
        this.kg = kg;
        this.gr = gr;
    }

    private void output() {
        output_ton.setText(Float.toString(t));
        output_kg.setText(Float.toString(kg));
        output_gr.setText(Float.toString(gr));
    }
}
