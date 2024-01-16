package com.kutaydem.hesap_makinesi.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.kutaydem.hesap_makinesi.R;

public class MainActivity extends AppCompatActivity {

    private EditText editTxtBirinciSayi, editTxtIkinciSayi;
    private TextView txtSonuc;
    private String birinciSayi, ikinciSayi;
    private int s1, s2, sonuc;
    private Hesapla hesapla;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitymain);

        editTxtBirinciSayi= findViewById(R.id.editTxtBirinciSayi);
        editTxtIkinciSayi= findViewById(R.id.editTxtIkinciSayi);
        txtSonuc= findViewById(R.id.txtSonuc);


    }
    @SuppressLint("NonConstantResourceId")
    public void btnHesapla(View v) {
        birinciSayi= editTxtBirinciSayi.getText().toString();
        ikinciSayi= editTxtIkinciSayi.getText().toString();

        if(!TextUtils.isEmpty(birinciSayi) || !TextUtils.isEmpty(ikinciSayi)){
            s1= Integer.valueOf(birinciSayi);    //İçindeki değeri integera çevirir
            s2= Integer.valueOf(ikinciSayi);
            hesapla = new Hesapla(s1, s2);

            switch(v.getId()){
                case R.id.btnTopla:
                    sonuc= hesapla.sonucuGonder("+");
                    break;

                case R.id.btnCikar:
                    sonuc= hesapla.sonucuGonder("-");
                    break;

                case R.id.btnCarpma:
                    sonuc= hesapla.sonucuGonder("-");
                    break;

                case R.id.btnBolme:
                    sonuc= hesapla.sonucuGonder("/");
                    break;
            }
            txtSonuc.setText("Sonuc" + sonuc);
        } else
            txtSonuc.setText("Girilen Degerler Bos Olamaz!");
    }
}
