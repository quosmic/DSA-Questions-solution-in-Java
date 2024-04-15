import java.lang.reflect.Array;
import java.util.*;

class knightL {
  public static List<List<Integer>> listing = new ArrayList<>();
   public static List<List<Integer>> knightL(int n) {
  char[][] board = new char[n][n];
  for(int i = 1; i<n; i++)
  {
    for(int j = 1; j<n; j++){
    calculateMoves(board, i, j, 0, 0, 0, n*n);
     
    }
  }
return listing;
}
    
public static void calculateMoves(char board[][], int a, int b, int idx1, int idx2, int sum, int maxMoves){
 //BC 1
  if(idx1 == board[0].length -1 && idx2 == board[0].length -1) {
  List<Integer> list = new ArrayList<>();
  list.add(a);
  list.add(b);
  list.add(sum);
 saveMetric(listing,list);
 return;
}
//BC 2
 if (sum >= maxMoves) {
   List<Integer> list = new ArrayList<>();
  list.add(a);
  list.add(b);
  list.add(-1);   
  saveMetric(listing,list);  
  return;
   }


if(isSafe(board, idx1 + a, idx2 +b)) {
  calculateMoves(board, a, b, idx1 + a, idx2 +b, sum+1,board.length*board.length);
      }
else if(isSafe(board,idx1 + a,idx2 - b)) {
  calculateMoves(board, a, b, idx1 + a, idx2 - b, sum+1,board.length*board.length);
}
  else if(isSafe(board,idx1 + b,idx2 +a)) {
  calculateMoves(board, a, b, idx1 + b, idx2 +a, sum+1,board.length*board.length);
    }
  
else if(isSafe(board,idx1 - b,idx2 +a)) {
  calculateMoves(board, a, b, idx1 - b, idx2 +a, sum+1,board.length*board.length);
    }
  else if(isSafe(board,idx1 - a,idx2 +b)) {
  calculateMoves(board, a, b, idx1 -a, idx2 +b, sum+1,board.length*board.length);
    }
  else if(isSafe(board,idx1 - a,idx2 -b)) {
  calculateMoves(board, a, b, idx1 - a, idx2 -b, sum+1,board.length*board.length);
    }
    else if(isSafe(board,idx1 + b,idx2 - a)) {
  calculateMoves(board, a, b, idx1 + b, idx2 - a, sum+1,board.length*board.length);
    }
    else if(isSafe(board,idx1 - b,idx2 - a)) {
  calculateMoves(board, a, b, idx1 - b, idx2 - a, sum+1,board.length*board.length);
    }
  }
 public static boolean isSafe(char board[][], int idx1, int idx2) {
    if(idx1>=board[0].length || idx2 >=board[0].length || idx1< 0 || idx2 < 0) {
        return false;
    }
  return true;
  }
 public static void saveMetric(List<List<Integer>> listing, List<Integer> list) {
     int flag =0;  
  if(!listing.isEmpty()){ 
  for (List<Integer> l : listing) {
            if (checkStatus(l, list)) {
                l.set(2, list.get(2));
                return;
            }
        if(checkPresence(l,list)){
          flag =1;
          if(l.get(2)==-1 && list.get(2)!=-1) {
            l.set(2, list.get(2));
          }
        if(l.get(2)!=-1 && list.get(2)!=-1) {
          int num = min(l.get(2),list.get(2));
          l.set(2,num);
        }
      else list.set(2, l.get(2));
      }
          }
      }
     if(flag ==0) {
      listing.add(list);
  }
}
 public static boolean checkPresence(List<Integer> list1, List<Integer> list2) { 
  if ((list1.get(0).equals(list2.get(1))) && list1.get(1).equals(list2.get(0))) {
    return true;
  }
else return false; 
}
  public static boolean checkStatus(List<Integer> list1, List<Integer> list2) {
      if (list1.get(0).equals(list2.get(0)) && list1.get(1).equals(list2.get(1))
        && list1.get(2)<list2.get(2) && list2.get(2)!=-1) {
            return true;
    }
  else if(list1.get(0).equals(list2.get(0)) && list1.get(1).equals(list2.get(1))
        && list1.get(2)>=list2.get(2)) {
        return false;
        }
    return false;
  }
  public static int min(int num1, int num2) {
    if(num1<num2){
      return num1;
    }
  else return num2;
  }

    public static void main(String[] args) {
    List<List<Integer>> result = knightL(10);
   System.out.println(result);  
  }

}
