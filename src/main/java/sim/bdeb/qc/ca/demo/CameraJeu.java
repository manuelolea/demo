package sim.bdeb.qc.ca.demo;

import javafx.scene.canvas.GraphicsContext;

public class CameraJeu{
private double positionX;
private double positionY;
private double longeureEcran;
private double hauteureEcran;

    public CameraJeu(double positionX, double positionY, double longeureEcran, double hauteureEcran) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.longeureEcran = longeureEcran;
        this.hauteureEcran = hauteureEcran;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public double getLongeureEcran() {
        return longeureEcran;
    }

    public double getHauteureEcran() {
        return hauteureEcran;
    }
}
