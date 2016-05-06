package com.josh;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.go();
    }

    public void go(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/GIJoeDB", "root", "itecitec");
            Statement statement;
            statement = conn.createStatement();
            String deleteSqlInfo = "DROP TABLE GIJoeDB";

            statement.execute(deleteSqlInfo);
            String createTableSQL = "CREATE TABLE GIJoeDB " + "(Year varchar(4), "+" Name varchar(25),"+" Acc1 varchar(30),"+" Acc2 varchar(30)" +
                    ", Acc3 varchar(30),"+" Acc4 varchar(30),"+" Acc5 varchar(30),"+" Acc6 varchar(30),"+" Acc7 varchar(30),"+" Acc8 varchar(30)" +
                    ", Acc9 varchar(30),"+" Acc10 varchar(30))";
            //PRINTING OUT DATABASE          System.out.println(createTableSQL);
            statement.execute(createTableSQL);
            PreparedStatement importDB = null;
            FileInputStream readStream = new FileInputStream("FiguresFinalProject.xls");
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
                Cell year = sheet.getRow(r).getCell(c, Row.RETURN_BLANK_AS_NULL);
                System.out.println(year + "year");
                Cell name = sheet.getRow(r).getCell(c + 1, Row.RETURN_BLANK_AS_NULL);
                System.out.println(name + "name");
                Cell acc1 = sheet.getRow(r).getCell(c + 2, Row.RETURN_BLANK_AS_NULL);
                System.out.println(acc1 + "acc1");
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
                System.out.println(acc10 + "acc10");

                String sqlInput2ndAttempt = "INSERT INTO GIJoeDB VALUES (year, name, acc1, acc2, acc3, acc4, acc5, acc6, acc7, acc8, acc9, acc10)";

//  WAS USING                String sqlInput = "INSERT INTO GIJoeDB VALUES('" + year + "', " + name + ", " + acc1 + "," + acc2 + "," + acc3 + ","
//                        + acc4 + "," + acc5 + "," + acc6 + "," + acc7 + "," + acc8 + "," + acc9 + "," + acc10 + ", )";


//    NOT USING            String sqlInput = "INSERT INTO GIJoeDB VALUES('" + year + "', '" + name + "', '" + acc1 + "','" + acc2 + "','" + acc3 + "','"
//                        + acc4 + "','" + acc5 + "','" + acc6 + "','" + acc7 + "','" + acc8 + "','" + acc9 + "','" + acc10 + "')";

                importDB = (PreparedStatement) conn.prepareStatement(sqlInput2ndAttempt);
                importDB.execute();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        GIJoeCollectionGUI gui = new GIJoeCollectionGUI(this);


    }

    public ArrayList requestNamesForYear(String year) {

        //todo database - make query, send results back
        return null; //todo
    }
}



