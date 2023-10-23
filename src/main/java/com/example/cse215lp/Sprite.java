package com.example.cse215lp;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.List;
import java.util.Objects;

public class Sprite {

    private Image image;
    //private String filePath;

    private double positionX;
    private double positionY;
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;

    private GraphicsContext gc;


    public Sprite() {
        this.positionX = 0;
        this.positionY = 0;
        this.velocityX = 0;
        this.velocityY = 0;

    }

    public Sprite(double positionX, double positionY, double velocityX, double velocityY, double width, double height) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.width = width;
        this.height = height;
        // this.image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(filePath)));

    }

    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }


    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setPositionXY(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }


    public double getPositionY() {
        return positionY;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }


    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public void setGc(GraphicsContext gc) {
        this.gc = gc;
    }


    public void setImage(Image image) {
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();

    }

    public void setImage(String filePath) {
        image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(filePath)));
    }

    public void setImage(List<Pipe> pipes) {
        for (Pipe pIpe : pipes) {
            pIpe.setImage(pIpe.getPipeFilePath());
        }
    }

    public void reseizeImage(String filepath, int width, int height) {
        Image toReturn = new Image(filepath, width, height, false, false);
        setImage(toReturn);
    }


    public void render() {
        //image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(filePath)));
        gc.drawImage(image, positionX, positionY, 50, 45);
    }

    public void render(GraphicsContext gc) {
        //image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(filePath)));
        this.gc = gc;
        gc.drawImage(image, positionX, positionY, 50, 45);
    }

    public void renderP(GraphicsContext gc) {
        //image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(filePath)));
        this.gc = gc;
        gc.drawImage(image, positionX, positionY, width, height);
    }


    public void render(List<Pipe> pipes, GraphicsContext gc) {
        // Render all the pipes
        //Pipe[] pipes;
        this.gc = gc;
        for (Pipe pipe : pipes) {
            pipe.renderP(this.gc); // gc is the GraphicsContext
        }
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(positionX, positionY, width, height);
    }

    public boolean intersectSprite(Sprite s) {
        return s.getBoundary().intersects(this.getBoundary());
    }

    public void addVelocity(double x, double y) {
        this.velocityX += x;
        this.velocityY += y;
    }

    public void update(double deltaTime) {
        positionX += velocityX * deltaTime;
        positionY += velocityY * deltaTime;
    }

}
