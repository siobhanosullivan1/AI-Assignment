//Siobhan O Sullivan - 15519453
public class Quiescence {

	private Tree tree;
	private int alpha = -10000, beta = 10000;
	private int count;
	
	public Quiescence(Tree tree){
		this.tree = tree;
	}
	
	public int search(int val) {
        count = 0;
        selectiveQ(tree.getRoot(), alpha, beta);
        return count;
    }
	
	private int selectiveQ(Node node, int achievable, int hope){
		int score = node.getValue();
        
		if(score >= hope)
            return score;

        else
        {
        	for(int i=0; i<node.getChildren().size(); i++){
            	Node n = (Node)node.getChildren().get(i);            	
                if(n.isInteresting())
                {
                    count++;
              
                    int temp = -1 * selectiveQ(n, -1 * hope, -1 * achievable);

                    if (temp > score)
                        score = temp;

                    if(score >= achievable)
                        achievable = score;

                    if(score >= hope)
                        break;
                }
            }
        }
		return score;
	}
}
