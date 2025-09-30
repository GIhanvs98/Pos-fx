module pos {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.gihanvs.pos to javafx.fxml;
    exports com.gihanvs.pos;
}