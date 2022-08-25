package com.whs.dubbonacosmybatisplusapi.entity;

    import java.io.Serializable;

/**
* <p>
    * 
    * </p>
*
* @author 巫浩盛
* @since 2021-06-30
*/
public class Person implements Serializable {

//    private static final long serialVersionUID = 1L;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    private String personname;

    private String personsex;

    private Integer personage;

    private String personaddr;

    public String getPersonname() {
        return personname;
        }

    public void setPersonname(String personname) {
        this.personname = personname;
        }
    public String getPersonsex() {
        return personsex;
        }

    public void setPersonsex(String personsex) {
        this.personsex = personsex;
        }
    public Integer getPersonage() {
        return personage;
        }

    public void setPersonage(Integer personage) {
        this.personage = personage;
        }
    public String getPersonaddr() {
        return personaddr;
        }

    public void setPersonaddr(String personaddr) {
        this.personaddr = personaddr;
        }

    @Override
    public String toString() {
    return "Person{" +
            "personname=" + personname +
            ", personsex=" + personsex +
            ", personage=" + personage +
            ", personaddr=" + personaddr +
    "}";
    }
}
