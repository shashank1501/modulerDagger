package com.example.daggermodules

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.core.CoreApplication
import com.example.core.di.CoreComponent
import com.example.daggermodules.di.DaggerAppComponent
import com.example.feature.RegisterActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainViewModel:MainViewModel

    lateinit var newAccountBtn:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val coreComponent=(applicationContext as CoreApplication).baseComponent
   DaggerAppComponent.factory().create(coreComponent).inject(this)
        setContentView(R.layout.activity_main)

        newAccountBtn=findViewById(R.id.new_account_text)

        login_btn.setOnClickListener {

            val userName=login_username.text.toString()
            val password=login_password.text.toString()
            if(mainViewModel.loginUser(userName,password)){
              val intent=Intent(this,UserActivity::class.java)
                intent.putExtra("user",mainViewModel.username)
                startActivity(intent)
            }else{
                Toast.makeText(this,"user found try again",Toast.LENGTH_SHORT).show()
            }
        }

        newAccountBtn.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }

    }


}
