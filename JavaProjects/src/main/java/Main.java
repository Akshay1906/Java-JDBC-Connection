import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public void read() {
        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "root", "Akshay@1998");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from student");
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3)
                        + "  " + rs.getString(4));
            con.close();
        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public void insert(String ID, String Name, String Department, String Contact) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "root", "Akshay@1998");

            Statement stmt = con.createStatement();

            // Inserting data in database
            String q1 = "insert into student values('" + ID + "', '" + Name +
                    "', '" + Department + "', '" + Contact + "')";
            int x = stmt.executeUpdate(q1);
            if (x > 0)
                System.out.println("Successfully Inserted");
            else
                System.out.println("Insert Failed");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete(String ID) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "root", "Akshay@1998");

            Statement stmt = con.createStatement();

            // Delete
            String q1 = "DELETE from student WHERE ID = " + ID;
            int x = stmt.executeUpdate(q1);

            if (x > 0)
                System.out.println("One User Successfully Deleted");
            else
                System.out.println("ERROR OCCURED :(");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void update(String ID, String n) {
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "root", "Akshay@1998");

            Statement stmt = con.createStatement();

            // Update
            String q1 = "UPDATE student set Name = '" + n +
                    "' WHERE ID = '" + ID + "'";

            int x = stmt.executeUpdate(q1);

            if (x > 0)
                System.out.println("One User Successfully updated");
            else
                System.out.println("ERROR OCCURED :(");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println("Select your choice \n---------------------------------");
        System.out.println("Press 1 for read");
        System.out.println("Press 2 for insert");
        System.out.println("Press 3 for update");
        System.out.println("Press 4 for delete");
        System.out.println("Press 0 for exit");
        Scanner sc = new Scanner(System.in);

        while (true) {
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    obj.read();
                    break;
                case 2:
                    obj.insert("3", "rishi", "Computer Science", "6574884894");
                    break;
                case 3:
                    obj.update("2", "Ashish");
                    break;
                case 4:
                    obj.delete("3");
                case 0:
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }


    }
}



