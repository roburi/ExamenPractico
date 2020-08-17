package com.example.examentecnico.mdata;

import java.util.ArrayList;

public class HeroId {
    private String response;
    private String id;
    private String name;
    private Powerstats PowerstatsObject;
    private Biography BiographyObject;
    private Appearance AppearanceObject;
    private Work WorkObject;
    private Connections ConnectionsObject;
    private Image ImageObject;


    // Getter Methods

    public String getResponse() {
        return response;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Powerstats getPowerstats() {
        return PowerstatsObject;
    }

    public Biography getBiography() {
        return BiographyObject;
    }

    public Appearance getAppearance() {
        return AppearanceObject;
    }

    public Work getWork() {
        return WorkObject;
    }

    public Connections getConnections() {
        return ConnectionsObject;
    }

    public Image getImage() {
        return ImageObject;
    }

    // Setter Methods

    public void setResponse(String response) {
        this.response = response;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPowerstats(Powerstats powerstatsObject) {
        this.PowerstatsObject = powerstatsObject;
    }

    public void setBiography(Biography biographyObject) {
        this.BiographyObject = biographyObject;
    }

    public void setAppearance(Appearance appearanceObject) {
        this.AppearanceObject = appearanceObject;
    }

    public void setWork(Work workObject) {
        this.WorkObject = workObject;
    }

    public void setConnections(Connections connectionsObject) {
        this.ConnectionsObject = connectionsObject;
    }

    public void setImage(Image imageObject) {
        this.ImageObject = imageObject;
    }
}

class Connections {
    private String group_affiliation;
    private String relatives;


    // Getter Methods

    public String getGroup_affiliation() {
        return group_affiliation;
    }

    public String getRelatives() {
        return relatives;
    }

    // Setter Methods

    public void setGroup_affiliation(String group_affiliation) {
        this.group_affiliation = group_affiliation;
    }

    public void setRelatives(String relatives) {
        this.relatives = relatives;
    }
}
class Work {
    private String occupation;
    private String base;


    // Getter Methods

    public String getOccupation() {
        return occupation;
    }

    public String getBase() {
        return base;
    }

    // Setter Methods

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setBase(String base) {
        this.base = base;
    }
}
class Appearance {
    private String gender;
    private String race;
    ArrayList < Object > height = new ArrayList < Object > ();
    ArrayList < Object > weight = new ArrayList < Object > ();
    private String eye_color;
    private String hair_color;


    // Getter Methods

    public String getGender() {
        return gender;
    }

    public String getRace() {
        return race;
    }

    public String getEye_color() {
        return eye_color;
    }

    public String getHair_color() {
        return hair_color;
    }

    // Setter Methods

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }

    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }
}
class Biography {
    private String full_name;
    private String alter_egos;
    ArrayList < Object > aliases = new ArrayList < Object > ();
    private String place_of_birth;
    private String first_appearance;
    private String publisher;
    private String alignment;


    // Getter Methods

    public String getFull_name() {
        return full_name;
    }

    public String getAlter_egos() {
        return alter_egos;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public String getFirst_appearance() {
        return first_appearance;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAlignment() {
        return alignment;
    }

    // Setter Methods

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setAlter_egos(String alter_egos) {
        this.alter_egos = alter_egos;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
    }

    public void setFirst_appearance(String first_appearance) {
        this.first_appearance = first_appearance;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }
}
class Powerstats {
    private String intelligence;
    private String strength;
    private String speed;
    private String durability;
    private String power;
    private String combat;


    // Getter Methods

    public String getIntelligence() {
        return intelligence;
    }

    public String getStrength() {
        return strength;
    }

    public String getSpeed() {
        return speed;
    }

    public String getDurability() {
        return durability;
    }

    public String getPower() {
        return power;
    }

    public String getCombat() {
        return combat;
    }

    // Setter Methods

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public void setDurability(String durability) {
        this.durability = durability;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public void setCombat(String combat) {
        this.combat = combat;
    }
}

