import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String jsonText = readString("employee.json");
        List<Employee> list = jsonToList(jsonText);
        list.forEach(System.out::println);

    }

    private static String readString(String fileName) {
        String json = null;
        StringBuilder stringBuilder = new StringBuilder();
        String str;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str);
            }
            json = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

    private static List<Employee> jsonToList(String jsonText) {
        List<Employee> employees =
                new Gson().fromJson(jsonText, new TypeToken<List<Employee>>(){}.getType());
        return employees;
        }
    }
