package felipediaz.wsdatabiertos.adapters.models;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import felipediaz.wsdatabiertos.R;


public class CaracteristicasAlcaldia extends AppCompatActivity {

    private ImageView imagen;
    private TextView codigoDaneMunicipio;
    private TextView correocontactenos;
    private TextView direcciN;
    private TextView nit;
    private TextView nombreAlcalde;
    private TextView nombreMunicipio;
    private TextView portalweb;
    private TextView telefonoDeContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caracteristicas_alcaldia);

        imagen = (ImageView) findViewById(R.id.img_card_detalle);
        codigoDaneMunicipio = (TextView) findViewById(R.id.txt_codigom);
        correocontactenos = (TextView) findViewById(R.id.txt_correo);
        direcciN = (TextView) findViewById(R.id.txt_ubicacion);
        nit = (TextView) findViewById(R.id.txt_nit);
        nombreAlcalde = (TextView) findViewById(R.id.txt_alcalde);
        nombreMunicipio = (TextView) findViewById(R.id.txt_municipio);
        portalweb = (TextView) findViewById(R.id.txt_portal);
        telefonoDeContacto = (TextView) findViewById(R.id.txt_contacto);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null) {


            codigoDaneMunicipio.setText((String) bundle.get("CODIGO DANE MUNICIPIO"));
            correocontactenos.setText((String) bundle.get("CORREOCONTACTENOS"));
            direcciN.setText((String) bundle.get("DIRECCIÓN"));
            nit.setText((String) bundle.get("NIT"));
            nombreAlcalde.setText((String) bundle.get("NOMBRE ALCALDE"));
            nombreMunicipio.setText((String) bundle.get("NOMBRE MUNICIPIO"));
            portalweb.setText((String) bundle.get("PORTAL WEB"));
            telefonoDeContacto.setText((String) bundle.get("TELEFONO DE CONTACTO"));

            switch ((String) bundle.get("NOMBRE MUNICIPIO")){
                case "FUNES":
                    imagen.setImageResource(R.drawable.funes);
                    break;
                case "MALLAMA":
                    imagen.setImageResource(R.drawable.mallama);
                    break;
                case "BARBACOAS":
                    imagen.setImageResource(R.drawable.barbacoas);
                    break;
                case "EL ROSARIO":
                    imagen.setImageResource(R.drawable.el_rosario);
                    break;
                case "ILES":
                    imagen.setImageResource(R.drawable.iles);
                    break;
                case  "GUAITARILLA":
                    imagen.setImageResource(R.drawable.guaitarilla);
                    break;
                case "CUASPUD":
                    imagen.setImageResource(R.drawable.cuaspud);
                    break;

                case "CUMBAL":
                    imagen.setImageResource(R.drawable.cumbal);
                    break;
                case "IMUES":
                    imagen.setImageResource(R.drawable.la_tola);
                    break;
                case  "EL PEÑOL":
                    imagen.setImageResource(R.drawable.el_rosario);
                    break;
                case  "FRANCISCO PIZARRO":
                    imagen.setImageResource(R.drawable.mallama);
                    break;
                case  "IPIALES":
                    imagen.setImageResource(R.drawable.ipiales);
                    break;
                case  "LA TOLA":
                    imagen.setImageResource(R.drawable.la_tola);
                    break;
                case "ANCUYA":
                    imagen.setImageResource(R.drawable.ancuya);
                    break;

            }

        }
    }
}
