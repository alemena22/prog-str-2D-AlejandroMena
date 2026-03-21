package com.example.demolistview.services;

import com.example.demolistview.repositories.PersonFileRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private PersonFileRepository repo = new PersonFileRepository();

    public List<String> loadDataforList() throws IOException {

        List<String> lines = repo.readAllLines();
        List<String> result = new ArrayList<>();
        for(String line : lines){
            if(line == null || line.isBlank()) continue;

            String[] parts = line.split(",", -1);
            String name = parts[0].trim();
            String correo = parts[1].trim();
            String edad = parts[2].trim();

            result.add(name + "-" + correo+"-"+edad);
        }
        return result;

    }
    public void addPerson(String name, String email, String age) throws IOException {
        if (age == null || !age.matches("\\d+")) {
            throw new IllegalArgumentException("La edad debe ser un número válido");
        }

        int ageInt = Integer.parseInt(age);

        validatePerson(name, email, ageInt);

        String nameNoComa = name.replace(",", "");
        String emailNoComa = email.replace(",", "");
        String ageNoComa = age.replace(",", "");

        repo.appendNewLine(nameNoComa + "," + emailNoComa + "," + ageNoComa);

    }
    public void updatePerson(int index, String name, String email, String edad) throws IOException {
        List<String> lines = getAllCleanLines();
        if(index == -1){
            throw new IllegalArgumentException("El indice recibido es invalido");
        }
        lines.set(index, name + "," + email + "," + edad);
        repo.appendAllLine(lines);

    }
    public void deletePerson(int index) throws IOException {
        List<String> lines = getAllCleanLines();
        lines.remove(index);
        repo.appendAllLine(lines);

    }
    private List<String> getAllCleanLines() throws IOException {
        List<String> lines = repo.readAllLines();
        List<String> cleanLines = new ArrayList<>();
        for(String line : lines){
            if(line != null && !line.isBlank()){
                cleanLines.add(line);

            }

        }
        return cleanLines;
    }


    private void validatePerson(String name, String email, int age){
        if(name == null || name.isBlank() || name.length() < 3){
            throw new IllegalArgumentException("El nombre no cumple con los estandares");
        }
        String em = (email == null) ? "" : email.trim();
        if(em.isBlank() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El correo es incorrecto");

        }
        if(age < 18 || age > 120 ){
            throw new IllegalArgumentException("Debe ser mayor de edad o rango de edad invalido.");
        }

    }
}