package nebulous;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public class SerializationUtils {
	
	public static int setBytes(byte[] array, int pointer, byte value){
		array[pointer++] = value;
		return pointer;
	}
	
	public static int setBytes(byte[] array, int pointer, char value){
		array[pointer++] = (byte)((value >> 8) & 0xff);
		array[pointer++] = (byte)((value >> 0) & 0xff);
		return pointer;
	}
	
	public static int setBytes(byte[] array, int pointer, short value){
		array[pointer++] = (byte)((value >> 8) & 0xff);
		array[pointer++] = (byte)((value >> 0) & 0xff);
		return pointer;
	}
	
	public static int setBytes(byte[] array, int pointer, int value){
		array[pointer++] = (byte)((value >> 24) & 0xff);
		array[pointer++] = (byte)((value >> 16) & 0xff);
		array[pointer++] = (byte)((value >> 8) & 0xff);
		array[pointer++] = (byte)((value >> 0) & 0xff);
		return pointer;
	}
	
	public static int setBytes(byte[] array, int pointer, long value){
		array[pointer++] = (byte)((value >> 56) & 0xff);
		array[pointer++] = (byte)((value >> 48) & 0xff);
		array[pointer++] = (byte)((value >> 40) & 0xff);
		array[pointer++] = (byte)((value >> 32) & 0xff);
		array[pointer++] = (byte)((value >> 24) & 0xff);
		array[pointer++] = (byte)((value >> 16) & 0xff);
		array[pointer++] = (byte)((value >> 8) & 0xff);
		array[pointer++] = (byte)((value >> 0) & 0xff);
		return pointer;
	}
	
	public static int setBytes(byte[] array, int pointer, float value){
		int data = Float.floatToIntBits(value);
		return setBytes(array, pointer, data);
	}
	
	public static int setBytes(byte[] array, int pointer, double value){
		long data = Double.doubleToLongBits(value);
		return setBytes(array, pointer, data);
	}
	
	public static int setBytes(byte[] array, int pointer, boolean value){
		array[pointer++] = (byte) (value ? 1 : 0);
		return pointer;
	}
	
	public static int setBytes(byte[] array, int pointer, String string){
		pointer = setBytes(array, pointer, (short)string.length());
		return setBytes(array, pointer, string.getBytes());
	}
	
	public static int setBytes(byte[] array, int pointer, byte[] value){
		for (int i = 0; i < value.length; i++)
			array[pointer++] = value[i];
		return pointer;
	}
	
	public static int setBytes(byte[] array, int pointer, char[] value){
		for (int i = 0; i < value.length; i++)
			array[pointer++] = (byte)(value[i]);
		return pointer;
	}
	
	public static int setBytes(byte[] array, int pointer, short[] value){
		ByteBuffer byteBuffer = ByteBuffer.allocate(2 * value.length);
		ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
		shortBuffer.put(value);
		setBytes(array, pointer, byteBuffer.array());
		pointer += (2 * value.length);
		return pointer;
	}
	
	public static int setBytes(byte[] array, int pointer, int[] value){
		ByteBuffer byteBuffer = ByteBuffer.allocate(4 * value.length);
		IntBuffer intBuffer = byteBuffer.asIntBuffer();
		intBuffer.put(value);
		setBytes(array, pointer, byteBuffer.array());
		pointer += (4 * value.length);
		return pointer;
	}
	
	public static int setBytes(byte[] array, int pointer, long[] value){
		ByteBuffer byteBuffer = ByteBuffer.allocate(8 * value.length);
		LongBuffer longBuffer = byteBuffer.asLongBuffer();
		longBuffer.put(value);
		setBytes(array, pointer, byteBuffer.array());
		pointer += (8 * value.length);
		return pointer;
	}
	
	public static int setBytes(byte[] array, int pointer, float[] value){
		ByteBuffer byteBuffer = ByteBuffer.allocate(4 * value.length);
		FloatBuffer floatBuffer = byteBuffer.asFloatBuffer();
		floatBuffer.put(value);
		setBytes(array, pointer, byteBuffer.array());
		pointer += (4 * value.length);
		return pointer;
	}
	
	public static int setBytes(byte[] array, int pointer, double[] value){
		ByteBuffer byteBuffer = ByteBuffer.allocate(8 * value.length);
		DoubleBuffer doubleBuffer = byteBuffer.asDoubleBuffer();
		doubleBuffer.put(value);
		setBytes(array, pointer, byteBuffer.array());
		pointer += (8 * value.length);
		return pointer;
	}
	
	public static int setBytes(byte[] array, int pointer, String[] value){
		pointer = setBytes(array, pointer, (short)value.length);
		for(int i = 0; i < value.length; i++)
			pointer = setBytes(array, pointer, value[i]);
		return pointer;
	}
	
	public static int setBytes(byte[] array, int pointer, boolean[] value){
		for (int i = 0; i < value.length; i++)
			array[pointer++] = (byte) (value[i] == true ? 0x0 : 0x1);	// TODO: Make this better
		return pointer;
	}
	
	public static byte readByte(byte[] source, int pointer){
		return (byte)(source[pointer++]);
	}
	
	public static char readChar(byte[] source, int pointer){
		return (char)(source[pointer++]);
	}
	
	public static short readShort(byte[] source, int pointer){
		return ByteBuffer.wrap(source, pointer, 2).getShort();
	}
	
	public static int readInt(byte[] source, int pointer){
		return ByteBuffer.wrap(source, pointer, 4).getInt();
	}
	
	public static long readLong(byte[] source, int pointer){
		return ByteBuffer.wrap(source, pointer, 8).getLong();
	}
	
	public static float readFloat(byte[] source, int pointer){
		return Float.intBitsToFloat(readInt(source, pointer));
	}
	
	public static double readDouble(byte[] source, int pointer){
		pointer += 8;
		return Double.longBitsToDouble(readLong(source, pointer));
	}
	
	public static boolean readBoolean(byte[] source, int pointer){
		assert(source[pointer] == 1 || source[pointer] == 0);
		return source[pointer] != 0;
	}
	
	public static String readString(byte[] source, int pointer){
		return new String(source, pointer + 2, (int)source[pointer] + (int)source[pointer + 1]);
	}
	
	public static byte[] readByteArray(byte[] source, int pointer){
		short size = readShort(source, pointer);
		byte[] array = new byte[size]; pointer += 2;
		array = subArray(source, pointer, pointer + size);
		return array;
	}
	
	public static char[] readCharArray(byte[] source, int pointer){
		short size = readShort(source, pointer);
		char[] array = new char[size]; pointer += 2;
		for(int i = 0; i < size; i++){
			array[i] = readChar(source, pointer); 
			pointer++;
		}
		return array;
	}
	
	public static short[] readShortArray(byte[] source, int pointer){
		short size = readShort(source, pointer);
		short[] array = new short[size]; pointer += 2;
		for(int i = 0; i < size; i++){
			array[i] = readShort(source, pointer); 
			pointer += 2;
		}
		return array;
	}
	
	public static int[] readIntArray(byte[] source, int pointer){
		short size = readShort(source, pointer);
		int[] array = new int[size]; pointer += 2;
		for(int i = 0; i < size; i++){
			array[i] = readInt(source, pointer); 
			pointer += 4;
		}
		return array;
	}
	
	public static long[] readLongArray(byte[] source, int pointer){
		short size = readShort(source, pointer);
		long[] array = new long[size]; pointer += 2;
		for(int i = 0; i < size; i++){
			array[i] = readLong(source, pointer); 
			pointer += 8;
		}
		return array;
	}
	
	public static float[] readFloatArray(byte[] source, int pointer){
		short size = readShort(source, pointer);
		float[] array = new float[size]; pointer += 2;
		for(int i = 0; i < size; i++){
			array[i] = readFloat(source, pointer); 
			pointer += 4;
		}
		return array;
	}
	
	public static double[] readDoubleArray(byte[] source, int pointer){
		short size = readShort(source, pointer);
		double[] array = new double[size]; pointer += 2;
		for(int i = 0; i < size; i++){
			array[i] = readDouble(source, pointer); 
			pointer += 8;
		}
		return array;
	}
	
	public static String[] readStringArray(byte[] source, int pointer){
		short size = readShort(source, pointer); pointer += 2;
		String[] array = new String[size];
		for(int i = 0; i < size; i++){
			array[i] = readString(source, pointer); 
			pointer += array[i].length() + 2;
		}
		return array;
	}
	
	public static boolean[] readBooleanArray(byte[] source, int pointer){
		short size = readShort(source, pointer);
		boolean[] array = new boolean[size]; pointer += 2;
		for(int i = 0; i < size; i++){
			array[i] = readBoolean(source, pointer); 
			pointer += 1;
		}
		return array;
	}
	
	public static boolean compare(byte[] b1, byte[] b2){
		if(b1.length != b2.length) return false;
		for(int i = 0; i < b1.length; i++)
			if(b1[i] != b2[i]) return false;
		return true;
	}
	
	public static boolean compare(byte[] b1, int b1pointer, byte[] b2, int b2pointer, int length){
		for(int i = 0; i < length; i++)
			if(b1[b1pointer + i] != b2[b2pointer + i]) return false;
		return true;
	}
	
	public static byte[] subArray(byte[] source, int start, int end){
		assert((end - start) >= 0);
		byte[] subArray = new byte[end - start];
		for(int i = start; i < end; i++){
			subArray[i - start] = source[i];
		} return subArray;
	}
}
