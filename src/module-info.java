module pos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires jbcrypt;


    // ---- Make your main Application class accessible ----
    opens com.gihanvs.pos to javafx.graphics, javafx.fxml;

    // ---- If your FXML controllers are in this package, keep this ----
    exports com.gihanvs.pos.controller;
    exports com.gihanvs.pos.view.tm ;

    // If your main package also needs to be visible outside, you can add:
    // exports com.gihanvs.pos;
}
