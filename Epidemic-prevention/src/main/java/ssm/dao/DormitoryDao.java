package ssm.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DormitoryDao {
    Dormitory getDormitoryById(int dormitoryId);
    List<Dormitory> getAllDormitories();
    List<Dormitory> getDormitoryList();
    Dormitory checkDormitoryNumber(String dormitoryNumber);
    void addDormitory(Dormitory dormitory);
    void deleteByDormitoryId(int dormitoryId);
}
