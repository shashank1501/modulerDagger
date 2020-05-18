package com.example.feature

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.core.CoreApplication
import com.example.core.di.CoreComponent
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class RegisterActivity : AppCompatActivity() {

    @Inject
    lateinit var registerViewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val coreComponent=(applicationContext as CoreApplication).baseComponent
        DaggerRegisterComponent.factory().create(coreComponent).inject(this)
        setContentView(R.layout.activity_register)

        register_btn.setOnClickListener {
            val userName=register_username.text.toString()
            val password=register_password.text.toString()
            if (TextUtils.isEmpty(userName)||TextUtils.isEmpty(password)){
                Toast.makeText(this,"Please enter values",Toast.LENGTH_SHORT).show()
            }else{
                registerViewModel.registerUser(userName,password)
               // startActivity(Intent("android.intent.action.MAIN"))
                finish()
            }
        }
    }
}
