package accountServer;

/**
 * Created by sgrimanov on 06.12.2016.
 */
public class AccountServer implements AccountServerI {

    private int userCount;
    private int userLimit;

    public AccountServer(int userLimit){
        this.userCount = 0;
        this.userLimit = userLimit;
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
