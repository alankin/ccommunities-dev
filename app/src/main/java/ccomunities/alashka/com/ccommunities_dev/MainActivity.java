package ccomunities.alashka.com.ccommunities_dev;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import ccomunities.alashka.com.ccommunities_dev.Model.Community;
import ccomunities.alashka.com.ccommunities_dev.Fragment.PublicationFragment;
import ccomunities.alashka.com.ccommunities_dev.Fragment.UserFragment;
import ccomunities.alashka.com.ccommunities_dev.Adapter.ViewPagerAdapter;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.mipmap.tab_publication,
            R.mipmap.tab_user
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        //_createComunity();

    }

    private void _createComunity(){
        Community community = new Community();
        community.setDescription("Comunidad cristiana");
        community.setLocation("Villa Belen");
        community.setName("Comunidad Cristiana Belen");
        community.setResponsibleId("1");
        community.save();
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PublicationFragment(), "PUBLICATION");
        adapter.addFragment(new UserFragment(), "USER");

        viewPager.setAdapter(adapter);
    }
}
