/*
 * MIT License
 *
 * Copyright (c) 2020 Christopher R. Ruley
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.ruleyunruly.simpleworks.core;

import static java.lang.Thread.*;
import static org.lwjgl.glfw.GLFW.*;

/**
 * Calculates the UPS, FPS, and delta.
 * 
 * @version 1.0 20200205
 * @author Christopher R. Ruley
 */
public class Timer
{
	/**
	 * Limits the UPS and FPS.
	 */
	private int syncInterval;

	/**
	 * Holds the current UPS. 
	 */
	private int currentUPS;

	/**
	 * Holds the current FPS.
	 */
	private int currentFPS;

	/**
	 * Used for UPS calculation.
	 */
	private int countForUPS;

	/**
	 * Used for FPS calculation.
	 */
	private int countForFPS;

	/**
	 * Used for UPS and FPS calculation.
	 */
	private float countForTime;

	/**
	 * Used for delta time calculation.
	 */
	private double lastTime;

	/**
	 * Initializes this timer.
	 * 
	 * @param syncInterval The sync interval.
	 */
	public Timer( int syncInterval )
	{
		this.syncInterval = syncInterval;

		currentUPS = 0;
		currentFPS = 0;
		countForUPS = 0;
		countForFPS = 0;
		countForTime = 0.0F;
		lastTime = getCurrentTime( );
	}

	/**
	 * @return The sync interval.
	 */
	public int getSyncInterval( )
	{
		return syncInterval;
	}

	/** 
	 * @return The current UPS.
	 */
	public int getCurrentUPS( )
	{
		return currentUPS > 0 ? currentUPS : countForUPS;
	}

	/**
	 * @return The current FPS.
	 */
	public int getCurrentFPS( )
	{
		return currentFPS > 0 ? currentFPS : countForFPS;
	}

	/** 
	 * @return The count for UPS.
	 */
	public int getCountForUPS( )
	{
		return countForUPS;
	}

	/**
	 * @return The count for FPS.
	 */
	public int getCountForFPS( )
	{
		return countForFPS;
	}

	/** 
	 * @return The count for time.
	 */
	public float getCountForTime( )
	{
		return countForTime;
	}

	/**
	 * @return The last time saved.
	 */
	public double getLastTime( )
	{
		return lastTime;
	}

	/** 
	 * @return The current time in seconds.
	 */
	public double getCurrentTime( )
	{
		return glfwGetTime( );
	}

	/**
	 * @return The delta time in seconds.
	 */
	public float getDeltaTime( )
	{
		double currentTime = getCurrentTime( );
		float deltaTime = ( float ) ( currentTime - lastTime );

		lastTime = currentTime;
		countForTime += deltaTime;

		return deltaTime;
	}

	/**
	 * Sets the sync interval.
	 * 
	 * @param syncInterval The new sync interval.
	 */
	public void setSyncInterval( int syncInterval )
	{
		this.syncInterval = syncInterval;
	}

	/**
	 * Updates the count for UPS by incrementing.
	 */
	public void updateCountForUPS( )
	{
		countForUPS++ ;
	}

	/**
	 * Updates the count for FPS by incrementing.
	 */
	public void updateCountForFPS( )
	{
		countForFPS++ ;
	}

	/**
	 * Syncs the UPS and FPS.
	 */
	public void sync( )
	{
		double currentTime = getCurrentTime( );
		float targetTime = 1.0F / syncInterval;

		while( currentTime - lastTime < targetTime )
		{
			yield( );

			currentTime = getCurrentTime( );
		}
	}

	/**
	 * Updates the timer.
	 */
	public void update( )
	{
		if( countForTime > 1.0F )
		{
			currentUPS = countForUPS;
			countForUPS = 0;
			currentFPS = countForFPS;
			countForFPS = 0;
			countForTime -= 1.0F;
		}
	}
}
