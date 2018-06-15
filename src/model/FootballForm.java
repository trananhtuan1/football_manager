package model;

public class FootballForm {
    private int id;
    private String name;
    private int age;
    private int height;
    private String nationality;
    private String postion;
    private String teamName;

    public FootballForm(){}

    public FootballForm(String name, int age, int height, String nationality, String postion, String teamName){
        this.name = name;
        this.age = age;
        this.height = height;
        this.nationality = nationality;
        this.postion = postion;
        this.teamName = teamName;
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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}

