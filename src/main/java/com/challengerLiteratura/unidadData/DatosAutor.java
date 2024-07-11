package com.challengerLiteratura.unidadData;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record DatosAutor(
        @JsonAlias("name") String autor,
        @JsonAlias("birth_year") Integer axoNacimiento ,
        @JsonAlias("death_year") Integer axoFallecimiento )
{
}
