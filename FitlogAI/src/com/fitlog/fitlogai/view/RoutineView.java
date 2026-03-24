package com.fitlog.fitlogai.view;

import com.fitlog.fitlogai.model.Routine;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class RoutineView {

    private List<Routine> routines = new ArrayList<>();
    private ListView<Routine> list = new ListView<>();

    public void show(Stage stage){

        TextField name = new TextField();
        name.setPromptText("Routine name");

        Button add = new Button("Add Routine");
        Button delete = new Button("Delete");

        add.setOnAction(e -> {

            Routine r = new Routine(name.getText());

            routines.add(r);
            refresh();

        });

        delete.setOnAction(e -> {

            Routine r = list.getSelectionModel().getSelectedItem();

            if(r != null){
                routines.remove(r);
                refresh();
            }

        });

        refresh();

        VBox root = new VBox(10,name,add,delete,list);

        stage.setScene(new Scene(root,400,400));
        stage.setTitle("Routines");
        stage.show();
    }

    private void refresh(){

        list.setItems(FXCollections.observableArrayList(routines));

    }
}