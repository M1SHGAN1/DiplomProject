package com.junit;

import api.Data.PetDataGeneration;
import api.Models.PetsData;
import api.PetsSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Проверка удаления питомца")
public class DeletePet {

    private final PetsSteps petsSteps = new PetsSteps();
    private final PetsData dataOfPet = PetDataGeneration.generateDataPet("sold");

    @Test
    @Owner("Mihail Petrov")
    @DisplayName("Удаление существующего питомца")
    @Description("Удаление существующего питомца с использованием метода DELETE. Проверка тела ответа")
    public void deleteExistedPet() {
        // Создание нового питомца
        petsSteps.createNewPet(dataOfPet);

        // Удаление питомца по его идентификатору и получение ответа
        Response res = petsSteps.deletePetById(dataOfPet.getId(), 200);

        // Проверка, что в ответе содержится ошибка "unknown" и идентификатор удаленного питомца
        petsSteps.assertBadRequestBody(res, "unknown", dataOfPet.getId().toString());
    }
}