public class ListNode {
	/**
	 * private variables representing the data
	 * that will be stored in a single node.
	 */
	private String name;
	private String address;
	private String city;
	private String phoneNumber;
	protected ListNode next;
	/**
	 * constructor for a fully populated node
	 * @param name : String representing the name
	 * @param address : String representing the address
	 * @param city : String representing the city
	 * @param phoneNumber : String representing the phone number
	 */
	public ListNode(String name, String address, String city, String phoneNumber)  {
		this.name = name;
		this.address = address;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.next = null;
	}
	/**
	 * constructor for empty node
	 */
	public ListNode() {
		next = null;
	}
	/**
	 * getter methods that return local values
	 * stored for each node
	 */
	public String getName() {
		return this.name;
	}
	public String getAddress() {
		return this.address;
	}
	public String getCity() {
		return this.city;
	}
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	/**
	 * setter methods that change the values
	 * stored for each node
	 */
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setNumber(String number) {
		this.phoneNumber = number;
	}
}