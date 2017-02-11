package nebulous;

public class TestingSerialization {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		byte[] 	array 		= 	new byte[16];
		byte  	dataByte 	= 	0x08;
		short 	dataShort 	= 	Short.MAX_VALUE;
		int		dataInt		= 	Integer.MAX_VALUE;
		long	dataLong	= 	Long.MAX_VALUE;
		String  dataString  =	"Hello World!";
		
//		Field field = new Field(DataType.STRING, "testString", "HelloWorld!");
//		
//		System.out.print("Bytes: ");
//		printBytes(field.getBytes());
//		System.out.print("\n");
//		
//		readField(field.getBytes());
//		
//		Field field2 = new Field(DataType.INT, "testInt", 12);
//		
//		System.out.print("\nBytes: ");
//		printBytes(field.getBytes());
//		System.out.print("\n");
//		
//		readField(field2.getBytes());
		
//		byte[] b1 = new byte[] { 0, 1, 2, 3 };
//		byte[] b2 = new byte[] { 0, 1, 2 };
//		
//		System.out.println(SerializationUtils.compare(b1, b2));
		
//		byte[] bytes = new byte[SerializedFile.HEADER.length + SerializedFile.FOOTER.length];
//		SerializationUtils.setBytes(bytes, 0, SerializedFile.HEADER);
//		SerializationUtils.setBytes(bytes, bytes.length - SerializedFile.FOOTER.length, SerializedFile.FOOTER);
//		
//		printBytes(SerializedFile.HEADER);
//		printBytes(SerializedFile.FOOTER);
//		printBytes(bytes);
//		
//		System.out.println(SerializedFile.verify(bytes));
		
//		Field field3 = new Field(DataType.STRING, "testString", "HelloWorld!");
//		printBytes(field3.getBytes());
//		System.out.println(field3.getSize());
		
//		SerializedFile file = new SerializedFile("./res/file.neb");
//		file.add(field3);
//		byte[] finalBytes = file.serialize();
//		System.out.println(SerializedFile.verify(finalBytes));
//		
//		printBytes(finalBytes);
		
//		Field byteArray= new Field(DataType.ARRAY_BYTE, "byteArray", new byte[] {0x45,0x46,0x72,0x3f,0x78});
//		printBytes(byteArray.getBytes());
//		
//		Field shortArray= new Field(DataType.ARRAY_SHORT, "shortArray", new short[] {0x45,0x46,0x72,0x3f,0x78});
//		printBytes(shortArray.getBytes());
//		
//		Field intArray= new Field(DataType.ARRAY_INT, "intArray", new int[] {12,13,14,15,16});
//		printBytes(intArray.getBytes());
//		
//		Field longArray= new Field(DataType.ARRAY_LONG, "longArray", new long[] {12,13,14,15,16});
//		printBytes(longArray.getBytes());
//		
//		Field floatArray= new Field(DataType.ARRAY_FLOAT, "floatArray", new float[] {12.1f,13.2f,14.3f,15.4f,16.5f});
//		printBytes(floatArray.getBytes());
//		
//		Field doubleArray= new Field(DataType.ARRAY_DOUBLE, "doubleArray", new double[] {12.0,13.0,14.0,15.0,16.0});
//		printBytes(doubleArray.getBytes());
//		
//		Field booleanArray= new Field(DataType.ARRAY_BOOLEAN, "booleanArray", new boolean[] {true, true, false});
//		printBytes(booleanArray.getBytes());
		
//		byte[] bytes = new byte[4];
//		SerializationUtils.setBytes(bytes, 0, new byte[] { 0x1, 0x2 } );
//		
//		SerializationUtils.readByteArray(bytes, 0);
		
//		Field field = new Field(DataType.ARRAY_BYTE, "byteArray", new byte[] {0x1,0x2,0x3,0x4,0x5,0x6,0x7,0x8,0x9,0xA,0xB,0xC});
//		Field field2 = new Field(DataType.ARRAY_INT, "intArray", new int[] {1,2,3,4,5,6,7,8,9,10});
//		
//		Field.deserialize(field.getBytes());
//		Field.deserialize(field2.getBytes());
		
//		Field bytef = new Field(DataType.BYTE, "b", (byte)0x2);
//		Field intf = new Field(DataType.INT, "i", 12000);
//		Field boolf = new Field(DataType.BOOLEAN, "b", true);
//		Field intaf = new Field(DataType.ARRAY_INT, "ai", new int[] {1,2,4,8,16,32,64,128,Integer.MAX_VALUE} );
//		Field intal = new Field(DataType.ARRAY_LONG, "al", new long[] {12,24,48,Long.MAX_VALUE} );
		
//		byte b = bytef.get();
//		int i = intf.get();
		
//		System.out.println(b);
//		System.out.println(i);
		
//		System.out.println(intf);
//		System.out.println(boolf);
//		System.out.println(intaf);
//		System.out.println(intal);
		
//		boolean b = boolf.get();
//		System.out.println(b);
		
//		int[] test = intaf.get();
//		for(int i2 : test) System.out.print(i2 + " ");
//		System.out.println();
//		
//		long[] test2 = intal.get();
//		for(long i2 : test2) System.out.print(i2 + " ");
//		System.out.println();
		
//		Field stringf = new Field(DataType.STRING, "sf", "HelloWorld!");
//		System.out.println(stringf);
//		
//		String result = stringf.get();
//		System.out.println(result);
		
//		Field stringaf = new Field(DataType.ARRAY_STRING, "string_array", new String[] {"HelloWorld1", "HelloWorld2", "HelloWorld3"} );
//		System.out.println(stringaf);
//		String[] result = stringaf.get();
//		for(String s : result) System.out.print(s + ", ");
		
//		String[] test = new String[] {"HelloWorld1", "HelloWorld2", "HelloWorld3"};
//		byte[] test2 = new byte[1000];
//		SerializationUtils.setBytes(test2, 0, test);
//		printBytes(test2);
//		String[] result = SerializationUtils.readStringArray(test2, 0);
//		for(String s : result) System.out.print(s + ", ");
		
		Field stringaf = new Field(DataType.ARRAY_STRING, "string_array", new String[] {"HelloWorld1", "HelloWorld2", "HelloWorld3"} );
		Field byteaf = new Field(DataType.ARRAY_BYTE, "byte_array", new byte[] {0x1,0x2,0x3,0x4,0x5,0x6,0x7,0x8,0x9,0xA,0xB,0xC});
		Field bytef = new Field(DataType.BYTE, "b", (byte)0x2);
		Field intf = new Field(DataType.INT, "i", 12000);
		Field boolf = new Field(DataType.BOOLEAN, "b", true);
		Field intaf = new Field(DataType.ARRAY_INT, "ai", new int[] {1,2,4,8,16,32,64,128,Integer.MAX_VALUE} );
		Field longaf = new Field(DataType.ARRAY_LONG, "al", new long[] {12,24,48,Long.MAX_VALUE} );
		
		SerializedFile file = new SerializedFile("./res/file.neb");
		file.add(stringaf);
		file.add(byteaf);
		file.add(bytef);
		file.add(intf);
		file.add(boolf);
		file.add(intaf);
		file.add(longaf);
		file.serializeAndSave();
		
		System.out.println("Hello!");
		
	}
	
	static void printBytes(byte[] bytes){
		for (int i = 0; i < bytes.length; i++){
			System.out.printf("0x%x ", bytes[i]);
		} System.out.println();
	}
	
	static Object readField(byte[] bytes){
		byte container = bytes[0];
		byte type = bytes[1];
		short nameLength = SerializationUtils.readShort(bytes, 2);
		String name = SerializationUtils.readString(bytes, 2);
		Object data = null;
		switch(type){
		default: return null;
		case Field.TYPE_BYTE:
			data =  SerializationUtils.readByte(bytes, 4 + name.length()); break;
		case Field.TYPE_CHAR:
			data =  SerializationUtils.readChar(bytes, 4 + name.length()); break;
		case Field.TYPE_SHORT:
			data =  SerializationUtils.readShort(bytes, 4 + name.length()); break;
		case Field.TYPE_INT:
			data =  SerializationUtils.readInt(bytes, 4 + name.length()); break;
		case Field.TYPE_LONG:
			data =  SerializationUtils.readLong(bytes, 4 + name.length()); break;
		case Field.TYPE_FLOAT:
			data =  SerializationUtils.readFloat(bytes, 4 + name.length()); break;
		case Field.TYPE_DOUBLE:
			data =  SerializationUtils.readDouble(bytes, 4 + name.length()); break;
		case Field.TYPE_BOOLEAN:
			data =  SerializationUtils.readBoolean(bytes, 4 + name.length()); break;
		case Field.TYPE_STRING:
			data = SerializationUtils.readString(bytes, 4 + name.length()); break;
		}
		
		System.out.println("Container: " + container + "\n" + "Type: " + type + "\n" + "NameLength: " + nameLength + "\n" + "Name: " + name);
		System.out.println("Data: " + data);
		return null;
	}

}
