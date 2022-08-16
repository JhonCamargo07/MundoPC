package datos;

import domain.Monitor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jhona
 */
public class MonitorDAO {
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private String sql  = "";
    private boolean operacionExitosa = false;
    
    public boolean insert(Monitor monitor){
        sql = "INSERT INTO monitor (marca, size) VALUES (?,?)";
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, monitor.getMarca());
            stmt.setDouble(2, monitor.getSize());
            stmt.executeUpdate();
            
            operacionExitosa = true;
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar el monitor: " + ex.toString());
            Logger.getLogger(RatonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return operacionExitosa;
    }
    
    public List<Monitor> select(){
       List<Monitor> monitores = new ArrayList<>();
       Monitor monitor = null;
       
        sql = "SELECT * FROM dispositivo_entrada";
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                monitor = new Monitor(rs.getInt(1), rs.getString(2), rs.getDouble(3));        
                monitores.add(monitor);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al seleccionar los monitores: " + ex.toString());
            Logger.getLogger(RatonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return monitores;
    }
}
