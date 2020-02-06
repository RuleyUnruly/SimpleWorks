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
 * Holds 2x2 matrix of floats.
 * 
 * @version 1.0 20200131
 * @author Christopher R. Ruley
 */
public class Matrix2F extends Matrix
{
	/**
	 * Represents the 1st element.
	 */
	public float element00;

	/**
	 * Represents the 2nd element.
	 */
	public float element01;

	/**
	 * Represents the 3rd element.
	 */
	public float element10;

	/**
	 * Represents the 4th element.
	 */
	public float element11;

	/**
	 * Initializes this matrix.
	 */
	public Matrix2F( )
	{
		super( );
	}

	/**
	 * Initializes this matrix.
	 * 
	 * @param element00 The new element00 value.
	 * @param element01 The new element01 value.
	 * @param element10 The new element10 value.
	 * @param element11 The new element11 value.
	 */
	public Matrix2F( float element00, float element01, float element10,
			float element11 )
	{
		this.element00 = element00;
		this.element01 = element01;
		this.element10 = element10;
		this.element11 = element11;
	}

	/**
	 * Initializes this matrix by copying another matrix.
	 * 
	 * @param other The matrix to copy.
	 */
	public Matrix2F( Matrix2F other )
	{
		this( other.element00, other.element01, other.element10,
				other.element11 );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Matrix2F setZero( )
	{
		element00 = 0.0F;
		element01 = 0.0F;
		element10 = 0.0F;
		element11 = 0.0F;

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Matrix2F setNegated( )
	{
		element00 = -element00;
		element01 = -element01;
		element10 = -element10;
		element11 = -element11;

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Matrix2F setIdentity( )
	{
		element00 = 1.0F;
		element01 = 0.0F;
		element10 = 0.0F;
		element11 = 1.0F;

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Matrix2F setTransposed( )
	{
		float element01 = element10;
		float element10 = element01;

		this.element01 = element01;
		this.element10 = element10;

		return this;
	}

	/**
	 * Adds another matrix to this matrix.
	 * 
	 * @param other The matrix to add.
	 * @return This matrix.
	 */
	public Matrix2F add( Matrix2F other )
	{
		element00 += other.element00;
		element01 += other.element01;
		element10 += other.element10;
		element11 += other.element11;

		return this;
	}

	/**
	 * Subtracts another matrix from this matrix.
	 * 
	 * @param other The matrix to subtract.
	 * @return This matrix.
	 */
	public Matrix2F subtract( Matrix2F other )
	{
		element00 -= other.element00;
		element01 -= other.element01;
		element10 -= other.element10;
		element11 -= other.element11;

		return this;
	}

	/**
	 * Multiplies this matrix by another matrix.
	 * 
	 * @param other The matrix to multiply by.
	 * @return This matrix.
	 */
	public Matrix2F multiply( Matrix2F other )
	{
		float element00 = this.element00 * other.element00
				+ this.element10 * other.element01;
		float element01 = this.element01 * other.element00
				+ this.element11 * other.element01;
		float element10 = this.element00 * other.element10
				+ this.element10 * other.element11;
		float element11 = this.element01 * other.element10
				+ this.element11 * other.element11;

		this.element00 = element00;
		this.element01 = element01;
		this.element10 = element10;
		this.element11 = element11;

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Matrix2F store( FloatBuffer floatBuffer )
	{
		floatBuffer.put( element00 );
		floatBuffer.put( element01 );
		floatBuffer.put( element10 );
		floatBuffer.put( element11 );
		floatBuffer.flip( );

		return this;
	}
}
