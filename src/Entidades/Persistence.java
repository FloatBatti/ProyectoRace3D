
package Entidades;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Persistence <T> {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    BufferedWriter bufferedWriter = null;
    BufferedReader bufferedReader = null;

    public void saveObject (T object, String rute){

        File file = new File(rute);

        try {

            bufferedWriter = new BufferedWriter(new FileWriter(file));
            gson.toJson(object, object.getClass(), bufferedWriter);


        }
        catch (IOException e){

            e.printStackTrace();
        }
        finally {

            if (bufferedWriter != null){

                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public T loadObject (Class objectClass, String rute){

        File file = new File(rute);

        try {

            bufferedReader = new BufferedReader(new FileReader(file));

            return (T) gson.fromJson(bufferedReader, objectClass);
        }
        catch (IOException e){

            e.printStackTrace();
        }
        finally {

            if (bufferedWriter != null){

                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return null;
    }

    public void saveList (List<T> list, String rute){

        File file = new File(rute);

        try {

            bufferedWriter = new BufferedWriter(new FileWriter(file));
            gson.toJson(list, list.getClass(), bufferedWriter);


        }
        catch (IOException e){

            e.printStackTrace();
        }
        finally {

            if (bufferedWriter != null){

                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public List<T> loadList(String rute, Class<T> classList) {

        File file = new File(rute);

        List<T> list = new ArrayList<>();

        Type collectionType = TypeToken.getParameterized(List.class, classList).getType();

        try {

            bufferedReader = new BufferedReader(new FileReader(file));

            list = gson.fromJson(bufferedReader, collectionType);

        }
        catch (IOException e){

            e.printStackTrace();
        }
        finally {

            if (bufferedWriter != null){

                try {

                    bufferedWriter.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

}

