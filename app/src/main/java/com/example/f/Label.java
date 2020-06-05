package com.example.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Label extends Game_object {

    public static Bitmap[] rus = null;
    public static Bitmap[] eng = null;
    public static Bitmap[] num = null;
    public static Bitmap symbol(char ch){
        switch (ch)
        {
            case 'a': case 'A': return eng[0];  case 'b': case 'B': return eng[1];   case 'c': case 'C': return eng[2];
            case 'd': case 'D': return eng[3];  case 'e': case 'E': return eng[4];   case 'f': case 'F': return eng[5];
            case 'g': case 'G': return eng[6];  case 'h': case 'H': return eng[7];   case 'i': case 'I': return eng[8];
            case 'j': case 'J': return eng[9];  case 'k': case 'K': return eng[10];   case 'l': case 'L': return eng[11];
            case 'm': case 'M': return eng[12];  case 'n': case 'N': return eng[13];   case 'o': case 'O': return eng[14];
            case 'p': case 'P': return eng[15];  case 'q': case 'Q': return eng[16];   case 'r': case 'R': return eng[17];
            case 's': case 'S': return eng[18];  case 't': case 'T': return eng[19];   case 'u': case 'U': return eng[20];
            case 'v': case 'V': return eng[21];  case 'w': case 'W': return eng[22];   case 'x': case 'X': return eng[23];
            case 'y': case 'Y': return eng[24];  case 'z': case 'Z': return eng[25];

            case 'а': case 'А': return rus[0];  case 'б': case 'Б': return rus[1];   case 'в': case 'В': return rus[2];
            case 'г': case 'Г': return rus[3];  case 'д': case 'Д': return rus[4];   case 'е': case 'Е': return rus[5];
            case 'ё': case 'Ё': return rus[6];  case 'ж': case 'Ж': return rus[7];   case 'з': case 'З': return rus[8];
            case 'и': case 'И': return rus[9];  case 'й': case 'Й': return rus[10];   case 'к': case 'К': return rus[11];
            case 'л': case 'Л': return rus[12];  case 'м': case 'М': return rus[13];   case 'н': case 'Н': return rus[14];
            case 'о': case 'О': return rus[15];  case 'п': case 'П': return rus[16];   case 'р': case 'Р': return rus[17];
            case 'с': case 'С': return rus[18];  case 'т': case 'Т': return rus[19];   case 'у': case 'У': return rus[20];
            case 'ф': case 'Ф': return rus[21];  case 'х': case 'Х': return rus[22];   case 'ц': case 'Ц': return rus[23];
            case 'ч': case 'Ч': return rus[24];  case 'ш': case 'Ш': return rus[25];   case 'щ': case 'Щ': return rus[26];
            case 'ъ': case 'Ъ': return rus[27];  case 'ы': case 'Ы': return rus[28];   case 'ь': case 'Ь': return rus[29];
            case 'э': case 'Э': return rus[30];  case 'ю': case 'Ю': return rus[31];   case 'я': case 'Я': return rus[32];

            case '0': return num[0];  case '1': return num[1];   case '2': return num[2];
            case '3': return num[3];  case '4': return num[4];   case '5': return num[5];
            case '6': return num[6];  case '7': return num[7];   case '8': return num[8];
            case '9': return num[9];  case '!': return num[10];   case '?': return num[11];
            case '.': return num[12];  case ',': return num[13];   case ':': return num[14];
            case '\'': return num[15];  case '-': return num[16];   case '(': return num[17];
            case ')': return num[18];

            default: return num[11];
        }
    }

    public static void loadRusFont(Resources res){
        rus = new Bitmap[33];
        rus[0]= BitmapFactory.decodeResource(res, R.drawable.rus_a).copy(Bitmap.Config.ARGB_8888, true);
        rus[1]= BitmapFactory.decodeResource(res, R.drawable.rus_b).copy(Bitmap.Config.ARGB_8888, true);
        rus[2]= BitmapFactory.decodeResource(res, R.drawable.rus_v).copy(Bitmap.Config.ARGB_8888, true);
        rus[3]= BitmapFactory.decodeResource(res, R.drawable.rus_g).copy(Bitmap.Config.ARGB_8888, true);
        rus[4]= BitmapFactory.decodeResource(res, R.drawable.rus_d).copy(Bitmap.Config.ARGB_8888, true);
        rus[5]= BitmapFactory.decodeResource(res, R.drawable.rus_e).copy(Bitmap.Config.ARGB_8888, true);
        rus[6]= BitmapFactory.decodeResource(res, R.drawable.rus_yo).copy(Bitmap.Config.ARGB_8888, true);
        rus[7]= BitmapFactory.decodeResource(res, R.drawable.rus_j).copy(Bitmap.Config.ARGB_8888, true);
        rus[8]= BitmapFactory.decodeResource(res, R.drawable.rus_z).copy(Bitmap.Config.ARGB_8888, true);
        rus[9]= BitmapFactory.decodeResource(res, R.drawable.rus_i).copy(Bitmap.Config.ARGB_8888, true);

        rus[10]= BitmapFactory.decodeResource(res, R.drawable.rus_y).copy(Bitmap.Config.ARGB_8888, true);
        rus[11]= BitmapFactory.decodeResource(res, R.drawable.rus_k).copy(Bitmap.Config.ARGB_8888, true);
        rus[12]= BitmapFactory.decodeResource(res, R.drawable.rus_l).copy(Bitmap.Config.ARGB_8888, true);
        rus[13]= BitmapFactory.decodeResource(res, R.drawable.rus_m).copy(Bitmap.Config.ARGB_8888, true);
        rus[14]= BitmapFactory.decodeResource(res, R.drawable.rus_n).copy(Bitmap.Config.ARGB_8888, true);
        rus[15]= BitmapFactory.decodeResource(res, R.drawable.rus_o).copy(Bitmap.Config.ARGB_8888, true);
        rus[16]= BitmapFactory.decodeResource(res, R.drawable.rus_p).copy(Bitmap.Config.ARGB_8888, true);
        rus[17]= BitmapFactory.decodeResource(res, R.drawable.rus_r).copy(Bitmap.Config.ARGB_8888, true);
        rus[18]= BitmapFactory.decodeResource(res, R.drawable.rus_s).copy(Bitmap.Config.ARGB_8888, true);
        rus[19]= BitmapFactory.decodeResource(res, R.drawable.rus_t).copy(Bitmap.Config.ARGB_8888, true);

        rus[20]= BitmapFactory.decodeResource(res, R.drawable.rus_u).copy(Bitmap.Config.ARGB_8888, true);
        rus[21]= BitmapFactory.decodeResource(res, R.drawable.rus_f).copy(Bitmap.Config.ARGB_8888, true);
        rus[22]= BitmapFactory.decodeResource(res, R.drawable.rus_h).copy(Bitmap.Config.ARGB_8888, true);
        rus[23]= BitmapFactory.decodeResource(res, R.drawable.rus_c).copy(Bitmap.Config.ARGB_8888, true);
        rus[24]= BitmapFactory.decodeResource(res, R.drawable.rus_ch).copy(Bitmap.Config.ARGB_8888, true);
        rus[25]= BitmapFactory.decodeResource(res, R.drawable.rus_sh).copy(Bitmap.Config.ARGB_8888, true);
        rus[26]= BitmapFactory.decodeResource(res, R.drawable.rus_sch).copy(Bitmap.Config.ARGB_8888, true);
        rus[27]= BitmapFactory.decodeResource(res, R.drawable.rus_yy).copy(Bitmap.Config.ARGB_8888, true);
        rus[28]= BitmapFactory.decodeResource(res, R.drawable.rus_iy).copy(Bitmap.Config.ARGB_8888, true);
        rus[29]= BitmapFactory.decodeResource(res, R.drawable.rus_yi).copy(Bitmap.Config.ARGB_8888, true);

        rus[30]= BitmapFactory.decodeResource(res, R.drawable.rus_ye).copy(Bitmap.Config.ARGB_8888, true);
        rus[31]= BitmapFactory.decodeResource(res, R.drawable.rus_yu).copy(Bitmap.Config.ARGB_8888, true);
        rus[32]= BitmapFactory.decodeResource(res, R.drawable.rus_ya).copy(Bitmap.Config.ARGB_8888, true);

        return;
    }
    public static void loadEngFont(Resources res){
        eng=new Bitmap[26];
        eng[0]= BitmapFactory.decodeResource(res, R.drawable.eng_a).copy(Bitmap.Config.ARGB_8888, true);
        eng[1]= BitmapFactory.decodeResource(res, R.drawable.eng_b).copy(Bitmap.Config.ARGB_8888, true);
        eng[2]= BitmapFactory.decodeResource(res, R.drawable.eng_c).copy(Bitmap.Config.ARGB_8888, true);
        eng[3]= BitmapFactory.decodeResource(res, R.drawable.eng_d).copy(Bitmap.Config.ARGB_8888, true);
        eng[4]= BitmapFactory.decodeResource(res, R.drawable.eng_e).copy(Bitmap.Config.ARGB_8888, true);
        eng[5]= BitmapFactory.decodeResource(res, R.drawable.eng_f).copy(Bitmap.Config.ARGB_8888, true);
        eng[6]= BitmapFactory.decodeResource(res, R.drawable.eng_g).copy(Bitmap.Config.ARGB_8888, true);
        eng[7]= BitmapFactory.decodeResource(res, R.drawable.eng_h).copy(Bitmap.Config.ARGB_8888, true);
        eng[8]= BitmapFactory.decodeResource(res, R.drawable.eng_i).copy(Bitmap.Config.ARGB_8888, true);
        eng[9]= BitmapFactory.decodeResource(res, R.drawable.eng_j).copy(Bitmap.Config.ARGB_8888, true);

        eng[10]= BitmapFactory.decodeResource(res, R.drawable.eng_k).copy(Bitmap.Config.ARGB_8888, true);
        eng[11]= BitmapFactory.decodeResource(res, R.drawable.eng_l).copy(Bitmap.Config.ARGB_8888, true);
        eng[12]= BitmapFactory.decodeResource(res, R.drawable.eng_m).copy(Bitmap.Config.ARGB_8888, true);
        eng[13]= BitmapFactory.decodeResource(res, R.drawable.eng_n).copy(Bitmap.Config.ARGB_8888, true);
        eng[14]= BitmapFactory.decodeResource(res, R.drawable.eng_o).copy(Bitmap.Config.ARGB_8888, true);
        eng[15]= BitmapFactory.decodeResource(res, R.drawable.eng_p).copy(Bitmap.Config.ARGB_8888, true);
        eng[16]= BitmapFactory.decodeResource(res, R.drawable.eng_q).copy(Bitmap.Config.ARGB_8888, true);
        eng[17]= BitmapFactory.decodeResource(res, R.drawable.eng_r).copy(Bitmap.Config.ARGB_8888, true);
        eng[18]= BitmapFactory.decodeResource(res, R.drawable.eng_s).copy(Bitmap.Config.ARGB_8888, true);
        eng[19]= BitmapFactory.decodeResource(res, R.drawable.eng_t).copy(Bitmap.Config.ARGB_8888, true);

        eng[20]= BitmapFactory.decodeResource(res, R.drawable.eng_u).copy(Bitmap.Config.ARGB_8888, true);
        eng[21]= BitmapFactory.decodeResource(res, R.drawable.eng_v).copy(Bitmap.Config.ARGB_8888, true);
        eng[22]= BitmapFactory.decodeResource(res, R.drawable.eng_w).copy(Bitmap.Config.ARGB_8888, true);
        eng[23]= BitmapFactory.decodeResource(res, R.drawable.eng_x).copy(Bitmap.Config.ARGB_8888, true);
        eng[24]= BitmapFactory.decodeResource(res, R.drawable.eng_y).copy(Bitmap.Config.ARGB_8888, true);
        eng[25]= BitmapFactory.decodeResource(res, R.drawable.eng_z).copy(Bitmap.Config.ARGB_8888, true);
        return;
    }
    public static void loadNumFont(Resources res){
        num=new Bitmap[19];
        num[0]= BitmapFactory.decodeResource(res, R.drawable.num_0).copy(Bitmap.Config.ARGB_8888, true);
        num[1]= BitmapFactory.decodeResource(res, R.drawable.num_1).copy(Bitmap.Config.ARGB_8888, true);
        num[2]= BitmapFactory.decodeResource(res, R.drawable.num_2).copy(Bitmap.Config.ARGB_8888, true);
        num[3]= BitmapFactory.decodeResource(res, R.drawable.num_3).copy(Bitmap.Config.ARGB_8888, true);
        num[4]= BitmapFactory.decodeResource(res, R.drawable.num_4).copy(Bitmap.Config.ARGB_8888, true);
        num[5]= BitmapFactory.decodeResource(res, R.drawable.num_5).copy(Bitmap.Config.ARGB_8888, true);
        num[6]= BitmapFactory.decodeResource(res, R.drawable.num_6).copy(Bitmap.Config.ARGB_8888, true);
        num[7]= BitmapFactory.decodeResource(res, R.drawable.num_7).copy(Bitmap.Config.ARGB_8888, true);
        num[8]= BitmapFactory.decodeResource(res, R.drawable.num_8).copy(Bitmap.Config.ARGB_8888, true);
        num[9]= BitmapFactory.decodeResource(res, R.drawable.num_9).copy(Bitmap.Config.ARGB_8888, true);

        num[10]= BitmapFactory.decodeResource(res, R.drawable.num_att).copy(Bitmap.Config.ARGB_8888, true);
        num[11]= BitmapFactory.decodeResource(res, R.drawable.num_qst).copy(Bitmap.Config.ARGB_8888, true);
        num[12]= BitmapFactory.decodeResource(res, R.drawable.num_dot).copy(Bitmap.Config.ARGB_8888, true);
        num[13]= BitmapFactory.decodeResource(res, R.drawable.num_com).copy(Bitmap.Config.ARGB_8888, true);
        num[14]= BitmapFactory.decodeResource(res, R.drawable.num_dpt).copy(Bitmap.Config.ARGB_8888, true);
        num[15]= BitmapFactory.decodeResource(res, R.drawable.num_cap).copy(Bitmap.Config.ARGB_8888, true);
        num[16]= BitmapFactory.decodeResource(res, R.drawable.num_dsh).copy(Bitmap.Config.ARGB_8888, true);
        num[17]= BitmapFactory.decodeResource(res, R.drawable.num_opn).copy(Bitmap.Config.ARGB_8888, true);
        num[18]= BitmapFactory.decodeResource(res, R.drawable.num_cls).copy(Bitmap.Config.ARGB_8888, true);
        return;
    }

    public Bitmap res;
    public int boxw, boxh;
    public Label(Resources res, int id) {
        super(res, id, -1);
        if(rus==null)
            loadRusFont(res);
        if(eng==null)
            loadEngFont(res);
        if(num==null)
            loadNumFont(res);

        init(bmp.getWidth(), bmp.getHeight());
        disable_collider=true;

        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        return;
    }

    public void init(int w, int h) {
        boxw=w;
        boxh=h;
        x=x1;
        y=y1;
        res = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        setBorder(x1, y1, x2, y2);
        return;
    }
    public void erase(){
        x=x1;
        y=y1;
        res = Bitmap.createBitmap(boxw, boxh, Bitmap.Config.ARGB_8888);
        return;
    }


    public int space = 5, endl = 8;
    public String text = "null";


    public int x=0, y=0, xmax=0, ymax=0;
    public int x1=0, y1=0, x2=0, y2=0;
    public void setBorder(int x1, int y1, int x2, int y2) {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        xmax=(int)((boxw-x2-x1)/fontSize);
        ymax=(int)((boxh-y2-y1)/fontSize);
        return;
    }



    public void push(Bitmap s) {
        for(int dy=0; dy<s.getHeight(); dy++)
            for(int dx=0; dx<s.getWidth(); dx++)
                res.setPixel(x+dx, y+dy, s.getPixel(dx, dy));
        x+=s.getWidth();
        return;
    }
    public boolean write(char ch) {
        if(ch==' ')
        {
            if(x>x1)
                x+=space;
            longWordCheck();
            text +=' ';
            cur++;
            return true;
        }
        if(ch=='\n')
        {
            x=x1;
            y+=endl;
            text +='\n';
            cur++;
            return true;
        }
        Bitmap s=symbol(ch);
        if(x+s.getWidth()>=xmax)
        {
            x=x1;
            y+=endl;
        }
        if(y+s.getHeight()>=ymax)
            return false;
        text +=ch;
        cur++;
        push(s);
        return true;
    }



    public int cur = 0, start = 0;
    public String longText = "null";
    public void setLongText(String txt){
        setLongText(txt, 1);
        return;
    }
    public void setLongText(String txt, int animation_speed){
        cur=0;
        start=0;
        x=x1;
        y=y1;
        init(boxw, boxh);
        longText=txt;
        this.animation_speed=animation_speed;
        finish=false;
        waiting=true;
        return;
    }


    public int len = 0;
    public boolean longWordCheck() {
        len=nextWordLength();
        if(x+len>=xmax)
        {
            x=x1;
            if(len>=xmax)
                return true;
            y+=endl;
            return false;
        }
        return false;
    }
    public int nextWordLength() {
        int res=0;
        for(int i=cur+1; i<longText.length(); i++)
            if(longText.charAt(i)!=' '&&longText.charAt(i)!='\n')
                res+=symbol(longText.charAt(i)).getWidth();
            else break;
        return res;
    }



    public void setText(String txt, int pos) {
        longText =txt;
        text ="";
        cur=pos;

        erase();

        for(int i=pos; i<txt.length(); i++)
            if(!write(longText.charAt(i)))
                break;
        start=cur;
        return;
    }
    public void setText(String txt){
        cur=0;
        start=0;
        x=x1;
        y=y1;
        setText(txt, cur);
        finish=false;
        waiting=false;
        return;
    }


    public boolean hide=false;
    public int animation_speed = 1;
    public int animation_time = 0;


    public float fontSize = 1;
    public void setFontSize(float fontSize){
        this.fontSize=fontSize;
        xmax=(int)((boxw-x2-x1)/fontSize);
        ymax=(int)((boxh-y2-y1)/fontSize);
        return;
    }


    public boolean finish=false, waiting=false;
    public boolean animate(){
        if(waiting)
            return false;
        if(cur>=longText.length())
            return true;
        if(animation_time<animation_speed)
        {
            animation_time++;
            return false;
        }
        else animation_time=0;


        waiting=!write(longText.charAt(cur));
        if(waiting)
            start=cur;

        return cur<=longText.length();
    }
    public void next() {
        erase();
        if(!waiting || animation_speed<=0)
        {
            setText(longText, start);
            waiting=animation_speed<=0;
        }
        else waiting=false;
        return;
    }


    public Paint paint = new Paint();
    public boolean render(Canvas canvas, Paint paint, float x0, float y0){
        if(hide)
            return false;

        finish=cur>=longText.length();
        if(animation_speed>0)
            animate();
        else waiting=true;


        canvas.drawBitmap(bmp, pt.x-x0, pt.y-y0, paint);
        canvas.scale(fontSize, fontSize);
        canvas.drawBitmap(res, (pt.x-x0)/fontSize, (pt.y-y0)/fontSize, paint);
        canvas.scale(1/fontSize, 1/fontSize);
        return false;
    }
}
