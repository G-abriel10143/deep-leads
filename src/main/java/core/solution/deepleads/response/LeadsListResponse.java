package core.solution.deepleads.response;


import core.solution.deepleads.model.miningDadosModel.LeadsModel;
import lombok.Data;


public class LeadsListResponse {

        private Long id;
        private String rating;
        private String stars;
        private String category;
        private String plusCode;
        private String name;
        private String phone;
        private String place;
        private String latitude;
        private String longitude;
        private String state;
        private String country;


    public LeadsListResponse(LeadsModel leadsModel) {
        this.id = leadsModel.getId();
        this.rating = leadsModel.getRating();
        this.stars = leadsModel.getStars();
        this.category = leadsModel.getCategory();
        this.plusCode = leadsModel.getPlusCode();
        this.name = leadsModel.getName();
        this.phone = leadsModel.getPhone();
        this.place = leadsModel.getPlace();
        this.latitude = leadsModel.getLatitude();
        this.longitude= leadsModel.getLongitude();
        this.state = leadsModel.getState();
        this.country = leadsModel.getCountry();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPlusCode() {
        return plusCode;
    }

    public void setPlusCode(String plusCode) {
        this.plusCode = plusCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
