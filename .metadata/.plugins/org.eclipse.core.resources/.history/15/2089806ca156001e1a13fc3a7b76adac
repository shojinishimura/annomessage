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

import util.UI;
import flash.geom.Point;
import flash.geom.Rectangle;

/**
 * A simply bar char widget
 *
 * @author Raffaele Sena
 */

class util.BarChart 
{
	var mc:MovieClip;
	var bars:Array;
	var background:Number;
	var barColor:Number;
	var barWidth:Number;
	var barHeight:Number;
	var space:Number;
		
	function BarChart(parent:MovieClip, x:Number, y:Number, w:Number, h:Number, bw:Number, backgroundColor:Number, color:Number)
	{
		barHeight = h;
		barWidth = bw == undefined ? 2 : bw;
		space = bw > 2 ? 1 : 0;
		
		background = backgroundColor == undefined ? UI.BLACK : backgroundColor;
		barColor = color == undefined ? UI.WHITE : color;
		
		mc = parent.createEmptyMovieClip("mc", parent.getNextHighestDepth());
		mc._x = x;
		mc._y = y;

		UI.drawRect(mc, 0, 0, w, h, background);
		
		var mask:MovieClip = parent.createEmptyMovieClip("mask", parent.getNextHighestDepth());
		mask._x = x;
		mask._y = y;
		UI.drawRect(mask, 0, 0, w, h, background);
		mc.setMask(mask);

		bars = new Array();
		
		for (var i = 0; i < w / barWidth; i++) {
			var bar:MovieClip = mc.createEmptyMovieClip("bar_" + i, mc.getNextHighestDepth());
			bar._x = barWidth * i;
			bar._y = barHeight;
			UI.drawRect(bar, 0, 0, barWidth - space, h, barColor);
			bars.push(bar);
		}
	}
	
	function add(n:Number)
	{
		var bar:MovieClip = MovieClip(bars.shift());
		bars.push(bar);
		
		bar._y = barHeight - int(barHeight * n / 100);

		for (var i = 0; i < bars.length; i++)
		{
			bar = bars[i];
			bar._x = barWidth * i;
		}
	}
	
	function clear()
	{
		for (var i = 0; i < bars.length; i++)
			bars[i]._y = barHeight;
	}
}
