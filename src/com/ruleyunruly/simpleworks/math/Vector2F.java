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

import java.nio.FloatBuffer;

/**
 * Holds a 2-tuple vector of floats.
 * 
 * @version 1.0 20200131
 * @author Christopher R. Ruley
 */
public class Vector2F extends Vector
{
	/**
	 * Represents the 1st element.
	 */
	public float x;

	/**
	 * Represents the 2nd element.
	 */
	public float y;

	/**
	 * Initializes this vector.
	 */
	public Vector2F( )
	{
		super( );
	}

	/**
	 * Initializes this vector.
	 * 
	 * @param x The new x value.
	 * @param y The new y value.
	 */
	public Vector2F( float x, float y )
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Initializes this vector by copying another vector.
	 * 
	 * @param other The vector to copy from.
	 */
	public Vector2F( Vector2F other )
	{
		this( other.x, other.y );
	}

	/**
	 * @param other The vector to calculate by.
	 * @return The dot product of this vector and another vector.
	 */
	public float getDotProduct( Vector2F other )
	{
		return x * other.x + y * other.y;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public float getLengthSquared( )
	{
		return x * x + y * y;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Vector2F setZero( )
	{
		x = 0.0F;
		y = 0.0F;

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Vector2F setNegated( )
	{
		x = -x;
		y = -y;

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Vector2F setNormalized( )
	{
		float length = getLength( );

		x /= length;
		y /= length;

		return this;
	}

	/**
	 * Adds a float to this vector.
	 * 
	 * @param value The float to add.
	 * @return This vector.
	 */
	public Vector2F add( float value )
	{
		x += value;
		y += value;

		return this;
	}

	/**
	 * Adds another vector to this vector.
	 * 
	 * @param other The vector to add.
	 * @return This vector.
	 */
	public Vector2F add( Vector2F other )
	{
		x += other.x;
		y += other.y;

		return this;
	}

	/**
	 * Subtracts a float from this vector.
	 * 
	 * @param value The float to subtract.
	 * @return This vector.
	 */
	public Vector2F subtract( float value )
	{
		x -= value;
		y -= value;

		return this;
	}

	/**
	 * Subtracts another vector from this vector.
	 * 
	 * @param other The vector to subtract.
	 * @return This vector.
	 */
	public Vector2F subtract( Vector2F other )
	{
		x -= other.x;
		y -= other.y;

		return this;
	}

	/**
	 * Multiplies this vector by a float.
	 * 
	 * @param value The float to multiply by.
	 * @return This vector.
	 */
	public Vector2F multiply( float value )
	{
		x *= value;
		y *= value;

		return this;
	}

	/**
	 * Multiplies this vector by another vector.
	 * 
	 * @param other The vector to multiply by.
	 * @return This vector.
	 */
	public Vector2F multiply( Vector2F other )
	{
		x *= other.x;
		y *= other.y;

		return this;
	}

	/**
	 * Divides this vector by a float.
	 * 
	 * @param value The float to divide by.
	 * @return This vector.
	 */
	public Vector2F divide( float value )
	{
		x /= value;
		y /= value;

		return this;
	}

	/**
	 * Divides this vector by another vector.
	 * 
	 * @param other The vector to divide by.
	 * @return This vector.
	 */
	public Vector2F divide( Vector2F other )
	{
		x /= other.x;
		y /= other.y;

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Vector2F store( FloatBuffer floatBuffer )
	{
		floatBuffer.put( x );
		floatBuffer.put( y );
		floatBuffer.flip( );

		return this;
	}
}
