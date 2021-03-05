package com.example.puzzlecrime.stage2extra

import android.widget.ImageView
import com.example.puzzlecrime.R

class Piece(val fontImgViewId:Int, val backImgViewId:Int) {
}
class pieceInstance{
    companion object{
        val piece1 = Piece(R.drawable.piece1font, R.drawable.piece5back)
        val piece2 = Piece(R.drawable.piece2font, R.drawable.piece4back)
        val piece3 = Piece(R.drawable.piece3font, R.drawable.piece3back)
        val piece4 = Piece(R.drawable.piece4font, R.drawable.piece2back)
        val piece5 = Piece(R.drawable.piece5font, R.drawable.piece1back)
        val piece6 = Piece(R.drawable.piece6font, R.drawable.piece10back)
        val piece7 = Piece(R.drawable.piece7font, R.drawable.piece9back)
        val piece8 = Piece(R.drawable.piece8font, R.drawable.piece8back)
        val piece9 = Piece(R.drawable.piece9font, R.drawable.piece7back)
        val piece10 = Piece(R.drawable.piece10font, R.drawable.piece6back)
    }
}