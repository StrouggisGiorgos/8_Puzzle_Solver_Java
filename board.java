// Nikolaos Giannopoulos A.M. 5199
// Marios Dimitrios Sarigiannis A.M. 5345
// Georgios Strouggis A.M. 5357

import java.util.ArrayList;

public class board {
    private final String[][] TK = {{"6","5","4"},{"7"," ","3"},{"8","1","2"}};
    private final String[][] AK;
    private int pos_i, pos_j;

    public board(String[][] init){
        this.AK = init;
        for(int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                if(AK[i][j].equals(" ")){
                    pos_i = i;
                    pos_j = j;
                    break;
                }
            }
        }
    }

    void showCurrent(){
        System.out.println();
        for(int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(AK[i][j]+" ");
            }
            System.out.println();
        }
    }

    int getDifference(){
        int difference = 0;
        for(int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                if(!TK[i][j].equals(AK[i][j])){
                    difference++;
                }
            }
        }
        return difference;
    }

    board copy(){
        String[][] c = new String[3][3];
        for(int i=0; i<3; i++) {
            System.arraycopy(AK[i], 0, c[i], 0, 3);
        }
        return new board(c);
    }

    board move(String direction){
        String keep;
        if(direction.equals("west") && ((pos_j - 1)>=0)){
            keep = AK[pos_i][pos_j];
            AK[pos_i][pos_j] = AK[pos_i][pos_j - 1];
            AK[pos_i][pos_j - 1] = keep;
            pos_j--;
            return this;
        }else if(direction.equals("east") && ((pos_j + 1)<=2)){
            keep = AK[pos_i][pos_j];
            AK[pos_i][pos_j] = AK[pos_i][pos_j + 1];
            AK[pos_i][pos_j + 1] = keep;
            pos_j++;
            return this;
        }else if(direction.equals("north") && ((pos_i - 1)>=0)){
            keep = AK[pos_i][pos_j];
            AK[pos_i][pos_j] = AK[pos_i - 1][pos_j];
            AK[pos_i - 1][pos_j] = keep;
            pos_i--;
            return this;
        }else if(direction.equals("south") && ((pos_i + 1)<=2)){
            keep = AK[pos_i][pos_j];
            AK[pos_i][pos_j] = AK[pos_i + 1][pos_j];
            AK[pos_i + 1][pos_j] = keep;
            pos_i++;
            return this;
        }else if(direction.equals("northwest") && ((pos_i - 1)>=0) && ((pos_j - 1)>=0)){
            keep = AK[pos_i][pos_j];
            AK[pos_i][pos_j] = AK[pos_i - 1][pos_j - 1];
            AK[pos_i - 1][pos_j - 1] = keep;
            pos_i--;
            pos_j--;
            return this;
        }else if(direction.equals("northeast") && ((pos_i - 1)>=0) && ((pos_j + 1)<=2)){
            keep = AK[pos_i][pos_j];
            AK[pos_i][pos_j] = AK[pos_i - 1][pos_j + 1];
            AK[pos_i - 1][pos_j + 1] = keep;
            pos_i--;
            pos_j++;
            return this;
        }else if(direction.equals("southeast") && ((pos_i + 1)<=2) && ((pos_j + 1)<=2)){
            keep = AK[pos_i][pos_j];
            AK[pos_i][pos_j] = AK[pos_i + 1][pos_j + 1];
            AK[pos_i + 1][pos_j + 1] = keep;
            pos_i++;
            pos_j++;
            return this;
        }
        else if(direction.equals("southwest") && ((pos_i + 1)<=2) && ((pos_j - 1)>=0)){
            keep = AK[pos_i][pos_j];
            AK[pos_i][pos_j] = AK[pos_i + 1][pos_j - 1];
            AK[pos_i + 1][pos_j - 1] = keep;
            pos_i++;
            pos_j--;
            return this;
        }
        return null;
    }

    ArrayList<board> surroundings(){
        ArrayList<board> surroundings = new ArrayList<>();
        board c;
        if((c = this.copy().move("west")) != null){
            surroundings.add(c);
        }
        if((c = this.copy().move("east")) != null){
            surroundings.add(c);
        }
        if((c = this.copy().move("north")) != null){
            surroundings.add(c);
        }
        if((c = this.copy().move("south")) != null){
            surroundings.add(c);
        }
        if((c = this.copy().move("northwest")) != null){
            surroundings.add(c);
        }
        if((c = this.copy().move("southwest")) != null){
            surroundings.add(c);
        }
        if((c = this.copy().move("southeast")) != null){
            surroundings.add(c);
        }
        if((c = this.copy().move("northeast")) != null){
            surroundings.add(c);
        }
        return surroundings;
    }
}
