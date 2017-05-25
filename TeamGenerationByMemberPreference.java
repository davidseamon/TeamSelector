import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TeamGenerationByMemberPreference implements TeamGenerationADT {
	//List to store Members not selected by the selection process
	List<Member> notSelected;
	List<Project> projects;
	
	/**
	 * Constructor just creates the Lists
	 */
	public TeamGenerationByMemberPreference() {
		notSelected = new ArrayList<Member>();
		projects = new ArrayList<Project>();
	}
	
	/**
	 * This is the method responsible for actually generating the teams,
	 * and is the algorithm we'll have to determine
	 */
	@Override
	public void generateProjects(PriorityQueue<Member> pq, ArrayList<Project> projects) {
		this.projects = projects;
		Member currentMember;
		boolean selected = false;
		
		//While there are members left in the PQ...
		while (!pq.isEmpty()) {
			//take the top member from the PQ
			currentMember = pq.remove();
			//Iterate through the list of the Member's project choices, and add
			//them to their top rated that isn't full
			for (int i = 0; i < currentMember.getTeamChoices().size(); i++) {
				if (!currentMember.getTeamChoices().get(i).isFull()) {
					currentMember.getTeamChoices().get(i).addMember(currentMember);
					selected = true;
					break;
				}
			}
			//if all of the projects they want are full, they are added to not selected
			if (!selected) {
				notSelected.add(currentMember);
			}
		}
		//once the PQ is empty, the project teams are printed
		printProjects();
	}
	
	/**
	 * The projects are printed, first the Projects and their Members and
	 * then the people not selected
	 */
	@Override
	public void printProjects() {
		System.out.println("Teams Generated By Member Preference:");
		for (int i = 0; i < projects.size(); i++) {
			System.out.print(projects.get(i));
		}
		
		System.out.println("Members Not Selected By Member Preference:");
		for (int i = 0; i < notSelected.size(); i++) {
			System.out.println(notSelected.get(i).getName());
		}
		if (notSelected.isEmpty()) {
			System.out.println("None");
		}

	}

}