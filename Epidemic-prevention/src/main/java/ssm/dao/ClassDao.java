package ssm.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassDao {
    List<DClass> getClassList();
    void deleteByClassId(int classId);
    List<DClass> getAllClasses();
    DClass getClassById(int classId);
    DClass getClassByClassName(String className);
    void updateClass(DClass dclass);
    void insertClass(DClass dclass);
}
