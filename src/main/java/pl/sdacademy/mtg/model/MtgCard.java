package pl.sdacademy.mtg.model;

import javafx.beans.property.*;

import java.util.Objects;

public class MtgCard {
    private StringProperty name;
    private IntegerProperty multiverseId;
    private StringProperty setName;

    private StringProperty manaCost;
    private DoubleProperty cmc;
    private StringProperty type;
    private StringProperty text;
    private StringProperty rarity;
    private StringProperty artist;
    private StringProperty flavor;

    public MtgCard() {this(null, null, null);}

    public MtgCard(String name, Integer mulriverseId, String setName){
        this.name = new SimpleStringProperty(name);
        this.multiverseId = new SimpleIntegerProperty(mulriverseId);
        this.setName = new SimpleStringProperty(setName);
    }

   /* public MtgCard(StringProperty name, StringProperty set, StringProperty setName, StringProperty imageUrl) {
        this.name = name;
        this.set = set;
        this.setName = setName;
        this.imageUrl = imageUrl;
    }*/

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getMultiverseId() {
        return multiverseId.get();
    }

    public IntegerProperty multiverseIdProperty() {
        return multiverseId;
    }

    public void setMultiverseId(int multiverseId) {
        this.multiverseId.set(multiverseId);
    }

    public String getSetName() {
        return setName.get();
    }

    public StringProperty setNameProperty() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName.set(setName);
    }

    public String getManaCost() {
        return manaCost.get();
    }

    public StringProperty manaCostProperty() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = new SimpleStringProperty(manaCost);
    }

    public double getCmc() {
        return cmc.get();
    }

    public DoubleProperty cmcProperty() {
        return cmc;
    }

    public void setCmc(double cmc) {
        this.cmc = new SimpleDoubleProperty(cmc);
    }

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type = new SimpleStringProperty(type);
    }

    public String getText() {
        return text.get();
    }

    public StringProperty textProperty() {
        return text;
    }

    public void setText(String text) {
        this.text = new SimpleStringProperty(text);
    }

    public String getRarity() {
        return rarity.get();
    }

    public StringProperty rarityProperty() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = new SimpleStringProperty(rarity);
    }

    public String getArtist() {
        return artist.get();
    }

    public StringProperty artistProperty() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = new SimpleStringProperty(artist);
    }

    public String getFlavor() {
        return flavor.get();
    }

    public StringProperty flavorProperty() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = new SimpleStringProperty(flavor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MtgCard mtgCard = (MtgCard) o;
        return Objects.equals(name, mtgCard.name) &&
                Objects.equals(multiverseId, mtgCard.multiverseId) &&
                Objects.equals(setName, mtgCard.setName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, multiverseId, setName);
    }
}
