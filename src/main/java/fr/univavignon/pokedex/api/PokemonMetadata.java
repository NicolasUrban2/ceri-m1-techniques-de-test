package fr.univavignon.pokedex.api;

/**
 * Pokemon metadata POJO.
 * 
 * @author fv
 */
/**
 * Represents the metadata of a Pokemon.
 */
/**
 * Represents the metadata of a Pokemon.
 */
public class PokemonMetadata {

	/** Pokemon index. **/
	private final int index;

	/** Pokemon name. **/
	private final String name;

	/** Pokemon attack level. **/
	private final int attack;

	/** Pokemon defense level. **/
	private final int defense;

	/** Pokemon stamina level. **/
	private final int stamina;

	/**
	 * Default constructor.
	 * 
	 * @param index Pokemon index.
	 * @param name Pokemon name.
	 * @param attack Attack level.
	 * @param defense Defense level.
	 * @param stamina Stamina level.
	 */
	public PokemonMetadata(final int index, final String name, final int attack, final int defense, final int stamina) {
		this.index = index;
		this.name = name;
		this.attack = attack;
		this.defense = defense;
		this.stamina = stamina;
	}
	
	/**
	 * Retrieves the index of the Pokemon.
	 * 
	 * @return The index of the Pokemon.
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * Retrieves the name of the Pokemon.
	 * 
	 * @return The name of the Pokemon.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retrieves the attack level of the Pokemon.
	 * 
	 * @return The attack level of the Pokemon.
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * Retrieves the defense level of the Pokemon.
	 * 
	 * @return The defense level of the Pokemon.
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * Retrieves the stamina level of the Pokemon.
	 * 
	 * @return The stamina level of the Pokemon.
	 */
	public int getStamina() {
		return stamina;
	}

}
