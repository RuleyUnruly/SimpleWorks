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
 * Holds a 3-tuple vector of floats.
 * 
 * @version 1.0 20200131
 * @author Christopher R. Ruley
 */
public class Vector3F extends Vector
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
	 * Represents the 3rd element.
	 */
	public float z;

	/**
	 * Initializes this vector.
	 */
	public Vector3F( )
	{
		super( );
	}

	/**
	 * Initializes this vector.
	 * 
	 * @param x The new x value.
	 * @param y The new y value.
	 * @param z The new z value.
	 */
	public Vector3F( float x, float y, float z )
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}

	/**
	 * Initializes this vector by copying another vector.
	 * 
	 * @param other The vector to copy.
	 */
	public Vector3F( Vector3F other )
	{
		this( other.x, other.y, other.z );
	}

	/**
	 * @param other The vector to calculate by.
	 * @return The dot product of this vector and another vector.
	 */
	public float getDotProduct( Vector3F other )
	{
		return x * other.x + y * other.y + z * other.z;
	}

	/**
	 * @param other The vector to calculate by.
	 * @return The cross product of this vector and another vector.
	 */
	public Vector3F getCrossProduct( Vector3F other )
	{
		return new Vector3F( y * other.z - z * other.y,
				other.x * z - other.z * x, x * other.y - y * other.x );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public float getLengthSquared( )
	{
		return x * x + y * y + z * z;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Vector3F setZero( )
	{
		x = 0.0F;
		y = 0.0F;
		z = 0.0F;

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Vector3F setNegated( )
	{
		x = -x;
		y = -y;
		z = -z;

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Vector3F setNormalized( )
	{
		float length = getLength( );

		x /= length;
		y /= length;
		y /= length;

		return this;
	}

	/**
	 * Adds a float to this vector.
	 * 
	 * @param value The float to add.
	 * @return This vector.
	 */
	public Vector3F add( float value )
	{
		x += value;
		y += value;
		z += value;

		return this;
	}

	/**
	 * Adds another vector to the this vector.
	 * 
	 * @param other The vector to add.
	 * @return This vector.
	 */
	public Vector3F add( Vector3F other )
	{
		x += other.x;
		y += other.y;
		z += other.z;

		return this;
	}

	/**
	 * Subtracts a float from this vector.
	 * 
	 * @param value The float to subtract.
	 * @return This vector.
	 */
	public Vector3F subtract( float value )
	{
		x -= value;
		y -= value;
		z -= value;

		return this;
	}

	/**
	 * Subtracts another vector from this vector.
	 * 
	 * @param other The vector to subtract.
	 * @return This vector.
	 */
	public Vector3F subtract( Vector3F other )
	{
		x -= other.x;
		y -= other.y;
		z -= other.z;

		return this;
	}

	/**
	 * Multiplies this vector by a float.
	 * 
	 * @param value The float to multiply by.
	 * @return This vector.
	 */
	public Vector3F multiply( float value )
	{
		x *= value;
		y *= value;
		z *= value;

		return this;
	}

	/**
	 * Multiplies this vector by another vector.
	 * 
	 * @param other The vector to multiply by.
	 * @return This vector.
	 */
	public Vector3F multiply( Vector3F other )
	{
		x *= other.x;
		y *= other.y;
		z *= other.z;

		return this;
	}

	/**
	 * Divides this vector by a float.
	 * 
	 * @param value The float to divide by.
	 * @return This vector.
	 */
	public Vector3F divide( float value )
	{
		x /= value;
		y /= value;
		z /= value;

		return this;
	}

	/**
	 * Divides this vector by another vector.
	 * 
	 * @param other The vector to divide by.
	 * @return This vector.
	 */
	public Vector3F divide( Vector3F other )
	{
		x /= other.x;
		y /= other.y;
		z /= other.z;

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Vector3F store( FloatBuffer floatBuffer )
	{
		floatBuffer.put( x );
		floatBuffer.put( y );
		floatBuffer.put( z );
		floatBuffer.flip( );

		return this;
	}
}
