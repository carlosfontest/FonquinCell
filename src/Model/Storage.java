package Model;

public class Storage {
    private int[] vec;
    private int size;

    public Storage(int size) {
        this.size = size;
        this.vec = new int[size];
    }
    
    public int getSize(){
        return this.size;
    }
    
    public void setVec(int pointer, int val){
        this.vec[pointer] = val;
    }   
}
