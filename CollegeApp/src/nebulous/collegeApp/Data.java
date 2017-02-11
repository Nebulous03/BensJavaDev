package nebulous.collegeApp;

import java.util.ArrayList;

public class Data {
	
	public static ArrayList<FamilyMember> familyMembers = new ArrayList<FamilyMember>();
	public static Profile profile = new Profile();
	
	public static ArrayList<FamilyMember> getFamilyMembers(){
		return familyMembers;
	}

	public static Profile getProfile() {
		return profile;
	}

}
