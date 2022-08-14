
public class HashSonde implements HashTable{
	private int Tamaño, maxSize=10;
    private Integer[] keys;
    private Object[] value;
    
    public HashSonde(){
        Tamaño = 0;
        keys = new Integer[maxSize];
        value = new Object[maxSize];
    }

	public int size() {
    	return Tamaño; 
	}

	public boolean isEmpty() {
    	return size() == 0; 
	}

	public boolean containsKey(Integer key) {
		if (key == null) throw new NullPointerException("argument to get() is null");
		return SearchKey(key) != null;
	}

	public boolean containsValue(Object value) {
	     if (value == null) throw new NullPointerException("argument to get() is null");
		return false;
	}

	public Integer get(Integer key) {
		return key.hashCode() % maxSize;
	}

	public void put(Integer key, Object valor) {
	     int tmp = get(key);
	     int i = tmp;
	        do {
	            if (keys[i] == null) {
	                keys[i] = key;
	                value[i] = valor;
	                Tamaño++;
	                return;
	            }
	            if (keys[i].equals(key)) {
	                value[i] = valor;
	                return;
	            }
	            i = (i + 1) % maxSize;
	        }
	 
	        while (i != tmp);
		
	}

	public void remove(Integer key) {
	      if (!containsKey(key))
	            return;	 
	        int i = get(key);
	        while (!key.equals(keys[i]))
	            i = (i + 1) % maxSize;
	        keys[i] = null; 
	        value[i] = null;
	        for (i = (i + 1) % maxSize; keys[i] != null;i = (i + 1) % maxSize) {
	            int tmp1 = keys[i];
	            Object tmp2 = value[i];
	            keys[i] = null; 
		        value[i] = null;
	            Tamaño--;
	            put(tmp1, tmp2);
	        }
	        Tamaño--;
	}

	public void clear() {
        Tamaño = 0;
        keys = new Integer[maxSize];
        value = new String[maxSize];
	}	   
 
    public Object SearchKey(Integer key){
        int i = get(key);
        while (keys[i] != null) {
            if (keys[i].equals(key))
                return value[i];
            i = (i + 1) % maxSize;
        }
        return null;
    }
 
    public void Imprimir(){
        System.out.println("\nHash Table: ");
        for (int i = 0; i < maxSize; i++)
            if (keys[i] != null)
                System.out.println(keys[i] + " " + value[i]);
        System.out.println();
    }


}
