package datos;

import domain.Orden;
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
public class OrdenDAO {
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private String sql  = "";
    private boolean operacionExitosa = false;
    
    public boolean insert(Orden orden){
        sql = "INSERT INTO orden (id_comutador) VALUES (?)";
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, orden.getIdComputador());
            stmt.executeUpdate();
            
            operacionExitosa = true;
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar la orden: " + ex.toString());
            Logger.getLogger(RatonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return operacionExitosa;
    }
    
    public List<Orden> select(){
       List<Orden> ordenes = new ArrayList<>();
       Orden orden = null;
       
        sql = "SELECT * FROM dispositivo_entrada";
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                orden = new Orden(rs.getInt(1), rs.getInt(2));        
                ordenes.add(orden);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al seleccionar las ordenes: " + ex.toString());
            Logger.getLogger(RatonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return ordenes;
    }
}
