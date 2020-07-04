package com.github.yukihane.so;

import java.io.*;
import java.util.*;

public class Num_Array {
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>(); 
        ArrayList<Integer> row;

        try{
            FileReader fr = new FileReader("1041.txt");
            FileReader fr2 = new FileReader("1042.txt");
            BufferedReader br = new BufferedReader(fr);
            BufferedReader br2 = new BufferedReader(fr2);
            File f = new File("output104.txt");
            FileWriter filewriter = new FileWriter(f);
            String str1 = null;
            str1 = br.readLine();
            String str2 = null;
            str2 = br2.readLine();
            
            while(str1 != null || str2 != null){
                int num = 0;
                int add_num = 0;
 
                String[] nstr1 = str1 != null ? str1.split(",") : new String[0];
                String[] nstr2 = str2 != null ? str2.split(",") : new String[0];
                row = new ArrayList<Integer>();
           
                for(int i = 0; i < nstr1.length || i < nstr2.length; i++){
                    if(i < nstr1.length && i < nstr2.length){
                        if(nstr1[i].equals("")){
                            nstr1[i] = "0";
                        }
                        if(nstr2[i].equals("")){
                            nstr2[i] = "0";
                        }
                        //System.out.println(nstr2[i]);
                        num = Integer.valueOf(nstr1[i]);
                        add_num = Integer.valueOf(nstr2[i]);
                        num += add_num;
                        row.add(num);
                    }
                
                    if(i >= nstr1.length){
                        row.add(Integer.valueOf(nstr2[i]));
                    }else if(i >= nstr2.length){
                        row.add(Integer.valueOf(nstr1[i]));
                    }
                }
                list.add(row);
                str1 = br.readLine();
                str2 = br2.readLine();
            }
            for(int i = 0; i < list.size(); i++){
                for(int j = 0; j < list.get(i).size(); j++){
                    filewriter.write(String.valueOf(list.get(i).get(j)));
                    if(j != list.get(i).size()-1){
                        filewriter.write(",");
                    }else{
                        filewriter.write("\n");
                    }
                }
            }
            br.close();
            br2.close();
            filewriter.close();
            fr.close();
            fr2.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
