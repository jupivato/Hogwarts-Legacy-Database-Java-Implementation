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
public class Mission 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String title;
	private String description;
	private int experienceReward;
	private int energyReward;
	private int accomplished;
	
	// get set
	public String getTitle() {return title;}
	public void setTitle(String title) {this.title = title;}
	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}
	public int getExperienceReward() {return experienceReward;}
	public void setExperienceReward(int experienceReward) {this.experienceReward = experienceReward;}
	public int getEnergyReward() {return energyReward;}
	public void setEnergyReward(int energyReward) {this.energyReward = energyReward;}
	public int getAccomplished() {return accomplished;}
	public void setAccomplished(int accomplished) {this.accomplished = accomplished;}
}