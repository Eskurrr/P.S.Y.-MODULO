module com.telemedicina.pabloescudero {
    requires javafx.controls;
    requires javafx.fxml;
    requires MaterialFX;


    exports com.telemedicina.pabloescudero.main.controller;
    opens com.telemedicina.pabloescudero.main.controller to javafx.fxml;
    exports com.telemedicina.pabloescudero.main;
    opens com.telemedicina.pabloescudero.main to javafx.fxml;
}