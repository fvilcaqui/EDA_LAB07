
public class PruebasEncad {
	
	public static void main(String[] args) {
		hashEncad<String> hm = new hashEncad<String>(10);
		hm.put(20, "Franks");
		hm.put(12, "Anghely");
		hm.put(5, "Yair");
		hm.put(18, "Javier");
		hm.put(8, "Milagros");
		System.out.println(hm.Search(18));
		System.out.println(hm.Search(8));
		hm.remove(8);
		System.out.println(hm.Search(8));
		System.out.println(hm.Search(12));
		hm.size();
		hm.isEmpty();
		hm.containsKey(20);
		hm.containsValue("Yair");
		hm.clear();
		System.out.println(hm.Search(20));  			
	}
	
}
