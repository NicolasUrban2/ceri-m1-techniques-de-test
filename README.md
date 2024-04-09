# UCE Génie Logiciel Avancé : Techniques de tests
### Nicolas Urban
### M1 ILSEN ALT G1

## Explications

### Pokedex
Contient un objet IPokemonMetadataProvider et IPokemonFactory. Pour la méthode createPokemon(), on commence par créer un pokémon incomplet (car PokemonFactory n'a pas accès aux metadata du pokémon) puis on le complète avec les métadata du metadataProvider.

## Code coverage

[![codecov](https://codecov.io/gh/NicolasUrban2/ceri-m1-techniques-de-test/graph/badge.svg?token=I5P2JUE70H)](https://codecov.io/gh/NicolasUrban2/ceri-m1-techniques-de-test)

## CircleCi

[![NicolasUrban2](https://circleci.com/gh/NicolasUrban2/ceri-m1-techniques-de-test.svg?style=svg)](https://app.circleci.com/pipelines/github/NicolasUrban2)

## Checkstyle
[![Checkstyle](/target/site/badges/checkstyle-result.svg)](/target/checkstyle-result.xml)

## Documentation
[Javadoc](https://nicolasurban2.github.io/ceri-m1-techniques-de-test/)

## Code review

[RocketPokemonFactory](Revue_RocketPokemonFactory_URBAN_Nicolas.pdf)
