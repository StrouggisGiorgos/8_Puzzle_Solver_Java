// Nikolaos Giannopoulos A.M. 5199
// Marios Dimitrios Sarigiannis A.M. 5345
// Georgios Strouggis A.M. 5357

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashSet;

public class A_star {
    public A_star(String[][] init){
        PriorityQueue<node> Nodes = new PriorityQueue<>((n1, n2) -> n1.getCost() - n2.getCost());
        board first_board = new board(init);
        node first_node = new node(first_board, 0, null);
        node current_node = first_node;
        node n;
        HashSet<board> used = new HashSet<>();

        used.add(first_board);

        while(true){
            assert current_node != null;
            if (current_node.getBoard().getDifference() == 0) break;
            for(board s : current_node.getBoard().surroundings()){
                n = new node(s, current_node.getLevel()+1, current_node);
                if(!used.contains(s)){
                    Nodes.add(n);
                    used.add(s);
                }
            }
            current_node = Nodes.poll();
        }

        ArrayList<node> reverse = new ArrayList<>();
        while(current_node.getParent() != null){
            reverse.add(current_node);
            current_node = current_node.getParent();
        }
        reverse.add(first_node);

        for(int i = reverse.size()-1; i>=0; i--){
            reverse.get(i).getBoard().showCurrent();
        }

        System.out.println("Cost: " + reverse.get(0).getCost());
        System.out.println("Number of expansions: " + used.size());
    }
}
