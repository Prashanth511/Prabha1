
public class Team {
	private int Id;
	private String Teamname;
	private String Captain;
	private String Rank;
    public int getId()
    {
    	return Id;
    }
    public void setId(int id)
    {
    	Id=id;
    }
	public String getTeamname() {
		return Teamname;
	}
	public void setTeamname(String teamname) {
		Teamname = teamname;
	}
	public String getCaptain() {
		return Captain;
	}
	public void setCaptain(String captain) {
		Captain = captain;
	}
	public String getRank() {
		return Rank;
	}
	public void setRank(String rank) {
		Rank = rank;
	}
}