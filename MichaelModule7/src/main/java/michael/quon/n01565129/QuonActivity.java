// Michael Quon N01565129
package michael.quon.n01565129;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class QuonActivity extends AppCompatActivity
        implements NavigationBarView.OnItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.MicBottomNavigationView);
        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.Michome);
    }

    HomeFragment homeFragment = new HomeFragment();
    PersonFragment personFragment = new PersonFragment();
    SettingsFragment settingsFragment = new SettingsFragment();
    MichaelFragment michaelFragment = new MichaelFragment();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.MicAction_settings) {
            Intent intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.Michome) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MicFlFragment, homeFragment)
                    .commit();
            return true;
        }

        if (itemId == R.id.Micperson) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MicFlFragment, personFragment)
                    .commit();
            return true;
        }

        if (itemId == R.id.Micsettings) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MicFlFragment, settingsFragment)
                    .commit();
            return true;
        }

        if (itemId == R.id.Michael) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.MicFlFragment, michaelFragment)
                    .commit();
            return true;
        }

        return false;
    }
}
