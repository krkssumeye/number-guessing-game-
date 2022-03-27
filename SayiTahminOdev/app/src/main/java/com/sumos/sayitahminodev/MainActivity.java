package com.sumos.sayitahminodev;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText sayi;
    TextView tahmin_durum, tahminSayisi;
    Button gonder,tekrar;    //xml kısmında kullandığımız komponentlere isim verdik
    Random r = new Random();
    int rand,girilenDeger,deneme_sayı;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sayi = (EditText) findViewById(R.id.sayi);   //komponentlerin idelerine göre verdiğimiz iismleri ideleriyle eşleştirdik
        tahmin_durum = (TextView) findViewById(R.id.tahmin);
        gonder = (Button) findViewById(R.id.gonder);
        tahminSayisi = (TextView) findViewById(R.id.deneme);
        tekrar = (Button) findViewById(R.id.tekrar);
        tekrar.setEnabled(false);
        rand = Rastgele();
        deneme_sayı = 0;
        gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deneme_sayı++;
                girilenDeger = Integer.parseInt(sayi.getText().toString());
                if(girilenDeger<rand){
                    tahmin_durum.setText("daha büyük bir sayı bir sayı deneyin?");  // kullanıcın girdiği sayının doğru tahmin olup olmadığını kontrol edip,
                    tahminSayisi.setText(Integer.toString(deneme_sayı)+". tahmin"); // eğer girilen sayıdan büyük ve küçük olma durumunu kontrol ettik.
                } else if(girilenDeger>rand){
                    tahmin_durum.setText("daha küçük bir sayı deneyin!");
                    tahminSayisi.setText(Integer.toString(deneme_sayı)+". tahmin");
                } else {
                    tahmin_durum.setText("Harikasın! Doğru Bildin!");
                    tahminSayisi.setText(Integer.toString(deneme_sayı)+". tahmin");
                    gonder.setEnabled(false);
                    tekrar.setEnabled(true);
                }
            }
        });

        tekrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rand = Rastgele();
                deneme_sayı = 0;              //tahmin doğru bilindikten sonra oyunu yeniden oynamak için buton tanımlanır.
                tahmin_durum.setText("");
                tahminSayisi.setText("");
                tekrar.setEnabled(false);
                gonder.setEnabled(true);
            }
        });

    }

    public int Rastgele(){
        return r.nextInt(100);  //100 sayıdan seçmesini sağladık
    }

}