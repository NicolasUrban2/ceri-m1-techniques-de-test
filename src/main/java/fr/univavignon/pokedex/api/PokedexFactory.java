package fr.univavignon.pokedex.api;

public class PokedexFactory implements IPokedexFactory{

    /**
     * Create a new pokedex instance using the given metadata provider and pokemon factory.
     * @param metadataProvider Metadata provider the created pokedex will use.
     * @param pokemonFactory Pokemon factory the created pokedex will use.
     * @return
     */
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory) {
        return new Pokedex(metadataProvider, pokemonFactory);
    }
}
