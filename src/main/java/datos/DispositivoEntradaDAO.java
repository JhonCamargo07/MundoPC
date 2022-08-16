
import datos.Conexion;
import domain.DispositivoEntrada;
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
public class DispositivoEntradaDAO extends Conexion{
    
    private Connection conn = null;
    private PreparedStatement stmt = null;
    private ResultSet rs = null;
    private String sql  = "";
    private boolean operacionExitosa = false;
    
    public boolean insert(DispositivoEntrada dispositivoEntrada){
        sql = "INSERT INTO dispositivo_entrada (tipo_entrada, marca_dispositivo) VALUES (?,?)";
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, dispositivoEntrada.getTipoEntrada());
            stmt.setString(2, dispositivoEntrada.getMarca());
            stmt.executeUpdate();
            
            operacionExitosa = true;
            
        } catch (SQLException ex) {
            System.out.println("Error al insertar el dispositivo: " + ex.toString());
            Logger.getLogger(DispositivoEntradaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return operacionExitosa;
    }
    
    public List<DispositivoEntrada> select(){
       List<DispositivoEntrada> dispositivos = new ArrayList<>();
       DispositivoEntrada dispositivoEntrada = null;
       
        sql = "SELECT * FROM dispositivo_entrada";
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                dispositivoEntrada = new DispositivoEntrada(rs.getInt(1), rs.getString(2), rs.getString(3));
                dispositivos.add(dispositivoEntrada);
            }
            
        } catch (SQLException ex) {
            System.out.println("Error al seleccionar los dispositivos: " + ex.toString());
            Logger.getLogger(DispositivoEntradaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return dispositivos;
    }
}
