package ssm.service;

import ssm.util.ResultUtil;

public interface FixService {
    ResultUtil getFixList(Integer page, Integer limit);
    void addFix(Fix fix);
    Fix getFixById(int id);
    void updateFix(Fix fix);
    void deleteFixById(int id);
}
