package com.example.api1;

public class Appl {

    private String subject;
    private String type;
    private String stats;
    private String reported_by;
    private String mobile_no;
    private String email_id;
    private String project;
    private String assigned_to;


    public Appl(String subject, String type, String stats, String reported_by, String mobile_no, String email_id, String project, String assigned_to) {
        this.subject = subject;
        this.type = type;
        this.stats = stats;
        this.reported_by = reported_by;
        this.mobile_no = mobile_no;
        this.email_id = email_id;
        this.project = project;
        this.assigned_to = assigned_to;
    }

    public String getSubject() {
        return subject;
    }

    public String getType() {
        return type;
    }

    public String getStats() {
        return stats;
    }

    public String getReported_by() {
        return reported_by;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public String getEmail_id() {
        return email_id;
    }

    public String getProject() {
        return project;
    }

    public String getAssigned_to() {
        return assigned_to;
    }
}
