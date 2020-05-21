package ssm.dao;

import ssm.domain.MaskOrder;

import java.util.List;

public interface MaskOrderDao {
    void addMaskOrder(MaskOrder maskorder);
    void deleteMaskOrderByOrderId(int orderId);
    List<MaskOrder> getMaskOrderByUserId(int userId);
    List<MaskOrder> getMaskOrderByUserId_finished(int userId);
    List<MaskOrder> getMaskOrderListByStoreId();
    List<MaskOrder> getMaskOrderListByStoreId_finished();

}
