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
package com.ruleyunruly.simpleworks.math;

import static java.lang.Math.*;

import java.nio.FloatBuffer;

/**
 * Acts as a base for vectors.
 * 
 * @version 1.0 20200131
 * @author Christopher R. Ruley
 */
public abstract class Vector
{
	/**
	 * Initializes this vector by setting it to zero.
	 */
	public Vector( )
	{
		setZero( );
	}

	/**
	 * @return The length of this vector.
	 */
	public final float getLength( )
	{
		return ( float ) sqrt( getLengthSquared( ) );
	}

	/**
	 * @return The length squared of this vector.
	 */
	public abstract float getLengthSquared( );

	/**
	 * Sets this vector to zero.
	 * 
	 * @return This vector.
	 */
	public abstract Vector setZero( );

	/**
	 * Sets this vector to its negated value.
	 * 
	 * @return This vector.
	 */
	public abstract Vector setNegated( );

	/**
	 * Sets this vector to its normalized value.
	 * 
	 * @return This vector.
	 */
	public abstract Vector setNormalized( );

	/**
	 * Stores this vector in a float buffer.
	 * 
	 * @param floatBuffer The float buffer to store this vector in.
	 * @return This vector.
	 */
	public abstract Vector store( FloatBuffer floatBuffer );
}
