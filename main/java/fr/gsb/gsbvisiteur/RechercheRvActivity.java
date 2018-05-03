package fr.gsb.gsbvisiteur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RechercheRvActivity extends AppCompatActivity {

    Spinner spMois ;
    Spinner spAnnee ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche_rv);

        spMois = ( Spinner ) findViewById( R.id.spMois ) ;
        spAnnee = ( Spinner ) findViewById( R.id.spAnnee ) ;

        String [ ] mois = { "01", "02","03", "04", "05", "06", "07", "08", "09", "10", "11", "12" } ;
        String [ ] annees = { "2017", "2018" } ;

        ArrayAdapter<String> aaMois = new ArrayAdapter<String>( this , android.R.layout.simple_spinner_item, mois ) ;
        ArrayAdapter<String> aaAnnee = new ArrayAdapter<String>( this , android.R.layout.simple_spinner_item, annees ) ;

        aaMois.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        aaAnnee.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );


        spMois.setAdapter( aaMois );
        spAnnee.setAdapter( aaAnnee );

    }

    public void validerMois(View vue){


        Intent intention = new Intent( this , ListeRvActivity.class ) ;

        Bundle paquet = new Bundle();
        paquet.putString( "mois", spMois.getSelectedItem().toString() );
        paquet.putString( "annee", spAnnee.getSelectedItem().toString() );

        intention.putExtras( paquet );

        startActivity( intention );
    }
}
