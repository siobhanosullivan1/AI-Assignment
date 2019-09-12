//Siobhan O Sullivan - 15519453
import java.util.ArrayList;
import java.util.List;

public class Node<T> {
	
	private T data = null;
	
	private ArrayList<Node> children;
	private Node parent;
	private int v;
	private boolean interesting = false;

	public Node(Node<T> parent, int v){
		this.parent = parent;
		this.v = v;
		children = new ArrayList<>();
	}
	
	public Node<T> addChild(Node<T> child){
		child.setParent(this);
		this.children.add(child);
		return child;
	}

	public void addChildren(List<Node<T>> children){
		children.forEach(each -> each.setParent(this));
		this.children.addAll(children);
	}
	
	public ArrayList<Node> getChildren(){
		return children;
	}
	
	public boolean hasChildren(){ 
        if(children.size() == 0)
            return false;
        else
            return true;
    }

	public int getValue(){
		return v;
	}
	
	private void setParent(Node<T> parent){
		this.parent = parent;
	}
	
	public Node<T> getParent(){
		return parent;
	}
	 
    public String toString()
    {
       String str = "";
       str = str + "\nNode: " + v;
      
       String tempString = "Children: ";
       for(Node child:children)
           tempString = tempString + child.v + "	";
       
       str = str+"\n" + tempString;
       
       return str;
    }
	
	public boolean isInteresting() { 
		return interesting; 
	}

    public void markInteresting() {
        interesting = true;
    }
	
	
}
