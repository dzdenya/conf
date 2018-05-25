package model;

import java.util.Objects;

public class MaterialData {
    private int id;
    private final String name;
    private final String volume;
    private final String prise;

    public MaterialData(String name, String volume, String prise) {
        this.id = 0;
        this.name = name;
        this.volume = volume;
        this.prise = prise;
    }

    public MaterialData(int id, String name, String volume, String prise) {
        this.id = id;
        this.name = name;
        this.volume = volume;
        this.prise = prise;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVolume() {
        return volume;
    }

    public String getPrise() {
        return prise;
    }

    @Override
    public String toString() {
        return "MaterialData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", volume='" + volume + '\'' +
                ", prise='" + prise + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MaterialData that = (MaterialData) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
