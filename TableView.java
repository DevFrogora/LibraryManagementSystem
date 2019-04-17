
import javax.swing.table.*;
import javax.swing.*;
import java.sql.*;
import java.util.Vector;

 public class TableView {

    public static void main(String[] args) throws Exception {

        Connection con = null;
        Statement st = null;
        String s;

        JFrame f = new JFrame();

        Db t = new Db();
        try {
          //  Class.forName("oracle.jdbc.driver.OracleDriver");
           Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "admin", "12345");
          
          //  con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "aimt");
            st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Issue");

            // It creates and displays the table
            JTable table = new JTable(t.buildTableModel(rs));

          JScrollPane sp = new JScrollPane(table);
           f.add(sp);
            // Closes the Connection

            f.setSize(500, 400);
            f.setVisible(true);
            
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // The Connection is obtained
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}

class Db {

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
        }
        return db;
    }

}
