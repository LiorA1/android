package com.example.myapplicationconnect3;

//enum ChipColor{RED, YELLOW};
enum Winner {TIE, RED_PLAYER, YELLOW_PLAYER}
public class BoardLogic
{
    private Winner _winner = Winner.TIE;
    private ChipColor[][] _Board = new ChipColor[3][3];


    public Winner getWinner()
    {
        return this._winner;
    }

    public boolean isBoardFull()
    {
        boolean result = true;

        for (ChipColor[] row : this._Board)
        {
            for (ChipColor col : row)
            {
                if(col == ChipColor.EMPTY)
                {
                    result = false;
                }
            }
        }

        return result;
    }

    /**
     * This function insert a chip inside the board.
     * I
     * @param i_coordX
     * @param i_coordY
     * @param i_color
     * @return true - If success. else - false.
     */
    public boolean insertChip(int i_coordX, int i_coordY, ChipColor i_color)
    {
        if(_Board[i_coordX][i_coordY] == ChipColor.EMPTY )
        {
            // enter the chip.
            this._Board[i_coordX][i_coordY] = i_color;
            // check for winners.
            if(checkBoard(i_coordX, i_coordY))
            {
                if(this._Board[i_coordX][i_coordY] == ChipColor.RED)
                {
                    this._winner = Winner.RED_PLAYER;
                }
                else
                {
                    this._winner = Winner.YELLOW_PLAYER;
                }
            }
            else
            {
                // no winner in this round.

            }


            return true;
        }
        else
        {
            // Place is needed to be disabled.
        }

        return false;
    }

    /**
     * This function return true if the location [i_coordX, i_coordY] is a part of 3 connected pieces.
     * Else, return false.
     * @param i_coordX
     * @param i_coordY
     * @return
     */
    private boolean checkBoard(int i_coordX, int i_coordY)
    {
        boolean result = false;
        ChipColor present = this._Board[i_coordX][i_coordY];

        if(i_coordX == 0 )
        {
            if(i_coordY == 0)
            {
                if((this._Board[i_coordX + 1][i_coordY] == present) && (this._Board[i_coordX + 2][i_coordY] == present)
                || (this._Board[i_coordX + 1][i_coordY + 1] == present && this._Board[i_coordX + 2][i_coordY + 2] == present)
                || (this._Board[i_coordX][i_coordY + 1] == present && this._Board[i_coordX][i_coordY + 2] == present))
                {
                    result = true;
                }
            }
            else if(i_coordY == 1)
            {
                if((this._Board[i_coordX][i_coordY - 1] == present && this._Board[i_coordX][i_coordY + 1] == present)
                || (this._Board[i_coordX + 1][i_coordY] == present && this._Board[i_coordX + 2][i_coordY] == present))
                {
                    result = true;
                }
            }
            else if(i_coordY == 2)
            {
                if((this._Board[i_coordX][i_coordY - 1] == present) && (this._Board[i_coordX][i_coordY - 2] == present)
                        || (this._Board[i_coordX + 1][i_coordY - 1] == present && this._Board[i_coordX + 2][i_coordY - 2] == present)
                        || (this._Board[i_coordX + 1][i_coordY] == present && this._Board[i_coordX + 2][i_coordY] == present))
                {
                    result = true;
                }

            }
            else {
                // error.
            }
        }
        else if(i_coordX == 1 )
        {
            if(i_coordY == 0)
            {
                if((this._Board[i_coordX + 1][i_coordY] == present) && (this._Board[i_coordX - 1][i_coordY] == present)
                        || (this._Board[i_coordX][i_coordY + 1] == present && this._Board[i_coordX][i_coordY + 2] == present))
                {
                    result = true;
                }

            }
            else if(i_coordY == 1)
            {
                if((this._Board[i_coordX + 1][i_coordY] == present) && (this._Board[i_coordX - 1][i_coordY] == present)
                        || (this._Board[i_coordX + 1][i_coordY + 1] == present && this._Board[i_coordX - 1][i_coordY - 1] == present)
                        || (this._Board[i_coordX][i_coordY + 1] == present && this._Board[i_coordX][i_coordY - 1] == present)
                        || (this._Board[i_coordX - 1][i_coordY + 1] == present && this._Board[i_coordX + 1][i_coordY - 1] == present))
                {
                    result = true;
                }

            }
            else if(i_coordY == 2)
            {
                if((this._Board[i_coordX + 1][i_coordY] == present) && (this._Board[i_coordX - 1][i_coordY] == present)
                        || (this._Board[i_coordX][i_coordY - 1] == present && this._Board[i_coordX][i_coordY - 2] == present))
                {
                    result = true;
                }

            }
            else {
                // error.
            }
        }
        else if(i_coordX == 2 )
        {
            if(i_coordY == 0)
            {
                if((this._Board[i_coordX - 1][i_coordY] == present) && (this._Board[i_coordX - 2][i_coordY] == present)
                        || (this._Board[i_coordX - 1][i_coordY + 1] == present && this._Board[i_coordX - 2][i_coordY + 2] == present)
                        || (this._Board[i_coordX][i_coordY + 1] == present && this._Board[i_coordX][i_coordY + 2] == present))
                {
                    result = true;
                }

            }
            else if(i_coordY == 1)
            {
                if((this._Board[i_coordX][i_coordY - 1] == present) && (this._Board[i_coordX][i_coordY + 1] == present)
                        || (this._Board[i_coordX - 1][i_coordY] == present && this._Board[i_coordX - 2][i_coordY] == present))
                {
                    result = true;
                }

            }
            else if(i_coordY == 2)
            {
                if((this._Board[i_coordX - 1][i_coordY] == present) && (this._Board[i_coordX - 2][i_coordY] == present)
                        || (this._Board[i_coordX - 1][i_coordY - 1] == present && this._Board[i_coordX - 2][i_coordY - 2] == present)
                        || (this._Board[i_coordX][i_coordY - 1] == present && this._Board[i_coordX][i_coordY - 2] == present))
                {
                    result = true;
                }

            }
            else {
                // error.
            }
        }
        else
        {
            // error.
        }



        return result;
    }



}
