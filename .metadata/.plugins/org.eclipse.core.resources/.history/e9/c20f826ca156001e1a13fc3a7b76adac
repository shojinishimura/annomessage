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

/**
 * Simple menu
 *
 * @author Raffaele Sena
 */

class util.Menu
{
	private var parent:MovieClip;
	private var selectColor:Number;
	private var unselectColor:Number;
	private var selected:MovieClip;
	
	// implements AsBroadcaster
	public var addListener:Function;
	public var broadcastMessage:Function;
	
	function Menu(mc:MovieClip, entries:Array, selectColor:Number, unselectColor:Number, borderColor:Number)
	{
		this.parent = mc;
		this.selectColor = selectColor;
		this.unselectColor = unselectColor;
		this.selected = undefined;
		
		AsBroadcaster.initialize(this);
		
		var fmt:TextFormat = new TextFormat(util.UI.DEFAULT_FONT, 12, 0xffffffff, true, false, false, null, null, "center");
		var top:Number = (mc._height - (entries.length * 20)) / 2;
		
		for (var i=0; i < entries.length; i++)
		{
			var bt:MovieClip = mc.createEmptyMovieClip(i, mc.getNextHighestDepth());
			bt.parentMenu = this;
			bt.index = i;
			bt._x = 20;
			bt._y = top + i * 20;
			bt.onPress = function() {
				this.parentMenu.select(this);
			}
				
			UI.drawRect(bt, 0, 0, mc._width - 40, 16, unselectColor);
					
			var entry:TextField = bt.createTextField("tf", bt.getNextHighestDepth(), 0, 0, bt._width, bt._height);
			var bc = borderColor;				
			with (entry)
			{
				text = entries[i];
				selectable = false;
				embedFonts = UI.EMBED_FONT;
				border = (bc != undefined);
				borderColor = bc;
				background = true;
				backgroundColor = unselectColor;
				setTextFormat(fmt);
			}
		}
	}
	
	function select(mc:MovieClip)
	{
		with (this)
		{
			if (selected != undefined)
				selected.tf.backgroundColor = unselectColor;
		
			selected = mc;
			selected.tf.backgroundColor = this.selectColor;
			
			broadcastMessage("onMenuSelect", selected.index);
		}
	}
}
