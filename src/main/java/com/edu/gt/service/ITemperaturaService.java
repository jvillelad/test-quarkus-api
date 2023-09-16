package com.edu.gt.service;

import com.edu.gt.dto.Temperatura;
import java.util.List;

public interface ITemperaturaService {

    List <Temperatura> obtenerTemperaturas();

    void addTemperatura(Temperatura t);

    boolean isEmpty();

    int maxima();

    void eliminarTodasLasTemperaturas();

}
