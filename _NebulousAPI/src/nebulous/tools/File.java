package nebulous.tools;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class File {
	
	private PrintWriter file = null;
	private String location = "";
	
	public File(String location){
		this.location = location;
	}
	
	public void open(){
		if(file != null) file.close();
		else try { file = new PrintWriter(new FileOutputStream(new java.io.File(location), true));
		} catch (FileNotFoundException e) { e.printStackTrace(); }
	}
	
	public void close(){
		if(file != null) file.close();
		file = null;
	}
	
	public void append(Object o){
		if(file != null) file.println(o);
		else System.err.println("[DataHandler]: <ERROR> No file open to append.");
	}
	
	public boolean isOpen(){
		return file != null ? true : false;
	}
	
	public void clearFile(){
		try { file = new PrintWriter(location);
		} catch (FileNotFoundException e) { e.printStackTrace(); }
		file.close();
		file = null;
	}
	
	@Override
	protected void finalize() {
		if(file != null) file.close();
		try { super.finalize(); } catch (Throwable e) { e.printStackTrace(); }
	}

}
