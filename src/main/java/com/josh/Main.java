package com.josh;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Main {

    private Connection conn;
    private Statement setUpTableStatement;
    //static HSSFRow row;
    static String year = "";
    static String name = "";
    public static void main(String[] args) throws IOException {


        Main main = new Main();
        main.go();
    }

    public void go() {


        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/GIJoeDB", "root", "CobraCommandCenter668");

            setUpTableStatement = conn.createStatement();
            String deleteSqlInfo = "DROP TABLE if EXISTS GIJoeDB";

            setUpTableStatement.execute(deleteSqlInfo);
            String createTableSQL = "CREATE TABLE GIJoeDB " + "(Year varchar(6), "+" Name varchar(40),"+" Acc1 varchar(40),"+" Acc2 varchar(50)" +
                    ", Acc3 varchar(45),"+" Acc4 varchar(40),"+" Acc5 varchar(45),"+" Acc6 varchar(40),"+" Acc7 varchar(40),"+" Acc8 varchar(40)" +
                    ", Acc9 varchar(40),"+" Acc10 varchar(40))";
            //PRINTING OUT DATABASE WHEN TESTING  //
              //    System.out.println(createTableSQL);
            setUpTableStatement.execute(createTableSQL);
            PreparedStatement importDB = null;
            FileInputStream readStream = null;
            try {
                readStream = new FileInputStream("FiguresFinalProject.xls");
            } catch (java.lang.Exception exception) {
                System.out.println("File Not Found");
                exception.printStackTrace();
            }
            HSSFWorkbook workbook = new HSSFWorkbook(readStream);

            System.out.println(workbook.getNumberOfSheets());

            HSSFSheet sheet = workbook.getSheetAt(0);


            for (int r = 0; r < sheet.getLastRowNum(); r++) {
                System.out.println(sheet.getRow(r));        //output of row information
                HSSFRow row = sheet.getRow(r);
                //while (row.getCell(c).getStringCellValue() != null) {
                int c = 0;
                //  for (int c = 0; c < row.getLastCellNum(); c++) {
                System.out.println(row.getLastCellNum());    //output last cell number

                Cell year = sheet.getRow(r).getCell(c);//, Row.RETURN_BLANK_AS_NULL);
                System.out.println(year);
                Cell name = sheet.getRow(r).getCell(c + 1, Row.RETURN_BLANK_AS_NULL);
                System.out.println(name + " name");
                Cell acc1 = sheet.getRow(r).getCell(c + 2, Row.RETURN_BLANK_AS_NULL);
                System.out.println(acc1);
                Cell acc2 = sheet.getRow(r).getCell(c + 3, Row.RETURN_BLANK_AS_NULL);
                System.out.println(acc2);
                Cell acc3 = sheet.getRow(r).getCell(c + 4, Row.RETURN_BLANK_AS_NULL);
                System.out.println(acc3);
                Cell acc4 = sheet.getRow(r).getCell(c + 5, Row.RETURN_BLANK_AS_NULL);
                System.out.println(acc4);
                Cell acc5 = sheet.getRow(r).getCell(c + 6, Row.RETURN_BLANK_AS_NULL);
                System.out.println(acc5);
                Cell acc6 = sheet.getRow(r).getCell(c + 7, Row.RETURN_BLANK_AS_NULL);
                System.out.println(acc6);
                Cell acc7 = sheet.getRow(r).getCell(c + 8, Row.RETURN_BLANK_AS_NULL);
                System.out.println(acc7);
                Cell acc8 = sheet.getRow(r).getCell(c + 9, Row.RETURN_BLANK_AS_NULL);
                System.out.println(acc8);
                Cell acc9 = sheet.getRow(r).getCell(c + 10, Row.RETURN_BLANK_AS_NULL);
                System.out.println(acc9);
                Cell acc10 = sheet.getRow(r).getCell(c + 11, Row.RETURN_BLANK_AS_NULL);
                System.out.println(acc10);

                //String sqlInput2ndAttempt = "INSERT INTO GIJoeDB VALUES (year, name, acc1, acc2, acc3, acc4, acc5, acc6, acc7, acc8, acc9, acc10)";
               // String sqlInput2ndAttempt = "INSERT INTO GIJoeDB (year, name, acc1, acc2, acc3, acc4, acc5, acc6, acc7, acc8, acc9, acc10)" + " VALUES ('year', ?, ?, ?, ?,

               // System.out.println(sqlInput2ndAttempt + "here is the data");
                //String sqlInput = "INSERT INTO GIJoeDB (year, name, acc1, acc2, acc3, acc4, acc5, acc6, acc7, acc8, acc9, acc10) VALUES ('" + year + "', '" + name + "', '" + acc1 + "','" + acc2 + "','" + acc3 + "','"
             //          + acc4 + "','" + acc5 + "','" + acc6 + "','" + acc7 + "','" + acc8 + "','" + acc9 + "','" + acc10 + "', )";

                String sqlInput = "INSERT INTO GIJoeDB(year, name, acc1, acc2, acc3, acc4, acc5, acc6, acc7, acc8, acc9, acc10) VALUE ('" + year + "', '" + name + "', '" + acc1 + "','" + acc2 + "','" + acc3 + "','" + acc4 + "','" + acc5 + "','" + acc6 + "','" + acc7 + "','" + acc8 + "','" + acc9 + "','" + acc10 + "')";
//    NOT USING            String sqlInput = "INSERT INTO GIJoeDB VALUES('" + year + "', '" + name + "', '" + acc1 + "','" + acc2 + "','" + acc3 + "','"
//                        + acc4 + "','" + acc5 + "','" + acc6 + "','" + acc7 + "','" + acc8 + "','" + acc9 + "','" + acc10 + "')";
               // PreparedStatement prepstat = conn.prepareStatement(sqlInput2ndAttempt);
               // prepstat.setString(name);
                //importDB = conn.prepareStatement(sqlInput);
                System.out.println(sqlInput);
                System.out.println(importDB + "another attempt at data");
                Statement statement = conn.createStatement();
                statement.executeUpdate(sqlInput);
                //statement.executeUpdate("INSERT INTO GIJoeDB(year, name, acc1, acc2, acc3, acc4, acc5, acc6, acc7, acc8, acc9, acc10) VALUE ('" + year + "', '" + name + "', '" + acc1 + "','" + acc2 + "','" + acc3 + "','" + acc4 + "','" + acc5 + "','" + acc6 + "','" + acc7 + "','" + acc8 + "','" + acc9 + "','" + acc10 + "')");
                //statement.executeUpdate(sqlInput);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        GIJoeCollectionGUI gui = new GIJoeCollectionGUI(this);

    }

    public ArrayList<String> requestNamesForYear(String year) throws SQLException {
        System.out.println(year + "year!!!!");
        System.out.println("going to make ArrayList");
        //String yearcheck = "'" + year + "'";
        Statement statement = conn.createStatement();
        //String sql = "SELECT name FROM GIJoeDB WHERE year = \"'\" + year + \"'\"";     //set this to 1983 to make sure I was using valid commands
        String sql = "SELECT name FROM GIJoeDB WHERE year =  "+ year +"";
        ResultSet rs = statement.executeQuery(sql);
        ArrayList<String> namesList = new ArrayList<>();

        while (rs.next())
        {
            String nameToAdd = rs.getString("name");
            System.out.println(nameToAdd + "name to add");
            namesList.add(nameToAdd);
//            namesList.add(name);
        }
        //todo take arraylist and enter into
        //todo database - make query, send results back
        //return requestNamesForYear(sQLGetNamesByYear); //todo This is causing your endless loop - keep calling this method again?
        return namesList;
    }
    public HashMap<String, Boolean> requestAccessoriesForName(String accessories) throws SQLException {
        System.out.println(accessories + "Accessories!!!");
        Statement statement = conn.createStatement();
        String acc1 = "SELECT acc1 FROM GIJoeDB WHERE (year = "+ year + " AND name = "+ name + ")";
        System.out.println(acc1.toString() + "acc1 attempt");
        ResultSet rs = statement.executeQuery(acc1);
        HashMap<String, Boolean> accHash = new HashMap<>();
        //String sqlAccessories = "SELECT acc1, acc2, acc3, acc4,  FROM GIJoeDB WHERE acc1 = "+ accessories +"";
        return accHash;
    }




    public void shutdown() {
        //todo close connection, statements.
        // Add individual try-catch blocks and check to make sure these things are not null before calling close
      try {
          setUpTableStatement.close();
          conn.close();
      }catch (SQLException sqle) {
          sqle.printStackTrace();
      }
    }

}



