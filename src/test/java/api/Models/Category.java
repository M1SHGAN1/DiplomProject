package api.Models;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name"
})
@Generated("jsonschema2pojo")
public class Category {

    // Указываем аннотацию @JsonProperty для сериализации и десериализации поля "id"
    @JsonProperty("id")
    private Long id;

    // Указываем аннотацию @JsonProperty для сериализации и десериализации поля "name"
    @JsonProperty("name")
    private String name;

    // Игнорируем это поле при сериализации и десериализации
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    // Геттер для поля "id"
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    // Сеттер для поля "id"
    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    // Геттер для поля "name"
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    // Сеттер для поля "name"
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    // Геттер для дополнительных свойств
    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    // Сеттер для дополнительных свойств
    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}