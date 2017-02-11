package nebulous;

import java.nio.ByteBuffer;

@SuppressWarnings("unused")
public class Field {
	
	public static final String DEFAULT_NAME 	= "UNNAMED";
	public static final byte[] DEFAULT_DATA		= new byte[0];
	
	public static final byte CONTAINER_UNKNOWN 	= 0x00;
	public static final byte CONTAINER_FIELD 	= 0x01;
	public static final byte CONTAINER_ARRAY	= 0x02;
	public static final byte CONTAINER_OBJECT	= 0x03;
	
	public static final byte TYPE_UNKNOWN 		= 0x00;
	public static final byte TYPE_BYTE 			= 0x01;
	public static final byte TYPE_CHAR 			= 0x02;
	public static final byte TYPE_SHORT			= 0x03;
	public static final byte TYPE_INT 			= 0x04;
	public static final byte TYPE_LONG 			= 0x05;
	public static final byte TYPE_FLOAT 		= 0x06;
	public static final byte TYPE_DOUBLE 		= 0x07;
	public static final byte TYPE_BOOLEAN 		= 0x08;
	public static final byte TYPE_STRING 		= 0x09;
	public static final byte TYPE_OBJECT 		= 0x0a;
	
	private byte   container = CONTAINER_UNKNOWN;
	private byte   type      = TYPE_UNKNOWN;
	private String name		 = DEFAULT_NAME;
	private byte[] data      = DEFAULT_DATA;
	private byte[] bytes	 = DEFAULT_DATA;
	
	public int datapointer = 0;
	private int size = 0;
	private Object value = null;
	
	private Field() {}
	
	public Field(DataType type, String name, Object value){
		this.name = name;
		this.value = value;
		switch(type){
		default : 
			data = new byte[2];
			new Exception("Cannot create field with null or UNKNOWN data type.").printStackTrace(); 
			break;
		case UNKNOWN : 
			data = new byte[2];
			new Exception("Cannot create field with null or UNKNOWN data type.").printStackTrace(); 
			break;
		case BYTE : 
			this.container = CONTAINER_FIELD;
			this.type = TYPE_BYTE;
			data = new byte[getTypeSize(TYPE_BYTE)];
			SerializationUtils.setBytes(data, 0, (byte)value);
			break;
		case CHAR : 
			this.container = CONTAINER_FIELD;
			this.type = TYPE_CHAR;
			data = new byte[getTypeSize(TYPE_CHAR)];
			SerializationUtils.setBytes(data, 0, (char)value);
			break;
		case SHORT : 
			this.container = CONTAINER_FIELD;
			this.type = TYPE_SHORT;
			data = new byte[getTypeSize(TYPE_SHORT)];
			SerializationUtils.setBytes(data, 0, (short)value);
			break;
		case INT : 
			this.container = CONTAINER_FIELD;
			this.type = TYPE_INT;
			data = new byte[getTypeSize(TYPE_INT)];
			SerializationUtils.setBytes(data, 0, (int)value);
			break;
		case LONG : 
			this.container = CONTAINER_FIELD;
			this.type = TYPE_LONG;
			data = new byte[getTypeSize(TYPE_LONG)];
			SerializationUtils.setBytes(data, 0, (long)value);
			break;
		case FLOAT : 
			this.container = CONTAINER_FIELD;
			this.type = TYPE_FLOAT;
			data = new byte[getTypeSize(TYPE_FLOAT)];
			SerializationUtils.setBytes(data, 0, (float)value);
			break;
		case DOUBLE : 
			this.container = CONTAINER_FIELD;
			this.type = TYPE_DOUBLE;
			data = new byte[getTypeSize(TYPE_DOUBLE)];
			SerializationUtils.setBytes(data, 0, (double)value);
			break;
		case BOOLEAN : 
			this.container = CONTAINER_FIELD;
			this.type = TYPE_BOOLEAN;
			data = new byte[getTypeSize(TYPE_BOOLEAN)];
			SerializationUtils.setBytes(data, 0, (boolean)value);
			break;
		case STRING :
			this.container = CONTAINER_FIELD;
			this.type = TYPE_STRING;
			data = new byte[2 + ((String)value).getBytes().length];
			SerializationUtils.setBytes(data, 0, (String)value);
			break;
		case OBJECT :
			this.container = CONTAINER_OBJECT;
			//TODO : CREATE OBJECT
			break;
		case ARRAY_BYTE :
			this.container = CONTAINER_ARRAY;
			this.type = TYPE_BYTE;
			data = new byte[(((byte[])value).length * getTypeSize(TYPE_BYTE))];
			SerializationUtils.setBytes(data, 0, (byte[])value);
			break;
		case ARRAY_CHAR :
			this.container = CONTAINER_ARRAY;
			this.type = TYPE_CHAR;
			data = new byte[(((char[])value).length * getTypeSize(TYPE_CHAR))];
			SerializationUtils.setBytes(data, 0, (char[])value);
			break;
		case ARRAY_SHORT :
			this.container = CONTAINER_ARRAY;
			this.type = TYPE_SHORT;
			data = new byte[(((short[])value).length * getTypeSize(TYPE_SHORT))];
			SerializationUtils.setBytes(data, 0, (short[])value);
			break;
		case ARRAY_INT :
			this.container = CONTAINER_ARRAY;
			this.type = TYPE_INT;
			data = new byte[(((int[])value).length * getTypeSize(TYPE_INT))];
			SerializationUtils.setBytes(data, 0, (int[])value);
			break;
		case ARRAY_LONG :
			this.container = CONTAINER_ARRAY;
			this.type = TYPE_LONG;
			data = new byte[(((long[])value).length * getTypeSize(TYPE_LONG))];
			SerializationUtils.setBytes(data, 0, (long[])value);
			break;
		case ARRAY_FLOAT :
			this.container = CONTAINER_ARRAY;
			this.type = TYPE_FLOAT;
			data = new byte[(((float[])value).length * getTypeSize(TYPE_FLOAT))];
			SerializationUtils.setBytes(data, 0, (float[])value);
			break;
		case ARRAY_DOUBLE :
			this.container = CONTAINER_ARRAY;
			this.type = TYPE_DOUBLE;
			data = new byte[(((double[])value).length * getTypeSize(TYPE_DOUBLE))];
			SerializationUtils.setBytes(data, 0, (double[])value);
			break;
		case ARRAY_STRING :
			this.container = CONTAINER_ARRAY;
			this.type = TYPE_STRING;
			int length = 0;
			assert(value instanceof String[]);
			for(String s : (String[])value) length += (s.length() + 2);
			data = new byte[length + 2];
			SerializationUtils.setBytes(data, 0, (String[])value);
			break;
		case ARRAY_BOOLEAN :
			this.container = CONTAINER_ARRAY;
			this.type = TYPE_BOOLEAN;
			data = new byte[(((boolean[])value).length * getTypeSize(TYPE_BOOLEAN))];
			SerializationUtils.setBytes(data, 0, (boolean[])value);
			break;
		case ARRAY_OBJECT : 
			//TODO: Make Array_Object
			break;
		}
		
		int pointer = 0;
		int optional = 2;	//TODO: ADD SUPPORT FOR OBJECTS!!!
		// Container + NameLength + Name + Type + data + optional
		bytes = new byte[4 + name.getBytes().length + data.length + optional];
		pointer = SerializationUtils.setBytes(bytes, pointer, this.container);
		pointer = SerializationUtils.setBytes(bytes, pointer, this.type);
		pointer = SerializationUtils.setBytes(bytes, pointer, this.name);
		datapointer = pointer;
		if(this.container == CONTAINER_ARRAY) {
			if(type != DataType.ARRAY_STRING) pointer = SerializationUtils.setBytes(bytes, pointer, (short)(data.length / getTypeSize(this.type)));
		}
		pointer = SerializationUtils.setBytes(bytes, pointer, this.data);
		size = pointer;
	}
	
	public static Field deserialize(byte[] bytes){
		int pointer = 0;
		Field field = new Field();
		
		field.container = SerializationUtils.readByte(bytes, pointer);		pointer ++;
		field.type = SerializationUtils.readByte(bytes, pointer);			pointer ++;
		field.name = SerializationUtils.readString(bytes, pointer);			pointer += field.name.length() + 2;
		
		field.data = SerializationUtils.subArray(bytes, pointer, bytes.length);
		
		return field;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Object> T get(){
		if(container == CONTAINER_FIELD){
			switch(type){
			case TYPE_BYTE :
				return (T)(Object)data[0];
			case TYPE_CHAR :
				return (T)(Object)SerializationUtils.readChar(data, 0);
			case TYPE_SHORT :
				return (T)(Object)SerializationUtils.readShort(data, 0);
			case TYPE_INT :
				return (T)(Object)SerializationUtils.readInt(data, 0);
			case TYPE_LONG :
				return (T)(Object)SerializationUtils.readLong(data, 0);
			case TYPE_FLOAT :
				return (T)(Object)SerializationUtils.readFloat(data, 0);
			case TYPE_DOUBLE :
				return (T)(Object)SerializationUtils.readDouble(data, 0);
			case TYPE_BOOLEAN :
				return (T)(Object)SerializationUtils.readBoolean(data, 0);
			case TYPE_STRING : 
				return (T)(Object)SerializationUtils.readString(data, 0);
			}
		} else if (container == CONTAINER_ARRAY){ 
			switch(type){
			case TYPE_BYTE :
				return (T)(Object)SerializationUtils.readByteArray(bytes, datapointer);
			case TYPE_CHAR :
				return (T)(Object)SerializationUtils.readCharArray(bytes, datapointer);
			case TYPE_SHORT :
				return (T)(Object)SerializationUtils.readShortArray(bytes, datapointer);
			case TYPE_INT :
				return (T)(Object)SerializationUtils.readIntArray(bytes, datapointer);
			case TYPE_LONG :
				return (T)(Object)SerializationUtils.readLongArray(bytes, datapointer);
			case TYPE_FLOAT :
				return (T)(Object)SerializationUtils.readFloatArray(bytes, datapointer);
			case TYPE_DOUBLE :
				return (T)(Object)SerializationUtils.readDoubleArray(bytes, datapointer);
			case TYPE_BOOLEAN :
				return (T)(Object)SerializationUtils.readBooleanArray(bytes, datapointer);
			case TYPE_STRING :
				return (T)(Object)SerializationUtils.readStringArray(bytes, datapointer);
			}
		} return null;
	}
	
	public byte[] getBytes(){
		return bytes;
	}
	
	public void setName(String name) {
		assert(name.length() < Short.MAX_VALUE);
		this.name = name;
	}
	
	public int getSize(){
		return size;
	}
	
	public static int getTypeSize(byte type){
		switch(type) { 
		default : 			assert (false);
		case TYPE_UNKNOWN :	assert (false);
		case TYPE_BYTE : 	return 1;
		case TYPE_CHAR : 	return 1;
		case TYPE_SHORT : 	return 2;
		case TYPE_INT : 	return 4;
		case TYPE_LONG :	return 8;
		case TYPE_FLOAT : 	return 4;
		case TYPE_DOUBLE : 	return 8;
		case TYPE_BOOLEAN : return 1;
		case TYPE_OBJECT :	return -1;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder(data.length * getTypeSize(type));
		string.append(container + ", " + type + ", " + name + ", ");
		if(container == CONTAINER_ARRAY) string.append(SerializationUtils.readShort(data, 0) + ", ");
	    for(byte b: data)
	    	string.append(String.format("0x%X", b & 0xff) + " ");
		return string.toString();
	}

}
