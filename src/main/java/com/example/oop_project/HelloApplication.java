package com.example.oop_project;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloApplication extends Application {

    @Override

    public void start(Stage primaryStage) {


        Rectangle rect = new Rectangle(80, 60, Color.RED);

        PathElement[] path = {
                new MoveTo(0, 300),
                new ArcTo(100, 100, 0, 100, 400, false, false),
                new LineTo(300, 400),
                new ArcTo(100, 100, 0, 400, 300, false, false),
                new LineTo(400, 100),
                new ArcTo(100, 100, 0, 300, 0, false, false),
                new LineTo(100, 0),
                new ArcTo(100, 100, 0, 0, 100, false, false),
                new LineTo(0, 100),
                new ClosePath()
        };

        Path road = new Path();
        road.setStroke(Color.BLACK);
        road.setStrokeWidth(80);
        road.getElements().addAll(path);

        Path divider = new Path();
        divider.setStroke(Color.WHITE);
        divider.setStrokeWidth(4);
        divider.getStrokeDashArray().addAll(11.0, 20.0);
        divider.getElements().addAll(path);

        PathTransition anim = new PathTransition();
        anim.setNode(rect);
        anim.setPath(road);
        anim.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        anim.setInterpolator(Interpolator.LINEAR);
        anim.setDuration(new Duration(6000));
        anim.setCycleCount(Timeline.INDEFINITE);

        Group root = new Group();
        root.getChildren().addAll(road, divider, rect);
        root.setTranslateX(50);
        root.setTranslateY(50);
        anim.play();
        Scene scene = new Scene(root, 500, 500, Color.WHITE);

        primaryStage.setTitle("Traffic car");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}