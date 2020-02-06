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
 * Holds a 3x3 matrix of floats.
 * 
 * @version 1.0 20200131
 * @author Christopher R. Ruley
 */
public class Matrix3F extends Matrix
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
	public float element02;

	/**
	 * Represents the 4th element.
	 */
	public float element10;

	/**
	 * Represents the 5th element.
	 */
	public float element11;

	/**
	 * Represents the 6th element.
	 */
	public float element12;

	/**
	 * Represents the 7th element.
	 */
	public float element20;

	/**
	 * Represents the 8th element.
	 */
	public float element21;

	/**
	 * Represents the 9th element.
	 */
	public float element22;

	/**
	 * Initializes this matrix.
	 */
	public Matrix3F( )
	{
		super( );
	}

	/**
	 * Initializes this matrix.
	 * 
	 * @param element00 The new element00 value.
	 * @param element01 The new element01 value.
	 * @param element02 The new element02 value.
	 * @param element10 The new element10 value.
	 * @param element11 The new element11 value.
	 * @param element12 The new element12 value.
	 * @param element20 The new element20 value.
	 * @param element21 The new element21 value.
	 * @param element22 The new element22 value.
	 */
	public Matrix3F( float element00, float element01, float element02,
			float element10, float element11, float element12, float element20,
			float element21, float element22 )
	{
		this.element00 = element00;
		this.element01 = element01;
		this.element02 = element02;
		this.element10 = element10;
		this.element11 = element11;
		this.element12 = element12;
		this.element20 = element20;
		this.element21 = element21;
		this.element22 = element22;
	}

	/**
	 * Initializes this matrix by copying another matrix.
	 * 
	 * @param other The matrix to copy.
	 */
	public Matrix3F( Matrix3F other )
	{
		this( other.element00, other.element01, other.element02,
				other.element10, other.element11, other.element12,
				other.element20, other.element21, other.element22 );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Matrix3F setZero( )
	{
		element00 = 0.0F;
		element01 = 0.0F;
		element02 = 0.0F;
		element10 = 0.0F;
		element11 = 0.0F;
		element12 = 0.0F;
		element20 = 0.0F;
		element21 = 0.0F;
		element22 = 0.0F;

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Matrix3F setNegated( )
	{
		element00 = -element00;
		element01 = -element01;
		element02 = -element02;
		element10 = -element10;
		element11 = -element11;
		element12 = -element12;
		element20 = -element20;
		element21 = -element21;
		element22 = -element22;

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Matrix3F setIdentity( )
	{
		element00 = 1.0F;
		element01 = 0.0F;
		element02 = 0.0F;
		element10 = 0.0F;
		element11 = 1.0F;
		element12 = 0.0F;
		element20 = 0.0F;
		element21 = 0.0F;
		element22 = 1.0F;

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Matrix3F setTransposed( )
	{
		float element00 = this.element00;
		float element01 = this.element10;
		float element02 = this.element20;
		float element10 = this.element01;
		float element11 = this.element11;
		float element12 = this.element21;
		float element20 = this.element02;
		float element21 = this.element12;
		float element22 = this.element22;

		this.element00 = element00;
		this.element01 = element01;
		this.element02 = element02;
		this.element10 = element10;
		this.element11 = element11;
		this.element12 = element12;
		this.element20 = element20;
		this.element21 = element21;
		this.element22 = element22;

		return this;
	}

	/**
	 * Adds another matrix to this matrix.
	 * 
	 * @param other The matrix to add.
	 * @return This matrix.
	 */
	public Matrix3F add( Matrix3F other )
	{
		element00 += other.element00;
		element01 += other.element01;
		element02 += other.element02;
		element10 += other.element10;
		element11 += other.element11;
		element12 += other.element12;
		element20 += other.element20;
		element21 += other.element21;
		element22 += other.element22;

		return this;
	}

	/**
	 * Subtracts another matrix from this matrix.
	 * 
	 * @param other The matrix to subtract.
	 * @return This matrix.
	 */
	public Matrix3F subtract( Matrix3F other )
	{
		element00 -= other.element00;
		element01 -= other.element01;
		element02 -= other.element02;
		element10 -= other.element10;
		element11 -= other.element11;
		element12 -= other.element12;
		element20 -= other.element20;
		element21 -= other.element21;
		element22 -= other.element22;

		return this;
	}

	/**
	 * Multiplies this matrix by another matrix.
	 * 
	 * @param other The matrix to multiply by.
	 * @return This matrix.
	 */
	public Matrix3F multiply( Matrix3F other )
	{
		float element00 = this.element00 * other.element00
				+ this.element10 * other.element01
				+ this.element20 * other.element02;
		float element01 = this.element01 * other.element00
				+ this.element11 * other.element01
				+ this.element21 * other.element02;
		float element02 = this.element02 * other.element00
				+ this.element12 * other.element01
				+ this.element22 * other.element02;
		float element10 = this.element00 * other.element10
				+ this.element10 * other.element11
				+ this.element20 * other.element12;
		float element11 = this.element01 * other.element10
				+ this.element11 * other.element11
				+ this.element21 * other.element12;
		float element12 = this.element02 * other.element10
				+ this.element12 * other.element11
				+ this.element22 * other.element12;
		float element20 = this.element00 * other.element20
				+ this.element10 * other.element21
				+ this.element20 * other.element22;
		float element21 = this.element01 * other.element20
				+ this.element11 * other.element21
				+ this.element21 * other.element22;
		float element22 = this.element02 * other.element20
				+ this.element12 * other.element21
				+ this.element22 * other.element22;

		this.element00 = element00;
		this.element01 = element01;
		this.element02 = element02;
		this.element10 = element10;
		this.element11 = element11;
		this.element12 = element12;
		this.element20 = element20;
		this.element21 = element21;
		this.element22 = element22;

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Matrix3F store( FloatBuffer floatBuffer )
	{
		floatBuffer.put( element00 );
		floatBuffer.put( element01 );
		floatBuffer.put( element02 );
		floatBuffer.put( element10 );
		floatBuffer.put( element11 );
		floatBuffer.put( element12 );
		floatBuffer.put( element20 );
		floatBuffer.put( element21 );
		floatBuffer.put( element22 );
		floatBuffer.flip( );

		return this;
	}
}
