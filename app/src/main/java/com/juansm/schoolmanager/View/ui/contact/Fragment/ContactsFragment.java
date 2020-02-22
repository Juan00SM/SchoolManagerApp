package com.juansm.schoolmanager.View.ui.contact.Fragment;

import androidx.appcompat.view.menu.MenuBuilder;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.juansm.schoolmanager.R;
import com.juansm.schoolmanager.View.ui.contact.ContactsViewModel;
import com.juansm.schoolmanager.View.ui.contact.Adapter.TabsAdapterContact;

import java.util.ArrayList;
import java.util.List;

public class ContactsFragment extends Fragment {

    String TAG = "SchoolManager/Fragments/ContactsFragment";
    private ContactsViewModel contactsViewModel;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        Log.d(TAG, "Entrando en onCreateView...");

        View root = inflater.inflate(R.layout.fragment_contacts, container, false);

        this.viewPager = root.findViewById(R.id.viewpager_contacts);
        this.tabLayout = root.findViewById(R.id.tablayout_contacts);

        this.setupViewPagerWithAdapter();
        this.tabLayout.setupWithViewPager(this.viewPager);

        setHasOptionsMenu(true);
        return root;
    }

    private void setupViewPagerWithAdapter() {

        List<String> title_tabs = new ArrayList<>();
        title_tabs.add(getString(R.string.title_tab_1_contacts));
        title_tabs.add(getString(R.string.title_tab_2_contacts));

        TabsAdapterContact adapter = new TabsAdapterContact(getChildFragmentManager(), title_tabs);
        this.viewPager.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        Log.d(TAG, "Entrando en onCreateOptionsMenu...");

        menu.clear();
        inflater.inflate(R.menu.options_contacts_menu,menu);
        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d(TAG, "Entrando en onOptionsItemSelected...");

        switch (item.getItemId()){
            case R.id.menu_help_contact:
                Log.d(TAG, "help");
                return true;
            case R.id.menu_about:
                Log.d(TAG, "about");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "Entrando en onActivityCreated...");

        contactsViewModel = ViewModelProviders.of(this).get(ContactsViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG, "Ejecutando onStart...");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG, "Ejecutando onResume...");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(TAG, "Ejecutando onStop...");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG, "Ejecutando onPause...");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Ejecutando onDestroy...");
    }
}
