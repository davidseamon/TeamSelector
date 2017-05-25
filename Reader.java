import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is responsible for reading the input files for both the Members
 * and the Projects and adding them to ArrayLists
 * Note that the files must be saved in the project file outside of the src file
 *
 */
public class Reader {
	/**
	 * Since the constructor does nothing, maybe we can make this a static
	 * class? I'm not really sure what the advantages/disadvantages are
	 */
	public Reader() {

	}

	/**
	 * Finds the .txt file with the Project data
	 * 
	 * @return
	 */
	public ArrayList<Project> inputProjectInfo() {
		// creates an ArrayList that stores all the Projects and a Scanner to
		// read the
		// .txt files
		ArrayList<Project> projects = new ArrayList<Project>();
		Scanner projectScanner = null;

		// finds the file and inputs it to the Scanner
		try {
			String projectFile = "SampleProjectData.txt";
			File projectInfo = new File(projectFile);
			projectScanner = new Scanner(projectInfo);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Project File Not Found");
		}

		// calls a helper method to generate the Projects
		generateProjectsFromFile(projectScanner, projects);

		return projects;
	}

	/**
	 * Creates the Projects from the input file
	 */
	private void generateProjectsFromFile(Scanner input, ArrayList<Project> projects) {
		// ignores the first line of headers
		input.nextLine();

		// runs once per line for as many lines as there are in the .txt file
		while (input.hasNextLine()) {

			// stores all of the data that's a String into one array
			String[] stringData = new String[2];
			stringData[0] = input.next();
			stringData[1] = input.next();

			// stores all of the data that are integers into one array
			int[] intData = new int[3];
			intData[0] = input.nextInt();
			intData[1] = input.nextInt();
			intData[2] = input.nextInt();

			// creates a new Project and adds it to the Projects ArrayList
			Project newProject = new Project(stringData, intData);
			projects.add(newProject);
			input.nextLine();
		}
	}

	public ArrayList<Member> inputMemberInfo(ArrayList<Project> projects) {
		// Creates an ArrayList to store the Members and a Scanner to read the
		// file
		ArrayList<Member> members = new ArrayList<Member>();
		Scanner personScanner = null;

		// finds the Member file and inputs it into the Scanner
		try {
			String filePath = "SampleMemberData.txt";
			File personInfo = new File(filePath);
			personScanner = new Scanner(personInfo);
		} catch (FileNotFoundException e) {
			System.out.println("Member File Not Found");
		}

		// calls a helper method to create the Members
		generateMembersFromFile(personScanner, members, projects);
		return members;
	}

	/**
	 * Creates the Members from the member file
	 */
	private void generateMembersFromFile(Scanner input, ArrayList<Member> members, ArrayList<Project> projects) {
		// clears the first line of headers
		input.nextLine();

		// runs once per line for as many lines as there are
		while (input.hasNextLine()) {

			// Stores all of the data that are Strings into a single array
			String[] stringData = new String[4];
			stringData[0] = input.next();
			stringData[1] = input.next();
			stringData[2] = input.next();
			stringData[3] = input.next();

			// Stores all of the data that are integers into a single array
			int[] intData = new int[9];
			intData[0] = input.nextInt();
			intData[1] = input.nextInt();
			intData[2] = input.nextInt();
			intData[3] = input.nextInt();
			intData[4] = input.nextInt();
			intData[5] = input.nextInt();
			intData[6] = input.nextInt();
			intData[7] = input.nextInt();
			intData[8] = input.nextInt();
			input.nextLine();

			// Creates a new Member and adds it to the Members ArrayList
			Member newMember = new Member(stringData, intData, projects);
			members.add(newMember);
		}
	}
}
