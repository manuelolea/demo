package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;

public abstract class ObjetJeux {private double x, y;

    public double getX() { return x; }
    public double getY() { return y; }

    public abstract void draw(GraphicsContext context, CameraJeu camera);
    public abstract void update();
}
