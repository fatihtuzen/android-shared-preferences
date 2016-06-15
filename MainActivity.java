package ce.shared_preferences;

// bu uygulama için gereken import nesneleri
import android.content.Context;
import android.content.SharedPreferences;
// import nesneleri buraya kadar

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public SharedPreferences settings;
    public SharedPreferences.Editor settingsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        settings = getSharedPreferences("shared_verilerim", Context.MODE_PRIVATE); // bu nesnemizi nerede tanımlarsak tanımlayalım "shared_verilem" olarak key'imizi aldığımızda kayıtlı veriler varsa onlarada ulaşabiliriz
        // örneğin bu "shared_verilerim" şuan oluşturuldu ve bi putString ile key ve value değeri atadıysak farklı bir Class içerisinde sadece bu nesneyi tekrar tanımlayıp getString methodunu kullanmak yeterli olacaktır
        settingsEditor = settings.edit(); // settingsEditor nesnesi oluşturdukdan sonra bu nesneye hangi Shared Preferences verilerine ulaşmak istiyorsak onu atıyoruz

        Button kaydet_buton = (Button) findViewById(R.id.kaydet_buton);
        final EditText text_degerim = (EditText) findViewById(R.id.yazilan_veri);
        final TextView kaydedilen = (TextView) findViewById(R.id.textView);

        kaydet_buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settingsEditor.putString("text1",text_degerim.getText().toString()); //yazdığımız text1 değeri key olarak istenildiği yerde çağırılabilir örnek olarak kaydedilen.settext içinde kullanılmıştır
                settingsEditor.commit(); // put edilen değişkenler commit edilmezse veriler kaydedilmez bu kısım çok önemli

                kaydedilen.setText(settings.getString("text1","")); // text1 adlı key'in yada anahtar cümlenin içinde bulunan değeri alıyoruz bilinmediği için değer ikinci kısım boş String olarak kalır ve değişken veriye ulaşılır
            }
        });
    }
}
