package entities;

import entities.enums.FishLivEnv;
import jakarta.persistence.*;

@Entity
public class Fish extends Animal {
    private FishLivEnv fishLivEnv;

    public Fish() {}

    public Fish(FishLivEnv fishLivEnv) {
        this.fishLivEnv = fishLivEnv;
    }

    public FishLivEnv getFishLivEnv() {
        return fishLivEnv;
    }

    public void setFishLivEnv(FishLivEnv fishLivEnv) {
        this.fishLivEnv = fishLivEnv;
    }
}
