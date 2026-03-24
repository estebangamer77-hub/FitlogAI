package com.fitlog.fitlogai.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView {

    private Stage stage;

    public LoginView(Stage stage) {
        this.stage = stage;
    }

    public void show() {

        Label title = new Label("FitLog AI");
        title.setStyle("-fx-font-size: 26px; -fx-font-weight: bold;");

        TextField username = new TextField();
        username.setPromptText("Username");

        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        Button loginBtn = new Button("Login");
        Button registerBtn = new Button("Register");

        loginBtn.setPrefWidth(200);
        registerBtn.setPrefWidth(200);

        loginBtn.setOnAction(e -> {
            DashboardView dashboard = new DashboardView(stage);
            dashboard.show();
        });

        registerBtn.setOnAction(e -> {
            RegisterView register = new RegisterView(stage);
            register.show();
        });

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(40));

        layout.getChildren().addAll(
                title,
                username,
                password,
                loginBtn,
                registerBtn
        );

        Scene scene = new Scene(layout, 400, 400);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setTitle("FitLog AI - Login");
        stage.setScene(scene);
        stage.show();
    }
}