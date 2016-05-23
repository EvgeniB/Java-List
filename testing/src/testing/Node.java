package testing;

public class Node {
	public Object data;
	public Node previous;
	public Node next;
	
	Node(Object d, Node p, Node n){
		data = d;
		previous = p;
		next = n;
	}

	public Node getPrevious() {
		return previous;
	}
	
}
