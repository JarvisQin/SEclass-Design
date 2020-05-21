package ssm.domain;

import java.io.Serializable;

public class Symp implements Serializable {
    private Integer symptom_id;
    private String symptom_name;

    @Override
    public String toString() {
        return "symp{" +
                "symptom_id=" + symptom_id +
                ", symptom_name='" + symptom_name + '\'' +
                '}';
    }

    public Integer getSymptom_id() {
        return symptom_id;
    }

    public void setSymptom_id(Integer symptom_id) {
        this.symptom_id = symptom_id;
    }

    public String getSymptom_name() {
        return symptom_name;
    }

    public void setSymptom_name(String symptom_name) {
        this.symptom_name = symptom_name;
    }


}
