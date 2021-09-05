package pl.sdaproject.medicalarchivemanagementsystem.model;

public enum FolderType {

    ENVELOPE("Envelope"),
    FOLDER("Folder"),
    BINDER("Binder"),
    BOX("Box");

    private final String label;

    FolderType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
