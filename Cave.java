public class Cave {
    
    private int[][] cave;
    private int count;

    public Cave(int[][] cave){
        count = 0;
        this.cave = cave;
    }

    public void findOpening(){
        boolean done = false;
        for(int c = 0; c < cave[0].length && !done; c++){
            if(cave[0][c] == 0){
                cave[0][c] = 3;
                isDown(0,c);
                done = true;
            }   
        }
    }

    public boolean isDown(int r, int c){
        boolean present = false;
        if(r < cave.length -1){
            if(cave[r+1][c] == 0){
                present = true;
                cave[r+1][c] = 3;
            }
        }
        return present;
    }

    public boolean isUp(int r, int c){
        boolean present = false;
        if(r-1 >= 0 && cave[r-1][c] == 0){
            present = true;
            cave[r-1][c] = 3;
        }
        return present;
    }

    public boolean search(){
        boolean found = false; //need to keep searching
        
        for(int r = 0; r < cave.length;r++){
            for(int c = 0; c < cave[0].length;c++){
                if(cave[r][c] == 3){
                    found = this.isUp(r,c);
                    if(found){
                        count++;
                    }
                    found = this.isDown(r,c);
                    if(found){
                        count++;
                    }
                    if(c+1 < cave[r].length && cave[r][c+1] == 0){
                        cave[r][c+1] = 3;
                        count++;
                        found = true;
                    }
                    if(c-1 >= 0 && cave[r][c+1] == 0){
                        cave[r][c-1] = 3;
                        count++;
                        found = true;
                    }
                }
            }
        }
        return found;
    }



    public String toString(){
        String result = "";
        for(int r = 0; r < cave.length; r++){
            for(int c = 0; c < cave[0].length; c++){
                result += cave[r][c] + " ";
            }
            result += "\n";
        }
        return result;
    }

}
