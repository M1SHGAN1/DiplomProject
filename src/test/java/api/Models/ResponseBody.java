package api.Models;

public class ResponseBody {
    private Integer code;    // Код ответа
    private String type;     // Тип ответа
    private String message;  // Сообщение

    public Integer getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
