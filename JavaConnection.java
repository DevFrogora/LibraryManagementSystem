/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.util.Vector;
import javax.swing.table.*;
import javax.swing.*;

/**
 *
 * @author user
 */
public class JavaConnection {

    Connection con = null;
    Statement st = null;

    ResultSet rs;

    void connection() {
        String dbname = "db1";
        try {
            JavaConnection db = new JavaConnection();
            db.connectionInitial();
            ResultSet rs1 = db.executeQuery("Select name from currentdb where id=1");
            if (rs1.next()) {
                dbname = rs1.getString(1);
            }
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname , "admin", "12345");

            // It creates and displays the table
            // Closes the Connection
            // The Connection is obtained
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "please Connect Xamp Start Mysql","Error the Developer Wants You to Start Xamp/Wamp",JOptionPane.ERROR_MESSAGE);
        }
    }

    void connectionInitial() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");

            // It creates and displays the table
            // Closes the Connection
            // The Connection is obtained
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "please Connect Xamp Start Mysql","Error the Developer Wants You to Start Xamp/Wamp",JOptionPane.ERROR_MESSAGE);
        }
    }

    int executeUpdate(String s) {
        int r = 0;
        try {
            st = con.createStatement();
            r = st.executeUpdate(s);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return r;

    }

    void execute(String s) {

        try {
            st = con.createStatement();
            st.execute(s);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    ResultSet executeQuery(String s) {
        try {
            st = con.createStatement();
            rs = st.executeQuery(s);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rs;
    }

    /*  void empDb() {
        JavaConnection db = new JavaConnection();
        db.connection();
        try {
            ResultSet rs;
            rs = db.Execute("select id,name,age from emp");
            if (rs != null) {
                while (rs.next()) {
                    System.out.println(r.getInt(1) + "  " + r.getString(2) + "  " + r.getString(3));
                }
            } else {
                System.out.println("hey here is null");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        db.connClose();

    }
     */
    void connClose() {
        try {
            this.con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    void empTable() {
        try {
            JavaConnection db = new JavaConnection();
            db.connection();
            ResultSet rs;
            rs = db.executeQuery("select * from addition");
            TableModelJTable t = new TableModelJTable();
            JFrame f = new JFrame();

            JTable table = new JTable(t.buildTableModel(rs));

            JScrollPane sp = new JScrollPane(table);
            f.add(sp);

            f.setSize(300, 400);
            f.setVisible(true);

            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}

class TableModelJTable {

    static DefaultTableModel db;
// it is not predifines function

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException {

        try {
            ResultSetMetaData metaData = rs.getMetaData();

            // names of columns
            Vector<String> columnNames = new Vector<String>();
            int columnCount = metaData.getColumnCount();
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnName(column));
            }

            // data of the table
            Vector<Vector<Object>> data = new Vector<Vector<Object>>();
            while (rs.next()) {
                Vector<Object> vector = new Vector<Object>();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    vector.add(rs.getObject(columnIndex));
                }
                data.add(vector);
            }

            db = new DefaultTableModel(data, columnNames);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return db;
    }

}

class ab {

    public static void main(String[] args) {
        JavaConnection db = new JavaConnection();
        db.empTable();
        // db.empDb();
        //   db.connClose();
    }
}
