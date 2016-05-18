package com.josh;


import java.sql.SQLException;
import java.sql.Statement;


public class GIJoeTable {

    private final static String GI_Joe_Table = "GIJoeTable";

    final static String ID = "Id";
    final static String YEAR = "Year";
    final static String NAME = "Name";
    final static String ACC1 = "Acc1";
    final static String ACC2 = "Acc2";
    final static String ACC3 = "Acc3";
    final static String ACC4 = "Acc4";
    final static String ACC5 = "Acc5";
    final static String ACC6 = "Acc6";
    final static String ACC7 = "Acc7";
    final static String ACC8 = "Acc8";
    final static String ACC9 = "Acc9";
    final static String ACC10 = "Acc10";

    GIJoeTable() {
    }

    ;

    static boolean createGIJoeTable(Statement statement) {

        try {

            String createGIJoeTable =
                    "CREATE TABLE " +
                            GI_Joe_Table + " (" +
                            ID + " INT NOT NULL AUTO_INCREMENT, " +
                            YEAR + " VARCHAR(6), " +
                            NAME + " VARCHAR(40), " +
                            ACC1 + " VARCHAR(40), " +
                            ACC2 + " VARCHAR(50), " +
                            ACC3 + " VARCHAR(45), " +
                            ACC4 + " VARCHAR(40), " +
                            ACC5 + " VARCHAR(45), " +
                            ACC6 + " VARCHAR(40), " +
                            ACC7 + " VARCHAR(40), " +
                            ACC8 + " VARCHAR(40), " +
                            ACC9 + " VARCHAR(40), " +
                            ACC10 + " VARCHAR(40), PRIMARY KEY(" + ID + "))";
            statement.executeUpdate(createGIJoeTable);


        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
            System.out.println("Fail to create table");
            return false;
        }
        return true;
    }
}


//    CREATE TABLE GIJoeDB " + "(Year varchar(6), "+" Name varchar(40),"+" Acc1 varchar(40),"+" Acc2 varchar(50)" +
//        ", Acc3 varchar(45),"+" Acc4 varchar(40),"+" Acc5 varchar(45),"+" Acc6 varchar(40),"+" Acc7 varchar(40),"+" Acc8 varchar(40)" +
//        ", Acc9 varchar(40),"+" Acc10 varchar(40))";