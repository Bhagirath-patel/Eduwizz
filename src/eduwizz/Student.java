/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eduwizz;
import java.util.*;
/**
 *
 * @author bhagirath
 */
public class Student {
   String name;
   ArrayList<Course> cs= new ArrayList<Course>(1000);
   
   Student(String name ){
       this.name = name;
       
   }
   
   void print(){
        System.out.println(this.name);
   }
   void printCourse(){
       for(int i = 0 ; i < cs.size() ; i++){
           System.out.println(this.cs.get(i).name +" ");
       }
   }
   
   void printStudent(Course c){
       
       for(int i = 0 ; i < cs.size() ; i++){
           if(cs.get(i).name.equals(c.name))
           System.out.println(this.cs.get(i).name +" ");
       }
   }
}
