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
 * Acts as a base for matrices.
 * 
 * @version 1.0 20200131
 * @author Christopher R. Ruley
 */
public abstract class Matrix
{
	/**
	 * Initializes this matrix by setting it to the identity.
	 */
	public Matrix( )
	{
		setIdentity( );
	}

	/**
	 * Sets this matrix to zero.
	 * 
	 * @return This matrix.
	 */
	public abstract Matrix setZero( );

	/**
	 * Sets this matrix to its negated value.
	 * 
	 * @return This matrix.
	 */
	public abstract Matrix setNegated( );

	/**
	 * Sets this matrix to the identity.
	 * 
	 * @return This matrix.
	 */
	public abstract Matrix setIdentity( );

	/**
	 * Sets this matrix to its transposed order.
	 * 
	 * @return This matrix.
	 */
	public abstract Matrix setTransposed( );

	/**
	 * Stores this matrix in a float buffer.
	 * 
	 * @param floatBuffer The float buffer to store this matrix in.
	 * @return This matrix.
	 */
	public abstract Matrix store( FloatBuffer floatBuffer );
}
