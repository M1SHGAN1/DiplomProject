package com.junit;

import api.Data.InvalidData;
import api.Data.PetDataGeneration;
import api.Models.PetsData;
import api.PetsSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Checking the creation of a new pet")
public class PostPets {

    private final PetsSteps petsSteps = new PetsSteps();
    private final PetsData dataOfPet = PetDataGeneration.generateDataPet("sold");

    @Test
    @Owner("Mihail Petrov")
    @DisplayName("Adding a new pet with valid data")
    @Description("Добавление нового питомца с валидными данными. Метод POST. Проверка тела ответа и поиск новой записи")
    public void postValidNewPet(){

        // Создание нового питомца
        PetsData body = petsSteps.createNewPet(dataOfPet);

        // Проверка тела ответа на соответствие ожидаемым данным
        petsSteps.assertPetBody(body, dataOfPet);

        // Получение питомца по его идентификатору и проверка тела ответа
        PetsData petById = petsSteps.getPetById(body.getId());
        petsSteps.assertPetBody(petById, dataOfPet);

    }
}