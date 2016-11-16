package modules;

import javax.persistence.*;

@Entity
@Table(name = "disciplina")
public class Disciplina {
	@Id
	@GeneratedValue
	private int id;//Chave prim�ria da tabela Disciplinas
	
	@Column
	private String nome;//Nome da disciplina
	
	@OneToMany
	@JoinTable(name = "departamento_disciplina")
	private Departamento departamento;//'FK' refer�ncia ao Departamento que oferta a disciplina
	
	@Column
	private int credito;//Quantidade de cr�ditos da disciplina
	
	@Column
	private int codigo;
	
	@OneToMany
	@JoinTable(name = "requisito_disciplina")
	private Requisito requisitoDisciplina;
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
		
	public void setCredito(int credito){
		this.credito = credito;
	}
	
	public int getCredito(){
		return credito;
	}
	
	public void setDepartamento(Departamento departamento){
		this.departamento = departamento;
	}
	
	public Departamento getDepartamento(){
		return departamento;
	}	
	
	public void setCodigo(int codigo){
		this.codigo = codigo;
	}
	
	public int getcodigo(){
		return codigo;
	}
	
	public void setRequisitoDisciplina(Requisito requisitoDisciplina){
		this.requisitoDisciplina = requisitoDisciplina;
	}
	
	public Requisito getRequisitoDisciplina(){
		return requisitoDisciplina;
	}
}
