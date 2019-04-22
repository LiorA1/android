package com.example.myapplicationconnect3;

import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.GridLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

enum ChipColor{EMPTY, RED, YELLOW};

public class MainActivity extends AppCompatActivity
{

    ChipColor _turn = ChipColor.RED;
    BoardLogic _board = new BoardLogic();
    TextView _Header;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _Header = (TextView) findViewById(R.id.textViewHeader);
    }


    private void insertChip(ImageView i_view, ChipColor i_color)
    {
        i_view.setEnabled(false);
        int xCoord = 0, yCoord = 0;
        String fullName = getResources().getResourceName(i_view.getId());
        String name = fullName.substring(fullName.lastIndexOf("/") + 1);

        // now extract the correct coordianates.
        if(name.equalsIgnoreCase("imageviewtopleft"))
        {
            xCoord = 0;
            yCoord = 0;
        }
        else if(name.equalsIgnoreCase("imageviewtopcenter"))
        {
            xCoord = 0;
            yCoord = 1;
        }
        else if(name.equalsIgnoreCase("imageviewtopright"))
        {
            xCoord = 0;
            yCoord = 2;
        }
        else if(name.equalsIgnoreCase("imageviewmiddleleft"))
        {
            xCoord = 1;
            yCoord = 0;
        }
        else if(name.equalsIgnoreCase("imageviewmiddlecenter"))
        {
            xCoord = 1;
            yCoord = 1;
        }
        else if(name.equalsIgnoreCase("imageviewmiddleright"))
        {
            xCoord = 1;
            yCoord = 2;
        }
        else if(name.equalsIgnoreCase("imageviewbottomleft"))
        {
            xCoord = 2;
            yCoord = 0;
        }
        else if(name.equalsIgnoreCase("imageviewbottomcenter"))
        {
            xCoord = 2;
            yCoord = 1;
        }
        else if(name.equalsIgnoreCase("imageviewbottomright"))
        {
            xCoord = 2;
            yCoord = 2;
        }

        // enter the coordinates to the board.
        if(this._board.insertChip(xCoord, yCoord, i_color))
        {
            // insert succeed.
            //check if won.
            if(this._board.getWinner() == Winner.RED_PLAYER)
            {
                // red player won.
                this._Header.setText("Red Player Won !");
            }
            else if(this._board.getWinner() == Winner.YELLOW_PLAYER)
            {
                // yellow player won.
                this._Header.setText("Yellow Player Won !");
            }
            else
            {
                // a tie.
                // check if full
            }
        }
        else
        {
            // insert doesn't succeed.
            // check if full.
        }

        // graphical show :

        i_view.animate().alpha(0);

        if(i_color == ChipColor.RED)
        {
            i_view.setImageDrawable(getDrawable(R.drawable.red));
        }
        else
        {
            i_view.setImageDrawable(getDrawable(R.drawable.yellow));
        }

        i_view.setY(-480);
        i_view.animate().alpha(1);
        i_view.animate().translationY(0).setDuration(2000);
    }

    private void checkBoard()
    {

    }



    public void onClick(View view)
    {
        int id = view.getId();
        ImageView ImageViewClicked = (ImageView) findViewById(id);

        insertChip(ImageViewClicked, this._turn);

        if(this._turn == ChipColor.YELLOW)
        {
            this._turn = ChipColor.RED;
        }
        else
        {
            this._turn = ChipColor.YELLOW;
        }






    }
}
