package RequestServices;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteBookRequest {
    @JsonProperty("ID")
    private String id;

    public String deleteId() {
        return id;
    }

    public void setIdToDelete(String id) {
        this.id = id;
    }
}
