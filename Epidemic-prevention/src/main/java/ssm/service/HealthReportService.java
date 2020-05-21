package ssm.service;

import ssm.domain.HealthReport;

import java.util.List;

public interface HealthReportService {
    //健康报告
    void addHealthReport(HealthReport hr);
    List<HealthReport> getHealthRList();
    List<HealthReport> getHealthRListByUserId(int userId);



}
