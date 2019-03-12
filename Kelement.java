import java.util.*;
public class Kelement{
  private int[] data;
  public String toString(){
    String ans = "";
    for(int i=0;i < data.length;i++){
      ans+= Integer.toString(data[i])+", ";
    }
    return ans;
  }
  Kelement( int[] dataList){
    data = dataList;
  }
  int partition ( int start, int end){
    //System.out.println(toString(data));
    // if(end -start == 1){
    //   if (data[start] >data[end]){
    //     int temp = data[end];
    //     data[end]=data[start];
    //     data[start]=data[end];
    //   }
    //   return start;
    // }
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
    pivotIndex=start;
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
      //System.out.println(toString());
      return start - 1;
    }
    if(data[start]<data[0]){
      int temp2 = data[0];
      data[0]=data[start];

      data[start]=temp2;
      //System.out.println(toString());
      return start;
    }
    else{
      int temp2 = data[0];
      data[0]=data[start-1];

      data[start-1]=temp2;
      //System.out.println(toString());
      return start - 1;
    }



  }
  public boolean validate(int index, int start, int end){

    for(int i = start; i < index - 1; i++){
      if(data[i]>data[index]){
        return false;
      }
    }
    for(int i = index + 1; i <= end; i++){
      if(data[i]<data[index]){
        return false;
      }
    }
    return true;

  }

  public int getKelement(int elementNum){
    int start = 0;
    int end = data.length - 1;

    while(true){
      int x = partition(start,end);
      if(elementNum == x){
        return data[x];
      }
      if(elementNum > x){
        start = x+1;
      }
      if(elementNum < x){
        end = x-1;
      }
      System.out.print("Start:"+Integer.toString(start)+" , End: "+Integer.toString(end)+"\n");
    }

  }

  public static void main(String[] args){
    int[] data = {17, 61, 67, 47, 93, 12,	20,	4, 44,	68, 13, 51, 53, 132, 313, 101, 612, 94};
    for(int i = 5; i<15; i++){
      int[] newArray = Arrays.copyOfRange(data, 0, i);

      Kelement k = new Kelement(newArray);
      Random r = new Random();
      int end = Math.abs(r.nextInt())%(i-1)+1;
      int x = k.partition(3,end);
      if(!k.validate(x,0,end)){
        System.out.println(x);
        System.out.println(k.toString());
      }
    }
  }
}
