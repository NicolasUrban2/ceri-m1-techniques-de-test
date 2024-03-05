package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {
    IPokemonFactory pokemonFactory;
    @BeforeEach
    public void setUp() throws Exception {
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testPokemonNullWhenCombatLvlNegative() {
        when(pokemonFactory.createPokemon(0, -1, 0, 0, 0)).thenReturn(null);
        assertNull(this.pokemonFactory.createPokemon(0, -1, 0, 0, 0));
    }

    @Test
    public void testPokemonNullWhenDustNegative() {
        when(pokemonFactory.createPokemon(0, 0, 0, -1, 0)).thenReturn(null);
        assertNull(this.pokemonFactory.createPokemon(0, 0, 0, -1, 0));
    }

    @Test
    public void testPokemonNullWhenHealthPointsNegative() {
        when(pokemonFactory.createPokemon(0, 0, -1, 0, 0)).thenReturn(null);
        assertNull(this.pokemonFactory.createPokemon(0, 0, -1, 0, 0));
    }

    @Test
    public void testPokemonNullWhenCandiesAmountNegative() {
        when(pokemonFactory.createPokemon(0, 0, 0, 0, -1)).thenReturn(null);
        assertNull(this.pokemonFactory.createPokemon(0, 0, 0, 0, -1));
    }

    @Test
    public void testPokemonNullWhenIndexNegative() {

        assertNull(this.pokemonFactory.createPokemon(-1, 0, 0, 0, 0));
    }

    @Test
    public void testPokemonNullWhenIndexGreaterThan150() {
        when(pokemonFactory.createPokemon(151, 0, 0, 0, 0)).thenReturn(null);
        assertNull(this.pokemonFactory.createPokemon(151, 0, 0, 0, 0));
    }

    @Test
    public void testPokemonCorrectlyCreated() {
        int index = 0;
        int cp = 50;
        int hp = 50;
        int dust = 80;
        int candy = 3;
        when(pokemonFactory.createPokemon(index, cp, hp, dust, candy)).thenReturn(
                new Pokemon(index, "", 1, 1, 1, cp, hp, dust, candy, 5)
        );
        Pokemon pokemon = this.pokemonFactory.createPokemon(index, cp, hp, dust, candy);
        assertEquals(index, pokemon.getIndex());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());
    }
}