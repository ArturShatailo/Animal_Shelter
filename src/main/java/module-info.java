module com.example.animal_shelter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.animal_shelter to javafx.fxml;
    exports com.example.animal_shelter;
}