package proj.java.user.doa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proj.java.user.model.Medicine;
public class MedDao {

	String url="jdbc:mysql://localhost:3306/pharma";
	String user="root";
	String pass="shubhi2125";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO pharma" + "  (med_name, category, price, exp_date) VALUES " +
	        " (?, ?, ?, ?);";

	    private static final String SELECT_USER_BY_ID = "select med_id,med_name,category,price, exp_date from pharma where med_id =?";
	    private static final String SELECT_ALL_USERS = "select * from pharma";
	    private static final String UPDATE_USERS_SQL = "update pharma set med_name = ?,category= ?, price =?, exp_date=? where med_id = ?;";
	    protected Connection getConnection() {
	        Connection connection = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            connection = DriverManager.getConnection(url, user, pass);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return connection;
	    }
	    
	    public void insertMed(Medicine med) throws SQLException {
	        System.out.println(INSERT_USERS_SQL);
	        // try-with-resource statement will auto close the connection.
	        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setString(1, med.getMed_name());
	            preparedStatement.setString(2, med.getCategory());
	            preparedStatement.setInt(3, med.getPrice());
	            preparedStatement.setString(4, med.getDate());
	            System.out.println(preparedStatement);
	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	    }
	    public Medicine selectMed(int med_id) {
	        Medicine med = null;
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
	            preparedStatement.setInt(1, med_id);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                String med_name = rs.getString("med_name");
	                String category = rs.getString("category");
	                int price = rs.getInt("price");
	                String exp_date = rs.getString("exp_date");

	                med = new Medicine(med_id, med_name, category, price, exp_date );
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return med;
	    }
	    
	    public List < Medicine > selectAllMed() {

	        // using try-with-resources to avoid closing resources (boiler plate code)
	        List < Medicine > med = new ArrayList < > ();
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                int med_id = rs.getInt("med_id");
	                String med_name = rs.getString("med_name");
	                String category = rs.getString("category");
	                int price = rs.getInt("price");
	                String exp_date = rs.getString("exp_date");
	                med.add(new Medicine(med_id, med_name, category, price, exp_date));
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return med;
	    }
	    
	    public boolean updateMed(Medicine med) throws SQLException {
	        boolean rowUpdated;
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
	            statement.setString(1, med.getMed_name());
	            statement.setString(2, med.getCategory());
	            statement.setInt(3, med.getPrice());
	            statement.setString(4,med.getDate());
	            statement.setInt(5, med.getMed_id());

	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }



		private void printSQLException(SQLException ex) {
			 for (Throwable e: ex) {
		            if (e instanceof SQLException) {
		                e.printStackTrace(System.err);
		                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
		                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
		                System.err.println("Message: " + e.getMessage());
		                Throwable t = ex.getCause();
		                while (t != null) {
		                    System.out.println("Cause: " + t);
		                    t = t.getCause();
		                }
		            }
		        }
			
		}

}
