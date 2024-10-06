package seminars.third.tdd;

public class User {

    String name;
    String password;

    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;

    }

    //3.6. Задание No6
    /*
    Разработайте класс User с методом аутентификации по логину и паролю.
    Метод должен возвращать true, если введенные логин и пароль корректны, иначе false.
    Протестируйте все методы
     */
    public boolean authenticate(String name, String password) {
        if (name.equals(this.name) && password.equals(this.password)){
            isAuthenticate = true;
            return true;
        } else {
            isAuthenticate = false;
            return false;
        }

    }

}