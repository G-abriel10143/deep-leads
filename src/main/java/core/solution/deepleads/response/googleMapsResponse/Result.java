package core.solution.deepleads.response.googleMapsResponse;

import java.util.List;

public class Result {
    private List<AddressComponent> address_components;
    private String formatted_address;
    private Geometry geometry;
    private boolean partial_match;
    private String place_id;
    private List<String> types;

    public List<AddressComponent> getAddressComponents() {
        return address_components;
    }

    public void setAddressComponents(List<AddressComponent> address_components) {
        this.address_components = address_components;
    }

    public String getFormattedAddress() {
        return formatted_address;
    }

    public void setFormattedAddress(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public boolean isPartialMatch() {
        return partial_match;
    }

    public void setPartialMatch(boolean partial_match) {
        this.partial_match = partial_match;
    }

    public String getPlaceId() {
        return place_id;
    }

    public void setPlaceId(String place_id) {
        this.place_id = place_id;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}
