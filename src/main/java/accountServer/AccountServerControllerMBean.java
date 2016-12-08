package accountServer;

/**
 * Created by sgrimanov on 06.12.2016.
 */
@SuppressWarnings("UnusedDeclaration")
public interface AccountServerControllerMBean {

    int getUsers();

    int getUsersLimit();

    void SetUsersLimit(int usersLimit);
}
