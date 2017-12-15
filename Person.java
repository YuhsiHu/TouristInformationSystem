/**
 * @author admin
 *
 */
public abstract class Person {

	private String ID;
	private String name;
	private String telephonenum;
	private String email;

	/**
	 * Initializes the person.
	 * 
	 * @param id
	 *            id
	 * @param Name
	 *            name
	 * @param Telephonenum
	 *            telephone number
	 * @param Email
	 *            email
	 */
	public Person(String id, String Name, String Telephonenum, String Email) {
		ID = id;
		name = Name;
		telephonenum = Telephonenum;
		email = Email;

	}

	/**
	 * @return the ID
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the telephone number
	 */
	public String getTelephonenum() {
		return telephonenum;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Display the person information
	 */
	public String toString() {
		return "[ID=" + ID + "," + " name=" + name + "," + " telephone number=" + telephonenum + "," + " email="
				+ email;
	}
}
