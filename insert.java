package net.sqlitetutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insert {

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/movies.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertdata(String movie, String actor,String actress,int year,String director ) {
        String sql = "INSERT INTO Movie(Movie_name,actor,actress,year,director) VALUES(?,?,?,?,?)";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, movie);
            pstmt.setString(2, actor);
	pstmt.setString(3, actress);
	pstmt.setInt(4, year);
	pstmt.setString(5, director);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        insert app = new insert();
        // insert three new rows
        app.insertdata("Veeram", "Ajith","Tamannah",2014,"siva");
        app.insertdata("jai bhim","Suriya","jose",2021,"gnanavel");
        app.insertdata("master","Vijay","malavika",2020,"Lokesh");
    }

}