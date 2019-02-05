package com.example.lenovo.thescient;

public class promga {
    private Integer id;
    private String projectImage;
    private String projectTitle;
    private String projectDesc;
    private String createdAt;
    private String updatedAt;

    public promga( String projectImage, String projectTitle, String projectDesc) {

        this.projectDesc = projectDesc;
        this.projectImage = projectImage;
        this.projectTitle = projectTitle;

    }

    public String getdesc() {
        return projectDesc;
    }

    public String getProjectImage() {
        return "https://scient.nitt.edu" + projectImage;

    }

    public String getProjectTitle() {
        return projectTitle;
    }
}