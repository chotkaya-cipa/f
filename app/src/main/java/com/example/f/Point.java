package com.example.f;

public class Point {
    public boolean inert = true;
    public float delta_damping = 0;
    public float delta_magnitude = 1;

    public float x = 0, y = 0;
    public float dx = 0, dy = 0;
    public float nextdx = 0, nextdy = 0;
    public boolean delta(){
        return dx!=0 || dy!=0;
    }

    public void set(float x, float y){
        this.x=x;
        this.y=y;
        return;
    }
    public void set(Point pt){
        set(pt.x, pt.y);
        return;
    }


    public void add(float dx, float dy){
        this.dx+=dx*speed;
        this.dy+=dy*speed;
        return;
    }
    public void add(float dx, float dy, float speed) {
        this.dx+=dx*speed;
        this.dy+=dy*speed;
        return;
    }


    public boolean update() {
        x+=dx*delta_magnitude;
        y+=dy*delta_magnitude;
        boolean res = dx!=0 || dy!=0;
        dx=nextdx + dx*delta_damping;
        dy=nextdy + dy*delta_damping;
        nextdx=0;
        nextdy=0;
        return res;
    }


    public float speed = 1;
    public boolean go(Point pt){
        float dx=pt.x-x, dy=pt.y-y;
        float r = (float)Math.sqrt(dx*dx+dy*dy);
        if(r<speed)
        {
            set(pt);
            return false;
        }
        dx*=speed/r;
        dy*=speed/r;
        add(dx, dy);
        return dx!=0 || dy!=0;
    }


    public float distance(Point pt){
        return distance(this, pt);
    }
    public static float distance(Point p1, Point p2){
        return (float)Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
    }


    public boolean equals(Point pt, float precision) {
        if(Math.abs(x-pt.x)>precision)
            return false;
        if(Math.abs(y-pt.y)>precision)
            return false;
        return true;
    }

    public Point(Point pt) {
        this(pt.x, pt.y);
        return;
    }
    public Point(float x, float y){
        this.x=x;
        this.y=y;
        return;
    }
    public Point(){
        x=0;
        y=0;
        return;
    }
}
