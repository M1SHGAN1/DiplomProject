package com.junit;

import api.PetsSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

@DisplayName("Проверка питомцев со статусами SOLD, PENDING, AVAILABLE")
public class PetByStatus {

    private final PetsSteps petsSteps = new PetsSteps();

    @Test
    @Owner("Mihail Petrov")
    @DisplayName("Получение всех питомцев со статусами SOLD, PENDING, AVAILABLE")
    @Description("Получение питомцев со статусами SOLD, PENDING, AVAILABLE с помощью метода GET. Проверка заголовков, статуса ответа и факта, что все записи имеют статусы SOLD, PENDING, AVAILABLE")
    public void getPetByStatusAll(){

        // Получение питомцев со статусами SOLD, PENDING, AVAILABLE
        List pets = petsSteps.getPetByStatus("sold,available,pending");

        // Получение списка статусов питомцев
        List <String> statuses = petsSteps.getStatuses(pets);

        // Проверка, что все питомцы имеют статусы SOLD, PENDING, AVAILABLE
        petsSteps.assertPetsStatus(statuses, Arrays.asList("available", "pending", "sold"));

        // Проверка, что несколько питомцев имеют статус "available"
        petsSteps.assertPetsSeveralStatus(statuses, "available");

        // Проверка, что несколько питомцев имеют статус "pending"
        petsSteps.assertPetsSeveralStatus(statuses, "pending");

        // Проверка, что несколько питомцев имеют статус "sold"
        petsSteps.assertPetsSeveralStatus(statuses, "sold");

    }

    @Test
    @Owner("Mihail Petrov")
    @DisplayName("Получение питомцев со статусом SOLD")
    @Description("Получение питомцев со статусом SOLD с помощью метода GET. Проверка заголовков, статуса ответа и факта, что все записи имеют статус SOLD")
    public void getPetByStatusSold(){

        // Получение питомцев со статусом SOLD
        List pets = petsSteps.getPetByStatus("sold");

        // Получение списка статусов питомцев
        List <String> statuses = petsSteps.getStatuses(pets);

        // Проверка, что все питомцы имеют статус SOLD
        petsSteps.assertPetsStatus(statuses, Arrays.asList("sold"));

    }

    @Test
    @Owner("Mihail Petrov")
    @DisplayName("Получение питомцев со статусом AVAILABLE")
    @Description("Получение питомцев со статусом AVAILABLE с помощью метода GET. Проверка заголовков, статуса ответа и факта, что все записи имеют статус AVAILABLE")
    public void getPetByStatusAvailable(){

        // Получение питомцев со статусом AVAILABLE
        List pets = petsSteps.getPetByStatus("available");

        // Получение списка статусов питомцев
        List <String> statuses = petsSteps.getStatuses(pets);

        // Проверка, что все питомцы имеют статус AVAILABLE
        petsSteps.assertPetsStatus(statuses, Arrays.asList("available"));
    }

    @Test
    @Owner("Mihail Petrov")
    @DisplayName("Получение питомцев со статусом PENDING")
    @Description("Получение питомцев со статусом PENDING с помощью метода GET. Проверка заголовков, статуса ответа и факта, что все записи имеют статус PENDING")
    public void getPetByStatusPending(){

        // Получение питомцев со статусом PENDING
        List pets = petsSteps.getPetByStatus("pending");

        // Получение списка статусов питомцев
        List <String> statuses = petsSteps.getStatuses(pets);

        // Проверка, что все питомцы имеют статус PENDING
        petsSteps.assertPetsStatus(statuses, Arrays.asList("pending"));

    }

}