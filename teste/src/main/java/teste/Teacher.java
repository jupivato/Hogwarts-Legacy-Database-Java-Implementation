package teste;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Teacher 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	@ManyToOne
	private House house;
	@OneToOne
	private Subject subject;
	
	// get set
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public House getHouse() {return house;}
	public void setHouse(House house) {this.house = house;}
	public Subject getSubject() {return subject;}
	public void setSubject(Subject subject) {this.subject = subject;}
}

