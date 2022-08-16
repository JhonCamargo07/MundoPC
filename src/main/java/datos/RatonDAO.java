package datos;

import domain.Raton;
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
public class RatonDAO {
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private String sql  = "";
    private boolean operacionExitosa = false;
    
    public boolean insert(Raton raton){
        sql = "INSERT INTO raton (id_dispositivo) VALUES (?)";
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, raton.getIdDispositivo());
            stmt.executeUpdate();
            
            operacionExitosa = true;
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar el raton: " + ex.toString());
            Logger.getLogger(RatonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return operacionExitosa;
    }
    
    public List<Raton> select(){
       List<Raton> ratones = new ArrayList<>();
       Raton raton = null;
       
        sql = "SELECT * FROM dispositivo_entrada";
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                raton = new Raton(rs.getInt(1), rs.getInt(2));        
                ratones.add(raton);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al seleccionar los ratones: " + ex.toString());
            Logger.getLogger(RatonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return ratones;
    }
}
