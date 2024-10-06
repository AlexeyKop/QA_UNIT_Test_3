package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

/**
 Задание No7
 Добавьте класс UserRepository для управления пользователями.
 В этот класс должен быть включен метод addUser, который добавляет пользователя в систему,
 если он прошел аутентификацию. Покройте тестами новую функциональность
 */
public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();

    public void addUser(User user) {
       //Добавление пользователей в систему
        if (user.isAuthenticate) {
            data.add(user);
        }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    // разлогинивает всех пользователей в системе
    public void logoutAll(){
        for (int i = 0; i < data.size(); i++){
            data.get(i).isAuthenticate = false;
        }
    }

}