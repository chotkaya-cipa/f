package com.example.f;

import android.content.res.Resources;

public class Camera extends Game_object {

    public Point focus=null;
    public Camera(Resources res, int id){
        super(res, id, -1);
    }


    public void setFocus(Point target){
        focus=target;
        return;
    }
    public boolean update() {
        if(focus==null)
            return false;
        if(pt.distance(focus)<pt.speed*2)
        {
            pt.set(focus);
            return true;
        }
        pt.go(focus);
        pt.update();
        return true;
    }
}
