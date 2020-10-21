# ViewModel 

📄 SecondViewModelActivity

```
package com.example.carajo.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.carajo.R
import com.example.carajo.ViewModel.Sumar
import com.example.carajo.ViewModel.SumarViewModel
import kotlinx.android.synthetic.main.activity_second_view_model.*

class SecondViewModelActivity : AppCompatActivity() {

    var number: Int = 0

    lateinit var sumarViewModel: SumarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_view_model)

        sumarViewModel = ViewModelProviders.of(this).get(SumarViewModel::class.java)


        txtNumber.text = "${number}"
        txtNumberVM.text = "${sumarViewModel.numberX}"


        btnCalculate.setOnClickListener {

            number = Sumar.suma(number)
            txtNumber.text = "${number}"
            sumarViewModel.numberX = Sumar.suma(sumarViewModel.numberX)
            txtNumberVM.text = "${sumarViewModel.numberX}"
        }

    }
}
```

Sumar

```
package com.example.carajo.ViewModel

class Sumar {

    companion object {

        fun suma(number: Int): Int {
            return number + 1
        }
    }
}
```

SumarViewModel

```
package com.example.carajo.ViewModel

import androidx.lifecycle.ViewModel

class SumarViewModel: ViewModel() {

    internal var numberX: Int = 0

}
```


MainActivity

```
package com.example.carajo.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carajo.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSender.setOnClickListener {
            showView()
        }
    }

    fun showView(){
        val myIntent = Intent(this, SecondViewModelActivity::class.java)
        startActivity(myIntent)
    }
}
```


