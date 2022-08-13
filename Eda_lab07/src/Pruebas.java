
public class Pruebas {
	
	public static void main(String[] args) {
		hashTabl<String> hm = new hashTabl<String>(10);
		hm.put(20, "Franks");
		hm.put(12, "hola");
		hm.put(5, "asdas");
		hm.put(18, "fhgf");
		hm.put(8, "werw");
		System.out.println(hm.Search(18));
		System.out.println(hm.Search(8));
	}

}
