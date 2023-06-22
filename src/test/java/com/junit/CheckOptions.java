package com.junit;

import api.PetsSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Проверка доступных методов для https://petstore.swagger.io/v2/pet/findByStatus")
public class CheckOptions {

    private final PetsSteps petsSteps = new PetsSteps();

    @Test
    @Owner("Mihail Petrov")
    @DisplayName("Получение списка доступных методов")
    @Description("Отправка запроса OPTIONS и проверка ответа")
    public void getAllowMethods(){
        // Получение списка доступных методов для "/pet/findByStatus"
        String allMethods = petsSteps.getAllowMethods("/pet/findByStatus");
        // Проверка, что список доступных методов соответствует ожидаемому значению "OPTIONS,HEAD,GET"
        petsSteps.assertAllowMethods("OPTIONS,HEAD,GET", allMethods);
    }

    @Test
    @Owner("Mihail Petrov")
    @DisplayName("Некорректный запрос с методом POST для https://petstore.swagger.io/v2/pet/findByStatus")
    @Description("Отправка некорректного запроса POST для https://petstore.swagger.io/v2/pet/findByStatus и проверка ответа")
    public void postToFindByStatus(){
        // Отправка некорректного запроса POST для "/pet/findByStatus?status=sold"
        petsSteps.postNotAllowMethods("/pet/findByStatus?status=sold");
    }
}