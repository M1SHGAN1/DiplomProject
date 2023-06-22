package api.Data;

/*Код представляет собой строковое представление JSON-объекта.
Он служит в качестве примера некорректных данных для тестирования
или демонстрации некорректной структуры или содержимого JSON-запросов
или ответов в API.*/

public class InvalidData {
    public static final String INCORRECT_JSON_BODY = "{\n" +
            "  \"id\": STRING,\n" +
            "  \"category\": {\n" +
            "    \"id\": 3333,\n" +
            "    \"name\": \"Pet203257\"\n" +
            "  },\n" +
            "  \"name\": \"Pet203257\",\n" +
            "  \"photoUrls\": [\n" +
            "    \"\"\n" +
            "  ],\n" +
            "  \"tags\": [\n" +
            "    {\n" +
            "      \"id\": 203007,\n" +
            "      \"name\": \"Pet203257\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"status\": \"sold\"\n" +
            "}";
}
