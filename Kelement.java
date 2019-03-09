import java.util.*;
public class Kelement{
  String toString( int[] data){
    String ans = "";
    for(int i=0;i < data.length;i++){
      ans+= Integer.toString(data[i])+", ";
    }
    return ans;
  }
  int partition ( int [] data, int start, int end){
    //System.out.println(toString(data));
    int temp = data[start];

    Random r = new Random();
    int pivotIndex = start+Math.abs(r.nextInt())%(end-start);
    //int pivotIndex = 4;
    //System.out.println(pivotIndex);
    int pivotValue = data[pivotIndex];
    boolean Biggest = true;
    data[start]=data[pivotIndex];
    data[pivotIndex]=temp;
    //System.out.println(toString(data));
    pivotIndex=0;
    start+=1;
    while(start-end<1){
      if(data[start]<pivotValue){

        start++;
        // System.out.print("Start: "+Integer.toString(start));
        // System.out.println(toString(data));
      }
      else{
        int temp2 = data[end];
        data[end]=data[start];

        data[start]=temp2;
        end--;
        Biggest = false;
        // System.out.print("End: "+Integer.toString(end));
        // System.out.println(toString(data));
      }
      // System.out.println("Pivot:");
      // System.out.println(pivotIndex);
      // System.out.println("i");
      // System.out.println(i);
    }
    //System.out.println(toString(data));
    //System.out.println(start);
    if(Biggest){
      int temp2 = data[0];
      data[0]=data[start - 1];

      data[start - 1]=temp2;
      System.out.println(toString(data));
      return start - 1;
    }
    if(data[start]<data[0]){
      int temp2 = data[0];
      data[0]=data[start];

      data[start]=temp2;
      System.out.println(toString(data));
      return start;
    }
    else{
      int temp2 = data[0];
      data[0]=data[start-1];

      data[start-1]=temp2;
      System.out.println(toString(data));
      return start - 1;
    }



  }
  public static void main(String[] args){
    Kelement k = new Kelement();
    int[] data = {17, 61, 67, 47, 93,12,	20,	4, 44,	68};
    System.out.println(k.partition(data,0,9));
  }
}
