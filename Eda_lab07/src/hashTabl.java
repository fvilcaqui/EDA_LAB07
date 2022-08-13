
public class hashTabl<T> implements HashTable{
	
	User[] Hash;
	int tamaño,cantidad;
	
	public hashTabl(int tamaño) {
		this.tamaño = tamaño;
		Hash = new User[tamaño];
		for(int i=0;i<tamaño;i++) {
			Hash[i] = new User();
		}
	}
	public int size() {
		return cantidad;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer get(Integer key) {
		return key%tamaño;
	}

	@Override
	public void put(Integer key, Object value) {
		int HashIndex = get(key);
		User ArrayValor = Hash[HashIndex];
		User newItem = new User(key , value);
		newItem.next = ArrayValor.next;
		ArrayValor.next = newItem;
	}

	@Override
	public Integer remove(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
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

}
