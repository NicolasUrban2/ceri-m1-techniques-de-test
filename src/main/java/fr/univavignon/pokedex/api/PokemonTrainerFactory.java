package fr.univavignon.pokedex.api;

public class PokemonTrainerFactory implements IPokemonTrainerFactory{
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    /**
     * Set the metadata provider
     * @param metadataProvider
     */
    public void setMetadataProvider(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

    /**
     * Set the pokemon factory
     * @param pokemonFactory
     */
    public void setPokemonFactory(IPokemonFactory pokemonFactory) {
        this.pokemonFactory = pokemonFactory;
    }

    /**
     * Create a new pokemon trainer instance.
     * @param name Name of the created trainer.
     * @param team Team of the created trainer.
     * @param pokedexFactory Factory to use for creating associated pokedex instance.
     * @return Created pokemon trainer instance.
     */
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        return new PokemonTrainer(name, team, pokedexFactory.createPokedex(this.metadataProvider, this.pokemonFactory));
    }
}
