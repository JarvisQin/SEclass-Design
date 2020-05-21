package ssm.domain;

import java.io.Serializable;
import java.util.Date;

public class HealthReport implements Serializable {
    private Integer report_id;
    private Integer user_id;
    private String city;
    private String address;
    private String organization;
    private Integer personelType;
    private boolean isolate;
    private Integer residentType;
    private Integer symptom_id;
    private String description;
    private boolean isfever;
    private boolean isChecked;
    private boolean isNeedHelp;
    private Date report_time;

    public Date getReport_time() {
        return report_time;
    }

    public void setReport_time(Date report_time) {
        this.report_time = report_time;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Integer getPersonelType() {
        return personelType;
    }

    public void setPersonelType(Integer personelType) {
        this.personelType = personelType;
    }

    public boolean isIsolate() {
        return isolate;
    }

    public void setIsolate(boolean isolate) {
        this.isolate = isolate;
    }

    public Integer getResidentType() {
        return residentType;
    }

    public void setResidentType(Integer residentType) {
        this.residentType = residentType;
    }

    public Integer getSymptom_id() {
        return symptom_id;
    }

    public void setSymptom_id(Integer symptom_id) {
        this.symptom_id = symptom_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsfever() {
        return isfever;
    }

    public void setIsfever(boolean isfever) {
        this.isfever = isfever;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public boolean isNeedHelp() {
        return isNeedHelp;
    }

    public void setNeedHelp(boolean needHelp) {
        isNeedHelp = needHelp;
    }

    public Integer getReport_id() {
        return report_id;
    }

    public void setReport_id(Integer report_id) {
        this.report_id = report_id;
    }

    @Override
    public String toString() {
        return "Health_report{" +
                "report_id=" + report_id +
                ", user_id=" + user_id +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", organization='" + organization + '\'' +
                ", personelType=" + personelType +
                ", isolate=" + isolate +
                ", residentType=" + residentType +
                ", symptom_id=" + symptom_id +
                ", description='" + description + '\'' +
                ", isfever=" + isfever +
                ", isChecked=" + isChecked +
                ", isNeedHelp=" + isNeedHelp +
                ", report_time=" + report_time +
                '}';
    }


}
