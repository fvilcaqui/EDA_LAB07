
public class hashEncad<T> implements HashTable{
	
	User[] Hash;
	int tamaño,cantidad;
	
	public hashEncad(int tamaño) {
		this.tamaño = tamaño;
		Hash = new User[tamaño];
		for(int i=0;i<tamaño;i++) {
			Hash[i] = new User();
		}
	}
	public int size() {
		return cantidad;
	}

	public boolean isEmpty() {
		if(Hash.length>0)
			return true;
		return false;
	}

	public boolean containsKey(Integer key) {
	     if (key == null) throw new NullPointerException("argument to get() is null");
	     return SearchKey(key);
	}

	public boolean containsValue(Object value) {
	     if (value == null) throw new NullPointerException("argument to get() is null");
	     return SearchVal(value);
	}

	public Integer get(Integer key) {
		return key%tamaño;
	}

	public void put(Integer key, Object value) {
		int HashIndex = get(key);
		User ArrayValor = Hash[HashIndex];
		User newItem = new User(key , value);
		newItem.next = ArrayValor.next;
		ArrayValor.next = newItem;
		cantidad ++;
	}

	public void remove(Integer key) {
		T value = null;
		int HashIndex = get(key);
		User ArrayValor = Hash[HashIndex];
		while(ArrayValor != null) {
			if(ArrayValor.getKey()==key) {
		       ArrayValor.setValue(null);
		       cantidad--;
		       break;
			}
			ArrayValor = ArrayValor.next;
		}
	}

	public void clear() {
		for(int key=0;key<tamaño;key++) {
			T value = null;
			int HashIndex = get(key);
			User ArrayValor = Hash[HashIndex];
			while(ArrayValor != null) {
				ArrayValor.setValue(null);
			}
				ArrayValor = ArrayValor.next;
		}
	}
	
	public T Search(int key) {
		T value = null;
		int HashIndex = get(key);
		User ArrayValor = Hash[HashIndex];
		while(ArrayValor != null) {
			if(ArrayValor.getKey()==key) {
		         value = (T) ArrayValor.getValue();
		         break;
			}
			ArrayValor = ArrayValor.next;
		}
		return value;
	}
	
	public boolean SearchKey(int key) {
		T value = null;
		int HashIndex = get(key);
		User ArrayValor = Hash[HashIndex];
		while(ArrayValor != null) {
			if(ArrayValor.getKey()==key) {
		         value = (T) ArrayValor.getValue();
		         return true;
			}
			ArrayValor = ArrayValor.next;
		}
		return false;
	}
	public boolean SearchVal(Object valor) {
		for(int key=0;key<tamaño;key++) {
			T value = null;
			int HashIndex = get(key);
			User ArrayValor = Hash[HashIndex];
			while(ArrayValor != null) {
				if(ArrayValor.getValue()==valor) {
			         return true;
				}
				ArrayValor = ArrayValor.next;
			}
		}
		return false;
	}



}
