	
public class Usuario {
	
    private String nombre;
	private String login;
    private String password;
    
    
    public Usuario(String nombre, String login, String password) {
		
		this.nombre = nombre;
		this.login = login;
		this.password = password;
	}
    
    public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
    	
   