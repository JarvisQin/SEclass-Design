package ssm.service;

import ssm.util.ResultUtil;

import java.util.List;

public interface ClassService {
    ResultUtil getClassList(Integer page, Integer limit);
    void deleteByClassId(int classId);
    List<DClass> getAllClasses();
    DClass getClassById(int classId);
    DClass getClassByClassName(String className);
    ResultUtil updateClass(DClass dclass);
    void addClass(DClass dclass);
}
