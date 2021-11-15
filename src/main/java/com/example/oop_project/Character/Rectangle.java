package com.example.oop_project.Character;

import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends Shape {
    private final int x;
    private final int y;

    public Rectangle (int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.fillRect(x - size / 2, y - size / 2, size, size);

    }
}
