package teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Player
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private int level;
	private int experience;
	private int energy;
	@ManyToOne
	private House house;
	@ManyToMany
	private List<Subject>subjects = new ArrayList<>();
	@OneToOne
	private Broomstick broomstick;
	@OneToOne
	private Wand wand;
	@OneToOne
	private Cauldron cauldron;
	@OneToMany
	private List<Spell> spells = new ArrayList<>();
	@ManyToMany
	private List<Mission> misssions = new ArrayList<>();
	@OneToMany
	private List<MagicalItem> magicalItem = new ArrayList<>();
	// get set
	public int getLevel() {return level;}
	public void setLevel(int level) {this.level = level;}
	public int getExperience() {return experience;}
	public void setExperience(int experience) {this.experience = experience;}
	public int getEnergy() {return energy;}
	public void setEnergy(int energy) {this.energy = energy;}
	public House getHouse() {return house;}
	public void setHouse(House house) {this.house = house;}
	public List<Subject> getSubjects() {return subjects;}
	public void setSubjects(List<Subject> subjects) {this.subjects = subjects;}
	public Broomstick getBroomstick() {return broomstick;}
	public void setBroomstick(Broomstick broomstick) {this.broomstick = broomstick;}
	public Wand getWand() {return wand;}
	public void setWand(Wand wand) {this.wand = wand;}
	public Cauldron getCauldron() {return cauldron;}
	public void setCauldron(Cauldron cauldron) {this.cauldron = cauldron;}
	public List<Spell> getSpells() {return spells;}
	public void setSpells(List<Spell> spells) {this.spells = spells;}
	public List<Mission> getMisssions() {return misssions;}
	public void setMisssions(List<Mission> misssions) {this.misssions = misssions;}
	public List<MagicalItem> getMagicalItem() {return magicalItem;}
	public void setMagicalItem(List<MagicalItem> magicalItem) {this.magicalItem = magicalItem;}
    public String getName() {return name;}
	public void setName(String name) {this.name = name;}
}

