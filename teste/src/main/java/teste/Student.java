package teste;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Student
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private int year;
	@OneToOne
	private House house;
	
	// get set
    public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getYear() {return year;}
	public void setYear(int year) {this.year = year;}
	public House getHouse() {return house;}
	public void setHouse(House house) {this.house = house;}
}