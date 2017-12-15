import java.util.ArrayList;

/**
 * @author admin
 *
 */
public class Group {
	private ArrayList<ContactPerson> ContactList = new ArrayList<ContactPerson>();
	private String groupID;

	public Group(String groupid) {
		groupID = groupid;
	}

	/**
	 * @return the ContactList
	 */
	public ArrayList<ContactPerson> getContactList() {
		return ContactList;
	}

	/**
	 * @param ContactList
	 *            the ContactList to set
	 */
	public void setContactList(ArrayList<ContactPerson> ContactList) {
		this.ContactList = ContactList;
	}

	/**
	 * Add new contact person.
	 * @param contactperson contact person
	 */
	public void addContactPerson(ContactPerson contactperson) {
		this.ContactList.add(contactperson);
	}

	/**
	 * Remove a contact person.
	 * @param name name of a contact person
	 */
	public void removeContactPerson(String name) {
		for (ContactPerson want : ContactList) {
			if (want.getName().equals(name)) {
				ContactList.remove(want);
				return;
			}
		}
	}

	/**
	 * 
	 * @param name name of a contact person
	 * @return the contact person that users want
	 */
	public ContactPerson getContactPerson(String name) {
		for (ContactPerson want : ContactList) {
			if (want.getName().equals(name)) {
				return want;
			}
		}
		return null;
	}

	/**
	 * @return the ID
	 */
	public String getID() {
		return groupID;
	}

	/**
	 * Display the group information
	 */
	public String toString() {
		String str = groupID + "\n";
		String str2 = groupID + "\n";
		for (ContactPerson want : ContactList) {
			str = str + want.toString() + "\n";
		}
		if (str.equals(str2))
			str = str + "There is no contact person in this group!\n";
		return str;
	}
}
