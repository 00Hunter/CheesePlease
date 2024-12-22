package io.github.some_example_name;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.IntMap;

public class CheesePlease extends Game {
    private SpriteBatch spriteBatch;
    private Texture MouseTexture;
    private float MouseX;
    private float MouseY;

    private Texture CheeseTexture;
    private float CheeseX;
    private float CheeseY;

    private Texture FloorTexture;

    @Override
    public void render() {
        if(Gdx.input.isTouched()){
        MouseX++;
        MouseY++;
        }

        Gdx.gl.glClearColor(0.8f, 0.8f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        spriteBatch.begin();
        spriteBatch.draw(FloorTexture,0,0);
        spriteBatch.draw(MouseTexture,MouseX,MouseY);
        spriteBatch.draw(CheeseTexture,CheeseX,CheeseY);
        spriteBatch.end();
    }

    @Override
    public void create() {
        spriteBatch=new SpriteBatch();
        MouseTexture=new Texture(Gdx.files.internal("Mouse.png"));
        MouseX=20;
        MouseY=20;

        CheeseTexture=new Texture(Gdx.files.internal("cheese.png"));
        CheeseX=400;
        CheeseY=400;

        FloorTexture=new Texture(Gdx.files.internal("tiles.png"));

    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        MouseTexture.dispose();
        CheeseTexture.dispose();
        FloorTexture.dispose();
    }
}
