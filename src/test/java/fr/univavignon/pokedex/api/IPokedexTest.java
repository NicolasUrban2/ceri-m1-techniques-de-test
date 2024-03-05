package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexTest {
    private IPokedex pokedex;
    private Pokemon pokemon;

    @BeforeEach
    public void setUp() {
        pokedex = mock(IPokedex.class);
        pokemon = new Pokemon(0, "Bulbizarre", 126, 127, 90, 613, 64, 4000, 4, 56);
    }

    @Test
    public void testSize() {
        when(pokedex.size()).thenReturn(0);
        assertEquals(0, pokedex.size());
        pokedex.addPokemon(pokemon);
        when(pokedex.size()).thenReturn(1);
        assertEquals(1, pokedex.size());
    }

    @Test
    public void testAddPokemonIndex() {
        when(pokedex.addPokemon(pokemon)).thenReturn(0);
        int index = pokedex.addPokemon(pokemon);
        assertEquals(0, index);
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        when(pokedex.addPokemon(pokemon)).thenReturn(0);
        int index = pokedex.addPokemon(pokemon);
        when(pokedex.getPokemon(index)).thenReturn(pokemon);
        Pokemon retrievedPokemon = pokedex.getPokemon(index);
        assertEquals(pokemon, retrievedPokemon);
    }

    public void testGetPokemonThrowsException() throws PokedexException {
        when(pokedex.getPokemon(100)).thenThrow(new PokedexException("Out of bound index"));

        assertThrows(PokedexException.class, () -> {
                pokedex.getPokemon(100);
        });
    }

    @Test
    public void testGetPokemons() {
        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pokemon);
        when(pokedex.addPokemon(pokemon)).thenReturn(0);
        pokedex.addPokemon(pokemon);
        when(pokedex.getPokemons()).thenReturn(pokemonList);
        assertEquals(pokemonList, pokedex.getPokemons());
    }

    @Test
    public void testGetPokemonsWithComparator() {
        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pokemon);
        Comparator<Pokemon> comparator = Comparator.comparing(Pokemon::getName);
        when(pokedex.addPokemon(pokemon)).thenReturn(0);
        pokedex.addPokemon(pokemon);
        when(pokedex.getPokemons(comparator)).thenReturn(pokemonList);
        assertEquals(pokemonList, pokedex.getPokemons(comparator));
    }
}