package com.edu.gt.service.impl;

import com.edu.gt.dto.Temperatura;
import com.edu.gt.service.ITemperaturaService;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ApplicationScoped

public class TemperaturaService implements ITemperaturaService {

    private List <Temperatura> valores = new ArrayList<>();

    @Override
    public List<Temperatura> obtenerTemperaturas() {
        return Collections.unmodifiableList(valores);
    }

    @Override
    public void addTemperatura(Temperatura t) {
        valores.add(t);
        System.out.println(t + "save");

    }

    @Override
    public boolean isEmpty() {
        return valores.isEmpty();
    }

    @Override
    public int maxima() {
        return valores.stream().mapToInt(Temperatura::getMaxima).max().getAsInt();
    }

    @Override
    public void eliminarTodasLasTemperaturas() {
        valores.clear();
    }
}
