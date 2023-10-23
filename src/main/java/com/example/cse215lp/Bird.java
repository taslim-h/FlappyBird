package com.example.cse215lp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.util.Objects;

public class Bird extends Sprite {

    //private Sprite birdSprite;
    private Sprite birdSprite;
    public String filePath = "/com/example/cse215lp/bird1.png";


    public String getFilePath() {
        return filePath;
    }

    public Bird(GraphicsContext gc) {


        super(70, 200, 5, 5, 50, 45);
        //bird.setImage();
        // birdSprite.setPositionXY(positionX, positionY);

        //birdSprite.setGc(gc);
        //birdSprite.render();


    }

    public void update(){
      this.setPositionY(getPositionY() + getVelocityY());
    }
}
