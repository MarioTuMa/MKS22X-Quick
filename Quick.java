import java.util.*;
import java.io.*;
public class Quick{

  public String toString(int[] data){
    String ans = "";
    for(int i=0;i < data.length;i++){
      ans+= Integer.toString(data[i])+", ";
    }
    return ans;
  }

  int partition (int[] data, int start, int end){
    //System.out.println(toString(data));
    if(end == start){
      return start;
    }
    if(end -start == 1){
      if (data[start] > data[end]){
        int temp = data[end];
        data[end]=data[start];
        data[start]=temp;
      }
      return start;
    }
    int temp = data[start];
    int init =Integer.valueOf(start);
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
    //System.out.println(toString());
    while(start-end<1){
      //System.out.println(toString());
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

    //System.out.println(start);

    if(Biggest){
      int temp2 = data[end];
      data[end]=data[init];
      data[init]=temp2;
      //System.out.println(toString());
      return end;
    }
    if(data[start]<data[init]){
      int temp2 = data[init];
      data[init]=data[start];

      data[start]=temp2;
      //System.out.println(toString());
      return start;
    }
    else{
      int temp2 = data[init];
      data[init]=data[start-1];

      data[start-1]=temp2;
      //System.out.println(toString());
      return start - 1;
    }



  }

  int[] dutchpartition (int[] data, int start, int end){
    //System.out.println(toString(data));
    if(end == start){
      int[] toReturn = new int[2];
      toReturn[0]=end;
      toReturn[1]=end;
      return toReturn;
    }
    if(end -start == 1){
      if (data[start] > data[end]){
        int temp = data[end];
        data[end]=data[start];
        data[start]=temp;
      }
      int[] toReturn = new int[2];
      toReturn[0]=start;
      toReturn[1]=end;
      return toReturn;
    }
    int temp = data[start];
    int init =Integer.valueOf(start);
    Random r = new Random();
    int pivotIndex = start+Math.abs(r.nextInt())%(end-start);
    //int pivotIndex = 4;

    int pivotValue = data[pivotIndex];
    //System.out.println(Integer.toString(pivotIndex)+", "+Integer.toString(pivotValue));
    boolean Biggest = true;
    int mid = Integer.valueOf(start);
    data[start]=data[pivotIndex];
    data[pivotIndex]=temp;
    //System.out.println(toString(data));
    pivotIndex=Integer.valueOf(start);
    start+=1;
    int counter = 1;
    //System.out.println("Start"+Integer.toString(start));
    //System.out.println("Mid"+Integer.toString(mid));
    mid+=1;
    //System.out.println(toString());
    while(mid-end<1){
      //System.out.println(toString());
      if(data[mid]<pivotValue){
        int temp2 = data[mid];
        data[mid] = data[start];
        data[start]= temp2;
        start++;
        mid++;
        // System.out.print("Start: "+Integer.toString(start));
        // System.out.println(toString(data));
      }
      else{
        if (data[mid]==pivotValue){

          mid++;
          counter++;

        }
        else{
        int temp2 = data[end];
        data[end]=data[mid];

        data[mid]=temp2;
        end--;
        Biggest = false;
        }

        // System.out.print("End: "+Integer.toString(end));
        // System.out.println(toString(data));
      }
      // System.out.println("Pivot:");
      // System.out.println(pivotIndex);
      // System.out.println("i");
      // System.out.println(i);
    }

    //System.out.println(start);

    if(Biggest){
      int temp2 = data[end];
      data[end]=data[init];
      data[init]=temp2;
      //System.out.println(toString());
      int[] toReturn = new int[2];
      toReturn[0]=start;
      toReturn[1]=mid;

      return toReturn;
    }
    if(data[start]<data[init]){
      int temp2 = data[init];
      data[init]=data[start];

      data[start]=temp2;
      //System.out.println(toString());
      int[] toReturn = new int[2];
      toReturn[0]=start;
      toReturn[1]=mid;

      return toReturn;
    }
    else{
      int temp2 = data[init];
      data[init]=data[start-1];

      data[start-1]=temp2;
      //System.out.println(toString());
      int[] toReturn = new int[2];
      toReturn[0]=start - 1;
      toReturn[1]=mid;

      return toReturn;
    }



  }
  public boolean validate(int[] data, int index, int start, int end){

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
  public void fix(int[] data){

    for(int i = 1; i < data.length; i++){
      if(data[i-1]>data[i]){
        int temp2  = data[i-1];
        data[i-1]=data[i];
        data[i] = temp2;
      }
    }



  }
  public boolean validate(int[] data){

    for(int i = 1; i < data.length; i++){
      if(data[i-1]>data[i]){
        return false;
      }
    }

    return true;

  }

  public int quickselect(int[] data, int elementNum){
    int start = 0;
    int end = data.length - 1;

    while(true){
      int[] x = dutchpartition(data,start,end);
      if(elementNum > x[0] && elementNum < x[1]){
        return data[x[0]];
      }
      if(elementNum > x[1]){
        start = x[1];
      }
      if(elementNum < x[0]){
        end = x[0]-1;
      }
      //System.out.print("Start:"+Integer.toString(start)+" , End: "+Integer.toString(end)+"\n");
    }

  }



  public void quicksort(int[] data){

    int[] x = dutchpartition(data,0,data.length - 1);

    if(x[0]>0 && x[1]<data.length - 1){
      quicksort(data,0,x[0]);
      quicksort(data,x[1],data.length - 1);
    }
    else{
      if(x[0]<1){
        quicksort(data,x[1],data.length-1);
      }
      else{
        quicksort(data,0,x[0]);
      }
    }
    fix(data);
  }

  public void quicksort(int[] data, int start, int end){

    if(start < end){
      int[] x = dutchpartition(data,start,end);
      // System.out.println(x);
      // System.out.println(toString());
      // System.out.print("Start:"+Integer.toString(start)+" , End: "+Integer.toString(end)+"\n");
      if(x[0]>start){
        quicksort(data,start,x[0] - 1);

      }
      if(x[1]<end - 1){
        quicksort(data,x[1],end);

      }


    }


  }

  public static void main(String[] args){
    int size = 60;
    int[] data = new int[size];

    int counter = 0;
    Random r  = new Random();
    for(int i = 0; i < size; i++){
        data[i] = r.nextInt()%1000;
    }
    // for(int i = 10; i<11; i++){
    //   int[] newArray = Arrays.copyOfRange(data, 0, i);
    //
    Quick q = new Quick();
    int[] compArray = Arrays.copyOf(data,data.length);
    final long sTime = System.nanoTime();
    //System.out.println(q.validate(compArray));
    Arrays.sort(compArray);
    //System.out.println(q.validate(compArray));

    System.out.println((System.nanoTime() - sTime)/1000000000.0);
    final long startTime = System.nanoTime();
    q.quicksort(data);
    System.out.println(q.toString(data));

    final long duration = System.nanoTime() - startTime;
    System.out.println(duration/1000000000.0);
    //System.out.println(q.validate(data));
    System.out.println(Arrays.equals(data,compArray));
    System.out.println(q.toString(data));
    System.out.println(q.toString(compArray));
    // int[] info =  q.dutchpartition(data,4,data.length - 1);
    //
    // System.out.println(Integer.toString(info[0])+", "+Integer.toString(info[1]));
    // System.out.println(q.toString(data));

    //   }
    // }

  }
}
