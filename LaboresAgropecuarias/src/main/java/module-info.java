module com.app.laboresagropecuarias {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    
    opens com.app.laboresagropecuarias to javafx.fxml;
    opens Controladores to javafx.fxml;
    opens Model to javafx.base;
    
    exports com.app.laboresagropecuarias;
    exports Controladores;
    exports Model;
}
