
public class hashTabl<T> implements HashTable{
	
	User[] Hash;
	int tama�o,cantidad;
	
	public hashTabl(int tama�o) {
		this.tama�o = tama�o;
		Hash = new User[tama�o];
		for(int i=0;i<tama�o;i++) {
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
		return key%tama�o;
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
