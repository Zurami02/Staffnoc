module com.mbtec.staffnoc {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.mbtec.staffnoc to javafx.fxml;
    exports com.mbtec.staffnoc;
}