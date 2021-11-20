package modelo;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class consultas extends modelo.connection{
	boolean estado1;
	int pagina;
	int cantidad;
	//Metodo para consultar los productos de la categoria de baloncesto
	public producto[] getcatalogo(int categoria) {
		producto[] catalogo;
		
		catalogo=new producto[15];
		PreparedStatement pst =null;
		ResultSet rs = null;;
		int contador=0;
		try {
			String sql ="select * from recuperacion.producto where categoria =?";
			
			pst =getConexion().prepareCall(sql);
			pst.setInt(1, categoria);
			rs= pst.executeQuery();
		
			while(rs.next()) {
				catalogo[contador]=new producto(rs.getString("nombre"),rs.getString("marca"),rs.getInt("categoria"),rs.getDouble("precio"),rs.getInt("id"));
				contador++;
			} 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error al cargar");
		}finally {
			try {
				if (rs != null )rs.close();
				if (pst != null)pst.close();
				if (getConexion() != null) getConexion().close();
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return catalogo;
	
	}
	//Metodo para registrarse
	public boolean registro(String correo,String pass,String name,String apel,String loca, int codigopost,String country, String street, String est,int code) {
		 
		 boolean regi=false;
		
		 PreparedStatement pst=null;
		 int id=(int)(10000 + Math.random() * 90000);
		 String retorno = null;
	        try {
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            digest.reset();
	            digest.update(pass.getBytes("utf8"));
	            retorno = String.format("%064x", new BigInteger(1, digest.digest()));
	        }catch(Exception ex) {
	            ex.printStackTrace();
	        }
		 
	        String sql= "insert into recuperacion.cliente values ('"+name+"', '"+apel+"', '"+correo+"', '"+id+"', '"+retorno+"', '"+est+"','"+loca
				 +"','"+codigopost+"','"+country+"','"+street+"','"+code+"')";
		 
		 try {
			pst=getConexion().prepareStatement(sql);
			pst.executeUpdate();
			regi=true;
			if(regi==true)
			System.out.println("si entra");
			
			pst.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return regi; 
	 }
		//Metodo para validar en caso de que no se haya validad
	public void validar(String codigito) {
		int code=Integer.parseInt(codigito);
		ResultSet rst=null;
		
		 PreparedStatement ps=null;
		 PreparedStatement pst=null;
		 String sql=("select cov from recuperacion.cliente where cov="+code);
		 try {
			ps=getConexion().prepareCall(sql);
			rst=ps.executeQuery();
			rst.next();
			if(code==rst.getInt("cov")) {
				ps.close();
				rst.close();
				String sql2=("update recuperacion.cliente set verificado='s'");
				pst=getConexion().prepareCall(sql2);
				pst.executeUpdate();
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			
		
	}
	public boolean consultar(String correo, String contra) {
		 boolean esta=false;
		 String nom = null;
		 
		 ResultSet rst=null;
		 PreparedStatement ps=null;
		 String sql="select * from blossomb.user";
		 try {
			ps=getConexion().prepareCall(sql);
			rst=ps.executeQuery();
			
			
			while(rst.next()){
				String u=rst.getString("email");
				String c=rst.getString("pass");
				String v=rst.getString("verify");
				nom=rst.getString("name");
				String retorno = null;
		        try {
		            MessageDigest digest = MessageDigest.getInstance("SHA-256");
		            digest.reset();
		            digest.update(contra.getBytes("utf8"));
		            retorno = String.format("%064x", new BigInteger(1, digest.digest()));
		        }catch(Exception ex) {
		            ex.printStackTrace();
		        }
				
				
				if(correo.matches(u) && c.matches(retorno)) {
					if(v.matches("s")) {
						esta=true;
						System.out.println(nom);
					}
				}
				else {
					System.out.println(retorno);
					System.out.println("Error");
				}
			};
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return esta;
		
	 }
	public cliente consultarnombre(String correo, String contra) {
			cliente c = null;
			
		 
		 ResultSet rst=null;
		 PreparedStatement ps=null;
		 String retorno = null;
	        try {
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            digest.reset();
	            digest.update(contra.getBytes("utf8"));
	            retorno = String.format("%064x", new BigInteger(1, digest.digest()));
	        }catch(Exception ex) {
	            ex.printStackTrace();
	        }
		 String sql="select * from blossomb.user where email = ? and pass = ?";
		 try {
			ps=getConexion().prepareCall(sql);
			ps.setString(1, correo);
			ps.setString(2, retorno);
			rst=ps.executeQuery();
			
			
			while(rst.next()){
				String u=rst.getString("email");
				String co=rst.getString("pass");
				String ape=rst.getString("surname");
				String id=rst.getString("cod_user");
				String nom=rst.getString("name");
				c = new cliente(nom,ape,u,co,id);
			};
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
		
	 }
	 public byte[] cargarImagenProducto(int pidereferencia) {
		 byte[] src;
		 ResultSet srcProducto;
		 PreparedStatement ps =null;
		 
	        src = null;
	        srcProducto = null;
	        try {
	            
	            ps = getConexion().prepareCall("SELECT imagen FROM recuperacion.producto WHERE id = ?");
	            ps.setInt(1, pidereferencia);
	            srcProducto = ps.executeQuery();
	            srcProducto.next();
	            src = srcProducto.getBytes(1);
	            
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
	        return src;
	    }
	 public producto[] listarporID(int ID) {
			
			PreparedStatement pst=null;
			ResultSet rs= null;
			producto[] pro=new producto[1];
			int contador=0;
			
			try {
				
				pst=getConexion().prepareCall("select * from recuperacion.producto where id=?");
				pst.setInt(1, ID);
				rs=pst.executeQuery();
				
				
				rs.next();
				pro[contador]=new producto(rs.getString("nombre"),rs.getString("marca"),rs.getInt("categoria"),rs.getDouble("precio"),rs.getInt("id"));
					
				pst.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return pro;
		}
	 public producto consultarID(int ID) {
			
			PreparedStatement pst=null;
			ResultSet rs= null;
			producto pro=null;
			
			try {
				
				pst=getConexion().prepareCall("select * from recuperacion.producto where id=?");
				pst.setInt(1, ID);
				rs=pst.executeQuery();
				
				rs.next();
				pro=new producto(rs.getString("nombre"),rs.getString("marca"),rs.getInt("categoria"),rs.getDouble("precio"),rs.getInt("id"));
					
				pst.close();
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return pro;
		}
	 public producto[] getcatalogopag(int categoria,int offset) {
			PreparedStatement pst=null;
			ResultSet rs= null;
			pagina=0;
			producto[] catalogo;
			int contador=0;
			
			
			catalogo=new producto[5];
		 try {
			 pagina=offset*5;
			pst=pst=getConexion().prepareCall("select * from recuperacion.producto where categoria =? offset ? limit 5");
			pst.setInt(1, categoria);
			pst.setInt(2,pagina);
			rs=pst.executeQuery();
			while(rs.next()) {
				catalogo[contador]=new producto(rs.getString("nombre"),rs.getString("marca"),rs.getInt("categoria"),rs.getDouble("precio"),rs.getInt("id"));
				contador++;
			} 
				
			pst.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return catalogo;
		 
	 }
	 public int cantidadpro(int categoria) {
		 PreparedStatement pst=null;
		ResultSet rs= null;
		cantidad=0;
		try {
			pst=getConexion().prepareCall("select count(id) from recuperacion.producto where categoria =?");
			pst.setInt(1, categoria);
			
			
			rs=pst.executeQuery();
			rs.next();
			pst.close();
			cantidad=rs.getInt(1);
		} catch (Exception e) {
			System.out.println("aqui");
		}
		return cantidad;
		 
	 }
	 public byte[] cargarImagencliente(String correo){
		 byte[] src;
		 ResultSet srcProducto;
		 PreparedStatement ps =null;
		 
	        src = null;
	        srcProducto = null;
	        try {
	            
	            ps = getConexion().prepareCall("SELECT imagen FROM recuperacion.cliente WHERE email = ?");
	            ps.setString(1, correo);
	            srcProducto = ps.executeQuery();
	            srcProducto.next();
	            src = srcProducto.getBytes(1);
	            
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
	        return src;
	    }

}
