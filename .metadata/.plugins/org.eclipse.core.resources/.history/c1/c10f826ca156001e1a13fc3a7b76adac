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

import flash.geom.Rectangle;
import util.UI;
import flash.geom.Matrix;

/**
 * A simple meter widget
 *
 * @author Raffaele Sena
 */

class util.HorizontalMeter 
{
	private var x:Number;
	private var y:Number;
	private var w:Number;
	private var h:Number;
	private var mc:MovieClip;
	private var bar:MovieClip;
	private var mask:MovieClip;
	
	private static var border:Number = 6;
	
	public function HorizontalMeter(parent:MovieClip, x:Number, y:Number, w:Number, h:Number, n:Number, split:Array) 
	{
		if (n == undefined)
			n = 10;
		
		this.x = x;
		this.y = y;
		
		//
		// black background   
		//
		mc = parent.createEmptyMovieClip("mc", parent.getNextHighestDepth());
		mc._x = x;
		mc._y = y;
		
		UI.drawRect(mc, 0, 0, w, h, UI.BLACK);
		
		//
		// green to red bars
		//
		//var m:Matrix = new Matrix();
		//m.createGradientBox(w, h, 0, 0, 0);
		//mc.beginGradientFill("linear", [ 0x00ff00, 0xffff00, 0xff0000 ], [ 100, 100, 100 ], [ 0, 100, 255 ], m);
		//UI.drawRect(mc, border, border, w - (2*border), h - (2*border));
		
		if (split == undefined)
			split = [ 0.333, 0.333, 0.333 ];
			
		var w1:Number = (w - (border * 2)) * split[0];
		var w2:Number = (w - (border * 2)) * split[1];
		var w3:Number = (w - (border * 2)) * split[2];
		
   		// green portion  
		mc.beginFill(0x88FF00);
		UI.drawRect(mc, border + 0, border, w1, h - (2 * border));
		mc.endFill();
		
   		// yellow portion  
		mc.beginFill(0xFF8800);
		UI.drawRect(mc, border + w1, border, w2, h - (2 * border));
		mc.endFill();
		
		// red portion
		mc.beginFill(0xFF0000);
		UI.drawRect(mc, border + w1 + w2, border, w3, h - (2 * border));
		mc.endFill();
		
		// separators
		var sp:Number = (w-(2*border)) / n;
		var sx:Number = border+sp;
		var i:Number;
		for (i = 1; i < n; i++) {
			UI.drawRect(mc, sx - 1, 0, 2, h, UI.BLACK);
			sx += sp;
		}
					
		//
		// level bar
		//
		var z = parent.getNextHighestDepth();
		bar = parent.createEmptyMovieClip("bar" + z, z);
		bar._x = x;
		bar._y = y;
		UI.drawRect(bar, 0, 0, w, h, UI.BLACK, 80);
		
		//
		// bar mask
		//
		z = parent.getNextHighestDepth();
		mask = parent.createEmptyMovieClip("mask" + z, z);
		mask._x = x;
		mask._y = y;
		UI.drawRect(mask, 0, 0, w, h, UI.BLACK);
		
		bar.setMask(mask);
	}
	
	public function set(n:Number)
	{
		var v:Number = int((bar._width-(2*border)) * n / 100);
		bar._x = x + border + v;
	}
}
