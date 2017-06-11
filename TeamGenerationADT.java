import java.util.ArrayList;
import java.util.PriorityQueue;

//An ADT is used so that different assignment algos can be used
public interface TeamGenerationADT {
	
	public void generateProjects(PriorityQueue<Member> pq, ArrayList<Project> projects);
	
	public void printProjects();
	System.out.print();
}
