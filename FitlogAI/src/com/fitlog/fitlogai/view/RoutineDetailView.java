package com.fitlog.fitlogai.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RoutineDetailView {

    private Stage stage;
    private String routineName;

    public RoutineDetailView(Stage stage, String routineName) {
        this.stage = stage;
        this.routineName = routineName;
    }

    public void show(){

        Label title = new Label(routineName + " Exercises");
        title.setStyle("-fx-font-size:22px; -fx-font-weight:bold;");

        ListView<String> exercises = new ListView<>();

        switch(routineName){

            case "Chest Day":
                exercises.getItems().addAll(
                        "Bench Press",
                        "Incline Dumbbell Press",
                        "Chest Fly",
                        "Push Ups"
                );
                break;

            case "Leg Day":
                exercises.getItems().addAll(
                        "Squats",
                        "Leg Press",
                        "Lunges",
                        "Leg Curl"
                );
                break;

            case "Back & Biceps":
                exercises.getItems().addAll(
                        "Pull Ups",
                        "Barbell Row",
                        "Lat Pulldown",
                        "Bicep Curl"
                );
                break;

            case "Shoulders":
                exercises.getItems().addAll(
                        "Shoulder Press",
                        "Lateral Raises",
                        "Front Raises",
                        "Reverse Fly"
                );
                break;

            case "Cardio":
                exercises.getItems().addAll(
                        "Running",
                        "Cycling",
                        "Jump Rope",
                        "HIIT"
                );
                break;
        }

        Button back = new Button("Back");

        back.setOnAction(e -> {
            DashboardView dash = new DashboardView(stage);
            dash.show();
        });

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(title, exercises, back);

        Scene scene = new Scene(layout,600,400);

        stage.setScene(scene);
    }
}