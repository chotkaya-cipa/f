package com.example.f;

public class Motion_drive {

    public boolean active = true;
    public Point p1 = new Point();
    public Point p2 = new Point();

    public enum Motion_direction {
        MD_static,
        MD_directive,
        MD_round,
        MD_patrol,
        MD_avoid,
        MD_related,
        MD_controller
    }
    public Motion_direction MD_type = Motion_direction.MD_static;


    public boolean targeting = true;
    public Game_object obj, target;
    public void set(Motion_direction type, Game_object obj, Point pt, float radius) {
        this.obj=obj;
        MD_type=type;
        p1.set(pt);
        this.radius=radius;
        targeting=false;
        return;
    }
    public void set(Motion_direction type, Game_object obj, Point p1, Point p2) {
        this.obj=obj;
        MD_type=type;
        this.p1.set(p1);
        this.p2.set(p2);
        targeting=false;
        return;
    }
    public void set(Motion_direction type, Game_object obj){
        targeting=false;
        MD_type=type;
        this.obj=obj;
        return;
    }


    public float radius=0, angle=0;
    public boolean MDP_reverse = false;


    public boolean update() {
        if(!active)
            return false;
        switch(MD_type)
        {
            case MD_directive:
                return MD_directive_update();
            case MD_round:
                return MD_round_update();
            case MD_patrol:
                return MD_patrol_update();
            case MD_avoid:
                return MD_avoid_update();
            case MD_related:
                return MD_related_update();
            case MD_controller:
                return MD_controller_update();
            case MD_static:
            default:
                return false;
        }
    }
    public boolean MD_directive_update() {
        Point pt = p1;
        if(targeting)
            pt=target.pt;
        if(obj.pt.distance(pt)<radius)
            return false;
        return obj.pt.go(pt);
    }
    public boolean MD_round_update() {
        if(obj.pt.equals(p2, obj.pt.speed))
            angle+=obj.pt.speed/radius;
        p2.set(p1);
        if(targeting)
            p2.set(target.pt);
        p2.x+=radius*Math.cos(angle);
        p2.y+=radius*Math.sin(angle);
        return obj.pt.go(p2);
    }
    public boolean MD_patrol_update() {

        Point pt = p1;
        if(MDP_reverse)
            pt=p2;
        if(obj.pt.go(pt))
            return true;
        MDP_reverse=!MDP_reverse;
        return false;
    }
    public boolean MD_avoid_update() {

        if(obj.pt.distance(target.pt) > radius)
            return false;
        Point pt = obj.pt;
        pt.go(target.pt);
        obj.pt.add(-pt.dx * 2, -pt.dy * 2);
        return pt.dx!=0 || pt.dy!=0;
    }
    public boolean MD_related_update(){
        if(!targeting)
            return false;
        float dx, dy;
        dx=p1.x+(target.pt.x-obj.pt.x);
        dy=p1.y+(target.pt.y-obj.pt.y);
        obj.pt.add(dx, dy, 1);
        return dx!=0 || dy!=0;
    }
    public boolean MD_controller_update(){
        obj.pt.add(Graphic_system.dx, Graphic_system.dy);
        return Graphic_system.dx!=0 || Graphic_system.dy!=0;
    }
}
