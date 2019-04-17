/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dao.PersonDao;
import dao.StudentDao;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import pojo.Person;
import pojo.Student;

/**
 *
 * @author nicolaenastas
 */
public class ProcessResponse {

    public String processResponse() {
        PersonDao personDao = new PersonDao();
        List<Person> persons = personDao.getAll();
        Gson gson = new Gson();
        String jSon = gson.toJson(persons);
        return jSon;
    }

    public String processResponseFilter() {
        PersonDao personDao = new PersonDao();
        Person person ;
        Map<String,String> hashMap = new HashMap<>();
        List<Person> persons = personDao.getAll();
       // List<Map> newList = new ArrayList<>();
       List<String> newList = new ArrayList<>();
        for(Object prs: persons){
            person = (Person) prs;
            int id = person.getId();
            String name = "";
            if(person.getName().startsWith("\"")){
                    name = person.getName().substring(1, person.getName().length()-1); 
            }else{
                name = person.getName();
            }
            String general = String.valueOf(id)+","+ name;
           // hashMap.put(String.valueOf(id), name);
            newList.add(general);
        }
        //newList.add(hashMap);
        
        Gson gson = new Gson();
        String jSon = gson.toJson(newList);
        return jSon;
    }

    public int createPerson(String json) {
        Student student = null;
        StudentDao studetnDao = new StudentDao();
        JsonParser parser = new JsonParser();
        JsonElement jsonTree = parser.parse(json);

        if (jsonTree.isJsonObject()) {
            JsonObject jsonObject = jsonTree.getAsJsonObject();

            student = new Student();
            student.setName(jsonObject.getAsJsonPrimitive("name").toString());
            student.setAddress(jsonObject.getAsJsonPrimitive("address").toString());
            student.setPhone(jsonObject.getAsJsonPrimitive("phone").toString());
            student.setEmail(jsonObject.getAsJsonPrimitive("email").toString());
        }

        int result = studetnDao.insertStudent(student.getName(), student.getAddress(), student.getPhone(), student.getEmail());

        return result;
    }
    
    
    public String findById(int id){
        PersonDao personDao = new PersonDao();
        Person person = personDao.findById(id);
        Gson gson = new Gson();
        String jSon = gson.toJson(person);
        return jSon;
    }

    public void deltePerson(int id) {
        StudentDao studetnDao = new StudentDao();
        studetnDao.deleteStudent(id);
    }

}
