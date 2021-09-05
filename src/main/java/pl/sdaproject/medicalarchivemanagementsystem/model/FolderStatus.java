package pl.sdaproject.medicalarchivemanagementsystem.model;

public enum FolderStatus {

    IN_ARCHIVE("In archive"),
    BORROWED("Borrowed");

    private final String label;

    FolderStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
