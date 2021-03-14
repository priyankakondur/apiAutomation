package ResponseServices;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddBookResponse {
    @JsonProperty("Msg")
    private String Msg;
    @JsonProperty("ID")
    private String Id;

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        this.Msg = msg;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = Id;
    }


}
