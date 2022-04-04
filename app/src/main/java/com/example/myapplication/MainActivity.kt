package com.example.myapplication

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //XML元件
        val ed_name = findViewById<EditText>(R.id.ed_name)
        val tv_text = findViewById<TextView>(R.id.tv_text)
        val btn_scissor = findViewById<RadioButton>(R.id.btn_scissor)
        val btn_stone = findViewById<RadioButton>(R.id.btn_stone)
        val btn_paper = findViewById<RadioButton>(R.id.btn_paper)
        val btn_mora = findViewById<Button>(R.id.btn_mora)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_winner = findViewById<TextView>(R.id.tv_winner)
        val tv_mmora = findViewById<TextView>(R.id.tv_mmora)
        val tv_cmora = findViewById<TextView>(R.id.tv_cmora)

        btn_mora.setOnClickListener{
            //判斷玩家有沒有輸入名子，沒有就亮紅字
            if (ed_name.length() < 1 ){
                tv_text.text = "請輸入玩家姓名!"
                tv_text.setTextColor(android.graphics.Color.RED)
                return@setOnClickListener
            }
            //取出玩家姓名
            val playerName = ed_name.text
            //設定亂數
            val comMora = (Math.random() * 3).toInt()
            //取出玩家出的拳
            val playerMoraText = when{
                btn_scissor.isChecked -> "剪刀"
                btn_paper.isChecked ->"布"
                else ->"石頭"
            }
            //決定電腦出的拳
            val comMoraText = when(comMora){
                0 -> "剪刀"
                1 -> "石頭"
                else -> "布"
            }
            //顯示結果
            tv_name.text = "名子\n$playerName"
            tv_mmora.text = "我方出拳\n$playerMoraText"
            tv_cmora.text = "電腦出拳\n$comMoraText"
            //判斷結果
            when{
                btn_scissor.isChecked && comMora == 2 ||
                        btn_paper.isChecked && comMora == 1 ||
                        btn_stone.isChecked && comMora == 0
                ->{
                    tv_winner.text = "勝利者\n$playerName"
                    tv_text.text = "你獲勝了!"
                }
                btn_scissor.isChecked && comMora == 1 ||
                        btn_paper.isChecked && comMora == 0 ||
                        btn_stone.isChecked && comMora == 2
                ->{
                    tv_winner.text= "勝利者\n電腦"
                    tv_text.text = "你輸了"
                }
                else ->{
                    tv_winner.text = "勝利者\n平手"
                    tv_text.text = "平手，在一次ㄅ"
                }
            }


        }


    }



}

