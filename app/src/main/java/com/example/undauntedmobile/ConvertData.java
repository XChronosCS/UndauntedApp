package com.example.undauntedmobile;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ConvertData {
    @RequiresApi(api = Build.VERSION_CODES.N)
    public List<Pokemon> generate() {
        List<Pokemon> data = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            data = Arrays.asList(mapper.readValue(new File("data.json"), Pokemon[].class));
            System.out.println("\nJSON array to List of objects");
            data.forEach(System.out::println);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
