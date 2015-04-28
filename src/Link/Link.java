package Link;

public class Link<T> {
	
	 
	   
	    private Node<T> header, tail;
	    private int size;
	    public Link() {
	        this.header = null;
	        this.tail = null;
	        this.size = 0;
	    }
	  
	    public boolean isEmpty() {
	        return header == null;
	    }
	   
	    public void addToHeader(T item) {
	        header = new Node<T>(item);
	        size += 1;
	        if (tail == null)
	            tail = header;
	    }
	   
	    public void addToTail(T item) {
	        if (!isEmpty()) {
	            tail.next = new Node<T>(item); 
	            tail = tail.next;
	            size += 1;
	        } else {
	            header = tail = new Node<T>(item);
	            size += 1;
	        }
	    }
	  
	    public void print() {
	        if (isEmpty()) {
	            System.out.println("null");
	        } else {
	            Node<T> current = header;
	            while (current != null) {
	                System.out.println("sigleLink size:" + this.size + "\t data:" + current.data);
	                current = current.next;
	            }
	        }
	    }
	  
	    public void addFirst(T item) {
	        Node<T> newNode = new Node<T>(item);
	        newNode.next = header;
	        header = newNode;
	        size += 1;
	    }
	   
	    public void addLast(T item) {
	        Node<T> newNode = new Node<T>(item);
	        while (header.next != null)
	            header = header.next;
	        header.next = newNode;
	        newNode.next = null;
	        size += 1;
	    }
	   
	    public void deleteFirst() {
	        if (!isEmpty()) {
	            header = header.next;
	            size -= 1;
	        } else
	            System.out.println("The list have been emptied!");
	    }
	    
	    public void deleteLast() {
	        Node<T> current = header;
	        Node<T> pre = null;
	        while (current != null) {
	            pre = current;
	            current = current.next;
	            if (current.next == null) {
	                pre.next = null;
	                size -= 1;
	            }
	        }
	    }
	   
	    public void insert(int n, T item) {
	        if (n < 0 || n > size) {
	            System.out.println("insert error!");
	        } else {
	            Node<T> current = header;
	            Node<T> newNode = new Node<T>(item);
	            for (int index = 0; index < n -1; index++) {
	                current = current.next;
	            }
	            newNode.next = current.next;
	            current.next = newNode;
	            this.size +=1;
	        }
	    }
	                    
	    
	    public static void main(String[] args) {
	        Link<String> sl = new Link<String>();
	                        
	        sl.addToHeader("A");
	        sl.addToTail("B");
	        sl.addFirst("D");
	        sl.insert(2, "C");
	        sl.insert(1, "E");
	        sl.deleteFirst();
	                        
	        sl.print();
	    }

}
