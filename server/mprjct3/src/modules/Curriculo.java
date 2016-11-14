package modules;

import javax.persistence.*;
@Entity
@Table(name = "curriculo")
public class Curriculo {
	
	@Id
	@GeneratedValue
	private int id;//Chave prim�ria da Tabela Curriculo
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinTable(name = "disciplina_curriculo")
	private Disciplina disciplina;//'FK' Refer�ncia �s diciplinas no curriculo
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinTable(name = "curso_curriculo")
	private Curso curso;//'FK' Refer�ncia ao curso a o qual o curriculo pertence
	
	@Column(name = "semestre_disciplina")
	private int semestreDisciplina;
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return id;
	}
	
	public void setCurso(Curso curso){
		this.curso = curso;
	}
	
	public Curso getCurso(){
		return curso;
	}
	
	public void setDisciplina(Disciplina disciplina ){
		this.disciplina = disciplina;
	}
	
	public Disciplina getDisciplina(){
		return disciplina;
	}
	
	public void setSemestreDisciplina(int semestreDisciplina){
		this.semestreDisciplina = semestreDisciplina;
	}
	
	public int getSemestreDisciplina(){
		return semestreDisciplina;
	}
}