
package app_mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class App_MySQL {

    
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String _url = "jdbc:mysql://localhost/tienda?user=root&password=mysqladmin";
            Connection connect = DriverManager.getConnection(_url);
            Statement statement = connect.createStatement();
            String _query = "SELECT * FROM producto";
            ResultSet resultSet = statement.executeQuery(_query);
            while (resultSet.next()){
                int idProducto = resultSet.getInt("id_producto");
                String descProd = resultSet.getString("desc_producto");
                int precio = resultSet.getInt("precio");
                System.out.println("Id: "+idProducto);
                System.out.println("Desc: "+descProd);
                System.out.println("Precio: "+precio);
                System.out.println("--------------------------------\n");
            }
            resultSet.close();
            statement.close();
            connect.close();
            
        } catch (Exception e) {
        }
        
    }
    
}
