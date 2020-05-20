package ssm.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CleanDao {
    List<Clean> getCleanList();
    void addClean(Clean clean);
    void updateClean(Clean clean);
    Clean getCleanById(Integer cleanId);
    void deleteCleanById(int cleanId);

}
