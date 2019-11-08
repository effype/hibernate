package hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class lab5 {
	
	public static void main(String[] args) throws SQLException {
	
		String url = "jdbc:hsqldb:hsql://localhost/";
		Connection con = DriverManager.getConnection(url, "SA", "");
		
		int number;
		java.util.Scanner sc = new java.util.Scanner(System.in);
		//Scanner sc= new Scanner(System.in);
		System.out.println("Wybierz numer:");
	    number = sc.nextInt();
	    
	    switch (number) {
	    	case 1:
	    		Statement statement = con.createStatement();
				String query = "select * from kontakty";
				ResultSet result = statement.executeQuery(query);
				while (result.next()) {
				System.out.print(result.getInt("id"));
				System.out.print(" ");
				System.out.print(result.getString("nazwisko"));
				System.out.print(" ");
				System.out.print(result.getString("imie"));
				System.out.println();
	    }
				statement.close();
				break;
			
	    	case 2:
		    	//String query = "select * from kontakty where grupa=1";
		    	Statement statement1 = con.createStatement();
		    	String query1 = "select * from kontakty where grupa=1";
		    	ResultSet result1 = statement1.executeQuery(query1);
				while (result1.next()) {
				System.out.print(result1.getInt("id"));
				System.out.print(" ");
				System.out.print(result1.getString("nazwisko"));
				System.out.print(" ");
				System.out.print(result1.getString("imie"));
				System.out.println();
				}
		        break;
		        
	    	case 3:
	    		PreparedStatement pdst = con.prepareStatement(
	    				"insert into kontakty (imie, nazwisko, email, telefon, grupa) "
	    				+ "values (?, ?, ?, ?, ?)");
	    				pdst.setString(1, "Janina");
	    				pdst.setString(2, "Kowalska");
	    				pdst.setString(3, "janina@kowalski.pl");
	    				pdst.setString(4, "223123121");
	    				pdst.setInt(5, 1);
	    				pdst.executeUpdate();
	    				pdst.close();
	    				
	    		    	break;
	    	case 4:
	    		Statement st = con.createStatement();
				String sql = "DELETE FROM kontakty WHERE id = 1";  
				int deleteCount = st.executeUpdate(sql);
				sql = "DELETE FROM kontakty WHERE id = 1";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, 918);                    
				deleteCount = pstmt.executeUpdate();
		    	
		    	break;
	    
	default: {
        System.out.println("Zakonczono");
	}
	}
	}
}