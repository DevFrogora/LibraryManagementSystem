/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author root
 */
public class PrimarySetup {

    int r;

    void createDb() {
        JavaConnection dm = new JavaConnection();
        dm.connectionInitial();

        r = dm.executeUpdate("CREATE DATABASE db1");

        if (r == 0) {
            JOptionPane.showMessageDialog(null, "DB1 database already exists");
            // System.out.println("Database exists");
        } else {
            JOptionPane.showMessageDialog(null, "Db1 database created");
        }
        // System.out.println("r value is " + r);
        dm.connClose();
        System.out.println("Db1 created");

    }

    void createUser() {
        JavaConnection dm = new JavaConnection();
        dm.connectionInitial();
        dm.execute("CREATE USER 'admin' IDENTIFIED BY '12345';");
        dm.connClose();
        System.out.println("user admin created");

    }

    void grantUser() {
         JavaConnection dm = new JavaConnection();
        dm.connectionInitial();
          String dbname="db1";
        try {
            JavaConnection db = new JavaConnection();
            db.connectionInitial();
            ResultSet rs1 = db.executeQuery("Select name from currentdb where id=1");
            if(rs1.next()){
            dbname = rs1.getString(1);
            }
        dm.execute("grant all privileges on "+dbname+".* to 'admin'@'localhost' identified by '12345'");
        dm.execute("flush privileges");

        dm.connClose();
           } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        System.out.println("grant given");

    }

    void dropdb() {
        JavaConnection dm = new JavaConnection();
        dm.connectionInitial();
        dm.execute("Drop database db1 ");
        dm.connClose();
        System.out.println("Db1 droped from current user");

    }

    void call() {

       PrimarySetup s = new PrimarySetup();
        //s.createDb();
        //  s.createUser();
        s.grantUser();
        s.signupCreateTable();
        s.newBookTable();
        s.newMemberTable();
        
        s.newIssueTable();
        s.newReturnTable();
      //  s.dropdb();
    }

    void signupCreateTable() {
        JavaConnection db = new JavaConnection();
        db.connection();
        String sql = "CREATE TABLE Sign "
                + "( username VARCHAR(255) not NULL, "
                + " name VARCHAR(255), "
                + " password VARCHAR(255), "
                + " question VARCHAR(255), "
                + " answer VARCHAR(255), "
                + " PRIMARY KEY (username))";
        db.executeUpdate(sql);
        db.connClose();
        //   System.out.println("table Created");
    }

    void newBookTable() {
        JavaConnection db = new JavaConnection();
        db.connection();
        //auto increment start from 1
        String sql = "CREATE TABLE Book "
                + "( bookid INT AUTO_INCREMENT not NULL, "
                + " name VARCHAR(255), "
                + " edition INT , "
                + " publisher VARCHAR(255), "
                + " price FLOAT(6,2) , "
                + " pages INT ,"
                + " PRIMARY KEY (bookid))";
        db.executeUpdate(sql);
        db.connClose();
        //   System.out.println("table Created");
    }

    void newMemberTable() {

        JavaConnection db = new JavaConnection();
        db.connection();
        //auto increment start from 1
        String sql = "CREATE TABLE Member "
                + "( memberid INT AUTO_INCREMENT not NULL, "
                + " name VARCHAR(255), "
                + " father_name VARCHAR(255) , "
                + " department VARCHAR(255), "
                + " year INT , "
                + " sem INT ,"
                + " member_type VARCHAR(255) ,"
                + " PRIMARY KEY (memberid))";
        db.executeUpdate(sql);
        db.connClose();

    }

    void newIssueTable() {
        JavaConnection db = new JavaConnection();
        db.connection();
        //auto increment start from 1
        String sql = "CREATE TABLE Issue "
                + "( memberid INT not NULL, "
                + " bookid INT not NULL, "
                + " membername VARCHAR(255), "
                + " department VARCHAR(255), "
                + " member_type VARCHAR(255) ,"
                + " date DATE ,"
                + "FOREIGN KEY (memberid) REFERENCES Member(memberid),"
                + "FOREIGN KEY (bookid) REFERENCES Book(bookid))";
        db.executeUpdate(sql);
        db.connClose();

    }
     void newReturnTable() {
        JavaConnection db = new JavaConnection();
        db.connection();
        //auto increment start from 1
        String sql = "CREATE TABLE ReturnTable "
                + "( member_id INT not NULL, "
                + " book_id INT not NULL, "
                + " member_name VARCHAR(255), "
                + " department VARCHAR(255), "
                + " member_type VARCHAR(255),"
                + " issue_date DATE ,"
                + " return_date DATE )";
        db.executeUpdate(sql);
        db.connClose();

    }

}

class frt {

    public static void main(String[] args) {
        PrimarySetup s = new PrimarySetup();
        // s.call();
       // s.newReturnTable();
    }
}
