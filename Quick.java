import java.util.*;
import java.io.*;
public class Quick{
  private int[] data;
  public String toString(){
    String ans = "";
    for(int i=0;i < data.length;i++){
      ans+= Integer.toString(data[i])+", ";
    }
    return ans;
  }
  Quick( int[] dataList){
    data = dataList;
  }
  int partition ( int start, int end){
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
  public boolean validate(){

    for(int i = 1; i < data.length; i++){
      if(data[i-1]>data[i]){
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
      //System.out.print("Start:"+Integer.toString(start)+" , End: "+Integer.toString(end)+"\n");
    }

  }

  public void quickSort(){

    int x = partition(0,data.length - 1);
    System.out.println(x);
    if(x>0 && x<data.length - 1){
      quickSort(0,x-1);
      quickSort(x+1,data.length - 1);
    }
    else{
      if(x<1){
        quickSort(1,data.length-1);
      }
      else{
        quickSort(0,data.length-2);
      }
    }
  }

  public void quickSort(int start, int end){

    if(start < end){
      int x = partition(start,end);
      // System.out.println(x);
      // System.out.println(toString());
      // System.out.print("Start:"+Integer.toString(start)+" , End: "+Integer.toString(end)+"\n");
      if(x>start && x < end){
        quickSort(start,x - 1);
        quickSort(x+1,end);
      }
      else{
        if(x<start+1){
          quickSort(start+1,end);
        }
        else{
          quickSort(start,end - 1);
        }
      }
    }


  }

  public static void main(String[] args){
    try{
      final long startTime = System.nanoTime();

      int[] data = new int[1000000];
      File text = new File("1000000perm.txt");
      // can be a path like: "/full/path/to/file.txt" or "../data/file.txt"

      //inf stands for the input file
      Scanner inf = new Scanner(text);
      int counter = 0;

      while(inf.hasNextLine()){
          String line = inf.nextLine();
          data[counter] = Integer.parseInt(line);
          counter++;
      }
      // for(int i = 10; i<11; i++){
      //   int[] newArray = Arrays.copyOfRange(data, 0, i);
      //
      Quick q = new Quick(data);
      //   Random r = new Random();
      //   int end = i - 1;
      //   int x = k.partition(0,end);
      //   if(!k.validate(x,0,end)){
      //     System.out.println(x);
      q.quickSort();

      System.out.println(q.validate());
      final long duration = System.nanoTime() - startTime;
      System.out.println(duration/1000000000.0);
    }catch(FileNotFoundException e){
      System.out.println("file not found");
    }
    //   }
    // }

  }
}
