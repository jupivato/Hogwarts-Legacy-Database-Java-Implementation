package teste;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Spell 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String description;
	private float difficultyLevel;
	private float energyCost;
	
	// get set
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	public float getDifficultyLevel() {return difficultyLevel;}
	public void setDifficultyLevel(float difficultyLevel) {this.difficultyLevel = difficultyLevel;}
	public float getEnergyCost() {return energyCost;}
	public void setEnergyCost(float energyCost) {this.energyCost = energyCost;}
}
