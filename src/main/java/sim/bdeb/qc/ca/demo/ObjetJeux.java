package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;

public abstract class ObjetJeux {
    public abstract void draw(GraphicsContext context, CameraJeu camera);
    public abstract void update();
}
