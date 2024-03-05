package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    IPokemonMetadataProvider pokemonMetadataProvider;

    @BeforeEach
    public void setUp() throws Exception {
    pokemonMetadataProvider = mock(PokemonMetadataProvider.class);
    }

    @Test
    public void testRaisePokedexExceptionWhenNoRelatedPokemon() throws PokedexException {
        when(pokemonMetadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException(""));
        assertThrows(PokedexException.class, () -> {
            this.pokemonMetadataProvider.getPokemonMetadata(-1);
        });
    }

    @Test
    public void testCorrectDescriptionGivenForIndex0() throws PokedexException {
        when(this.pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(
                new PokemonMetadata(0, "Bulbizarre", 126, 126, 90)
        );
        PokemonMetadata pokemonMetadata = this.pokemonMetadataProvider.getPokemonMetadata(0);
        assertNotNull(pokemonMetadata);
        assertEquals(126, pokemonMetadata.getAttack());
        assertEquals(126, pokemonMetadata.getDefense());
        assertEquals(90, pokemonMetadata.getStamina());
        assertEquals("Bulbizarre", pokemonMetadata.getName());
    }

    @Test
    public void testCorrectDescriptionGivenForIndex133() throws PokedexException {
        when(this.pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(
                new PokemonMetadata(133, "Aquali", 186, 168, 260)
        );
        PokemonMetadata pokemonMetadata = this.pokemonMetadataProvider.getPokemonMetadata(0);
        assertNotNull(pokemonMetadata);
        assertEquals(186, pokemonMetadata.getAttack());
        assertEquals(168, pokemonMetadata.getDefense());
        assertEquals(260, pokemonMetadata.getStamina());
        assertEquals("Aquali", pokemonMetadata.getName());
    }
}