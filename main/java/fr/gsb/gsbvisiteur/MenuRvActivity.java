package fr.gsb.gsbvisiteur;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;


import fr.gsb.gsbvisiteur.technique.Session;

public class MenuRvActivity extends AppCompatActivity {

    TextView tvIdentite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_rv);

        tvIdentite = (TextView) findViewById(R.id.tvIdentite);

        String identite = "\n Utilisateur : " + Session.getSession().getLeVisiteur().getPrenom() + " " + Session.getSession().getLeVisiteur().getNom() + " \n" ;
        tvIdentite.setText(identite);
    }

    public void consultationRv(View vueMenuActivity) {


        Intent intention = new Intent(this, RechercheRvActivity.class);
        startActivity(intention);

    }


    public void saisieRv(View vueMenuActivity) {


        Intent intention = new Intent(this, SaisieRvActivity.class);
        startActivity(intention);

    }
}
