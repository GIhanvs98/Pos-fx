module pos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    // ---- Make your main Application class accessible ----
    opens com.gihanvs.pos to javafx.graphics, javafx.fxml;

    // ---- If your FXML controllers are in this package, keep this ----
    exports com.gihanvs.pos.controller;

    // If your main package also needs to be visible outside, you can add:
    // exports com.gihanvs.pos;
}
