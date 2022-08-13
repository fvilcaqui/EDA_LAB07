
public class Node<e> {
	private  e key;
	private Node next;
	private Object valor;
	public Node(e key, Object valor, Node next) {
		this.key = key;
		this.next = next;
		this.valor = valor;
	}
	public Node(e data) {
		this(data,null, null);
	}
	public e getKey() {
		return this.key;
	}
	public void setkey(e key) {
		this.key = key;
	}
	public Object getValor() {
		return this.valor;
	}
	public void setValor(Object valor) {
		this.valor = valor;
	}
	public Node getNext(){
		return this.next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

}
