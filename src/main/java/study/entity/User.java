package study.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Administrator on 2017/9/21.
 */
public class User {
    @JsonProperty(value = "user_name")
    private String userName;
    @JsonProperty(value = "pass_word")
    private String passWord;
    private int id;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
