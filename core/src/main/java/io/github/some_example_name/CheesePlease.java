package io.github.some_example_name;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.IntMap;

public class CheesePlease extends Game {
    private SpriteBatch spriteBatch;
    private Sprite MouseSprite;
    private float MouseX;
    private float MouseY;

    private Sprite CheeseSprite;
    private float CheeseX;
    private float CheeseY;
    private boolean win;
    private Sprite winTextSprite;

    private Sprite FloorSprite;

    @Override
    public void render() {
        if(Gdx.input.isTouched()){
            MouseSprite.translateX(1);
            MouseSprite.translateY(1);

        }

        Rectangle cheeseRectangle=CheeseSprite.getBoundingRectangle();
        Rectangle mouseReactangle=MouseSprite.getBoundingRectangle();

        if(cheeseRectangle.contains(mouseReactangle)){
            win=true;
        }

        Gdx.gl.glClearColor(0.8f, 0.8f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        FloorSprite.draw(spriteBatch);
        CheeseSprite.draw(spriteBatch);
        MouseSprite.draw(spriteBatch);

        if(win){
            winTextSprite.draw(spriteBatch);
        }
        spriteBatch.end();
    }

    @Override
    public void create() {
        spriteBatch=new SpriteBatch();
        MouseSprite=new Sprite(new Texture(Gdx.files.internal("Mouse.png")));
        MouseSprite.setPosition(20,20);

        CheeseSprite=new Sprite(new Texture(Gdx.files.internal("cheese.png")));
        CheeseSprite.setPosition(200,200);

        FloorSprite=new Sprite(new Texture(Gdx.files.internal("tiles.png")));
        winTextSprite=new Sprite(new Texture(Gdx.files.internal("winner.png")));
        winTextSprite.setPosition(600,600);
        win =false;
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
    }
}
