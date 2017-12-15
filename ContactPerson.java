/**
 * @author admin
 *
 */
public class ContactPerson extends Person {
	private String jobPosition;

	/**
	 * Initializes the Contact Person.
	 * 
	 * @param ID
	 *            id
	 * @param name
	 *            name
	 * @param telephonenum
	 *            telephone number
	 * @param email
	 *            email
	 * @param JobPosition
	 *            job position
	 */
	public ContactPerson(String ID, String name, String telephonenum, String email, String JobPosition) {
		super(ID, name, telephonenum, email);
		jobPosition = JobPosition;

	}

	/**
	 * @return the jobPosition
	 */
	public String getJobPosition() {
		return jobPosition;
	}

	/**
	 * Display the contact person information
	 */
	public String toString() {
		return super.toString() + "," + " jobPosition=" + jobPosition + "]";
	}
}
