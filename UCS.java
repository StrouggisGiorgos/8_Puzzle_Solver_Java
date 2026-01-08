// Nikolaos Giannopoulos A.M. 5199
// Marios Dimitrios Sarigiannis A.M. 5345
// Georgios Strouggis A.M. 5357

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashSet;

public class UCS {

    public UCS(String[][] init){
        PriorityQueue<node> Nodes = new PriorityQueue<>((n1, n2) -> n1.getLevel() - n2.getLevel());
        board first_board = new board(init);
        node first_node = new node(first_board, 0, null);
        node current_node = first_node;
        node n;
        HashSet<board> used = new HashSet<>();

        Nodes.add(first_node);
        used.add(first_board);

        while(!Nodes.isEmpty()){
            current_node = Nodes.poll();
            if(current_node.getBoard().getDifference() == 0){
                break;
            }
            for(board s : current_node.getBoard().surroundings()){
                if(!used.contains(s)) {
                    n = new node(s, current_node.getLevel() + 1, current_node);
                    Nodes.add(n);
                    used.add(s);
                }
            }
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

        System.out.println("Cost: " + reverse.get(0).getLevel());
        System.out.println("Number of expansions: " + used.size());
    }
}