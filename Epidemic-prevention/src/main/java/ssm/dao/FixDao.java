package ssm.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FixDao {
    List<Fix> getFixList();
    void addFix(Fix fix);
    Fix getFixById(int fixId);
    void updateFix(Fix fix);
    void deleteFixById(int fixId);
}
