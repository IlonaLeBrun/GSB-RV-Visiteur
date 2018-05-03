package fr.gsb.gsbvisiteur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import fr.gsb.gsbvisiteur.entites.RapportVisite;
import fr.gsb.gsbvisiteur.entites.Visiteur;
import fr.gsb.gsbvisiteur.modele.ModeleGsb;
import fr.gsb.gsbvisiteur.technique.Session;

public class ListeRvActivity extends AppCompatActivity {

    TextView textView8 ;
    ListView listeRv ;
    Integer numero ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_rv);

        //transtypage pour les views qui deviennent un textview
        textView8 = (TextView) findViewById( R.id.textView8 );
        listeRv = (ListView) findViewById( R.id.listeRv );

        Visiteur leVisiteur = Session.getSession().getLeVisiteur() ;

        Bundle paquet = this.getIntent().getExtras() ;
        int mois = Integer.parseInt( paquet.getString("mois") ) ;
        int annee = Integer.parseInt( paquet.getString("annee") ) ;

        //liste des rapports de visite
        List<RapportVisite> rvs = ModeleGsb.getInstance().getRapportsVisites( leVisiteur, mois, annee );

        ArrayAdapter<RapportVisite> adapterRv = new ArrayAdapter<RapportVisite>( this,android.R.layout.simple_list_item_1,rvs );

        listeRv.setAdapter( adapterRv );

    }

/*    public void visualiserUnRv(View vueVisuRvActivity) {

        Intent intention = new Intent(this, VisuRvActivity.class);

        Bundle paquet = new Bundle();
        paquet.putString( "id", numero.getSelectedItem().toString() );

        intention.putExtras( paquet );

        startActivity(intention);

    }*/

}