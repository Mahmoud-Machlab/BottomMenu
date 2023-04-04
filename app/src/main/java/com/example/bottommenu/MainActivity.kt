package com.example.bottommenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.bottommenu.databinding.ActivityMainBinding
import com.example.bottommenu.databinding.FragmentHomeBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomBar.setOnItemSelectedListener { item: MenuItem ->

            val fragment = when(item.itemId){
                R.id.action_home -> HomeFragment()
                R.id.action_search -> SearchFragment()
                R.id.action_mail -> MailFragment()
                R.id.action_favorits -> FavoritsFragment()
                else -> Fragment()
            }

            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(binding.fragmentContainerView.id, fragment)
            transaction.commit()

            true
        }
    }
}