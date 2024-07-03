package teste;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Team
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	@OneToOne
	private House house;
	@OneToMany
	private List<Student>students = new ArrayList<>();
	
	// gets e sets
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public House getHouse() {return house;}
	public void setHouse(House house) {this.house = house;}
	public List<Student> getStudents() {return students;}
	public void setStudents(List<Student> students) {this.students = students;}
}