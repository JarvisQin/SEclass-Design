package ssm.domain;

import java.io.Serializable;

public class MaskOrder implements Serializable {

    private Integer order_id;
    private Integer store_id;
    private Integer user_id;
    private String name;
    private Integer id_type;
    private String id_number;
    private String phone;


    @Override
    public String toString() {
        return "mask_order{" +
                "order_id=" + order_id +
                ", store_id=" + store_id +
                ", name='" + name + '\'' +
                ", id_type=" + id_type +
                ", id_number='" + id_number + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }


    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getStore_id() {
        return store_id;
    }

    public void setStore_id(Integer store_id) {
        this.store_id = store_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId_type() {
        return id_type;
    }

    public void setId_type(Integer id_type) {
        this.id_type = id_type;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
