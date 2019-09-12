//Siobhan O Sullivan - 15519453
public class NegamaxAlphaBeta {

	private Tree tree;
	private int alpha = -10000, beta = 10000;
	private int count;
	
	public NegamaxAlphaBeta(Tree tree){
		this.tree = tree;
	}
	
	public int search(int value) {
		count = 0;
        alphabeta(tree.getRoot(), tree.getHorizon(), alpha, beta);
        return count;
    }
	
	private int alphabeta(Node node, int ht, int achievable, int hope)
    {
		//no moves available if node has no daughters
        if(ht == 0 || node.hasChildren() == false) 
            return node.getValue();
        else
        {
        	for(int i=0; i<node.getChildren().size(); i++){
            count++;
            	//my IDE made me cast it this way, I don't actually know why
            int temp = -1* alphabeta((Node) node.getChildren().get(i),
            		ht-1, -1*hope, -1*achievable);
            		

            if(temp >= hope)
              return temp;//beta cutoff

             achievable = Integer.max(temp,achievable);
            }
        }

        return achievable;
    }
	
}
