module com.telemedicina.pabloescudero {
    requires javafx.fxml;
    requires MaterialFX;
    requires org.controlsfx.controls;


    exports com.telemedicina.pabloescudero.main.controller;
    opens com.telemedicina.pabloescudero.main.controller to javafx.fxml;
    exports com.telemedicina.pabloescudero.main;
    opens com.telemedicina.pabloescudero.main to javafx.fxml;
}