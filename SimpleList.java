/**
 * @author      M Redwan Chowdhury
 * @class ID     386
 * @Assignment   Assigment #1
 * @Description  This file creates a list object using an array of integers.
 * It adds basic operations that you can expect from a list object.
 */

public class SimpleList {
    //This class acts as a list object that is build using an array of integers.
    //It performs the add and remove operations while also maintaining an accurate count.
    private int[] list;
    private int count;

    public SimpleList(){
        //Constructor. Initializes a new array with space for 10 ints.
        this.list = new int[10];
        this.count = 0;
    }
    public void add(int element){
        //Adds an element to the beginning of the list and shifts all other elements up.
        // Updates count.
        this.shiftUp(0, this.count);
        this.list[0] = element;
        this.count++;
    }
    public void remove(int element){
        //Searches for a element in the array. If found, it removes it. Updates count.
        for(int index=0; index<this.count; index++){
            if(this.list[index] == element){
                this.list[index] = 0;
                this.shiftDown(index, this.count);
                this.count--;
                break;
            }
        }
    }
    public int count(){
        //returns the current count
        return(this.count);
    }
    public String toString(){
        //converts object instance into a string returning every element in the list.
        String output = "";
        for(int index=0; index<this.count-1; index++){
            output += this.list[index] + " ";
        }
        output += this.list[this.count];
        return(output);

    }
    public int search(int element){
        // searches for an element in the array. Will return index if found, else -1.
        for(int index=0; index<this.count; index++){
            if(this.list[index]==element){
                return index;
            }
        }
        return -1;
    }
    private void shiftDown(int left, int right){
        // Helper function to help remove elements
        // Shifts down all elements between a left index and a right index
        for(int index=left; index<right; index++){
            this.list[index] = this.list[index+1];
        }
        this.list[right] = 0;
    }
    private void shiftUp(int left, int right){
        // Helper function to help add elements
        // Shifts up all elements between a left index and a right index
        if(right==10){
            for(int index=right; index>left; index--){
                this.list[index] = this.list[index-1];
            }
        }
        else{
            this.list[right+1] = 0;
            for(int index=right+1; index>left; index--){
                this.list[index] = this.list[index-1];
            }
        }
        this.list[left] = 0;

    }

}
