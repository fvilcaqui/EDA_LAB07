
public class PruebasSonde {
	
	public static void main(String[] args) {
		HashSonde hs = new HashSonde();
		hs.put(20, "Franks");
		hs.put(12, "Anghely");
		hs.put(5, "Yair");
		hs.put(18, "Javier");
		hs.put(8, "Milagros");
		System.out.println(hs.SearchKey(18));
		System.out.println(hs.SearchKey(8));
		hs.remove(8);
		System.out.println(hs.SearchKey(8));
		System.out.println(hs.SearchKey(12));
		hs.size();
		hs.isEmpty();
		hs.containsKey(20);
		hs.containsValue("Yair");
		hs.clear();
		System.out.println(hs.SearchKey(20));  			
	}

}
