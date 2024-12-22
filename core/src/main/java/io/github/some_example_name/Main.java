        package io.github.some_example_name;

        import com.badlogic.gdx.ApplicationAdapter;
        import com.badlogic.gdx.Gdx;
        import com.badlogic.gdx.graphics.GL20;
        import com.badlogic.gdx.graphics.Texture;
        import com.badlogic.gdx.graphics.g2d.SpriteBatch;
        import com.badlogic.gdx.utils.ScreenUtils;

        /** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
        public class Main extends ApplicationAdapter {
            private SpriteBatch batch;
            private Texture image;
            private CheesePlease cheesePlease;

            @Override
            public void create() {
                cheesePlease=new CheesePlease();
                batch = new SpriteBatch();
               cheesePlease.create();
            }

            @Override
            public void render() {
                cheesePlease.render();
            }

            @Override
            public void dispose() {
                cheesePlease.render();
            }
        }
