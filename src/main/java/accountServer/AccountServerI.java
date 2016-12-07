package accountServer;

/**
 * Created by sgrimanov on 06.12.2016.
 */
public interface AccountServerI {

    void addNewUser();

    void removeUser();

    int getUsersLimit();

    void setUsersLimit(int usersLimit);

    int getUsersCount();
}
