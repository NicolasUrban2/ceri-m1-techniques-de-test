package fr.univavignon.pokedex.api;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class IPokedexTest extends TestCase {
    private IPokedex pokedex;
    private Pokemon pokemon;
    @Before
    public void setUp() {
        pokedex = new Pokedex();
        pokemon = new Pokemon(0, "Bulbizarre", 126, 127, 90, 613, 64, 4000, 4, 56);
    }

    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());
        pokedex.addPokemon(pokemon);
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testAddPokemonIndex() {
        int index = pokedex.addPokemon(pokemon);
        assertEquals(0, index);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        int index = pokedex.addPokemon(pokemon);
        Pokemon retrievedPokemon = pokedex.getPokemon(index);
        assertEquals(pokemon, retrievedPokemon);
    }

    @Test(expected = PokedexException.class)
    public void testGetPokemonThrowsException() throws PokedexException {
        pokedex.getPokemon(100);
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pokemon);
        pokedex.addPokemon(pokemon);
        assertEquals(pokemonList, pokedex.getPokemons());
    }

    @Test
    public void testGetPokemonsWithComparator() {
        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pokemon);
        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getName);
        pokedex.addPokemon(pokemon);
        assertEquals(pokemonList, pokedex.getPokemons(comparator));
    }
}