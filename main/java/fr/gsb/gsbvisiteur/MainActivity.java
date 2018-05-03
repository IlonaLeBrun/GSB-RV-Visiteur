package fr.gsb.gsbvisiteur;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import fr.gsb.gsbvisiteur.technique.Session;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import fr.gsb.gsbvisiteur.technique.Session;

public class MainActivity extends AppCompatActivity {

    EditText etMatricule ;
    EditText etMdp ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etMatricule = (EditText)findViewById(R.id.etMatricule);
        etMdp = (EditText)findViewById(R.id.etMdp);

    }

    public void valider(View vueAuthentification){

        String matricule = etMatricule.getText().toString() ;
        String mdp = etMdp.getText().toString() ;

        boolean ok = Session.ouvrir(matricule , mdp);

        if( ok ){
            System.out.println( " Connexion réussie " );

            Intent intention = new Intent( this , MenuRvActivity.class ) ;
            startActivity( intention );

        }
        else{
            System.out.println( " Echec à la connexion. Recommencez... " );
            Toast.makeText( this, "Login ou mot de passe incorrect", Toast.LENGTH_LONG ).show() ;
            etMatricule.setText("");
            etMdp.setText("");
        }


    }

    public void annuler(View vueAuthentification){

        etMatricule.setText( "" );
        etMdp.setText( "" );

    }

}