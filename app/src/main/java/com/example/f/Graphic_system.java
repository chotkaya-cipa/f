package com.example.f;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.TextView;


public class Graphic_system extends View {
    public static TextView no_sex;
    public static Paint paint = new Paint();

    public static int w, h;
    public static int scale = 2;

    public static float x=0, y=0;
    public static int dx=0, dy=0, act=0, prevact=0;

    public Game_map background = new Game_map(getResources(), R.drawable.map1, R.drawable.map1_collider);
    public NPC_Enchelatti enchelatti = new NPC_Enchelatti(getResources(), getContext());
    public NPC_Denchique denchique = new NPC_Denchique(getResources(), getContext());
    public NPC bob = new NPC(getResources(), R.drawable.bob, R.drawable.bob_collider);

    public Label label = new Label(getResources(), R.drawable.textbox);


    public static Label dialogue;
    public static Camera camera;
    public static Player player;
    public static Platform stairs;
    public boolean reloaded = false;


    MediaPlayer mp = MediaPlayer.create(getContext(), R.raw.scream);
    Object_system objects = new Object_system();


    public int bgColor = Color.rgb(0,0,0);
    public void update(Canvas canvas) {
        canvas.translate(w/2, h/2);
        int w = Graphic_system.w/scale/2, h=Graphic_system.h/scale/2;
        canvas.scale(scale, scale);
        canvas.drawColor(bgColor);


        objects.update_motions();

        if(act==1 && prevact==0)
            objects.dispatch_action(player);


        camera.update();
        x=camera.pt.x;
        y=camera.pt.y;
        objects.render_objects(canvas, x, y);
        dialogue.render(canvas, paint, dialogue.w/2, dialogue.h-h);

        //
        if(!reloaded && player.pt.equals(stairs.pt, 20)) {

            objects.objects.remove(stairs);

            player.pt.set(background.w/2-player.w, background.h/2-player.h);
            camera.pt.set(player.pt);
            test_map();
            reloaded = true;
        }

        if(denchique.inRect(stairs.pt.x, stairs.pt.y, stairs.pt.x+stairs.w, stairs.pt.y+stairs.h) &&  denchique.counter==1)
            denchique.hide=true;
        //

        //no_sex.setText(String.valueOf(dialogue.cur)+" "+String.valueOf(dialogue.start));

        prevact=act;

        return;
    }

    public Graphic_system(Context context) {
        super(context);
        dialogue = new Label(getResources(), R.drawable.textbox);
        camera = new Camera(getResources(), -1);
        player = new Player(getResources(), R.drawable.chad, R.drawable.chad_collider);
        stairs = new Platform(getResources(), R.drawable.stairs, -1);

        player.pt.set(background.w/2, background.h/2);
        player.MD.set(Motion_drive.Motion_direction.MD_controller, player);
        player.pt.speed=4;


        camera.setFocus(player.pt);
        camera.pt.speed=player.pt.speed;


        dialogue.setBorder(8, 8, 10,  8);
        dialogue.setFontSize(2);
        dialogue.setText("");
        dialogue.layer=4;
        dialogue.hide=true;


        denchique.name="denchique";
        denchique.pt.set(300, 100); //300, 100
        denchique.pt.inert=false;


        stairs.hide = true;
        stairs.pt.set(background.w - stairs.w/2, background.h/2 - stairs.h/2);


        bob.name="bob";
        int[] ids={R.drawable.bob1, R.drawable.bob2, R.drawable.bob3};
        bob.load_animation(getResources(), ids, R.drawable.bob_collider);
        bob.animation_period = 10;


        bob.pt.inert=false;
        bob.pt.set(50, 100);


        background.pt.inert=false;
        background.layer=0;


        objects.add(background);
        objects.add(denchique);
        objects.add(bob);
        objects.add(player);
        objects.add(stairs);


        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        objects.paint=paint;
        return;
    }

    public void test_map() {
        background.load(getResources(), R.drawable.test_map, R.drawable.test_map);

        denchique.hide=false;

        enchelatti.name="enchelatti";
        enchelatti.pt.set(300, 400);


        label.pt.set(background.w/2 + 150, background.h/2);
        label.setBorder(10, 5, 20, 10);
        label.setFontSize(2);
        label.setText("Я думал ты туда вставишь цитату. (С) Сергей");

        objects.add(label);
        objects.add(enchelatti);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        update(canvas);
        invalidate();
    }

}
