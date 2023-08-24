package core.solution.deepleads.response;

import core.solution.deepleads.model.miningDadosModel.LeadsModel;
import core.solution.deepleads.model.miningDadosModel.UrlModel;

import java.time.LocalDateTime;
import java.util.List;

public class LeadsResponse {

    private int totalMiningData;

    private LocalDateTime miningTime;

    private List<LeadsModel> genericEntities;



    public int getTotalMiningData() {
        return totalMiningData;
    }

    public void setTotalMiningData(int totalMiningData) {
        this.totalMiningData = totalMiningData;
    }

    public List<LeadsModel> getGenericEntities() {
        return genericEntities;
    }

    public void setGenericEntities(List<LeadsModel> genericEntities) {
        this.genericEntities = genericEntities;
    }

    public LocalDateTime getMiningTime() {
        return miningTime;
    }

    public void setMiningTime(LocalDateTime miningTime) {
        this.miningTime = miningTime;
    }

    public LeadsResponse(UrlModel urlModel) {

        if (urlModel.getLeadsModels().size() != 0 || !urlModel.getLeadsModels().isEmpty()) {
            this.totalMiningData = urlModel.getLeadsModels().size();
        }
        this.genericEntities = urlModel.getLeadsModels();
        this.miningTime = urlModel.getDataMining();

    }
}
