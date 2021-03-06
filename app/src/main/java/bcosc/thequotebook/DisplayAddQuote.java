package bcosc.thequotebook;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class DisplayAddQuote extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_add_quote);

        final EditText inputQuote = (EditText) findViewById(R.id.editQuote);
        final EditText inputName = (EditText) findViewById(R.id.editName);

        Button sendToQuoteBook = (Button) findViewById(R.id.SaveButton);
        sendToQuoteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityResult = new Intent(getApplicationContext(), QuoteBook.class);
                activityResult.putExtra("newQuote", inputQuote.getText().toString());
                Log.d("QuoteBook-OnClick", "Added new quote");
                activityResult.putExtra("newName", inputName.getText().toString());
                Log.d("QuoteBook-OnClick", "Added new name");
                setResult(RESULT_OK, activityResult);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_add_quote, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public String saveQuote(View v) {
        EditText userInputText = (EditText) findViewById(R.id.editQuote);
        String newQuote = userInputText.getText().toString();
        Log.d("DERP", newQuote);
        return newQuote;
    }

}
