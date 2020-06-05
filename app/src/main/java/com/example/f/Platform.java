package com.example.f;

import android.content.res.Resources;

public class Platform extends Area {

    public Platform(Resources res, int id, int collider_id) {
        super(res, id, collider_id);
    }


    public boolean onCollision(Game_object target) {
        target.pt.nextdx+=pt.dx;
        target.pt.nextdy+=pt.dy;
        return true;
    }

}
