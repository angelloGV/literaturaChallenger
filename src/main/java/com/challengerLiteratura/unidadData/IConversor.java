package com.challengerLiteratura.unidadData;

public interface IConversor {
    <T> T obtenerDatos(String json, Class<T> clase);
}
