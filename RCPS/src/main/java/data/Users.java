package data;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Users {
    private static List<Usuario> usuarios = new ArrayList<Usuario>();
    private static List<Usuario> LogIn = new ArrayList<Usuario>();

    private Gson gson = new Gson();

    public void addUser(Usuario user){
        usuarios.add(user);
        saveUsersToJson();
    }

    public void saveUsersToJson (){
        try (FileWriter writer = new FileWriter("users.json")){
            gson.toJson(usuarios,writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List <Usuario> loadUsersFromJson(){
        try (FileReader reader = new FileReader ("users.json")){
            Type userListType = new TypeToken<List<Users>>(){}.getType();
            return gson.fromJson(reader,userListType);
        }catch (IOException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
