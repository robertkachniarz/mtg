package pl.sdacademy.mtg.model;

public class MtgCardJSON {
    private String name;
    private int multiverseId;
    private String setName;


    public MtgCardJSON() {
    }

    public MtgCardJSON(String name, int multiverseId, String setName) {
        this.name = name;
        this.multiverseId = multiverseId;
        this.setName = setName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMultiverseId() {
        return multiverseId;
    }

    public void setMultiverseId(int multiverseId) {
        this.multiverseId = multiverseId;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }
}

