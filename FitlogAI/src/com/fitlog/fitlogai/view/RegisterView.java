package com.fitlog.fitlogai.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterView {

    private Stage stage;

    public RegisterView(Stage stage) {
        this.stage = stage;
    }

    public void show() {

        Label title = new Label("Create Account");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        TextField username = new TextField();
        username.setPromptText("Username");

        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        Button registerBtn = new Button("Register");
        Button backBtn = new Button("Back");

        registerBtn.setPrefWidth(200);
        backBtn.setPrefWidth(200);

        backBtn.setOnAction(e -> {
            LoginView login = new LoginView(stage);
            login.show();
        });

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(40));

        layout.getChildren().addAll(
                title,
                username,
                password,
                registerBtn,
                backBtn
        );

        Scene scene = new Scene(layout, 400, 400);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setTitle("FitLog AI - Register");
        stage.setScene(scene);
    }
}