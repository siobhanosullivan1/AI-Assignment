//Siobhan O Sullivan - 15519453
import java.util.Random;

public class Main {
    public static void main(String[] args){
    	
    	Tree[] trees = new Tree[12]; //array of 12 trees
    	Random random = new Random();
        for(Tree t: trees)
        {
        	int T = random.nextInt(5001)-2500;
            t = new Tree(3, 7, T, 100, 20);
            t.buildTree();
            NegamaxAlphaBeta alphabeta = new NegamaxAlphaBeta(t);
            int evaluation = alphabeta.search(20);
            System.out.println("Total number of evaluations: " + evaluation);
        }
    }
}