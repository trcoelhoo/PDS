package ex2;
public class Contact {
	private String email = null;
	private Integer number;
	private String name;
	
	
	public Contact(String name, Integer number) {
		this.name=name;
		this.number=number;
	}
	
	
	public Contact(String name, Integer number, String email) {
		this.name=name;
		this.number=number;
		this.email=email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public boolean hasEmail() {
		if(email == null)
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", number=" + number + ", email=" + email + "]";
	}

	@Override
	public boolean equals(Object x) {
		Contact y = (Contact) x;
		if(y.hasEmail()) {
			if(name.equals(y.getName()) && email.equals(y.getEmail()) && number==y.getNumber())
				return true;
		}else {
			if(name.equals(y.getName())&& number==y.getNumber())
				return true;
		}
		
		return false;
	}
	
	
	
	

}