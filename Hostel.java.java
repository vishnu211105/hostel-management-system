package jdbc;
import java.sql.*;
import java.util.*;

public class Hostel {
    private static final String URL = "jdbc:mysql://localhost:3306/HMS";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    
    private static void displayDetails() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM hostel2")) {
            System.out.println(" Id| Department| Room");
            while (rs.next()) {
                System.out.println( rs.getInt("Id") + " | " + rs.getString("Department") +" | " + rs.getInt("Room"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    private static void addRoom() {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO hostel3 (RoomNo, RoomFilled, RoomAvailable) VALUES (?, ?, ?)")) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Room Number: ");
            int roomNo = sc.nextInt();
            System.out.print("Is Room Filled? (true/false): ");
            boolean roomFilled = sc.nextBoolean();
            boolean roomAvailable = !roomFilled;

            ps.setInt(1, roomNo);
            ps.setBoolean(2, roomFilled);
            ps.setBoolean(3, roomAvailable);
            ps.executeUpdate();

            System.out.println("Room added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    private static void updateRoomDetails() {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE hostel3 SET RoomFilled = ?, RoomAvailable = ? WHERE RoomNo = ?")) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Room Number to Update: ");
            int roomNo = sc.nextInt();
            System.out.print("Is Room Filled? (true/false): ");
            boolean roomFilled = sc.nextBoolean();
            boolean roomAvailable = !roomFilled;

            ps.setBoolean(1, roomFilled);
            ps.setBoolean(2, roomAvailable);
            ps.setInt(3, roomNo);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Room updated successfully.");
            } else {
                System.out.println("Room not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    private static void deleteDetails() {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM hostel3 WHERE RoomNo = ?")) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Room Number to Delete: ");
            int roomNo = sc.nextInt();

            ps.setInt(1, roomNo);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Room deleted successfully.");
            } else {
                System.out.println("Room not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    private static void roomVacancy() {
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT RoomNo FROM hostel3 WHERE RoomAvailable = true")) {
            System.out.println("Available Rooms:");
            boolean found = false;
            while (rs.next()) {
                System.out.println("Room No: " + rs.getInt("RoomNo"));
                found = true;
            }
            if (!found) {
                System.out.println("No available rooms at the moment.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
 
    

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Hostel Management System ===");
            System.out.println("1. Display Room Details");
            System.out.println("2. Add Room");
            System.out.println("3. Update Room Details");
            System.out.println("4. Delete Room");
            System.out.println("5. Room Vacancy");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: displayDetails(); break;
                case 2: addRoom(); break;
                case 3: updateRoomDetails(); break;
                case 4: deleteDetails(); break;
                case 5: roomVacancy(); break;
                case 6: System.out.println("Exiting system..."); return;
                default: System.out.println("Invalid option. Try again.");
            }
        }
    }
}
