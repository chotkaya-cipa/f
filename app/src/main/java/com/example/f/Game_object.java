package com.example.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


public abstract class Game_object
{
    public String name = "no sex";
    public Bitmap bmp, collider;
    public int layer = 1;
    public int z=1;
    public int w = 0, h = 0;
    public boolean hide = false;


    public int collider_color = Color.BLACK;
    public void load(Resources res, int id, int collider_id) {
        if(id!=-1)
        {
            bmp = BitmapFactory.decodeResource(res, id).copy(Bitmap.Config.ARGB_8888, true);
            w=bmp.getWidth();
            h=bmp.getHeight();
        }
        else
        {
            bmp=null;
            w=0;
            h=0;
        }
        if(collider_id!=-1)
            collider = BitmapFactory.decodeResource(res, collider_id).copy(Bitmap.Config.ARGB_8888, true);
        else collider=null;
        return;
    }
    public Game_object(Resources res, int id, int collider_id) {
        load(res, id, collider_id);
        return;
    }


    public int animation_period = 1;
    public int animation_timer = 0;
    public Bitmap[] film;
    public void load_animation(Resources res, int[] ids, int collider_id) {
        film = new Bitmap[ids.length];
        for(int i=0; i<ids.length; i++)
            film[i] = BitmapFactory.decodeResource(res, ids[i]).copy(Bitmap.Config.ARGB_8888, true);
        if(collider_id!=-1)
            collider=BitmapFactory.decodeResource(res, collider_id).copy(Bitmap.Config.ARGB_8888, true);
        else collider=null;
        return;
    }


    Motion_drive MD = new Motion_drive();
    public Point pt = new Point();

    public boolean update(){
        pt.update();
        if(pt.dx<0)
            onLeftMove();
        if(pt.dx>0)
            onRightMove();
        if(pt.dy<0)
            onUpMove();
        if(pt.dy>0)
            onDownMove();
        if(pt.delta())
            return true;
        whileStay();
        return false;
    }
    public boolean onLeftMove(){
        return false;
    }
    public boolean onUpMove(){
        return false;
    }
    public boolean onRightMove(){
        return false;
    }
    public boolean onDownMove(){
        return false;
    }
    public boolean whileStay(){
        return false;
    }


    public boolean disable_collider = false;

    public boolean inRect(float x1, float y1, float x2, float y2) {
        x1-=pt.x+pt.dx;
        x2-=pt.x+pt.dx;
        y1-=pt.y+pt.dy;
        y2-=pt.y+pt.dy;
        if(x1<0)
            x1=0;
        if(x2>=w)
            x2=w-1;
        if(y1<0)
            y1=0;
        if(y2>=h)
            y2=h-1;
        return (x2-x1)>0 && (y2-y1)>0;
    }
    public boolean collision(float x1, float y1, float x2, float y2) {
        if(collider==null)
            return inRect(x1, y1, x2, y2);
        x1-=pt.x+pt.dx;
        x2-=pt.x+pt.dx;
        y1-=pt.y+pt.dy;
        y2-=pt.y+pt.dy;
        if(x1<0)
            x1=0;
        if(x2>=w)
            x2=w-1;
        if(y1<0)
            y1=0;
        if(y2>=h)
            y2=h-1;
        for(float xx=x1; xx<x2; xx++)
            for(float yy=y1; yy<y2; yy++)
                if(collider.getPixel((int)xx, (int)yy)==collider_color)
                    return true;
        return false;
    }
    public boolean collision(Game_object target) {
        if(target.disable_collider)
            return false;
        if(collision(
                target.pt.x + target.pt.dx, target.pt.y + target.h - 20 + target.pt.dy,
                target.pt.x+target.w + target.pt.dx, target.pt.y+target.h + target.pt.dy))
        {
            onCollision(target);
            return !disable_collider;
        }
        return false;
    }


    public boolean onCollision(Game_object target) {
        return false;
    }

    public boolean interactive=false;
    public float action_radius = 30;
    public boolean onAction(Game_object target){ return false; }


    public boolean render(Canvas canvas, Paint paint, float x0, float y0) {
        if (hide)
            return false;
        animation_timer=(1 + animation_timer) % Integer.MAX_VALUE;
        canvas.drawRect((pt.x - x0 - action_radius), (pt.y - y0 - action_radius), (pt.x - x0 + w + action_radius), (pt.y - y0 + h + action_radius), paint);


        if(film==null)
        {
            canvas.drawBitmap(bmp, (int)(pt.x - x0), (int)(pt.y - y0), paint);
            return true;
        }
        if (bmp != null)
        {
            canvas.drawBitmap(film[(animation_timer / animation_period) % film.length], (int)(pt.x - x0), (int)(pt.y - y0), paint);
            return true;
        }
        return false;
    }


}
