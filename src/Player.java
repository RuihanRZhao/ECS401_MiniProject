public record Player (String Name, char Symbol){
    public Player(String Name, char Symbol){
        this.Name = Name;
        this.Symbol=Symbol;
    }
    public String Name(){
        return Name;
    }
    public char Symbol(){
        return Symbol;
    }
}
