/*
 * The MIT License
 *
 * Copyright (c) 2008 Raffaele Sena <raff367@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 */

/**
 * Useful UI methods
 *
 * @author Raffaele Sena
 */

class util.UI
{
    static var WHITE:Number = 0xffffff;
    static var BLACK:Number = 0x000000;
    static var RED:Number = 0xff0000;
    static var GREEN:Number = 0x00ff00;
    static var BLUE:Number = 0x0000ff;
    static var YELLOW:Number = 0xffff00;
    static var CYAN:Number = 0x00ffff;
    static var MAGENTA:Number = 0xff00ff;
    
    // chumby colors
    static var BLUE_1:Number = 0x3A71C6;
    static var BLUE_2:Number = 0x5484CE;
    static var BLUE_3:Number = 0x1B5ABD;
    
    static var LIGHTBLUE:Number = 0x84CEFE;
    
    
    static var DEFAULT_FONT:String = "_sans";
	static var DEFAULT_COLOR:Number = UI.WHITE;
    static var EMBED_FONT:Boolean = false;
    
    static function mainScreen(mc:MovieClip, background, title:String, fh:Number) {
        if (fh == undefined)
            fh=20;

        if (typeof(background) == "number")
            drawRect(mc, 0, 0, Stage.width, Stage.height, background);
        else
            mc.attachMovie(background, "bg", mc.getNextHighestDepth());
        
        if (title != undefined)
            getTextField(mc, 10, 0, fh, title);
    }

    static function getTextFormat(height:Number, color:Number, bold:Boolean, italic:Boolean) {
		if (color == undefined)
			color = DEFAULT_COLOR;
        return new TextFormat(DEFAULT_FONT, height, color, bold, italic);
    }
    
    static function after(mc:Object):Number
    {
        return mc._x + mc._width;
    }
    
    static function under(mc:Object):Number
    {
        return mc._y + mc._height;
    }
    
    static function getTextField(mc:MovieClip, x:Number, y:Number, fh:Number, message:String, lines:Number, bAutosize:Boolean, color:Number, bold:Boolean, italic:Boolean)
    {
        var h:Number =  bAutosize ? undefined : (lines==undefined ? 1 : lines) * (fh+4); 
        var fmt:TextFormat = UI.getTextFormat(fh, color, bold, italic);
        var depth:Number = mc.getNextHighestDepth();
        var tf:TextField = mc.createTextField("tf_" + depth, depth, x, y, mc._width - x - 4, h);
        tf.setNewTextFormat(fmt);
        with (tf)
        {
            selectable = false;
            embedFonts = EMBED_FONT;
            if (lines != undefined)
                wordWrap = true;
            if (bAutosize)
                autoSize = "center";
        }
        if (message != undefined)
            tf.text = message;
        return tf;
    }

    static function drawRect(mc:MovieClip, x:Number, y:Number, w:Number, h:Number, color:Number, alpha:Number)
    {
        with (mc)
        {
            if (color != undefined) {
                if (alpha == undefined) alpha = 100;
                beginFill(color, alpha);
            }

            moveTo(x,   y);
            lineTo(x,   y+h);
            lineTo(x+w, y+h);
            lineTo(x+w, y);

            if (color != undefined)
                endFill();
        }
    }
    
    static function drawRoundedRect(mc:MovieClip, x:Number, y:Number, w:Number, h:Number, r:Number, color:Number, alpha:Number)
    {
        if (color != undefined) {
            if (alpha == undefined) alpha = 100;
            mc.beginFill(color, alpha);
        }

        // init vars
        var theta, angle, cx, cy, px, py;
        // make sure that w + h are larger than 2*r
        if (r > Math.min(w, h)/2) {
               r = Math.min(w, h)/2;
        }
        // theta = 45 degrees in radians
        theta = Math.PI/4;
        // draw top line
        mc.moveTo(x+r, y);
        mc.lineTo(x+w-r, y);
        //angle is currently 90 degrees
        angle = -Math.PI/2;
        // draw tr corner in two parts
        cx = x+w-r+(Math.cos(angle+(theta/2))*r/Math.cos(theta/2));
        cy = y+r+(Math.sin(angle+(theta/2))*r/Math.cos(theta/2));
        px = x+w-r+(Math.cos(angle+theta)*r);
        py = y+r+(Math.sin(angle+theta)*r);
        mc.curveTo(cx, cy, px, py);
        angle += theta;
        cx = x+w-r+(Math.cos(angle+(theta/2))*r/Math.cos(theta/2));
        cy = y+r+(Math.sin(angle+(theta/2))*r/Math.cos(theta/2));
        px = x+w-r+(Math.cos(angle+theta)*r);
        py = y+r+(Math.sin(angle+theta)*r);
        mc.curveTo(cx, cy, px, py);
        // draw right line
        mc.lineTo(x+w, y+h-r);
        // draw br corner
        angle += theta;
        cx = x+w-r+(Math.cos(angle+(theta/2))*r/Math.cos(theta/2));
        cy = y+h-r+(Math.sin(angle+(theta/2))*r/Math.cos(theta/2));
        px = x+w-r+(Math.cos(angle+theta)*r);
        py = y+h-r+(Math.sin(angle+theta)*r);
        mc.curveTo(cx, cy, px, py);
        angle += theta;
        cx = x+w-r+(Math.cos(angle+(theta/2))*r/Math.cos(theta/2));
        cy = y+h-r+(Math.sin(angle+(theta/2))*r/Math.cos(theta/2));
        px = x+w-r+(Math.cos(angle+theta)*r);
        py = y+h-r+(Math.sin(angle+theta)*r);
        mc.curveTo(cx, cy, px, py);
        // draw bottom line
        mc.lineTo(x+r, y+h);
        // draw bl corner
        angle += theta;
        cx = x+r+(Math.cos(angle+(theta/2))*r/Math.cos(theta/2));
        cy = y+h-r+(Math.sin(angle+(theta/2))*r/Math.cos(theta/2));
        px = x+r+(Math.cos(angle+theta)*r);
        py = y+h-r+(Math.sin(angle+theta)*r);
        mc.curveTo(cx, cy, px, py);
        angle += theta;
        cx = x+r+(Math.cos(angle+(theta/2))*r/Math.cos(theta/2));
        cy = y+h-r+(Math.sin(angle+(theta/2))*r/Math.cos(theta/2));
        px = x+r+(Math.cos(angle+theta)*r);
        py = y+h-r+(Math.sin(angle+theta)*r);
        mc.curveTo(cx, cy, px, py);
        // draw left line
        mc.lineTo(x, y+r);
        // draw tl corner
        angle += theta;
        cx = x+r+(Math.cos(angle+(theta/2))*r/Math.cos(theta/2));
        cy = y+r+(Math.sin(angle+(theta/2))*r/Math.cos(theta/2));
        px = x+r+(Math.cos(angle+theta)*r);
        py = y+r+(Math.sin(angle+theta)*r);
        mc.curveTo(cx, cy, px, py);
        angle += theta;
        cx = x+r+(Math.cos(angle+(theta/2))*r/Math.cos(theta/2));
        cy = y+r+(Math.sin(angle+(theta/2))*r/Math.cos(theta/2));
        px = x+r+(Math.cos(angle+theta)*r);
        py = y+r+(Math.sin(angle+theta)*r);
        mc.curveTo(cx, cy, px, py);

        if (color != undefined)
            mc.endFill();
    }
    
    static function drawCircle(mc:MovieClip, x:Number, y:Number, r:Number, color:Number, alpha:Number)
    {
        var c1 = r * (Math.SQRT2 - 1);
        var c2 = r * Math.SQRT2 / 2;
        
        if (color != undefined) {
            if (alpha == undefined) alpha = 100;
            mc.beginFill(color, alpha);
        }

        with (mc)
        {
            moveTo(x + r, y);
            curveTo(x + r,  y + c1, x + c2, y + c2);
            curveTo(x + c1, y + r,  x,      y + r);
            curveTo(x - c1, y + r,  x - c2, y + c2);
            curveTo(x - r,  y + c1, x - r,  y);
            curveTo(x - r,  y - c1, x - c2 ,y - c2);
            curveTo(x - c1, y - r,  x,      y - r);
            curveTo(x + c1, y - r,  x + c2, y - c2);
            curveTo(x +  r, y - c1, x + r,  y);
        }

        if (color != undefined)
            mc.endFill();
    }
}
