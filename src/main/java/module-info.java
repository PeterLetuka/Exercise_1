module com.example.exercise_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exercise_1 to javafx.fxml;
    exports com.example.exercise_1;
}