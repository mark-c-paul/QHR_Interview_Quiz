package com.qhrtech.devquiz.digitsquaresum;

import java.io.*;
import java.util.*;

/**
 * My submission to QHR that I am proud of.
 * @author TheCandidate
 */
public class MySubmission extends DigitSquareSumSubmission {
    // TODO: Update with candidate's name
    private static final String MY_NAME = "Mark Paul";

    public MySubmission() {
        super(MY_NAME);
    }
    
    @Override
    public int digitSquareSum(int n) {
        int sum = 0;
        int temp;
        while (n > 0){
            temp = n % 10;
            sum += temp * temp;
            n /= 10;
        }
        return sum;
    }

    @Override
    public File questionOne() throws Exception {
        try{
          File f = new File("output.txt");
          if (f.exists()) {
            f.delete();
          }
          PrintWriter pw = new PrintWriter(new FileOutputStream(f,true));
          for(int i=1; i<=500; i++){
            pw.append(i + "," + digitSquareSum(i) + "\n");
          }
          pw.close();
          return f;
       }
       catch(Exception e){
          return null;
       }
    }

    @Override
    public String questionTwo() throws Exception {
      List<String> strings = new LinkedList<>();
      for(int num = 1;num<=500;num++){
        if(helper(num)){
           strings.add(Integer.toString(num));
        }
      }
      return String.join(",", strings);
    }
    
    private boolean helper(int num){
       HashSet<Integer> set = new HashSet<Integer>();
       while(num != 1 && set.add(num)){
           num = digitSquareSum(num);
       }
       return num == 1;
   }

    @Override
    public Integer questionThree() throws Exception {
      int counter=0;
      int maxNumber=10000000;
      for(int i=1;i<=maxNumber;i++){
        if(needsSevenSteps(i)){
            counter++;
        }
      }
      return (counter);
    }
    
    private boolean needsSevenSteps(int num){
        int counter = 0;
        int cur = num;
        HashSet<Integer> set = new HashSet<Integer>();
        while(true){
            if (cur==89){ 
                return counter>7;
            }
            else if (set.contains(cur)){
                return false;
            }
            counter++;
            set.add(cur);
            cur = digitSquareSum(cur);
        }
    }
  }

