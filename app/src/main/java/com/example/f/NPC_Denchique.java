package com.example.f;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class NPC_Denchique extends NPC {

    public NPC_Denchique(Resources res, Context context){
        super(res, R.drawable.denchique, R.drawable.denchique_collider);
        name="Denchique";
        mmm = MediaPlayer.create(context, R.raw.tastes_good);
        return;
    }

    public String text = " Я люблю курочка :D А ты любишь курочка? :D\n" +
                        " Курочка очень классная, вкусная, бодрящая :D\n" +
                        " Я бы сейчас съел курочка, пошли есть курочка :DDD";
    public int phase = 0;
    public int counter = 0;
    public MediaPlayer mmm;
    public boolean onAction(Game_object target) {
        phase++;
        if(phase==1)
        {
            this.MD.active=false;
            target.MD.active=false;

            mmm.start();
            Graphic_system.camera.setFocus(this.pt);
            Graphic_system.dialogue.setLongText(text);
            Graphic_system.dialogue.hide=false;
        }
        if(Graphic_system.dialogue.finish)
        {
            counter++;
            this.MD.active=true;
            target.MD.active=true;

            phase=0;
            mmm.pause();
            mmm.seekTo(0);
            Graphic_system.camera.setFocus(Graphic_system.player.pt);
            Graphic_system.dialogue.hide=true;
            if (counter == 1){
                text = "kykareku, mi kyrochka!!! :D:D:D";
                MD.set(Motion_drive.Motion_direction.MD_directive, this, new Point(500, 100), 20);
            }
            if (counter == 2){
                MD.set(Motion_drive.Motion_direction.MD_patrol, this, new Point(200, 200), new Point(400, 200));
            }

        }
        Graphic_system.dialogue.next();

        return true;
    }

    public boolean onCollision(Game_object target)
    {
        if(target == Graphic_system.stairs && counter == 1)
            hide=true;
        return false;
    }

}
