package accountServer;

/**
 * Created by sgrimanov on 06.12.2016.
 */
public class AccountServer implements AccountServerI {

    private int userCount;
    public int userLimit = 10;


    public AccountServer(){
        this.userCount = 0;

    }

    @Override
    public void addNewUser() {
        userCount += 1;

    }

    @Override
    public void removeUser() {
        userCount -= 1;
    }

    @Override
    public int getUsersLimit() {
        return userLimit;
    }

    @Override
    public void setUsersLimit(int usersLimit) {
        this.userLimit = usersLimit;
    }

    @Override
    public int getUsersCount() {
        return userCount;
    }
}
