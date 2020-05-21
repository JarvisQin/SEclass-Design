package ssm.domain;

import java.io.Serializable;

public class StoreInfo implements Serializable {
    private  Integer store_id;
    private  String name;
    private  Integer quantity;
    private  Integer order;

    @Override
    public String toString() {
        return "store_info{" +
                "store_id=" + store_id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", order=" + order +
                '}';
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }
}
