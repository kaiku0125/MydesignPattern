package ProtectProxy_Pattern.Self_Practice;


public class User implements GameUser{
    String UserID;
    String Password;
    String CharacterName;
    int Attack = 10;
    int Health = 100;

    @Override
    public void setUserID(String UserID) {
        this.UserID = UserID;
    }
    @Override
    public void setPassword(String Password) {
        this.Password = Password;
    }
    @Override
    public void setCharacterName(String CharacterName) {
        this.CharacterName = CharacterName;
    }
    @Override
    public void CharacterAttack_adjust(int Attack) {
        this.Attack = Attack;
    }
    @Override
    public void CharacterHealth_adjust(int Health) {
        this.Health = Health;
    }
    @Override
    public void removeAccount(){
        System.out.println("刪除帳號");
    }
    @Override
    public String getUserID() {
        return UserID;
    }
    @Override
    public String getPassword() {
        return Password;
    }
    @Override
    public String getCharacterName() {
        return CharacterName;
    }
    @Override
    public int getCharacterAttack() {
        return Attack;
    }
    @Override
    public int getCharacterHealth() {
        return Health;
    }
  
}
