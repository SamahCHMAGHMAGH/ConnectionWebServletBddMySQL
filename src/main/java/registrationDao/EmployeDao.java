package registrationDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import registrationModel.Employe;

public class EmployeDao {

	private PreparedStatement preparedStatement;

	public int registreEmploye(Employe employe)throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO employe" +
				" (id,first_name, last_name, username, password, address, contact) VALUES " +
				" (1, Samah, Chma, Zouari, Pass1234, 15, Rue les Roses, 06556677)";
		
		int result = 0;
		
		Class.forName("com.mysql.jdbc.Driver");
		
		try (Connection connection = DriverManager.
			getConnection("jdbc:mysql://localhost:3306/employes","Samah","Samah12345*");
				
				//Step 2: create a statement using connection object
				PreparedStatement prepareStatement = connection.prepareStatement(INSERT_USERS_SQL)){
				prepareStatement.setInt(1, 1);
				prepareStatement.setString(2, employe.getFirstname());
				prepareStatement.setString(3, employe.getLastname());
				prepareStatement.setString(4, employe.getUsername());
				prepareStatement.setString(5, employe.getPassword());
				prepareStatement.setString(6, employe.getAdress());
				prepareStatement.setString(7, employe.getContact());
				
				System.out.println(prepareStatement);
				//Step 3: Execute the query or update query
				result = preparedStatement.executeUpdate();
		
		}catch (SQLException e) {
			// process sql exception
			e.printStackTrace();
		}
		return result;
	}

	
		
	}


