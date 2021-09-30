/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArtificialIntelligence;

/**
 *
 * @author lenovo
 */

import java.util.*;
public class Sudoku {
    public static void display(int [][]board){
        int size=board.length;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(board[i][j]+ " ");
            }
            
            System.out.println();
        }
    }
    public static boolean isValid(int [][]board,int row,int col,int val){
        //row check constraint
        for(int j=0;j<board[0].length;j++){
            if(board[row][j]==val){
                return false;
            }
        }
        //can check with whole ror where apna dabba checks with itself is no isue because we r pacing after finding its valid so at out pos there will be 0, not val.
        //column check constraint
        for(int j=0;j<board.length;j++){
            if(board[j][col]==val){
                return false;
            }
        }
        //sub matrix check constraint
        int subsize=(int)Math.sqrt(board.length);
        System.out.println("subsize"+subsize);
        int submat_i=((int)(row/subsize))*subsize; //top left corner :i
        int submat_j=((int)(col/subsize))*subsize; //top left corner : j
        //System.out.println(submat_i +" "+submat_j);
        for(int i=0;i<subsize;i++){
            for(int j=0;j<subsize;j++){
                if(board[submat_i+i][submat_j+j]==val){
                    return false;
                }
            }
        }
        return true;
        
        
    }
    public static boolean solveSudoku(int[][]board,int i ,int j){
        //base case
        if(i==board.length){
            //System.out.println(j);
            display(board);
            return true;
        }
        int ni=0; //initialising 2 variables i and j
        int nj=0;
        if(j==(board[0].length)-1){
            ni=i+1;
            nj=0;
        }
        else{
            ni=i;
            nj=j+1;
        }
        if(board[i][j]!=0){
            //make next call 
            boolean ans=solveSudoku(board,ni,nj);
            if(ans){
                return true;
            }
        }
        else{
            //traverse all possibility of putting 1 to 9 numbers
            //
            for(int pos=1;pos<=board.length;pos++){
                if(isValid(board,i,j,pos)==true){
                    board[i][j]=pos; //place value 
                    boolean ans=solveSudoku(board,ni,nj);
                    board[i][j]=0; //undo when going back and finding other posssibility
                    if(ans){
                        return true;
                    }
                }
            }
        } 
        return false;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int size=sc.nextInt(); //9,16 tested and verified  
        int board[][]=new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                board[i][j]=sc.nextInt();
            }
        }
        solveSudoku(board,0,0);   
    }    
}//
//25 x 25 : 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
//16 x 16 : 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 
 //9 x 9: 3 0 6 5 0 8 4 0 0 5 2 0 0 0 0 0 0 0 0 8 7 0 0 0 0 3 1 0 0 3 0 0 0 0 8 0 9 0 0 8 6 3 0 0 5 0 5 0 0 9 0 6 0 0 1 3 0 0 0 0 2 5 0 0 0 0 0 0 0 0 7 4 0 0 5 2 0 6 3 0 0
    
   