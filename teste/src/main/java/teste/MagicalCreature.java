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
public class MagicalCreature
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String magicalCreatureType;
	private String maagicalFeatures;
	@OneToOne
	private Place place;
	
	public MagicalCreature(){}
	
	// get set
	public String getMagicalCreatureType() {return magicalCreatureType;}
	public void setMagicalCreatureType(String magicalCreatureType) {this.magicalCreatureType = magicalCreatureType;}
	public String getMaagicalFeatures() {return maagicalFeatures;}
	public void setMaagicalFeatures(String maagicalFeatures) {this.maagicalFeatures = maagicalFeatures;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public Place getPlace() {return place;}
	public void setPlace(Place place) {this.place = place;}
}
