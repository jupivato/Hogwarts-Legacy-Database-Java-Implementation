package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App 
{
	public static void main (String[] args)
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("julia");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// creating broomstick
		
		Broomstick broomstick = new Broomstick();
		broomstick.setName("Nimbus 2001");
		broomstick.setWood("Wandlore");
		broomstick.setResistance(10);
		
		em.persist(broomstick);
		
		// creating cauldron
		
		Cauldron cauldron = new Cauldron();
		cauldron.setMetal("aluminium");
		cauldron.setSize(10);
		
		em.persist(cauldron);
		
		// creating enemy
		
		Enemy enemy = new Enemy();
		enemy.setName("Troll");
		enemy.setEnemyType("Troll");
		enemy.setAttackSkills(10);
		enemy.setAlive(1);
		
		em.persist(enemy);
		
		// creating house
		
		House house = new House();
		
		house.setName("Gryyffindor");
		house.setColor("Red");
		house.setSymbol("Lion");
		
		em.persist(house);
		
		// creating magical creature
		
		MagicalCreature magicalCreature = new MagicalCreature();
		
		magicalCreature.setName("Norbert");
		magicalCreature.setMagicalCreatureType("Dragon");
		magicalCreature.setMaagicalFeatures("Spits fire");
		
		em.persist(magicalCreature);
		
		// creating magical item
		
		MagicalItem magicalItem = new MagicalItem();
		magicalItem.setObject("Invisibility cloth");
		
		em.persist(magicalItem);
		
		
		// creating mission 
		
		Mission mission = new Mission();
		mission.setTitle("Troll in the dungeons");
		mission.setDescription("There is a troll in the dungeons, defeat it");
		mission.setExperienceReward(10);
		mission.setEnergyReward(10);
		mission.setAccomplished(0);
		
		em.persist(mission);
		
		// creating place
		
		Place place = new Place();
		place.setName("Hogwarts");
		
		em.persist(place);
		
		// creating spell
		
		Spell spell = new Spell();
		spell.setName("Wingardium Leviosa");
		spell.setDescription("Levitates things");
		spell.setDifficultyLevel(2);
		spell.setEnergyCost(5);
		
		em.persist(spell);
		
		// creating student
		
		Student student = new Student();
		student.setName("Justino Fletcher");
		student.setHouse(null);
		student.setYear(1);
		
		em.persist(student);
		
		// creating subject
		
		Subject subject = new Subject();
		subject.setName("Defense Against the Dark Arts");
		subject.setDifficultyLevel(10);
		subject.setExperienceReward(100);
		
		em.persist(subject);
		
		// creating teacher
		
		Teacher teacher = new Teacher();
		teacher.setName("Minerva McGonnagal");
		teacher.setHouse(house);
		teacher.setSubject(subject);
		
		em.persist(teacher);
		
		//creating team
		
		Team team = new Team();
		team.setName("Grifinoria");
		
		em.persist(team);
		
		// creating wand 
		
		Wand wand = new Wand();
		wand.setLength(10);
		
		em.persist(wand);
		
		// creating player
		
		Player player = new Player();
		player.setName("Hermione Granger");
		player.setExperience(0);
		player.setEnergy(100);
		player.setHouse(house);
		player.setSubjects(null);
		player.setWand(wand);
		player.setSpells(null);
		player.setCauldron(cauldron);
		player.setBroomstick(broomstick);
		player.setSpells(null);
		player.setMisssions(null);
		player.setMagicalItem(null);
		
		em.persist(player);
		
		// end
		
        em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
