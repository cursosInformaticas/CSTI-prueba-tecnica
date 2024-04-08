package com.springcloud.msvc.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "root")
public class Root {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @XmlElement
    private Person person;

    @XmlElement
    private int random;

    @XmlElement(name = "random_float")
    private float randomFloat;

    @XmlElement
    private boolean bool;

    @XmlElement
    private String date;

    @XmlElement
    private String regEx;

    @XmlElement(name = "enum")
    @Column(name = "enum")
    private String enumValue;

     @ElementCollection
    @CollectionTable(name = "elt", joinColumns = @JoinColumn(name = "root_id"))
    @Column(name = "elt")
    private List<String> elt;

    @Column(name = "LAST_UPDATE")
    private String lastUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        setLastModifiedToCurrentDateTime();
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    public float getRandomFloat() {
        return randomFloat;
    }

    public void setRandomFloat(float randomFloat) {
        this.randomFloat = randomFloat;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRegEx() {
        return regEx;
    }

    public void setRegEx(String regEx) {
        this.regEx = regEx;
    }

    public String getEnumValue() {
        return enumValue;
    }

    public void setEnumValue(String enumValue) {
        this.enumValue = enumValue;
    }

  //  public List<String> getElt() {
   //     return elt;
  //  }

   // public void setElt(List<String> elt) {
   //     this.elt = elt;
   // }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<String> getElt() {
        return elt;
    }

    public void setElt(List<String> elt) {
        this.elt = elt;
    }

    private void setLastModifiedToCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        this.lastUpdate = sdf.format(new Date());
    }
}
