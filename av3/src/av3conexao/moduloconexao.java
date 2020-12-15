package av3conexao;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class moduloconexao {

	
	public static Connection conector() {
		java.sql.Connection conexao = null;
		
		String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		
		String url ="jdbc:sqlserver://localhost:3306;databaseName=Locadora;user=sa;password=sa";
		String usuario = "sa";
		String senha ="sa";
		
		try {
			Class.forName(driver);
			conexao =DriverManager.getConnection(url,usuario,senha);
			return conexao;
		
		
		}catch (Exception e) {
			System.out.println(e);
			return null;
		}
	
	
	
	
	
	
	
	
	
	}
}