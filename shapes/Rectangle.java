package se.kth.isakwah.labb3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Rectangle extends FillableShape{

    private double width, height;

    public Rectangle(double x, double y, double widht, double height, Color color) {
        super(x, y, color);
        this.width = widht;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void paint(GraphicsContext gc) {
        gc.setStroke(getColor());
        gc.strokeRect(getX(),getY(), getHeight(), getWidth());
    }

    @Override
    public void constrain(double boxX, double boxY, double boxWidth, double boxHeight) {
        // If outside the box - calculate new dx and dy
        super.constrain(boxX,boxY,boxWidth,boxHeight);
        if (getX() < boxX) {
            setVelocity(getDx(),getDy());
        } else if (getX() > boxWidth) {
            setVelocity((-1)*getDx(),getDy());
        }
        if (getY() < boxY) {
            setVelocity(getDx(),getDy());
        } else if (getY() > boxHeight) {
            setVelocity(getDx(),(-1)*getDy());
        }
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
