import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * This class is the main application of the Team Selector
 *
 */
public class TeamSelector {
	
	/**
	 * The main method of the Team Selector
	 */
	public static void main(String[] args) {
		//creates a reader object
		Reader reader = new Reader();
		
		//creates a generator
		//TODO: User input which generation class to use once we have more than one
		TeamGenerationADT generator = new TeamGenerationByMemberPreference();
		
		//ArrayLists to store all of the Projects and all of the Members
		ArrayList<Project> allProjects = new ArrayList<Project>();
		ArrayList<Member> allPersons = new ArrayList<Member>();
		
		//gets all of the Projects and the Members from the files
		allProjects = reader.inputProjectInfo();
		allPersons = reader.inputMemberInfo(allProjects);
		
		//creates a PriorityQueue and adds all of the Members to it
		PriorityQueue<Member> pq = new PriorityQueue<Member>();
		for (int i = 0; i < allPersons.size(); i++) {
			pq.add(allPersons.get(i));
		}
		
		//generates the teams and prints them
		generator.generateProjects(pq, allProjects);
	}
	
}
