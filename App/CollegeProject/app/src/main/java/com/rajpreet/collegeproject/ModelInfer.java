package com.rajpreet.collegeproject;

import java.util.*;

public class ModelInfer {
     private int itr = 0;
     private String[] ex1 = {"AMBYULANCE", "AMBYULANSE"};
     private String[] ex2 = {"NIKAAS"};
     private String[] ex3 = {"STRECHER"};
     private String[][] words = {ex1, ex2, ex3};

     public String getInferOutput(){
         if (itr > 2){
             return "";
         }
         else {
             String[] possOutput = words[itr];
             Random rand = new Random();
             String output = possOutput[rand.nextInt(possOutput.length)];
             itr = itr + 1;
             return output;
         }
     }
}
