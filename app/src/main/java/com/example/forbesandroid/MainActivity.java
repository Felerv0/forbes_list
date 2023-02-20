package com.example.forbesandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.example.forbesandroid.adapter.PersonAdapter;
import com.example.forbesandroid.model.Person;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        init();

        recyclerView = findViewById(R.id.rv);

        PersonAdapter adapter = new PersonAdapter(people, LayoutInflater.from(this));
        recyclerView.setAdapter(adapter);
    }

    public void init() {
        people = new ArrayList<>();
        Person person;

        try {
            HSSFWorkbook excelBook = new HSSFWorkbook(getResources().openRawResource(R.raw.data));
            HSSFSheet excelSheet = excelBook.getSheetAt(1);

            for (int i = 2; i < 102; i++) {
                HSSFRow row = excelSheet.getRow(i);
                String str = "flag_" + row.getCell(9).getStringCellValue().split("\\.")[2];
                int res_id = R.drawable.class.getDeclaredField(str).getInt(null);
                person = new Person(row.getCell(1).getStringCellValue(),
                        res_id,
                        row.getCell(2).getStringCellValue());
                people.add(person);
                System.out.println(person);
            }
            excelBook.close();
        }
        catch (IllegalAccessException | NoSuchFieldException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}