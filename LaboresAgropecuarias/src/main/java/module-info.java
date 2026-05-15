module com.app.laboresagropecuarias {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
requires java.sql;
    opens com.app.laboresagropecuarias to javafx.fxml;
    exports com.app.laboresagropecuarias;
}
