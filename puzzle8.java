// Nikolaos Giannopoulos A.M. 5199
// Marios Dimitrios Sarigiannis A.M. 5345
// Georgios Strouggis A.M. 5357

import java.util.Scanner;
import java.util.HashMap;

public class puzzle8 {

    public static void main(String[] args){
        HashMap<String,Integer> usages = new HashMap<>();
        usages.put(" ",0);
        usages.put("1",0);
        usages.put("2",0);
        usages.put("3",0);
        usages.put("4",0);
        usages.put("5",0);
        usages.put("6",0);
        usages.put("7",0);
        usages.put("8",0);
        String[][] init = new String[3][3];
        String temp;
        boolean loop_check;
        Scanner input = new Scanner(System.in);
        System.out.println("Provide a number from 1 to 8 and one space and press enter without repeating the same values until the Board is full");
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                temp = input.nextLine();
                if (!usages.containsKey(temp) || usages.get(temp) != 0) {
                    loop_check = true;
                    while (loop_check) {
                        System.out.println("Input a number from 1 to 8 and a space, which has not been inserted before");
                        temp = input.nextLine();
                        if (usages.containsKey(temp) && usages.get(temp) == 0) {
                            loop_check = false;
                        }
                    }
                }
                init[i][j] = temp;
                usages.put(temp, 1);
            }
        }
        System.out.println("Select method to execute: 0 for A* and 1 for UCS");
        int select = input.nextInt();
        if(select == 0){
            new A_star(init);
        }else if (select == 1){
            new UCS(init);
        }
    }
}
