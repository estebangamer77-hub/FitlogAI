package com.fitlog.fitlogai;

import javafx.application.Application;
import javafx.stage.Stage;
import com.fitlog.fitlogai.view.LoginView;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        LoginView login = new LoginView(stage);
        login.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}