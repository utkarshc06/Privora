package com.ciphercore.model;

public class PrintRequest {

    private String requestId;
    private String documentId;
    private String userId;
    private String xeroxId;
    private int printCopies;
    private String status;
    private String requestedAt;

    // Default constructor required by Firebase
    public PrintRequest() {
    }

    public PrintRequest(String requestId,
                        String documentId,
                        String userId,
                        String xeroxId,
                        int printCopies,
                        String status,
                        String requestedAt) {

        this.requestId = requestId;
        this.documentId = documentId;
        this.userId = userId;
        this.xeroxId = xeroxId;
        this.printCopies = printCopies;
        this.status = status;
        this.requestedAt = requestedAt;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getXeroxId() {
        return xeroxId;
    }

    public void setXeroxId(String xeroxId) {
        this.xeroxId = xeroxId;
    }

    public int getPrintCopies() {
        return printCopies;
    }

    public void setPrintCopies(int printCopies) {
        this.printCopies = printCopies;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRequestedAt() {
        return requestedAt;
    }

    public void setRequestedAt(String requestedAt) {
        this.requestedAt = requestedAt;
    }
}