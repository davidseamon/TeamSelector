import java.util.ArrayList;

public class Project {
	//all of the data fields that are read in from the file
	private String projectName;
	private Integer difficulty;
	private Integer importance;
	private String skillRequired;
	private int numOpenSpots;
	ArrayList<Member> members;
	
	/**
	 * Inputs all of the  data from the file into Project objects
	 */
	public Project(String[] stringData, int[] intData) {
		members = new ArrayList<Member>();
		projectName = (String) stringData[0];
		skillRequired = stringData[1];
		difficulty = intData[0];
		importance = intData[1];
		numOpenSpots = intData[2];
	}
	
	public void addMember(Member currentMember) {
		members.add(currentMember);
		numOpenSpots--;
	}
	
	public String getSkillRequired() {
		return skillRequired;
	}
	
	public boolean isFull() {
		if (numOpenSpots <= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getName() {
		return projectName;
	}
	
	public String toString() {
		String toReturn = null;
		toReturn = projectName + ": \n";
		for (int i = 0; i < members.size(); i++) {
			toReturn += members.get(i).getName() + "\n";
		}
		return toReturn + "\n";
				
	}
}
