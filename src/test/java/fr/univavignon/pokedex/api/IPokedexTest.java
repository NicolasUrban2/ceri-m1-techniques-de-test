package fr.univavignon.pokedex.api;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.mock;

public class IPokedexTest {
    private IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);
    private IPokemonFactory pokemonFactory = mock(IPokemonFactory.class);
    private IPokedex pokedex = new Pokedex(metadataProvider, pokemonFactory);
    private Pokemon pokemon = new Pokemon(0, "Bulbizarre", 126, 127, 90, 613, 64, 4000, 4, 56);

    @BeforeEach
    public void setUp() {
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
        pokemon = new Pokemon(0, "Bulbizarre", 126, 127, 90, 613, 64, 4000, 4, 56);
    }

    @Test
    public void testSize() {
        pokedex = new Pokedex(metadataProvider, pokemonFactory);
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

    @Test
    public void testGetPokemonThrowsException() throws PokedexException {
        assertThrows(PokedexException.class, () -> {
                pokedex.getPokemon(100);
        });
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
        Pokemon farfuret = new Pokemon(156, "Farfuret", 1000, 1000, 9999, 50, 50, 50, 50, 100);

        List<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pokemon);
        pokemonList.add(farfuret);

        pokemonList.sort(PokemonComparators.CP);

        pokedex.addPokemon(pokemon);
        pokedex.addPokemon(farfuret);
        assertEquals(pokemonList, pokedex.getPokemons(PokemonComparators.CP));
    }
}