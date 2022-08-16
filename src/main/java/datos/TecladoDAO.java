package datos;

import domain.Teclado;
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
public class TecladoDAO extends Conexion{

    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private String sql = "";
    boolean operacionExitosa = false;

    public boolean insert(Teclado teclado) {
        sql = "INSERT INTO teclado (id_dispositivo) VALUES(?)";
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, teclado.getIdDispositivo());
            stmt.executeUpdate();
            
            operacionExitosa = true;
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar el teclado: " + ex.toString());
            Logger.getLogger(TecladoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return operacionExitosa;
    }
    
    public List<Teclado> select(){
       List<Teclado> teclados = new ArrayList<>();
       Teclado teclado = null;
       
        sql = "SELECT * FROM dispositivo_entrada";
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                teclado = new Teclado(rs.getInt(1), rs.getInt(2));        
                teclados.add(teclado);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al seleccionar los teclados: " + ex.toString());
            Logger.getLogger(RatonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return teclados;
    }
}
