import java.util.ArrayList;

/**
 * This class is used to represent an Insight member and stores all of their data as well as contains
 * algorithms that generate their "priority" to determine who gets added to teams first
 */
public class Member implements Comparable<Member>{
	//all of the data read in from the file
	private String name;
	private Integer year;
	private Integer priorityRanking;
	private ArrayList<String> projectChoicesStrings;
	private ArrayList<Project> projectChoices;
	private ArrayList<Integer> skills;
	private Integer pastSemesters;
	private Integer successfulSemesters;
	private Integer attendedMeetings;
	private int missedMeetings;
	
	/**
	 * the constructor for a Member that assigns all of the data from the file
	 * to object variables
	 */
	public Member(String[] stringData, int[] intData, ArrayList<Project> allProjects) {
		projectChoicesStrings = new ArrayList<String>();
		skills = new ArrayList<Integer>();
		projectChoices = new ArrayList<Project>();
		name = stringData[0];
		projectChoicesStrings.add(stringData[1]);
		projectChoicesStrings.add(stringData[2]);
		projectChoicesStrings.add(stringData[3]);
			
		year = intData[0];
		for (int i = 1; i < 4; i++) {
			skills.add(intData[i]);
		}
		
		pastSemesters = intData[5];
		successfulSemesters = intData[6];
		attendedMeetings = intData[7];
		missedMeetings = intData[8];
		generatePriorityRanking();
		convertTeamChoicesToTeams(allProjects);
	}
	
	/**
	 * Converts all of the names of the Projects (since they're passed in as Strings)
	 * to actual Project objects
	 * @param allProjects
	 */
	private void convertTeamChoicesToTeams(ArrayList<Project> allProjects) {
		for (int i = 0; i < projectChoicesStrings.size(); i++) {
			for (int j = 0; j < allProjects.size(); j++) {
				if (projectChoicesStrings.get(i).equals(allProjects.get(j).getName())) {
					projectChoices.add(allProjects.get(j));
					break;
				}
			}
		}
	}
	
	/**
	 * This is where the priority ranking for a Member is generated, should be changed
	 * once an appropriate algorithm is determined
	 */
	private void generatePriorityRanking() {
		priorityRanking = 0;
		if (pastSemesters != 0) {
		priorityRanking = (missedMeetings / attendedMeetings)* (successfulSemesters / pastSemesters);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public Integer getPriorityRanking() {
		return priorityRanking;
	}
	
	public ArrayList<Project> getTeamChoices() {
		return projectChoices;
	}
	
	/**
	 * Determines the Member's best skill - This won't be needed
	 * once all of the Member's skills are taken into account, but was used for
	 * the simpler version David wrote
	 * 
	 */
	public String getMaxSkill() {
		String maxSkill = null;
		if (skills.get(0) > skills.get(1) && skills.get(0) > skills.get(2)) {
			maxSkill = "hacker";
		}
		else if (skills.get(1) > skills.get(0) && skills.get(1) > skills.get(2)) {
			maxSkill = "tinkerer";
		}
		else if (skills.get(2) > skills.get(0) && skills.get(2) > skills.get(1)) {
			maxSkill = "business";
		}
		return maxSkill;
	}
	
	/**
	 * This is the method the priority queue uses to determine priority. In order to
	 * have multiple Generation types, we will have to add more methods that compare Members
	 */
	@Override
	public int compareTo(Member o) {
		if (this.getPriorityRanking() > o.getPriorityRanking()) {
			return 1;
		}
		else {
			return -1;
		}
	}
}
