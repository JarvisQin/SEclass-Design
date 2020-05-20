package ssm.domain;

import java.util.Date;

public class Contact {
    private Integer contact_id;
    private Integer user_id;
    private String name;
    private String id_num;
    private String relationship;
    private Date start_time;
    private Date end_time;
    private String description;

    public Integer getContact_id() {
        return contact_id;
    }

    public void setContact_id(Integer contact_id) {
        this.contact_id = contact_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_num() {
        return id_num;
    }

    public void setId_num(String id_num) {
        this.id_num = id_num;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public String toString() {
        return "Contact{" +
                "contact_id=" + contact_id +
                ", user_id=" + user_id +
                ", name='" + name + '\'' +
                ", id_num='" + id_num + '\'' +
                ", relationship='" + relationship + '\'' +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                ", description='" + description + '\'' +
                '}';
    }
}
