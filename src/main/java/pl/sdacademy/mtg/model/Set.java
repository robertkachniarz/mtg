package pl.sdacademy.mtg.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Set {
    private StringProperty name;
    private StringProperty block;
    private StringProperty code;
    private StringProperty releaseDate;

    public Set(){this(null, null, null, null);}

    public Set(String name, String block, String code, String releaseDate){
        this.name = new SimpleStringProperty(name);
        this.block = new SimpleStringProperty(block);
        this.code = new SimpleStringProperty(code);
        this.releaseDate = new SimpleStringProperty(releaseDate);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getBlock() {
        return block.get();
    }

    public StringProperty blockProperty() {
        return block;
    }

    public void setBlock(String block) {
        this.block.set(block);
    }

    public String getCode() {
        return code.get();
    }

    public StringProperty codeProperty() {
        return code;
    }

    public void setCode(String code) {
        this.code.set(code);
    }

    public String getReleaseDate() {
        return releaseDate.get();
    }

    public StringProperty releaseDateProperty() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate.set(releaseDate);
    }
}
