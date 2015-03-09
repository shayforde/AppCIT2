package project.dnet3.appcit;

import android.app.Activity;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);
      /*  if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
*/
        Log.i("CIT APP ", "we's here in onCreate");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.fragment_main, container, false);

            Button button1 = (Button) v.findViewById(R.id.button1);
            button1.setOnClickListener(this);

            Button button2 = (Button) v.findViewById(R.id.button2);
            button2.setOnClickListener(this);

            Button button3 = (Button) v.findViewById(R.id.button3);
            button3.setOnClickListener(this);

            Button button4 = (Button) v.findViewById(R.id.button4);
            button4.setOnClickListener(this);

            Button button5 = (Button) v.findViewById(R.id.button5);
            button5.setOnClickListener(this);

            Button button6 = (Button) v.findViewById(R.id.button6);
            button6.setOnClickListener(this);

            Button button7 = (Button) v.findViewById(R.id.button7);
            button7.setOnClickListener(this);

            Button button8 = (Button) v.findViewById(R.id.button8);
            button8.setOnClickListener(this);

            return v;
        }

        @Override
        public void onClick(View v) {

            //do what you want to do when button is clicked
            switch (v.getId()) {
                case R.id.button1:
                    //    Log.i("CIT App", "Button 1 has been pressed");
                    Toast.makeText( getActivity(), R.string.button1, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button2:
                    //switchFragment(SettingsFragment.TAG);
                    Toast.makeText( getActivity(), R.string.button2, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.button3:
                    Log.i("CIT App", "Button 1 has been pressed");

                    // Create an instance of Fragment1
           //         CitPortal firstFragment = new CitPortal();

                    // In case this activity was started with special instructions from an Intent,
                    // pass the Intent's extras to the fragment as arguments
             //       firstFragment.setArguments(getActivity().getIntent().getExtras());

                    // Add the fragment to the 'fragment_container' FrameLayout
                    //        getActivity().getSupportFragmentManager().beginTransaction()
                    //                .add(R.id.fragment_mycitportal, firstFragment).commit();

                    Toast.makeText( getActivity(),  R.string.button3, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button4:
                    //switchFragment(SettingsFragment.TAG);
                    Toast.makeText( getActivity(),  R.string.button4, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.button5:
                    Log.i("CIT App", "Button 1 has been pressed");
                    Toast.makeText( getActivity(),  R.string.button5, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button6:
                    //switchFragment(SettingsFragment.TAG);
                    Toast.makeText( getActivity(),  R.string.button6, Toast.LENGTH_SHORT).show();
                    break;

                case R.id.button7:
                    Log.i("CIT App", "Button 1 has been pressed");
                    Toast.makeText( getActivity(),  R.string.button7, Toast.LENGTH_SHORT).show();
                    break;
                case R.id.button8:
                    //switchFragment(SettingsFragment.TAG);
                    Toast.makeText( getActivity(),  R.string.button8, Toast.LENGTH_SHORT).show();
                    break;
                default:
            }
        }
    }
}


/*
package project.dnet3.appcit;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {
// please work now

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
*/