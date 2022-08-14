
public class User {
	private int key;
	private Object value;
	private String email;
	User next;
	
	public User(Integer key, Object value) {
		this.key = key;
		this.value = value;
		next = null;
	}
	
	public User() {
		next = null;
	}
	
	public User(int pId, String pName, String pEmail) {
		key = pId;
		value = pName;
		email = pEmail;
	}
		
	public int hashCode() {
	    final int prime = 31;
	    int result = key;
	    result = prime * result + ((email == null) ? 0 : email.hashCode());
	    result = prime * result + (int) (key ^ (key >>> 32));
	    result = prime * result + ((value == null) ? 0 : value.hashCode());
	    return result;
	}
	
	public int getKey() {
		return key;
	}
	
	public Object getValue() {
		return value;
	}
	
	public void setValue(Object valor) {
		value = valor;
	}
	
	public String getEmail() {
		return email;
	}

}
