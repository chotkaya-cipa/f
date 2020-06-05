package com.example.f;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

import static android.content.Context.AUDIO_SERVICE;
import static com.example.f.Graphic_system.player;

public class NPC_Enchelatti extends NPC {

    public NPC_Enchelatti(Resources res, Context context){
        super(res, R.drawable.enchelatti, R.drawable.enchelatti_collider);
        name="Enchelatti";
        //scream = MediaPlayer.create(context, R.raw.scream);
        aaa = new SoundPool(10, AudioManager.STREAM_MUSIC,0);
        soundID1 = aaa.load(context, R.raw.scream, 1);
        soundID2 = aaa.load(context, R.raw.starichok1, 1);
        AudioManager audioManager=(AudioManager) context.getSystemService(AUDIO_SERVICE);
        float actualVolume=(float) audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume=(float) audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        volume= actualVolume/ maxVolume;
        return;
    }


    public int phase = 0;
    //public MediaPlayer scream;
    public SoundPool aaa;
    public int soundID1, soundID2;
    public float volume;
    public float r;
    public boolean onAction(Game_object target) {

        phase++;
        if(phase==1)
        {
            this.MD.active=false;
            target.MD.active=false;
            r = Point.distance(player.pt, pt);
            //scream.start();
            aaa.play(soundID1, 1, 10/r, 1, 0, 1f);

            //aaa.play(soundID2, volume/10, volume, 1, 0, 1f);
            Graphic_system.camera.setFocus(this.pt);
            Graphic_system.dialogue.setLongText("AAAAAAAAAAAAAAAA_AAAAAAAAAAAAAAAAAAAAAAAAAAAAA!", 1);
            Graphic_system.dialogue.hide=false;
        }
        if(Graphic_system.dialogue.finish)
        {
            this.MD.active=true;
            target.MD.active=true;
            phase=0;
            aaa.autoPause();
            //scream.pause();
            //scream.seekTo(0);
            Graphic_system.camera.setFocus(player.pt);
            Graphic_system.dialogue.hide=true;
        }
        Graphic_system.dialogue.next();

        return false;
    }
}
