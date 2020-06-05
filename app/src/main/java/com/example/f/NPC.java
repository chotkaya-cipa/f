package com.example.f;

import android.content.res.Resources;

public class NPC extends  Game_object {

    public NPC(Resources res, int id, int collider_id) {
        super(res, id, collider_id);
        interactive=true;
        return;
    }


    public boolean onAction(Game_object target){
        Graphic_system.dialogue.hide=!Graphic_system.dialogue.hide;
        target.MD.active=!target.MD.active;
        this.MD.active=!MD.active;
        if(target==Graphic_system.player)
        {
            if(Graphic_system.camera.focus==Graphic_system.player.pt)
            {
                Graphic_system.dialogue.setText("звуки " + name);
                Graphic_system.camera.setFocus(this.pt);
            }
            else
            {
                Graphic_system.camera.setFocus(Graphic_system.player.pt);
            }
        }
        return false;
    }
}
