module com.mbtec.staffnoc {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
    requires mysql.connector.j;
    requires org.jetbrains.annotations;
    requires com.jfoenix;

    opens com.mbtec.staffnoc to javafx.fxml;
    opens com.mbtec.staffnoc.controller to javafx.fxml;
    opens com.mbtec.staffnoc.domain to javafx.base;   // <- troca pelo pacote real de Activity, Bts...

    exports com.mbtec.staffnoc;
}