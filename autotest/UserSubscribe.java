package ua.org.autotest;

import java.util.Random;

public class UserSubscribe {
    String email;
    String first_name;
    String last_name;
    String insta;
    int cook_level;
    String city;
    String country;
    boolean flag[];
    static int number;
    Random rand = new Random();

    public UserSubscribe(){

        email = "emailautotestfirst" + number + "@i.ua";
        first_name = "name" + number;
        last_name  = "lastname" + number;
        insta = "insta" + number;
        cook_level = rand.nextInt()*3;
        city = "city " + number;
        country = "country " + number;
        flag = new boolean[8];
        for(int i = 0; i < 8; i++){
            flag[i] = rand.nextBoolean();
        }
        number ++;
    };




}
