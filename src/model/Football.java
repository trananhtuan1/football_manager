package model;

public class Football {
    private int id;
    private String name;
    private int age;
    private int height;
    private String nationality;
    private String postion;
    private String team;

    public Football(){}

    public Football(String name, int age, int height, String nationality, String postion, String team){
        this.name = name;
        this.age = age;
        this.height = height;
        this.nationality = nationality;
        this.postion = postion;
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}

