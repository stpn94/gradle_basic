package gradle_basic_dto;

public class Title {
	private int tno;
	private String tname;
	public Title() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Title(int no) {
		this.tno = no;
	}


	public Title(int no, String name) {
		this.tno = no;
		this.tname = name;
	}


	public int gettNo() {
		return tno;
	}


	public void settNo(int no) {
		this.tno = no;
	}


	public String gettName() {
		return tname;
	}


	public void settName(String name) {
		this.tname = name;
	}


	@Override
	public String toString() {
		return String.format("Title [no=%s, name=%s]", tno, tname);
	}
	
	
	
}
