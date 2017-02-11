package nebulous;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@SuppressWarnings("unused")
public class SerializedFile {
	
	public static final byte VERSION = 0x01;
	public static String date = "0";	// TODO: FIX
	
	public static final byte[] HEADER = ("NSO_BEGIN" + VERSION) .getBytes();
	public static final byte[] FOOTER = ("NSO_END") .getBytes();
	
	private ArrayList<Field> fields = new ArrayList<Field>();
	
	private PrintWriter file 	= null;
	
	private String 	location 	= "";
	private byte[] 	data		= new byte[0];
	private long 	pointer 	= 0;
	private long 	fieldIntex	= 0;
	
	public SerializedFile(String location){
		this.location = location;
		
		if(file != null) file.close();
		else try { file = new PrintWriter(new FileOutputStream(new File(location), true));
		} catch (FileNotFoundException e) { e.printStackTrace(); }
		
		file.println(data);
		file.close();
	}
	
	public static boolean verify(byte[] bytes){
		if(!SerializationUtils.compare(bytes, 0, HEADER, 0, HEADER.length)) return false;
		if(!SerializationUtils.compare(bytes, bytes.length - FOOTER.length, FOOTER, 0, FOOTER.length)) return false;
		return true;
	}
	
	public void serializeAndSave(){
		byte[] bytes = serialize();
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(location);
			fos.write(bytes);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		assert(verify(bytes));
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Object> T read(){
		
		return (T)(Object)null;
	}
	
	public byte[] serialize(){
		int localPointer = 0;
		byte[] bytes = null;
		int size = HEADER.length + FOOTER.length;
		for(Field field : fields)
			size += field.getSize();
		bytes = new byte[size + 8];
		localPointer = SerializationUtils.setBytes(bytes, 0, HEADER);
		for(Field field : fields){
			localPointer = SerializationUtils.setBytes(bytes, localPointer, field.getBytes());
		}
		localPointer = SerializationUtils.setBytes(bytes, localPointer, FOOTER);
		return bytes;
	}
	
	public void add(Field field){
		fields.add(field);
	}
	
	public Field readNextField(){
		fieldIntex++;
		return fields.get((int) (fieldIntex - 1));
	}

}
