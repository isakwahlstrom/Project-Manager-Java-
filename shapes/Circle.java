package se.kth.isakwah.labb3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends FillableShape {
    private double diameter;

    public Circle(double x, double y, Color color, double diameter) {
        super(10,10,color);
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
        //super.constrain(boxX,boxY,boxWidth,boxHeight);
        if (getX()  < boxX || diameter < boxX) {
            setVelocity(getDx(),getDy());
        } else if (getX()  > boxWidth || diameter > boxWidth ) {
            setVelocity((-1)*getDx(),getDy());
        }
        if (getY()< boxY || diameter < boxY) {
            setVelocity(getDx(),getDy());
        } else if (getY()  > boxHeight || diameter > boxHeight) {
            setVelocity(getDx(),(-1)*getDy());
        }
    }

    @Override
    public String toString() {
        return super.toString() +
                "diameter=" + diameter +
                '}';
    }

    @Override
    public void paint(GraphicsContext gc) {
        gc.setStroke(getColor());
        gc.strokeOval(getX(),getY(),getDiameter(),getDiameter());
    }

}
