package com.example.f;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.HashSet;


public class Object_system {
    Paint paint;


    public HashSet<Game_object> objects = new HashSet();


    public void render_objects(int layer, Canvas canvas, float x, float y){

        int n=0;
        for(Game_object obj: objects)
            if(obj.layer==layer)
                n++;
        int i=0;
        Game_object onlayer[] = new Game_object[n];
        for(Game_object obj: objects)
            if(obj.layer==layer)
                onlayer[i++]=obj;

        Game_object temp;
        for(i=0; i<n; i++)
            for(int k=i; k<n; k++)
                if(onlayer[k].pt.y+onlayer[k].h<onlayer[i].pt.y+onlayer[i].h)
                {
                    temp=onlayer[i];
                    onlayer[i]=onlayer[k];
                    onlayer[k]=temp;
                }
        for(i=0; i<n; i++)
            onlayer[i].render(canvas, paint, x, y);
        return;
    }
    public void render_objects(int layer1, int layer2, Canvas canvas, float x, float y) {
        for(int layer=layer1; layer<=layer2; layer++)
            render_objects(layer, canvas, x, y);
        return;
    }
    public void render_objects(Canvas canvas, float x, float y) {
        int layer1=0, layer2=0;
        for(Game_object obj: objects)
        {
            if(obj.layer<layer1)
                layer1=obj.layer;
            if(obj.layer>layer2)
                layer2=obj.layer;
        }
        render_objects(layer1, layer2, canvas, x, y);
        return;
    }


    public float t1, t2, t3, t4;
    public float action_distance(Game_object obj, Game_object target){

        float x=obj.pt.x+obj.w/2, y=obj.pt.y+obj.h/2;
        t1=x-(target.pt.x-target.action_radius);
        t2=y-(target.pt.y-target.action_radius);
        t3=(target.pt.x+target.action_radius+target.w)-x;
        t4=(target.pt.y+target.action_radius+target.h)-y;

        if(t1<0 || t2<0 || t3<0 || t4<0)
            return Float.MAX_VALUE;
        if(t2<t1)
            t1=t2;
        if(t3<t1)
            t1=t3;
        if(t4<t1)
            t1=t4;
        return t1;
    }

    public Game_object closest_target(Game_object obj){
        float min = Float.MAX_VALUE, temp;
        Game_object res = null;
        for(Game_object target: objects)
        {
            if(!target.interactive)
                continue;
            if(target==obj)
                continue;
            temp=action_distance(obj, target);
            if(temp<min && temp<=target.action_radius)
            {
                min=temp;
                res=target;
            }
        }
        return res;
    }
    public boolean dispatch_action(Game_object obj) {
        Game_object target = closest_target(obj);
        if(target==null)
            return false;
        target.onAction(obj);
        return true;
    }


    public void update_motions(){
        for(Game_object obj: objects)
        {
            obj.MD.update();
            dispatch_collisions(obj);
        }
        for(Game_object obj: objects)
            obj.update();
        return;
    }


    public int dispatch_collisions(Game_object obj){
        int res=0;
        float dx1, dy1;
        for(Game_object target:objects)
            if(target.collision(obj) && target!=obj)
            {
                res++;
                dx1=obj.pt.dx;
                dy1=obj.pt.dy;
                if(obj.pt.inert)
                {
                    obj.pt.dx=target.pt.dx;
                    obj.pt.dy=target.pt.dy;
                }
                if(target.pt.inert)
                {
                    target.pt.dx=dx1;
                    target.pt.dy=dy1;
                }
            }
        return res;
    }


    public void add(Game_object obj) {
        objects.add(obj);
        return;
    }
}
