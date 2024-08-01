import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object OracleDBConnection {
    private const val URL = "jdbc:oracle:thin:@//[HOST]:[PORT]/[SERVICE_NAME]"
    private const val USER = "your_db_user"
    private const val PASSWORD = "your_db_password"

    fun getConnection(): Connection {
        return try {
            DriverManager.getConnection(URL, USER, PASSWORD)
        } catch (e: SQLException) {
            e.printStackTrace()
            throw RuntimeException("Error connecting to the database", e)
        }
    }
}
