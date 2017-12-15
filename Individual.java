/**
 * 
 */

/**
 * @author admin
 *
 */
public class Individual extends Person {

	/**
	 * Initialize a individual
	 * 
	 * @param ID
	 *            id
	 * @param name
	 *            name
	 * @param telephonenum
	 *            telephone number
	 * @param email
	 *            email
	 */
	public Individual(String ID, String name, String telephonenum, String email) {
		super(ID, name, telephonenum, email);
	}

	/**
	 * Display the contact person information
	 */
	public String toString() {
		return super.toString() + "]";
	}
}
