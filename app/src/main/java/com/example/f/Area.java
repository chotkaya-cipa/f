package com.example.f;

import android.content.res.Resources;

public class Area extends Game_object {

    public Area(Resources res, int id, int collider_id) {
        super(res, id, collider_id);
        pt.inert=false;
        disable_collider=true;
    }


    public boolean onCollision(Game_object target) {
        if(target.pt.dy>0)
            target.pt.nextdy+=1;
        else
            target.pt.nextdy-=1;
        return true;
    }

}
