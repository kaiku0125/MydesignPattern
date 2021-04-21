package ProtectProxy_Pattern.Self_Practice;

public interface GameUser {
    public void setUserID(String UserID);
    public void setPassword(String Password);
    public void setCharacterName(String CharacterName);
    public void CharacterAttack_adjust(int Attack);
    public void CharacterHealth_adjust(int Health);
    public void removeAccount();

    public String getUserID();
    public String getPassword();
    public String getCharacterName();
    public int getCharacterAttack();
    public int getCharacterHealth();
}


