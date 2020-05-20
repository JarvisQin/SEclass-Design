package ssm.service;

import ssm.util.ResultUtil;

import java.util.List;

public interface CleanService {
    List<Clean> getCleanList();
    void addClean(Clean clean);
    void updateClean(Clean clean);
    Clean getCleanById(Integer cleanId);
    void deleteCleanById(int cleanId);

    ResultUtil getClassList(Integer page, Integer limit);
}
