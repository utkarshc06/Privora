package com.ciphercore.model;

public class Document {

    private String documentId;
    private String ownerId;
    private String fileName;
    private String filePath;
    private String uploadedAt;
    private String expiryTime;
    private String status;
    

    // Default constructor required by Firebase
    public Document() {
    }

    public Document(String documentId,
                    String ownerId,
                    String fileName,
                    String filePath,
                    String uploadedAt,
                    String expiryTime,
                    String status) {

        this.documentId = documentId;
        this.ownerId = ownerId;
        this.fileName = fileName;
        this.filePath = filePath;
        this.uploadedAt = uploadedAt;
        this.expiryTime = expiryTime;
        this.status = status;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(String uploadedAt) {
        this.uploadedAt = uploadedAt;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}