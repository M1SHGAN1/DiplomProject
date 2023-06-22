package api;

import api.Models.PetsData;
import api.Models.ResponseBody;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PetsSteps extends PetsService {

    // Получить питомцев по статусу
    @Step("Получить питомцев по статусу = {status}")
    @Attachment
    public List<PetsData> getPetByStatus(String status) {
        Response response = getPetsByStatus(status);
        assertSCode(200, response);
        return response.jsonPath().getList(".", PetsData.class);
    }

    // Получить питомца по ID
    @Step("Получить питомца по ID")
    public PetsData getPetById(Long petId) {
        Response response = getPetByIds(petId);
        assertSCode(200, response);
        assertHeaders(response);
        return response.body().as(PetsData.class);
    }

    // Получение списка статусов для всех питомцев
    @Step("Получение списка статусов для всех питомцев")
    @Attachment
    public List<String> getStatuses(List<PetsData> pets) {
        List<String> statuses = new ArrayList<>();
        pets.forEach(n -> statuses.add(n.getStatus()));
        return statuses;
    }

    // Добавление нового питомца с невалидным body методом POST
    @Step("Добавление нового питомца с невалидным body методом POST")
    public Response postBadPet(Object pet) {
        Response response = postNewPet(pet);
        assertSCode(400, response);
        return response;
    }

    // Отправить Options запрос и получить список доступных методов для заданного пути
    @Step("Отправить Options запрос и получить список доступных методов для пути = {path}")
    @Attachment
    public String getAllowMethods(String path) {
        Response response = sendOptionsReq(path);
        assertSCode(204, response);
        return response.getHeader("Allow");
    }

    // Добавление нового питомца методом POST
    @Step("Добавление нового питомца методом POST")
    public PetsData createNewPet(PetsData pet) {
        Response response = postNewPet(pet);
        assertSCode(200, response);
        assertHeaders(response);
        Allure.addAttachment("CreatedPet", response.body().as(PetsData.class).toString());
        return response.body().as(PetsData.class);
    }

    // Отправка недопустимого POST запроса и проверка статуса ответа
    @Step("Отправка недопустимого POST запроса и проверка статуса ответа")
    public void postNotAllowMethods(String path) {
        Response response = notAllowedPost(path);
        assertSCode(405, response);
    }

    // Удаление питомца по ID
    @Step("Удаление питомца по ID")
    public Response deletePetById(Long petId, Integer statusCode) {
        Response response = deletePet(petId);
        assertSCode(statusCode, response);
        return response;
    }

    // Проверка, что поиск с несколькими статусами возвращает записи со статусом status
    @Step("Проверка, что поиск с несколькими статусами возвращает записи со статусом = {status}")
    public void assertPetsSeveralStatus(List<String> statuses, String status) {
        assertThat("Проверка, что список статусов содержит статус = {status}", statuses, hasItem(status));
    }

    // Проверка, что статус код ответа равен ожидаемому коду
    @Step("Проверка, что статус код ответа равен {expectedStatusCode}")
    public void assertSCode(Integer expectedStatusCode, Response response) {
        assertThat("Проверка, что статус код ответа равен {expectedStatusCode}", response.statusCode(), equalTo(expectedStatusCode));
    }

    // Проверка заголовков ответа
    @Step("Проверка заголовков ответа")
    public void assertHeaders(Response response) {
        assertThat("Проверка заголовка access-control-allow-headers", response.getHeader("access-control-allow-headers"), equalTo("Content-Type, api_key, Authorization"));
        assertThat("Проверка заголовка access-control-allow-methods", response.getHeader("access-control-allow-methods"), equalTo("GET, POST, DELETE, PUT"));
        assertThat("Проверка заголовка content-type", response.getHeader("content-type"), equalTo("application/json"));
    }

    // Проверка доступных методов
    @Step("Проверка доступных методов")
    public void assertAllowMethods(String expectedMethods, String allowMethods) {
        assertThat("Проверка, что полученные методы корректны", allowMethods, equalTo(expectedMethods));
    }

    // Проверка типа и сообщения ответа для невалидного запроса
    @Step("Проверка типа и сообщения ответа для невалидного запроса")
    public void assertBadRequestBody(Response response, String expectedType, String expectedMessage) {
        assertThat("Проверка, что тело ответа не пустое", response.body().asString().length(), greaterThan(0));
        String resType = response.body().as(ResponseBody.class).getType();
        String resMessage = response.body().as(ResponseBody.class).getMessage();
        assertThat("Проверка типа ответа", resType, equalTo(expectedType));
        assertThat("Проверка сообщения ответа", resMessage, equalTo(expectedMessage));
    }

    // Проверка тела ответа / питомца
    @Step("Проверка тела ответа / питомца")
    public void assertPetBody(PetsData body, PetsData pet) {
        Assertions.assertThat(body).as("Проверка, что тело ответа равно телу запроса").isEqualToComparingFieldByFieldRecursively(pet);
    }

    // Проверка, что все найденные питомцы имеют корректный статус status
    @Step("Проверка, что все найденные питомцы имеют корректный статус = {status}")
    public PetsSteps assertPetsStatus(List<String> statuses, List<String> status) {
        assertThat("Проверка, что статус равен {status} для всех элементов", statuses, everyItem(is(in(status))));
        return this;
    }
}