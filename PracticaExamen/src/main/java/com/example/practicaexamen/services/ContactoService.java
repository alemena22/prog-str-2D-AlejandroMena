package com.example.practicaexamen.services;

import com.example.practicaexamen.model.Contacto;

import java.util.ArrayList;
import java.util.List;

public class ContactoService {

    private List<Contacto> lista = new ArrayList<>();

    public String[] parentescos = {
            "Padre", "Madre", "Hermano", "Hermana", "Abuelo", "Abuela", "Tío", "Tía"
    };

    public List<Contacto> getAll() {
        return lista;
    }

    public void agregar(String nombre, String telefono, String parentesco) {

        validar(nombre, telefono, parentesco);

        for (Contacto cont : lista) {
            if (cont.getNombre().equalsIgnoreCase(nombre)) {
                throw new IllegalArgumentException("Ya existe un contacto con ese nombre");
            }
        }

        lista.add(new Contacto(nombre, telefono, parentesco));
    }

    public Contacto buscar(String nombre) {
        for (Contacto cont : lista) {
            if (cont.getNombre().equalsIgnoreCase(nombre)) {
                return cont;
            }
        }
        return null;
    }

    public void actualizar(String nombre, String telefono, String parentesco) {

        Contacto cont = buscar(nombre);

        if (cont == null) {
            throw new IllegalArgumentException("El contacto no fue encontrado");
        }

        validar(nombre, telefono, parentesco);

        cont.setTelefono(telefono);
        cont.setParentesco(parentesco);
    }

    public void eliminar(String nombre) {

        Contacto cont = buscar(nombre);

        if (cont == null) {
            throw new IllegalArgumentException("El contacto no fue encontrado");
        }

        lista.remove(cont);
    }

    private void validar(String nombre, String telefono, String parentesco) {

        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no debe estar vacio");
        }

        if (telefono == null || !telefono.matches("\\d{10}")) {
            throw new IllegalArgumentException("El teléfono debe contener 10 dígitos");
        }

        if (parentesco == null) {
            throw new IllegalArgumentException("Se debio seleccionar un parentesco");
        }
    }
}