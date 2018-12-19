package spring;

public interface Dao {

	Member selectByEmail(String email);

	void insert(Member newMember);

}
