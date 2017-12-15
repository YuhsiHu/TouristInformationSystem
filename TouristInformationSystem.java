import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author admin
 *
 */
import java.util.StringTokenizer;

public class TouristInformationSystem {
	private static BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
	private static PrintWriter stdOut = new PrintWriter(System.out, true);
	private static PrintWriter stdErr = new PrintWriter(System.err, true);

	private ArrayList<Group> GroupList = new ArrayList<Group>();
	private ArrayList<Individual> IndividualList = new ArrayList<Individual>();

	/**
	 * Loads data and starts the application.
	 *
	 * @param args
	 *            String arguments. Not used.
	 * @throws IOException
	 *             if there are errors in the input.
	 */
	public static void main(String[] args) throws IOException {

		TouristInformationSystem application = new TouristInformationSystem();
		application.run();

	}

	/**
	 *
	 * @param initial
	 */
	private TouristInformationSystem() {

		Individual individual1 = new Individual(new String("I001"), new String("XiaoMing"), new String("11111"),
				new String("Ming1@126.com"));
		Individual individual2 = new Individual(new String("I002"), new String("XiaoHong"), new String("22222"),
				new String("Hong2@126.com"));
		Individual individual3 = new Individual(new String("I003"), new String("XiaoGang"), new String("33333"),
				new String("Gang3@126.com"));

		ContactPerson person1 = new ContactPerson(new String("C001"), new String("XiaoFang"), new String("44444"),
				new String("Fang4@163.com"), new String("guide"));
		ContactPerson person2 = new ContactPerson(new String("C002"), new String("XiaoQing"), new String("55555"),
				new String("Qing5@163.com"), new String("commander"));
		ContactPerson person3 = new ContactPerson(new String("C003"), new String("XiaoDong"), new String("66666"),
				new String("Dong6@163.com"), new String("assistant"));

		ContactPerson person4 = new ContactPerson(new String("C004"), new String("XiaoHang"), new String("77777"),
				new String("Hang7@163.com"), new String("guide"));
		ContactPerson person5 = new ContactPerson(new String("C005"), new String("XiaoTing"), new String("88888"),
				new String("Ting8@163.com"), new String("commander"));
		ContactPerson person6 = new ContactPerson(new String("C006"), new String("XiaoWang"), new String("99999"),
				new String("Wang9@163.com"), new String("assistant"));

		IndividualList.add(individual1);
		IndividualList.add(individual2);
		IndividualList.add(individual3);

		Group group1 = new Group(new String("G001"));
		Group group2 = new Group(new String("G002"));

		group1.addContactPerson(person1);
		group1.addContactPerson(person2);
		group1.addContactPerson(person3);
		group2.addContactPerson(person4);
		group2.addContactPerson(person5);
		group2.addContactPerson(person6);

		GroupList.add(group1);
		GroupList.add(group2);
	}

	/**
	 * Presents the user with a menu of options and executes the selected task.
	 * 
	 * @throws IOException
	 */
	private void run() throws IOException {

		int choice = getChoice();

		while (choice != 0) {
			if (choice == 1) {
				addTourist();
			} else if (choice == 2) {
				stdErr.print("Tourist ID> ");
				stdErr.flush();
				String id = stdIn.readLine();
				findTourist(id);
			} else if (choice == 3) {
				stdErr.print("Tourist ID> ");
				stdErr.flush();
				String id = stdIn.readLine();
				removeTourist(id);
			} else if (choice == 4) {
				addContactPerson();
			} else if (choice == 5) {
				stdErr.print("Group ID> ");
				stdErr.flush();
				String groupid = stdIn.readLine();
				stdErr.print("Contact person name> ");
				stdErr.flush();
				String contactpersonname = stdIn.readLine();
				findContactPerson(groupid, contactpersonname);
			} else if (choice == 6) {
				stdErr.print("Group ID> ");
				stdErr.flush();
				String groupid = stdIn.readLine();
				stdErr.print("Contact person name> ");
				stdErr.flush();
				String contactpersonname = stdIn.readLine();
				removeContactPerson(groupid, contactpersonname);
			} else if (choice == 7) {
				displayIndividual();
			} else if (choice == 8) {
				displayGroup();
			}
			choice = getChoice();
		}
	}

	/*
	 * Displays a menu of options and verifies the user's choice.
	 *
	 * @return an integer in the range [0,8]
	 */
	private int getChoice() throws IOException {

		int input;
		do {
			try {
				stdErr.println();
				stdErr.print("[0] Quit\n" + "[1] Add a tourist into the system\n" + "[2] Look up a tourist by ID\n"
						+ "[3] Remove a tourist from the system by ID\n"
						+ "[4] Add a new contact for a tourist groups\n"
						+ "[5] Look up a contact by the ID of group and the name of contact\n"
						+ "[6] Remove a contact given the ID of the group and the name of the contact\n"
						+ "[7] Display individual list\n" + "[8] Display group list\n" + "choice> ");
				stdErr.flush();

				input = Integer.parseInt(stdIn.readLine());

				stdErr.println();

				if (0 <= input && input <= 8) {
					break;
				} else {
					stdErr.println("Invalid choice:  " + input);
				}
			} catch (NumberFormatException nfe) {
				stdErr.println(nfe);
			}
		} while (true);

		return input;
	}

	/**
	 * 
	 * @throws IOException
	 */
	public void addTourist() throws IOException {
		stdErr.println("Input tourist information(Id,name,telephonenum,email)> ");
		Individual individual = readIndividual();

		while (individual == null)
			individual = readIndividual();
		IndividualList.add(individual);
		stdErr.println("Add tourist successfully!");
	}

	/**
	 * Read a individual
	 * 
	 * @return individual
	 * @throws IOException
	 */
	private Individual readIndividual() throws IOException {

		String newindividual = stdIn.readLine();
		StringTokenizer individualinfo = new StringTokenizer(newindividual, ",");
		try {
			int size = individualinfo.countTokens();
			if (size > 4) {
				throw new Exception("Contain more value");
			} else if (size < 4) {
				throw new Exception("Contain fewer value");
			} else {
				String id = "";
				String name = "";
				String telephonenum = "";
				String email = "";
				id = individualinfo.nextToken();
				name = individualinfo.nextToken();
				telephonenum = individualinfo.nextToken();
				email = individualinfo.nextToken();
				Individual individual = new Individual(id, name, telephonenum, email);
				return individual;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * Find a tourist given the ID of individual
	 * 
	 * @param id
	 *            if
	 * @return individual
	 * @throws IOException
	 */
	private Individual findTourist(String id) throws IOException {
		int c = 0;
		for (Individual now : IndividualList) {
			if (now.getID().equals(id)) {
				stdErr.println(now.toString());
				c = 1;
				return now;
			}
		}
		if (c == 0) {
			stdErr.println("There is no tourist with that ID");
			return null;
		}
		return null;
	}

	/**
	 * Remove a tourist given the ID of individual.
	 * 
	 * @param id
	 *            id
	 * @throws IOException
	 */
	public void removeTourist(String id) throws IOException {
		int c = 0;
		for (Individual now : IndividualList) {
			if (now.getID().equals(id)) {
				c = 1;
				IndividualList.remove(now);
				stdErr.println("Remove successfully!");
				return;
			}
		}
		if (c == 0)
			stdErr.println("There is no tourist with that ID");
	}

	/**
	 * Add contact person given the ID of the group and the name of the contact.
	 * 
	 * @throws IOException
	 */
	public void addContactPerson() throws IOException {
		stdErr.println("Input contact person information(Id,name,telephonenum,email,job position)> ");
		ContactPerson contactperson = readContactPerson();

		while (contactperson == null)
			contactperson = readContactPerson();
		stdErr.println("Group ID> ");
		stdErr.flush();
		String groupid = stdIn.readLine();
		int k = 0;
		for (Group now : GroupList) {
			if (now.getID().equals(groupid)) {
				now.addContactPerson(contactperson);
				stdErr.println("Add successfully!");
				k = 1;
			}
		}
		if (k == 0) {
			stdErr.println("There is no group with that ID!\n" + "Do you want to add a new group?");
			stdErr.println("If you want to continue,input Y");
			stdErr.println("If you want to stop,input N");

			String choice = stdIn.readLine();
			String yes = "Y";
			if (choice.equals(yes)) {
				Group newGroup = new Group(groupid);
				newGroup.addContactPerson(contactperson);
				GroupList.add(newGroup);
				stdErr.println("You add a contact person to a new group successfully!");
			} else {
				return;
			}
		}
	}

	/**
	 * Read a contact person.
	 * 
	 * @return contact person
	 * @throws IOException
	 */
	private ContactPerson readContactPerson() throws IOException {

		String newperson = stdIn.readLine();
		StringTokenizer personinfo = new StringTokenizer(newperson, ",");
		try {
			int size = personinfo.countTokens();
			if (size > 5) {
				throw new Exception("Contain more value");
			} else if (size < 5) {
				throw new Exception("Contain fewer value");
			} else {
				String id = "";
				String name = "";
				String telephonenum = "";
				String email = "";
				String job = "";
				id = personinfo.nextToken();
				name = personinfo.nextToken();
				telephonenum = personinfo.nextToken();
				email = personinfo.nextToken();
				job = personinfo.nextToken();
				ContactPerson contactperson = new ContactPerson(id, name, telephonenum, email, job);
				stdErr.println("Add contact person successfully");
				return contactperson;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * Find contact person given the ID of the group and the name of the contact
	 * 
	 * @param groupid
	 *            group ID
	 * @param contactpersonname
	 *            name of a contact person
	 * @return contact person
	 * @throws IOException
	 */
	public ContactPerson findContactPerson(String groupid, String contactpersonname) throws IOException {
		int g = 0, c = 0;
		for (Group now : GroupList) {
			if (now.getID().equals(groupid)) {
				g = 1;
				for (ContactPerson want : now.getContactList()) {
					if (want.getName().equals(contactpersonname)) {
						c = 1;
						stdErr.println(want.toString());
						return want;
					}
				}
			}
		}
		if ((c == 0) && (g == 1))
			stdErr.println("There is no contact person with that name!");
		if (g == 0)
			stdErr.println("There is no group with that ID!");
		return null;
	}

	/**
	 * Remove contact person given the ID of the group and the name of the contact
	 * 
	 * @param groupid
	 *            group ID
	 * @param contactpersonname
	 *            name of a contact person
	 * @throws IOException
	 */
	public void removeContactPerson(String groupid, String contactpersonname) throws IOException {
		int g = 0;
		for (Group now : GroupList) {
			if (now.getID().equals(groupid)) {
				g = 1;
				now.removeContactPerson(contactpersonname);
				stdErr.println("Remove successfully!");
				return;
			}
		}
		if (g == 0)
			stdErr.println("There is no group with that ID!");

	}

	/**
	 * Displays the groups.
	 */
	public void displayGroup() {

		int size = this.GroupList.size();

		if (size == 0) {
			stdErr.println("The group list is empty");
		} else {
			for (Group group : this.GroupList) {
				stdErr.println(group.toString());
			}
		}
	}

	/**
	 * Displays the Individuals
	 */
	public void displayIndividual() throws IOException {
		int size = this.IndividualList.size();

		if (size == 0) {
			stdErr.println("The individual list is empty");
		} else {
			for (Individual individual : this.IndividualList) {
				stdErr.println(individual.toString());
			}
		}
	}
}
