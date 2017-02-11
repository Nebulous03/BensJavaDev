package nebulous.something;

import java.util.HashMap;

public class ItemIndex {
	
	private static HashMap<Integer, String> nameIndex = new HashMap<Integer, String>();
	private static HashMap<String, Integer> idIndex = new HashMap<String, Integer>();
	private static int index = 0;

//	public static final int Copper_Ingot = 1;
//	public static final int Iron_Ingot = 2;
//	public static final int Silver_Ingot = 3;
//	public static final int Gold_Ingot = 4;
//	public static final int Wooden_Sword = 5;
//	public static final int Iron_Sword = 6;
	
	public static void createItem(String localName){
		nameIndex.put(index + 1, localName);
		idIndex.put(localName, index + 1);
		index++;
	}
	
	public static String getNameFromID(int id){
		return nameIndex.get(id);
	}
	
	public static int getIDfromName(String localName){
		return idIndex.get(localName);
	}
	
}
