package com.fitlog.fitlogai.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import com.fitlog.fitlogai.model.ProgressData;

public class DashboardView {

    private Stage stage;
    private BorderPane root;
    private ArrayList<ProgressData> progressHistory = new ArrayList<>();

    public DashboardView(Stage stage) {
        this.stage = stage;
    }

    public void show() {

        root = new BorderPane();

        VBox menu = new VBox(15);
        menu.setPadding(new Insets(20));
        menu.setStyle("-fx-background-color: #2c3e50;");
        menu.setPrefWidth(200);

        Button dashboardBtn = new Button("Dashboard");
        Button routinesBtn = new Button("Routines");
        Button progressBtn = new Button("Progress");
        Button logoutBtn = new Button("Logout");

        dashboardBtn.setMaxWidth(Double.MAX_VALUE);
        routinesBtn.setMaxWidth(Double.MAX_VALUE);
        progressBtn.setMaxWidth(Double.MAX_VALUE);
        logoutBtn.setMaxWidth(Double.MAX_VALUE);

        menu.getChildren().addAll(dashboardBtn, routinesBtn, progressBtn, logoutBtn);

        root.setLeft(menu);

        // PANTALLA INICIAL
        showDashboard();

        // EVENTOS BOTONES
        dashboardBtn.setOnAction(e -> showDashboard());
        routinesBtn.setOnAction(e -> showRoutines());
        progressBtn.setOnAction(e -> showProgress());
        logoutBtn.setOnAction(e -> {
            LoginView login = new LoginView(stage);
            login.show();
        });

        Scene scene = new Scene(root, 900, 600);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        stage.setTitle("FitLog AI - Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    // DASHBOARD
    private void showDashboard() {

        Label title = new Label("Training Planner");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        DatePicker calendar = new DatePicker();

        Label routineLabel = new Label("Routine for selected day:");
        routineLabel.setStyle("-fx-font-size: 18px;");

        Label routine = new Label("Select a date to see your workout.");

        calendar.setOnAction(e -> {

            int day = calendar.getValue().getDayOfWeek().getValue();

            switch(day) {
                case 1:
                    routine.setText("Chest & Triceps Day");
                    break;
                case 2:
                    routine.setText("Back & Biceps Day");
                    break;
                case 3:
                    routine.setText("Leg Day");
                    break;
                case 4:
                    routine.setText("Shoulders");
                    break;
                case 5:
                    routine.setText("Cardio & Abs");
                    break;
                case 6:
                    routine.setText("Light Cardio / Recovery");
                    break;
                case 7:
                    routine.setText("Rest Day");
                    break;
            }

        });

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(
                title,
                calendar,
                routineLabel,
                routine
        );

        root.setCenter(layout);
    }

    // RUTINAS
    private void showRoutines() {

        Label title = new Label("Your Training Routines");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        ListView<String> routines = new ListView<>();

        routines.getItems().addAll(
                "Chest Day",
                "Leg Day",
                "Back & Biceps",
                "Shoulders",
                "Cardio"
        );

        routines.setOnMouseClicked(e -> {

            String selected = routines.getSelectionModel().getSelectedItem();

            if(selected != null){
                RoutineDetailView detail = new RoutineDetailView(stage, selected);
                detail.show();
            }

        });

        VBox layout = new VBox(20);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(title, routines);

        root.setCenter(layout);
    }

    // PROGRESO
    private void showProgress(){

     Label title = new Label("Progress Tracker");
     title.setStyle("-fx-font-size:20px; -fx-font-weight:bold;");

     TextField weight = new TextField();
     weight.setPromptText("Weight (kg)");

     TextField height = new TextField();
     height.setPromptText("Height (cm)");

     TextField bodyfat = new TextField();
     bodyfat.setPromptText("Body Fat %");

     Button save = new Button("Save Monthly Progress");

     Label bmiLabel = new Label();
     Label differenceLabel = new Label();

     save.setOnAction(e -> {

         double w = Double.parseDouble(weight.getText());
         double h = Double.parseDouble(height.getText());
         double bf = Double.parseDouble(bodyfat.getText());

         double bmi = w / Math.pow(h/100,2);

         bmiLabel.setText("BMI: " + String.format("%.2f", bmi));

         String currentMonth = LocalDate.now().getMonth().toString();

         ProgressData newData = new ProgressData(w,h,bf,currentMonth);

         if(progressHistory.size() > 0){

             ProgressData last = progressHistory.get(progressHistory.size()-1);

             double weightDiff = w - last.getWeight();
             double fatDiff = bf - last.getBodyFat();

             differenceLabel.setText(
                 "Change since last month → Weight: "
                 + weightDiff + " kg | Body Fat: "
                 + fatDiff + " %"
             );

         }

         progressHistory.add(newData);

     });

     VBox layout = new VBox(15);
     layout.setAlignment(Pos.CENTER);

     layout.getChildren().addAll(
             title,
             weight,
             height,
             bodyfat,
             save,
             bmiLabel,
             differenceLabel
     );

     root.setCenter(layout);
    }
}