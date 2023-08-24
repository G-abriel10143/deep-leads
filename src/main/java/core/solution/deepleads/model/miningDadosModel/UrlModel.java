package core.solution.deepleads.model.miningDadosModel;

import core.solution.deepleads.TypeSearch.TypeSearch;
import core.solution.deepleads.request.UrlRequest;
import jakarta.persistence.*;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "TB_DL_URL_MODEL")
public class UrlModel {

    @Id
    @GeneratedValue
    private int id;

    @NonNull
    private String url;

    @NonNull
    private String keys;

    @NonNull
    @Enumerated(EnumType.STRING)
    private TypeSearch typeSearch;

    private LocalDateTime dataMining;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_url_model")
    private List<LeadsModel>  leadsModels;

    public UrlModel(UrlRequest urlRequest,  List<LeadsModel> leadsModels) {
        this.url = urlRequest.getUrl();
        this.keys = urlRequest.getKeys();
        this.typeSearch = urlRequest.getTypeSearch();
        this.dataMining = LocalDateTime.now();
        this.setLeadsModels(leadsModels);

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<LeadsModel> getLeadsModels() {
        return leadsModels;
    }

    public void setLeadsModels(List<LeadsModel> leadsModels) {
        this.leadsModels = leadsModels;
    }

    public LocalDateTime getDataMining() {
        return dataMining;
    }

    public void setDataMining(LocalDateTime dataMining) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = dataMining.format(formatter);
        this.dataMining = LocalDateTime.parse(dataFormatada, formatter);
    }

    public UrlModel() {
    }
}
