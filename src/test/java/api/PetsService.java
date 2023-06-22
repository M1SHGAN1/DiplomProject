package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PetsService {

    // Создание объекта RequestSpecification с базовыми настройками
    private static final RequestSpecification REQ_SPEC = new RequestSpecBuilder()
            .setBaseUri("https://petstore.swagger.io/v2")
            .setContentType(ContentType.JSON)
            .addHeader("api_key", "special-key")
            .build();

    // Получение списка питомцев по их статусу
    public Response getPetsByStatus(String status) {
        return given()
                .spec(REQ_SPEC)
                .when()
                .get("/pet/findByStatus?status=" + addSeveralStatus(status))
                .then().extract().response();
    }

    // Метод для добавления нескольких статусов
    private String addSeveralStatus(String status) {
        if (status.contains(",")) {
            status.replace(",", "&status=");
            return status;
        } else {
            return status;
        }
    }

    // Отправка запроса OPTIONS
    public Response sendOptionsReq(String path) {
        return given()
                .spec(REQ_SPEC)
                .when()
                .options(path)
                .then().extract().response();
    }

    // Выполнение недопустимого запроса POST
    public Response notAllowedPost(String path) {
        return given()
                .spec(REQ_SPEC)
                .when()
                .post(path);
    }

    // Создание нового питомца
    public Response postNewPet(Object pet) {
        return given()
                .spec(REQ_SPEC)
                .when()
                .body(pet)
                .post("/pet")
                .then().extract().response();
    }

    // Получение информации о питомце по его ID
    public Response getPetByIds(Long petId) {
        return given()
                .spec(REQ_SPEC)
                .when()
                .get("/pet/" + petId)
                .then().extract().response();
    }

    // Удаление питомца по его ID
    public Response deletePet(Long petId) {
        return given()
                .spec(REQ_SPEC)
                .when()
                .delete("/pet/" + petId)
                .then().extract().response();
    }
}