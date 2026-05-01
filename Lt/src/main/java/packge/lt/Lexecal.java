/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package packge.lt;

import java.util.*;
import java.io.*;

/**
 *
 * @author one touch
 */
public class Lexecal {

     public static void main(String[] args) throws Exception {

          Scanner in = new Scanner(new File("C:\\Users\\one touch\\OneDrive\\Desktop\\lt"));

          char ch;
          String line, tk, com;

          while (in.hasNext()) {

               line = in.nextLine();
               tk = "";
               com = "";

               for (int i = 0; i < line.length(); i++) {

                    ch = line.charAt(i);
                    
                    if (ch == ' ') {

                         processToken(tk);
                         tk = "";
                    } 
                    else if (isop(ch)) {

                         processToken(tk);
                         tk = "";

                         System.out.println("Operator: " + ch);
                    } 
                    else if (issp(ch)) {

                         processToken(tk);
                         tk = "";

                         System.out.println("Special Symbol: " + ch);
                    } 
                    else {
                         tk += ch;
                    }
               }

               //  معالجة آخر توكن بالسطر
               processToken(tk);
          }

          in.close();
     }

     public static boolean issp(char x) {
          if (x == ',' || x == ';' || x == '(' || x == ')' || x == '{' || x == '}') {
               return true;
          } else {
               return false;
          }
     }

     public static boolean isop(char x) {
          if (x == '-' || x == '+' || x == '*' || x == '/' || x == '=') {
               return true;
          } else {
               return false;
          }
     }

     public static boolean isrw(String x) {
          if (x.equals("DEF") || x.equals("BODY") || x.equals("int")
                              || x.equals("byte") || x.equals("print")) {
               return true;
          }
          return false;
     }

     
     public static boolean isdig(String x) {
          for (int i = 0; i < x.length(); i++) {
               if (x.charAt(i) < '0' || x.charAt(i) > '9') {
                    return false;
               }
          }
          return true;
     }

     
     public static boolean isid(String id) {

          if (id.length() == 0) {
               return false;
          }

          if (!((id.charAt(0) >= 'a' && id.charAt(0) <= 'z')
                              || (id.charAt(0) >= 'A' && id.charAt(0) <= 'Z'))) {
               return false;
          }

          for (int i = 1; i < id.length(); i++) {

               char c = id.charAt(i);

               if (!((c >= 'a' && c <= 'z')
                                   || (c >= 'A' && c <= 'Z')
                                   || (c >= '0' && c <= '9'))) {
                    return false;
               }
          }
          return true;
     }

     public static void processToken(String tk) {

          if (tk.isEmpty()) {
               return;
          }

          if (isrw(tk)) {
               System.out.println("Reserved Word: " + tk);
          } else if (isdig(tk)) {
               System.out.println("Number: " + tk);
          } else if (isid(tk)) {
               System.out.println("Identifier: " + tk);
          } else {
               System.out.println("Error: " + tk);
          }
     }
}
