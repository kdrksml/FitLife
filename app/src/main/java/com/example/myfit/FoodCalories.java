package com.example.myfit;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class FoodCalories  extends AppCompatActivity {
    private HashMap _$_findCachedViewById;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_food_calories);
        ListView listview = this.findViewById(R.id.listView);
        boolean var4 = false;
        List list = (List) (new ArrayList());
        TextView calorieText = this.findViewById(R.id.calorieText);
        Button reset = this.findViewById(R.id.reset);
        final TextView value = this.findViewById(R.id.valueCal);
        list.add(new model("Ekmek", "Bir dilim ekmek: 74 kalori", R.drawable.ekmek));
        list.add(new model("Bal", "64 kalori", R.drawable.bal));
        list.add(new model("Kaşar Peyniri", "Bir dilim kaşar peyniri: 85 kalori", R.drawable.kasar));
        list.add(new model("Beyaz Peyniri", "Bir dilim beyaz peynir: 74 kalori", R.drawable.peynir));
        list.add(new model("Yumurta", "Bir adet yumurta: 78 kalori", R.drawable.yumurta));
        list.add(new model("Zeytin", "10 adet zeytin: 50 kalori", R.drawable.zeytin));
        list.add(new model("Yeşil Salata", "1 kase yeşil salata: 25 kalori", R.drawable.yesilsalata));
        list.add(new model("Patates Kızartması", "Bir kase patates kızartması: 312 kalori", R.drawable.patates));
        list.add(new model("Pilav", "Bir kase pilav: 150 kalori", R.drawable.pilav));
        list.add(new model("Kuru Fasulye", "Bir kase kuru fasulye: 230 kalori", R.drawable.kurufasulye));
        list.add(new model("Noodles", "Bir porsiyon noodle: 190 kalori", R.drawable.noodle));
        list.add(new model("Spagetti", "Bir porsiyon spagetti: 220 kalori", R.drawable.spagetti));
        list.add(new model("Kek", "Bir dilim kek: 200 kalori", R.drawable.kek));
        list.add(new model("Pizza", "Bir dilim pizza: 285 kalori", R.drawable.pizza));
        list.add(new model("Kebap", "Bir porsiyon kebap: 300 kalori", R.drawable.kebap));
        list.add(new model("Hamburger", "Bir porsiyon hamburger: 250 kalori", R.drawable.hamburger));
        list.add(new model("Lahmacun", "Bir adet lahmacun: 200 kalori", R.drawable.lahmacun));
        list.add(new model("Tavuk Döner", "Bir porsiyon tavuk döner: 350 kalori", R.drawable.tavukdoner));
        list.add(new model("Kola", "Bir kutu kola: 140 kalori", R.drawable.cola));
        list.add(new model("Havuç", "Bir adet havuç: 41 kalori", R.drawable.havuc));
        list.add(new model("Elma", "Bir adet elma: 52 kalori", R.drawable.elma));
        list.add(new model("Çikolata", "Bir adet çikolata: 230 kalori", R.drawable.cikolata));
        list.add(new model("Portakal", "Bir adet portakal: 62 kalori", R.drawable.portakal));
        listview.setAdapter(new food_adapter(this, R.layout.listview_row, list));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int[] calories = {74, 64, 85, 74, 78, 50, 25, 312, 150, 230, 190, 220, 200, 285, 300, 250, 200, 350, 140, 41, 52, 230, 62};

                int currentCalorie = Integer.parseInt(value.getText().toString());
                int updatedCalorie = currentCalorie + calories[position];
                value.setText(String.valueOf(updatedCalorie));
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                value.setText("0");
            }
        });
    }
}