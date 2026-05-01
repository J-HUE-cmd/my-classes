///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// */
//
//package packge.lt;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
///**
// *
// * @author one touch
// */
//public class Lt {
//
//    public static void main(String[] args) {
//         
//         
//      try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\one touch\\OneDrive\\Desktop\\lt\\l.txt"))) {
//
//            String line;
//            int lineNumber = 1;
//
//            while ((line = br.readLine()) != null) {
//                checkLine(line.trim(), lineNumber);
//                lineNumber++;
//            }
//
//        } catch (IOException e) {
//            System.out.println("Error reading file");
//        }
//    }
//
//    static void checkLine(String line, int lineNumber) {
//
//        if (line.isEmpty()) return;
//
//        // 1. لازم ينتهي بـ ;
//        if (!line.endsWith(";")) {
//            System.out.println("Error line " + lineNumber + ": Missing ;");
//            return;
//        }
//
//        // نحذف ;
//        line = line.substring(0, line.length() - 1);
//
//        // نقسم السطر
//        String[] parts = line.split(" ");
//
//        // نتوقع 4 أجزاء: type name = value
//        if (parts.length != 4) {
//            System.out.println("Error line " + lineNumber + ": Invalid syntax");
//            return;
//        }
//
//        String type = parts[0];
//        String name = parts[1];
//        String assign = parts[2];
//        String value = parts[3];
//
//        // 2. فحص النوع
//        if (!type.equals("int") && !type.equals("double")) {
//            System.out.println("Error line " + lineNumber + ": Invalid type");
//            return;
//        }
//
//        // 3. فحص اسم المتغير
//        if (!name.matches("[a-zA-Z]+")) {
//            System.out.println("Error line " + lineNumber + ": Invalid variable name");
//            return;
//        }
//
//        // 4. فحص =
//        if (!assign.equals("=")) {
//            System.out.println("Error line " + lineNumber + ": Missing =");
//            return;
//        }
//
//        // 5. فحص القيمة
//        try {
//            if (type.equals("int")) {
//                Integer.parseInt(value);
//            } else {
//                Double.parseDouble(value);
//            }
//        } catch (NumberFormatException e) {
//            System.out.println("Error line " + lineNumber + ": Invalid number");
//            return;
//        }
//
//        // إذا كلشي تمام
//        System.out.println("Line " + lineNumber + " OK");
//    }
//}
