package projeto.matriculeme.REST;
public class Mencao{
	private int id; 
	private String codigo;

	public Mencao() 
	{
		this.codigo = new String();
	}
	public int getId() 
	{
		return id;
	}
	public String getCodigo()
	{
		return codigo;
	}
	public void setCodigo(String codigo) 
	{
		this.codigo = codigo;
	}
}
