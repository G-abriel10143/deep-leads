package core.solution.deepleads.response.googleMapsResponse;

import java.util.List;

public class AddressComponent {
    private String long_name;
    private String short_name;
    private List<String> types;

    public String getLongName() {
        return long_name;
    }

    public void setLongName(String long_name) {
        this.long_name = long_name;
    }

    public String getShortName() {
        return short_name;
    }

    public void setShortName(String short_name) {
        this.short_name = short_name;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}
