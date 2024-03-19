package fr.univavignon.pokedex.api;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{

    /**
     * Retrieve the metadata for the pokemon denoted by the given index.
     * @param index Index of the pokemon to retrieve metadata for.
     * @return Metadata of the pokemon denoted by the given index.
     * @throws PokedexException
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        switch (index) {
            case 0:
                return new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
            case 133:
                return new PokemonMetadata(133, "Aquali", 186, 168, 260);
            default:
               throw new PokedexException("No related pokemon metadata found");
        }
    }
}
