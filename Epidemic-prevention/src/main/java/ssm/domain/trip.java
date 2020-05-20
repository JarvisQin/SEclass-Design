package ssm.domain;

import java.util.Date;

public class trip {
    private Integer trip_id;
    private Integer user_id;
    private  String from;
    private Date depart_date;
    private String destination;
    private  Date arrive_date;
    private String transpotation;
    private String trans_no;
    private Integer stayday;
    private String resident;

    @Override
    public String toString() {
        return "trip{" +
                "trip_id=" + trip_id +
                ", user_id=" + user_id +
                ", from='" + from + '\'' +
                ", depart_date=" + depart_date +
                ", destination='" + destination + '\'' +
                ", arrive_date=" + arrive_date +
                ", transpotation='" + transpotation + '\'' +
                ", trans_no='" + trans_no + '\'' +
                ", stayday=" + stayday +
                ", resident='" + resident + '\'' +
                '}';
    }

    public Integer getTrip_id() {
        return trip_id;
    }

    public void setTrip_id(Integer trip_id) {
        this.trip_id = trip_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Date getDepart_date() {
        return depart_date;
    }

    public void setDepart_date(Date depart_date) {
        this.depart_date = depart_date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getArrive_date() {
        return arrive_date;
    }

    public void setArrive_date(Date arrive_date) {
        this.arrive_date = arrive_date;
    }

    public String getTranspotation() {
        return transpotation;
    }

    public void setTranspotation(String transpotation) {
        this.transpotation = transpotation;
    }

    public String getTrans_no() {
        return trans_no;
    }

    public void setTrans_no(String trans_no) {
        this.trans_no = trans_no;
    }

    public Integer getStayday() {
        return stayday;
    }

    public void setStayday(Integer stayday) {
        this.stayday = stayday;
    }

    public String getResident() {
        return resident;
    }

    public void setResident(String resident) {
        this.resident = resident;
    }
}
