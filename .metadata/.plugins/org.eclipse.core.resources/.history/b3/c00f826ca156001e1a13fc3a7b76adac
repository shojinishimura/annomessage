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
 * Utility methods to access Chumby hardware
 * 
 * @author Raffaele Sena
 * @see http://wiki.chumby.com/mediawiki/index.php/Developing_Widgets_for_Foo/Katamari
 */

class util.Chumby
{
	static private var _getRawX        : Function = _global.ASNative(5,10);
	static private var _getRawY        : Function = _global.ASNative(5,11);
	static private var _getLastBend    : Function = _global.ASNative(5,14);
	static private var _getLightReading: Function = _global.ASNative(5,15);
	static private var _getDCPower     : Function = _global.ASNative(5,16);
	static private var _getSpeakerMute : Function = _global.ASNative(5,17);
	static private var _setSpeakerMute : Function = _global.ASNative(5,18);
	static private var _getLCDMute     : Function = _global.ASNative(5,19);
	static private var _setLCDMute     : Function = _global.ASNative(5,20);
	static private var _getBent        : Function = _global.ASNative(5,25);
	static private var _getBendAverage : Function = _global.ASNative(5,28);
	static private var _accellerometer : Function = _global.ASNative(5,60);

	//
	// return touchscreen raw coordinates
	//
	static function getRawCoord() : Object
	{
		return { x:_getRawX(), y:_getRawY() };
	}

	//
	// return last bend sensor reading
	//
	static function getLastBend() : Number
	{
		return _getLastBend();
	}

	//
	// return "bent" flag
	//
	static function getBent() : Boolean
	{
		return Boolean(_getBent());
	}
	
	//
	// return bend average
	//
	static function getBendAverage() : Number
	{
		return _getBendAverage();
	}

	//
	// return ambient light sensor reading
	//
	static function getLightReading() : Number
	{
		return _getLightReading();
	}

	//
	// return true if DC Power is connected
	//
	static function getDCPower() : Boolean
	{
		return Boolean(_getDCPower());
	}

	//
	// return the value of LCD "mute" (the display is on or off)
	//
	static function getLCDMute() : Boolean
	{
		return Boolean(_getLCDMute());
	}

	//
	// set the value of LCD "mute" (the display is on or off)
	//
	static function setLCDMute(mute:Boolean) : Void
	{
		_setLCDMute(Number(mute));
	}

	//
	// return the value of speaker "mute" (the speaker is muted)
	//
	static function getSpeakerMute() : Boolean
	{
		return Boolean(_getSpeakerMute());
	}

	//
	// set the value of speaker "mute" (the speaker is muted)
	//
	static function setSpeakerMute(mute:Boolean) : Void
	{
		_setSpeakerMute(Number(mute));
	}

	//
	// get accellerometer version
	//
	static function getAccellerometerVersion() : Number
	{
		return _accellerometer(0);
	}

	//
	// get current accellerometer values
	//
	static function getCurrentAccellerometer() : Object
	{
		return {
			tstamp:_accellerometer(1),
			x:_accellerometer(2),
			y:_accellerometer(3),
			z:_accellerometer(4)
		};
	}

	//
	// get average accellerometer values
	//
	static function getAverageAccellerometer() : Object
	{
		return {
			x:_accellerometer(5),
			y:_accellerometer(6),
			z:_accellerometer(7)
		};
	}

	//
	// get impact accellerometer values
	//
	static function getImpactAccellerometer() : Object
	{
		return {
			x:_accellerometer(8),
			y:_accellerometer(9),
			z:_accellerometer(10),
			time:_accellerometer(11),
			hints:_accellerometer(12)
		};
	}
}
