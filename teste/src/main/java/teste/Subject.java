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
public class Subject 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private float difficultyLevel;
	private int experienceReward;
	
	// get set
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public float getDifficultyLevel() {return difficultyLevel;}
	public void setDifficultyLevel(float difficultyLevel) {this.difficultyLevel = difficultyLevel;}
	public int getExperienceReward() {return experienceReward;}
	public void setExperienceReward(int experienceReward) {this.experienceReward = experienceReward;}
}
