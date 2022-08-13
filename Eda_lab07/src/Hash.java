
public class Hash<Key extends Comparable<Key>, Value> implements HashTable {
	private Node first;
	private int cantidad=0;
    private static final int CantidadCuadro = 10;
    
	public int size() {
		return cantidad;
	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public boolean containsKey(Object key) {
        if (key == null) throw new NullPointerException("argument to get() is null");
        return searchKey(first, key);
	}

	public boolean containsValue(Object value) {
        if (value == null) throw new NullPointerException("argument to get() is null");
        return searchVal(first, value);
	}

	public Integer get(String key) {
		Node aux = this.first;
		if ( key == null) throw new NullPointerException("argument to get() is null");
		while(aux != null && aux.getKey().equals(key)) {
			aux = aux.getNext();
		}
		
		if(aux.getKey().equals(key)) {
			if(aux.getValor() == null)
				System.out.println("No existe ingun valor en: " + key);
			System.out.println("El valor de : " + aux.getKey() + "  es: " + aux.getValor());
		}
		return null;
	}

	public Integer put(String key, Integer value) {
		Node aux = this.first;
		if (value == null || key == null) throw new NullPointerException("argument to get() is null");
		
		while(aux != null && aux.getKey().equals(key)) {
			aux = aux.getNext();
		}
		
		if(aux.getKey().equals(key)) {
			if(aux.getValor() == null)
				System.out.println("No existia ningun valor en: " + key);
			System.out.println("El valor: " + aux.getValor() + "  ah sido eliminado de: " + aux.getKey());
			aux.setValor(null);
		}
		return null;
	}

	public Integer remove(Object key) {
		Node aux = this.first;
		if (key == null) throw new NullPointerException("argument to get() is null");
		while(aux != null && aux.getKey().equals(key)) {
			aux = aux.getNext();
		}
		
		if(aux.getKey().equals(key)) {
			if(aux.getValor() == null)
				System.out.println("El codigo ah sido ingresado exitosamente");
			System.out.println("El codigo ha sido eliminado exitosamente");
			aux.setValor(null);
		}
		return null;
	}

	public void clear() {
		Node aux = this.first;
		while(aux != null) {
			aux.setValor(null);
			aux = aux.getNext();
		}
	}
	
	public int hashCode() {
		return 0;
	}
	    
	public String toString() {
		String toStr = "";
		Node a = this.first;
		for(int i=0; i<CantidadCuadro; i++) {
			toStr = ""; 
		}	
		return toStr;
	}
	// extras
	public boolean searchKey(Node a,Object key) {
		Node aux = this.first;
		while(aux != null && aux.getKey() == a.getKey()) {
			aux = aux.getNext();
		}
		if(aux.getKey() == a.getKey()) {
			return true;
		}
		return false;
	}
	
	public boolean searchVal(Node a,Object val) {
		Node aux = this.first;
		while(aux != null && aux.getValor() == a.getValor()) {
			aux = aux.getNext();
		}
		if(aux.getValor() == a.getValor()) {
			return true;
		}
		return false;	
	}
	
	public void CreateTable() {
		Node aux = this.first;
		for(int i=0;i < CantidadCuadro;i++) {
			aux.setValor(i);
		}
	}

}
