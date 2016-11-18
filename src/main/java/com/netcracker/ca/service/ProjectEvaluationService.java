package com.netcracker.ca.service;

import java.util.List;

import com.netcracker.ca.model.ProjectEvaluation;

/**
 * Created by Oleksandr on 12.11.2016.
 */
public interface ProjectEvaluationService {

    void add(ProjectEvaluation pe);

    void update(ProjectEvaluation pe);

    void delete(int id);

    List<ProjectEvaluation> getEvaluationsOfTeam(int id);

    List<ProjectEvaluation> getEvaluationsOfProject(int id);
}