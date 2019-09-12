//Siobhan O Sullivan - 15519453
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeMap;
import java.util.Random;

public class Tree {

    private Node root;
    private int b,h,v,approx,i; //branching factor,h,value,approx,interestingness
    private Random random = new Random();
    
    public Tree(int b, int h, int v, int approx, int i){
    	this.b = b;
    	this.h = h;
    	this.v = v;
    	this.approx = approx;
    	this.i = i;
    }
    
  //interior nodes have different branching factors with different chances
    private int generatebFactor(){ 
    	
    	int temp_b = b; //making a copy so original doesn't change
        int chance = random.nextInt(100);

        if(chance>=0 && chance<=3)
            temp_b = b+2;
        else if(chance>3 && chance<=9)
            temp_b = b+1;
        else if(chance>9 && chance<=89)
            return temp_b;
        else if(chance>89 && chance<=96)
            temp_b = b-1;
        else if(chance>96 && chance<100)
        	temp_b = b-2;
       if(temp_b < 0)
            temp_b = 0;

        return temp_b;	
    }
    
    private void checkInteresting(Node n, int d)
    {
        int rand = random.nextInt(99);
      //if a random number(0-99) is below i+(h-d)*30,it's marked interesting
        if(rand<(i+(h-d)*30))
            n.markInteresting();
    }
    
    private ArrayList<Node> generateChildren(Node n, int d){
    	ArrayList<Node> children = new ArrayList<>();
    	int nonuniform = random.nextInt(20);
    	if(nonuniform != 5){
    		
    	//one of the daughters has its T equal to the negative T of its parent
    	int bound=-1*n.getValue();
    	
    	Node firstDaughter = new Node(n, bound);
        checkInteresting(firstDaughter, d);//checks whether the node is interesting
        children.add(firstDaughter);
         
        for (int j=0;j<generatebFactor()-1;j++){
        	//all other daughters have T >= that, with max of +10000
        	Node daughter = new Node(n, bound + random.nextInt(10000-bound)); 
        	checkInteresting(daughter, d);//checks whether the node is interesting
        	children.add(daughter);	
        	//numberOfNodes++;       
        }
        n.addChildren(children);
        
    	}
        return children;
    }
    
    public void buildTree(){//generate the game tree

    	int d=0;
    	root = new Node(null, v);
        
        ArrayList<Node> children1 = new ArrayList<>();
        ArrayList<Node> children2 = new ArrayList<>();
        children2.add(root);

        while(d != h) //want to build until depth reaches horizon
        {
            if(d >= h)
                break;//check if depth reaches horizon

            for (Node child : children1) {
                children2.addAll(generateChildren(child, d));
                //System.out.println(child.toString());
            }

            if(d >= h)
                break;

            d++;

            children1.clear();
            
            for (Node child : children2) {
                children1.addAll(generateChildren(child, d));
               // System.out.println(child.toString());
            }
            
           d++;

            children2.clear();

        }
    }

	public Node getRoot() {		
		return root;
	}

	public int getHorizon(){
		return h;
	}
}
