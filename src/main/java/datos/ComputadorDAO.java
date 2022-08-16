package datos;

import domain.*;
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
public class ComputadorDAO extends Conexion{
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private String sql  = "";
    private boolean operacionExitosa = false;
    
    public boolean insert(Computador computador){
        sql = "INSERT INTO computador (nombre, id_monitor, id_teclado, id_raton) VALUES (?,?,?,?)";
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, computador.getNombre());
            stmt.setInt(2, computador.getIdMonitor());
            stmt.setInt(3, computador.getIdTeclado());
            stmt.setInt(4, computador.getIdRaton());
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
    
    public List<Computador> select(){
       List<Computador> computadores = new ArrayList<>();
       Computador computador = null;
       
        sql = "SELECT * FROM computador";
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                computador = new Computador(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));        
                computadores.add(computador);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al seleccionar los computadores: " + ex.toString());
            Logger.getLogger(RatonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return computadores;
    }
}
