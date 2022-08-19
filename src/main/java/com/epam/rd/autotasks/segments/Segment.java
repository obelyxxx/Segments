package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {

    public Point start;
    public Point end;

    public Segment(Point start, Point end) {
        this.start = start;
        this.end = end;
        if(start.getX() == end.getX() && start.getY() == end.getY()){
            throw  new IllegalArgumentException();
        }
    }

     double length() {
        double result = sqrt((end.getX()-start.getX())*(end.getX()-start.getX()) + (end.getY()-start.getY())*(end.getY()-start.getY()));
return result;
    }

    Point middle() {
        double MiddleX =  (start.getX()+end.getX())/2;
        double MiddleY = (start.getY()+end.getY())/2;
                 return new Point(MiddleX, MiddleY);
    }

    Point intersection(Segment another) {
Segment segment = null;

double x3 = another.start.getX();
double x4 = another.end.getX();
double y3 = another.start.getY();
double y4 = another.end.getY();

double t =((start.getX()-x3)*(y3-y4)-(start.getY()-y3)*(x3-x4))  /  ((start.getX()-end.getX())*(y3-y4)-(start.getY()- end.getY())*(x3-x4));
double u = ((start.getX()-x3)*(start.getY()-end.getY())-(start.getY()-y3)*(start.getX()-end.getX())) /   ((start.getX()-end.getX())*(y3-y4)-(start.getY()- end.getY())*(x3-x4));

if(t>=0 && t<=1 && u>=0 && u<=1){
    double pX = start.getX()+(t*(end.getX()-start.getX()));
    double pY = start.getY()+(t*(end.getY()-start.getY()));

    Point point = new Point(pX, pY);

    return point;
}

return  null;
    }

}
