// Nikolaos Giannopoulos A.M. 5199
// Marios Dimitrios Sarigiannis A.M. 5345
// Georgios Strouggis A.M. 5357

public class node {
    private final board board;
    private final int level;
    private final node parent;

    private final int cost;

    public node(board b, int l, node p){
        this.board = b;
        this.level = l;
        this.parent = p;
        this.cost = board.getDifference() + level;
    }

    board getBoard(){
        return board;
    }

    int getLevel(){
        return level;
    }

    node getParent(){
        return parent;
    }

    int getCost(){ return cost;}
}
