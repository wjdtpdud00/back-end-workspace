package person;

public class Person {
	private int id;
	private String Name;
	private String address;
	public Person() {
		
	}
	
	public Person(int id, String name, String address) {
		super();
		this.id = id;
		Name = name;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", Name=" + Name + ", address=" + address + "]";
	}
	
	
}
