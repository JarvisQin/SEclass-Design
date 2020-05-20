package ssm.domain;

public class symp_report {
    private Integer symptom_id;
    private Integer report_id;
    public Integer getSymptom_id() {
        return symptom_id;
    }

    public void setSymptom_id(Integer symptom_id) {
        this.symptom_id = symptom_id;
    }

    public Integer getReport_id() {
        return report_id;
    }

    public void setReport_id(Integer report_id) {
        this.report_id = report_id;
    }

    @Override
    public String toString() {
        return "symp_report{" +
                "symptom_id=" + symptom_id +
                ", report_id=" + report_id +
                '}';
    }
}
