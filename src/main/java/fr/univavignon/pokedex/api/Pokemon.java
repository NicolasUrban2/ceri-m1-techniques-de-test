package fr.univavignon.pokedex.api;

/**
 * Pokemon POJO.
 * 
 * @author fv
 */
/**
 * Represents a Pokemon with its attributes and behavior.
 */
public final class Pokemon extends PokemonMetadata {

	/** Combat Point of the pokemon. **/
	private final int cp;

	/** HP of the pokemon. **/
	private final int hp;

	/** Required dust for upgrading this pokemon. **/
	private final int dust;

	/** Required candy for upgrading this pokemon. **/
	private final int candy;

	/** IV perfection percentage. **/
	private final double iv;

	/**
	 * Default constructor.
	 *
	 * @param index   Pokemon index.
	 * @param name    Pokemon name.
	 * @param attack  Attack level.
	 * @param defense Defense level.
	 * @param stamina Stamina level.
	 * @param cp      Pokemon cp.
	 * @param hp      Pokemon hp.
	 * @param dust    Required dust for upgrading this pokemon.
	 * @param candy   Required candy for upgrading this pokemon.
	 * @param iv      IV perfection percentage.
	 */
	public Pokemon(
			final int index,
			final String name,
			final int attack,
			final int defense,
			final int stamina,
			final int cp,
			final int hp,
			final int dust,
			final int candy,
			final double iv) {
		super(index, name, attack, defense, stamina);
		this.cp = cp;
		this.hp = hp;
		this.dust = dust;
		this.candy = candy;
		this.iv = iv;
	}

	/**
	 * Retrieves the Combat Point (CP) of the Pokemon.
	 *
	 * @return The Combat Point (CP) of the Pokemon.
	 */
	public int getCp() {
		return cp;
	}

	/**
	 * Retrieves the Hit Points (HP) of the Pokemon.
	 *
	 * @return The Hit Points (HP) of the Pokemon.
	 */
	public int getHp() {
		return hp;
	}

	/**
	 * Retrieves the required dust for upgrading this Pokemon.
	 *
	 * @return The required dust for upgrading this Pokemon.
	 */
	public int getDust() {
		return dust;
	}

	/**
	 * Retrieves the required candy for upgrading this Pokemon.
	 *
	 * @return The required candy for upgrading this Pokemon.
	 */
	public int getCandy() {
		return candy;
	}

	/**
	 * Retrieves the IV (Individual Value) perfection percentage of the Pokemon.
	 *
	 * @return The IV (Individual Value) perfection percentage of the Pokemon.
	 */
	public double getIv() {
		return iv;
	}

	/**
	 * Checks if this Pokemon is equal to another object.
	 *
	 * @param o The object to compare.
	 * @return True if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Pokemon pokemon = (Pokemon) o;

		if (cp != pokemon.cp) return false;
		if (hp != pokemon.hp) return false;
		if (dust != pokemon.dust) return false;
		if (candy != pokemon.candy) return false;
		return Double.compare(pokemon.iv, iv) == 0;
	}
}
