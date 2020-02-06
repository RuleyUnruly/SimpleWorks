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
 * Holds a 4x4 matrix of floats.
 * 
 * @version 1.0 20200131
 * @author Christopher R. Ruley
 */
public class Matrix4F extends Matrix
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
	public float element03;

	/**
	 * Represents the 5th element.
	 */
	public float element10;

	/**
	 * Represents the 6th element.
	 */
	public float element11;

	/**
	 * Represents the 7th element.
	 */
	public float element12;

	/**
	 * Represents the 8th element.
	 */
	public float element13;

	/**
	 * Represents the 9th element.
	 */
	public float element20;

	/**
	 * Represents the 10th element.
	 */
	public float element21;

	/**
	 * Represents the 11th element.
	 */
	public float element22;

	/**
	 * Represents the 12th element.
	 */
	public float element23;

	/**
	 * Represents the 13th element.
	 */
	public float element30;

	/**
	 * Represents the 14th element.
	 */
	public float element31;

	/**
	 * Represents the 15th element.
	 */
	public float element32;

	/**
	 * Represents the 16th element.
	 */
	public float element33;

	/**
	 * Initializes this matrix.
	 */
	public Matrix4F( )
	{
		super( );
	}

	/**
	 * Initializes this matrix.
	 * 
	 * @param element00 The new element00 value.
	 * @param element01 The new element01 value.
	 * @param element02 The new element02 value.
	 * @param element03 The new element03 value.
	 * @param element10 The new element10 value.
	 * @param element11 The new element11 value.
	 * @param element12 The new element12 value.
	 * @param element13 The new element13 value.
	 * @param element20 The new element20 value.
	 * @param element21 The new element21 value.
	 * @param element22 The new element22 value.
	 * @param element23 The new element23 value.
	 * @param element30 The new element30 value.
	 * @param element31 The new element31 value.
	 * @param element32 The new element32 value.
	 * @param element33 The new element33 value.
	 */
	public Matrix4F( float element00, float element01, float element02,
			float element03, float element10, float element11, float element12,
			float element13, float element20, float element21, float element22,
			float element23, float element30, float element31, float element32,
			float element33 )
	{
		this.element00 = element00;
		this.element01 = element01;
		this.element02 = element02;
		this.element03 = element03;
		this.element10 = element10;
		this.element11 = element11;
		this.element12 = element12;
		this.element13 = element13;
		this.element20 = element20;
		this.element21 = element21;
		this.element22 = element22;
		this.element23 = element23;
		this.element30 = element30;
		this.element31 = element31;
		this.element32 = element32;
		this.element33 = element33;
	}

	/**
	 * Initializes this matrix by copying another matrix.
	 * 
	 * @param other The matrix to copy.
	 */
	public Matrix4F( Matrix4F other )
	{
		this( other.element00, other.element01, other.element02,
				other.element03, other.element10, other.element11,
				other.element12, other.element13, other.element20,
				other.element21, other.element22, other.element23,
				other.element30, other.element31, other.element32,
				other.element33 );
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Matrix4F setZero( )
	{
		element00 = 0.0F;
		element01 = 0.0F;
		element02 = 0.0F;
		element03 = 0.0F;
		element10 = 0.0F;
		element11 = 0.0F;
		element12 = 0.0F;
		element13 = 0.0F;
		element20 = 0.0F;
		element21 = 0.0F;
		element22 = 0.0F;
		element23 = 0.0F;
		element30 = 0.0F;
		element31 = 0.0F;
		element32 = 0.0F;
		element33 = 0.0F;

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Matrix4F setNegated( )
	{
		element00 = -element00;
		element01 = -element01;
		element02 = -element02;
		element03 = -element03;
		element10 = -element10;
		element11 = -element11;
		element12 = -element12;
		element13 = -element13;
		element20 = -element20;
		element21 = -element21;
		element22 = -element22;
		element23 = -element23;
		element30 = -element30;
		element31 = -element31;
		element32 = -element32;
		element33 = -element33;

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Matrix4F setIdentity( )
	{
		element00 = 1.0F;
		element01 = 0.0F;
		element02 = 0.0F;
		element03 = 0.0F;
		element10 = 0.0F;
		element11 = 1.0F;
		element12 = 0.0F;
		element13 = 0.0F;
		element20 = 0.0F;
		element21 = 0.0F;
		element22 = 1.0F;
		element23 = 0.0F;
		element30 = 0.0F;
		element31 = 0.0F;
		element32 = 0.0F;
		element33 = 1.0F;

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Matrix4F setTransposed( )
	{
		float element00 = this.element00;
		float element01 = this.element10;
		float element02 = this.element20;
		float element03 = this.element30;
		float element10 = this.element01;
		float element11 = this.element11;
		float element12 = this.element21;
		float element13 = this.element31;
		float element20 = this.element02;
		float element21 = this.element12;
		float element22 = this.element22;
		float element23 = this.element32;
		float element30 = this.element03;
		float element31 = this.element13;
		float element32 = this.element23;
		float element33 = this.element33;

		this.element00 = element00;
		this.element01 = element01;
		this.element02 = element02;
		this.element03 = element03;
		this.element10 = element10;
		this.element11 = element11;
		this.element12 = element12;
		this.element13 = element13;
		this.element20 = element20;
		this.element21 = element21;
		this.element22 = element22;
		this.element23 = element23;
		this.element30 = element30;
		this.element31 = element31;
		this.element32 = element32;
		this.element33 = element33;

		return this;
	}

	/**
	 * Adds another matrix to this matrix.
	 * 
	 * @param other The matrix to add.
	 * @return This matrix.
	 */
	public Matrix4F add( Matrix4F other )
	{
		element00 += other.element00;
		element01 += other.element01;
		element02 += other.element02;
		element03 += other.element03;
		element10 += other.element10;
		element11 += other.element11;
		element12 += other.element12;
		element13 += other.element13;
		element20 += other.element20;
		element21 += other.element21;
		element22 += other.element22;
		element23 += other.element23;
		element30 += other.element30;
		element31 += other.element31;
		element32 += other.element32;
		element33 += other.element33;

		return this;
	}

	/**
	 * Subtracts another matrix from this matrix.
	 * 
	 * @param other The matrix to subtract.
	 * @return This matrix.
	 */
	public Matrix4F subtract( Matrix4F other )
	{
		element00 -= other.element00;
		element01 -= other.element01;
		element02 -= other.element02;
		element03 -= other.element03;
		element10 -= other.element10;
		element11 -= other.element11;
		element12 -= other.element12;
		element13 -= other.element13;
		element20 -= other.element20;
		element21 -= other.element21;
		element22 -= other.element22;
		element23 -= other.element23;
		element30 -= other.element30;
		element31 -= other.element31;
		element32 -= other.element32;
		element33 -= other.element33;

		return this;
	}

	/**
	 * Multiplies this matrix by another matrix.
	 * 
	 * @param other The matrix to multiply by.
	 * @return This matrix.
	 */
	public Matrix4F multiply( Matrix4F other )
	{
		float element00 = this.element00 * other.element00
				+ this.element10 * other.element01
				+ this.element20 * other.element02
				+ this.element30 * other.element03;
		float element01 = this.element01 * other.element00
				+ this.element11 * other.element01
				+ this.element21 * other.element02
				+ this.element31 * other.element03;
		float element02 = this.element02 * other.element00
				+ this.element12 * other.element01
				+ this.element22 * other.element02
				+ this.element32 * other.element03;
		float element03 = this.element03 * other.element00
				+ this.element13 * other.element01
				+ this.element23 * other.element02
				+ this.element33 * other.element03;
		float element10 = this.element00 * other.element10
				+ this.element10 * other.element11
				+ this.element20 * other.element12
				+ this.element30 * other.element13;
		float element11 = this.element01 * other.element10
				+ this.element11 * other.element11
				+ this.element21 * other.element12
				+ this.element31 * other.element13;
		float element12 = this.element02 * other.element10
				+ this.element12 * other.element11
				+ this.element22 * other.element12
				+ this.element32 * other.element13;
		float element13 = this.element03 * other.element10
				+ this.element13 * other.element11
				+ this.element23 * other.element12
				+ this.element33 * other.element13;
		float element20 = this.element00 * other.element20
				+ this.element10 * other.element21
				+ this.element20 * other.element22
				+ this.element30 * other.element23;
		float element21 = this.element01 * other.element20
				+ this.element11 * other.element21
				+ this.element21 * other.element22
				+ this.element31 * other.element23;
		float element22 = this.element02 * other.element20
				+ this.element12 * other.element21
				+ this.element22 * other.element22
				+ this.element32 * other.element23;
		float element23 = this.element03 * other.element20
				+ this.element13 * other.element21
				+ this.element23 * other.element22
				+ this.element33 * other.element23;
		float element30 = this.element00 * other.element30
				+ this.element10 * other.element31
				+ this.element20 * other.element32
				+ this.element30 * other.element33;
		float element31 = this.element01 * other.element30
				+ this.element11 * other.element31
				+ this.element21 * other.element32
				+ this.element31 * other.element33;
		float element32 = this.element02 * other.element30
				+ this.element12 * other.element31
				+ this.element22 * other.element32
				+ this.element32 * other.element33;
		float element33 = this.element03 * other.element30
				+ this.element13 * other.element31
				+ this.element23 * other.element32
				+ this.element33 * other.element33;

		this.element00 = element00;
		this.element01 = element01;
		this.element02 = element02;
		this.element03 = element03;
		this.element10 = element10;
		this.element11 = element11;
		this.element12 = element12;
		this.element13 = element13;
		this.element20 = element20;
		this.element21 = element21;
		this.element22 = element22;
		this.element23 = element23;
		this.element30 = element30;
		this.element31 = element31;
		this.element32 = element32;
		this.element33 = element33;

		return this;
	}

	/**
	 * Translates this matrix.
	 * 
	 * @param translation The vector to translate by.
	 * @return This matrix.
	 */
	public Matrix4F translate( Vector3F translation )
	{
		element30 += element00 * translation.x + element10 * translation.y
				+ element20 * translation.z;
		element31 += element01 * translation.x + element11 * translation.y
				+ element21 * translation.z;
		element32 += element02 * translation.x + element12 * translation.y
				+ element22 * translation.z;
		element33 += element03 * translation.x + element13 * translation.y
				+ element23 * translation.z;

		return this;
	}

	/**
	 * Rotates this matrix.
	 * 
	 * @param angle The float (in degrees) to rotate.
	 * @param axis The vector to rotate by.
	 * @return This matrix.
	 */
	public Matrix4F rotate( float angle, Vector3F axis )
	{
		float cosine = ( float ) cos( toRadians( angle ) );
		float sine = ( float ) sin( toRadians( angle ) );
		float oneMinusCosine = 1.0F - cosine;
		float xy = axis.x * axis.y;
		float yz = axis.y * axis.z;
		float xz = axis.x * axis.z;
		float xs = axis.x * sine;
		float ys = axis.y * sine;
		float zs = axis.z * sine;
		float factor00 = axis.x * axis.x * oneMinusCosine + cosine;
		float factor01 = xy * oneMinusCosine + zs;
		float factor02 = xz * oneMinusCosine - ys;
		float factor10 = xy * oneMinusCosine - zs;
		float factor11 = axis.y * axis.y * oneMinusCosine + cosine;
		float factor12 = yz * oneMinusCosine + xs;
		float factor20 = xz * oneMinusCosine + ys;
		float factor21 = yz * oneMinusCosine - xs;
		float factor22 = axis.z * axis.z * oneMinusCosine + cosine;
		float element00 = this.element00 * factor00 + this.element10 * factor01
				+ this.element20 * factor02;
		float element01 = this.element01 * factor00 + this.element11 * factor01
				+ this.element21 * factor02;
		float element02 = this.element02 * factor00 + this.element12 * factor01
				+ this.element22 * factor02;
		float element03 = this.element03 * factor00 + this.element13 * factor01
				+ this.element23 * factor02;
		float element10 = this.element00 * factor10 + this.element10 * factor11
				+ this.element20 * factor12;
		float element11 = this.element01 * factor10 + this.element11 * factor11
				+ this.element21 * factor12;
		float element12 = this.element02 * factor10 + this.element12 * factor11
				+ this.element22 * factor12;
		float element13 = this.element03 * factor10 + this.element13 * factor11
				+ this.element23 * factor12;
		float element20 = this.element00 * factor20 + this.element10 * factor21
				+ this.element20 * factor22;
		float element21 = this.element01 * factor20 + this.element11 * factor21
				+ this.element21 * factor22;
		float element22 = this.element02 * factor20 + this.element12 * factor21
				+ this.element22 * factor22;
		float element23 = this.element03 * factor20 + this.element13 * factor21
				+ this.element23 * factor22;

		this.element00 = element00;
		this.element01 = element01;
		this.element02 = element02;
		this.element03 = element03;
		this.element10 = element10;
		this.element11 = element11;
		this.element12 = element12;
		this.element13 = element13;
		this.element20 = element20;
		this.element21 = element21;
		this.element22 = element22;
		this.element23 = element23;

		return this;
	}

	/**
	 * Scales this matrix.
	 * 
	 * @param scale The vector to scale by.
	 * @return This matrix.
	 */
	public Matrix4F scale( Vector3F scale )
	{
		element00 *= scale.x;
		element01 *= scale.x;
		element02 *= scale.x;
		element03 *= scale.x;
		element10 *= scale.y;
		element11 *= scale.y;
		element12 *= scale.y;
		element13 *= scale.y;
		element20 *= scale.z;
		element21 *= scale.z;
		element22 *= scale.z;
		element23 *= scale.z;

		return this;
	}

	/**
	 * Recreates this matrix into a transformation matrix.
	 * 
	 * @param translation The vector to translate by.
	 * @param rotation The vector to rotate by.
	 * @param scale The vector to scale by.
	 * @return The current matrix.
	 */
	public Matrix4F recreateIntoTransformation( Vector3F translation,
			Vector3F rotation, Vector3F scale )
	{
		setIdentity( );
		translate( translation );
		rotate( rotation.x, new Vector3F( 1.0F, 0.0F, 0.0F ) );
		rotate( rotation.y, new Vector3F( 0.0F, 1.0F, 0.0F ) );
		rotate( rotation.z, new Vector3F( 0.0F, 0.0F, 1.0F ) );
		scale( scale );

		return this;
	}

	/**
	 * Recreates this matrix into a view matrix.
	 * 
	 * @param translation The vector to translate by.
	 * @param rotation The vector to rotate by.
	 * @return The current matrix.
	 */
	public Matrix4F recreateIntoView( Vector3F translation, Vector3F rotation )
	{
		setIdentity( );
		rotate( rotation.x, new Vector3F( 1.0F, 0.0F, 0.0F ) );
		rotate( rotation.y, new Vector3F( 0.0F, 1.0F, 0.0F ) );
		rotate( rotation.z, new Vector3F( 0.0F, 0.0F, 1.0F ) );
		translate( new Vector3F( translation ).setNegated( ) );

		return this;
	}

	/**
	 * Recreates this matrix into a perspective matrix.
	 * 
	 * @param width The width of the window.
	 * @param height The height of the window.
	 * @param fieldOfView The extent of the observable world.
	 * @param nearPlane The first part of the frustum.
	 * @param farPlane The second part of the frustum.
	 * @return The current matrix.
	 */
	public Matrix4F recreateIntoPerspective( int width, int height,
			float fieldOfView, float nearPlane, float farPlane )
	{
		float aspectRatio = ( float ) width / ( float ) height;
		float scaleY = ( float ) ( 1.0F
				/ tan( toRadians( fieldOfView / 2.0F ) ) );
		float scaleX = scaleY / aspectRatio;
		float frustumLength = farPlane - nearPlane;

		setIdentity( );

		element00 = scaleX;
		element11 = scaleY;
		element22 = -( ( nearPlane + farPlane ) / frustumLength );
		element23 = -1.0F;
		element32 = -( 2.0F * nearPlane * farPlane / frustumLength );
		element33 = 0.0F;

		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Matrix4F store( FloatBuffer floatBuffer )
	{
		floatBuffer.put( element00 );
		floatBuffer.put( element01 );
		floatBuffer.put( element02 );
		floatBuffer.put( element03 );
		floatBuffer.put( element10 );
		floatBuffer.put( element11 );
		floatBuffer.put( element12 );
		floatBuffer.put( element13 );
		floatBuffer.put( element20 );
		floatBuffer.put( element21 );
		floatBuffer.put( element22 );
		floatBuffer.put( element23 );
		floatBuffer.put( element30 );
		floatBuffer.put( element31 );
		floatBuffer.put( element32 );
		floatBuffer.put( element33 );
		floatBuffer.flip( );

		return this;
	}
}
