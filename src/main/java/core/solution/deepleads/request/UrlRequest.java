package core.solution.deepleads.request;

import core.solution.deepleads.TypeSearch.TypeSearch;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NonNull;

@Data
public class UrlRequest {

    @NonNull
    private String url;

    @NonNull
    private String keys;

    @NonNull
    @Enumerated(EnumType.STRING)
    private TypeSearch typeSearch;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public TypeSearch getTypeSearch() {
        return typeSearch;
    }

    public void setTypeSearch(TypeSearch typeSearch) {
        this.typeSearch = typeSearch;
    }
}
