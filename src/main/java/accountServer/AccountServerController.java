package accountServer;

/**
 * Created by sgrimanov on 06.12.2016.
 */
public class AccountServerController implements AccountServerControllerMBean{

    private final AccountServer accountServer;

    public AccountServerController(AccountServer accountServer){
        this.accountServer = accountServer;
    }

    @Override
    public int getUsers() {
        return accountServer.getUsersCount();
    }

    @Override
    public int getUsersLimit() {
        return accountServer.getUsersLimit();
    }

    @Override
    public void SetUsersLimit(int usersLimit) {
        accountServer.setUsersLimit(usersLimit);
    }
}
