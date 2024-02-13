package fr.univavignon.pokedex.api;

import junit.framework.TestCase;

public class IPokemonFactoryTest extends TestCase {
    IPokemonFactory pokemonFactory;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        pokemonFactory = new PokemonFactory();
    }

    public void testPokemonNullWhenCombatLvlNegative() {
        assertNull(this.pokemonFactory.createPokemon(0, -1, 0, 0, 0));
    }

    public void testPokemonNullWhenDustNegative() {
        assertNull(this.pokemonFactory.createPokemon(0, 0, 0, -1, 0));
    }

    public void testPokemonNullWhenHealthPointsNegative() {
        assertNull(this.pokemonFactory.createPokemon(0, 0, -1, 0, 0));
    }

    public void testPokemonNullWhenCandiesAmountNegative() {
        assertNull(this.pokemonFactory.createPokemon(0, 0, 0, 0, -1));
    }

    public void testPokemonNullWhenIndexNegative() {
        assertNull(this.pokemonFactory.createPokemon(-1, 0, 0, 0, 0));
    }

    public void testPokemonNullWhenIndexGreaterThan150() {
        assertNull(this.pokemonFactory.createPokemon(151, 0, 0, 0, 0));
    }

    public void testPokemonCorrectlyCreated() {
        int index = 0;
        int cp = 50;
        int hp = 50;
        int dust = 80;
        int candy = 3;
        Pokemon pokemon = this.pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        assertEquals(index, pokemon.getIndex());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
    }
}