package ssm.service;

import ssm.util.ResultUtil;

import java.util.List;

public interface DormitoryService {
    Dormitory getDormitoryById(int dormitoryId);
    List<Dormitory> getAllDormitories();
    ResultUtil getDormitoryList(Integer page, Integer limit);
    Dormitory checkDormitoryNumber(String dormitoryNumber);
    void addDormitory(Dormitory dormitory);
    void deleteByDormitoryId(int dormitoryId);

}
