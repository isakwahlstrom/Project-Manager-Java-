package se.kth.isakwah.labb3.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape {
    private double x2,y2;

    public Line(double x, double y, double x2, double y2, Color color) {
        super(x,y,color);
        this.x2 = x2;
        this.y2 = y2;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public Line(){
        super(0,0, Color.BLACK);
        this.x2=100;
        this.y2=100;
    }
    @Override
    public void move(long elapsedTimeNs) {
        super.move(elapsedTimeNs);
        x2 += getDx() * elapsedTimeNs / BILLION;
        y2 += getDy() * elapsedTimeNs / BILLION;
    }
    @Override
    public void paint(GraphicsContext gc) {
        gc.setStroke(getColor());
        gc.strokeLine(getX(),getY(),x2,y2);
    }

    @Override
    public String toString() {
        return super.toString() +
                "x2=" + x2 +
                ", y2=" + y2 + " ";
    }
}
