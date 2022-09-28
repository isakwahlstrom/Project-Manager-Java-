package se.kth.isakwah.labb3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends FillableShape {
    private double diameter;
    public Circle(double diameter) {
        super();
        this.diameter = diameter;
    }

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    @Override
    protected void constrain(
            double boxX, double boxY,
            double boxWidth, double boxHeight) {
        // If outside the box - calculate new dx and dy
        if (x < boxX) {
            dx = Math.abs(dx);
        } else if (x > boxWidth) {
            dx = -Math.abs(dx);
        }
        if (y < boxY) {
            dy = Math.abs(dy);
        } else if (y > boxHeight) {
            dy = -Math.abs(dy);
        }
    }

    @Override
    public void paint(GraphicsContext gc) {

    }

}
