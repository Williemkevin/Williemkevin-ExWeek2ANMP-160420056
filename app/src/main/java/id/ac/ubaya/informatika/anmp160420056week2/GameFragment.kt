package id.ac.ubaya.informatika.anmp160420056week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlin.random.Random

class GameFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }
    var calculate = 0
    var score = 0

    fun randomNumber(){
        var num1 = Random.nextInt(1, 99)
        var num2 = Random.nextInt(1, 99)
        calculate = num1 + num2

        txtNum1.text = num1.toString()
        txtNum2.text = num2.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        randomNumber()
        btnSubmit.setOnClickListener {
            if(txtAnswer.text.toString() == calculate.toString()){
                score += 1
                randomNumber()
                txtAnswer.setText("")
            } else{
                val action = GameFragmentDirections.actionResultFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }
        if (arguments != null){
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName
            txtTurn.text = "$playerName's Turn"
        }
    }

}