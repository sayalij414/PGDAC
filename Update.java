import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Update {

	public static void main(String[] args) throws Exception {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		
		String q="update table1 set tname=? ,tcity=? where tid=?";
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root","root");
		PreparedStatement pstmt=con.prepareStatement(q);
		
		//for scanning values
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter name:");
		String name=br.readLine();
		
		System.out.println("Enter city:");
		String city=br.readLine();
		
		System.out.println("Enter student id:");
		int id=Integer.parseInt(br.readLine());
		
		
		
		pstmt.setString(1,name);
		pstmt.setString(2,city);
		pstmt.setInt(3,id);
		
		pstmt.executeUpdate();
		
		System.out.println("Done...");
		con.close();
	}

}
