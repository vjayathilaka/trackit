package com.myproject.trackit.domain;

public class ProjectResponseMobile {

    private Long id;
    private String projectName;
    private String clientId;
    private String deadline;
    private String status;
    private String engineerId;
    private String constructorId;
    private String projectMgrId;

    private String engName;
    private String conName;
    private String manName;
    private String cliName;

    public String getEngineerId() {
        return engineerId;
    }

    public void setEngineerId(String engineerId) {
        this.engineerId = engineerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String name) {
        this.projectName = name;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getConstructorId() {
        return constructorId;
    }

    public void setConstructorId(String constructorId) {
        this.constructorId = constructorId;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProjectMgrId() {
        return projectMgrId;
    }

    public void setProjectMgrId(String projectMgrId) {
        this.projectMgrId = projectMgrId;
    }

    public String getEngName() {
        return engName;
    }

    public String getConName() {
        return conName;
    }

    public String getManName() {
        return manName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public void setManName(String manName) {
        this.manName = manName;
    }

    public String getCliName() {
        return cliName;
    }

    public void setCliName(String cliName) {
        this.cliName = cliName;
    }

    public ProjectResponseMobile(Long id, String projectName, String clientId, String deadline, String status, String engineerId, String constructorId, String projectMgrId) {
        this.id = id;
        this.projectName = projectName;
        this.clientId = clientId;
        this.deadline = deadline;
        this.status = status;
        this.engineerId = engineerId;
        this.constructorId = constructorId;
        this.projectMgrId = projectMgrId;
    }
}
