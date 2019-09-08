package student_player;
import pentago_swap.PentagoBoardState;
import pentago_swap.PentagoMove;


public class MyTools {


    public static PentagoMove firstPlayerWin(PentagoBoardState boardState) {

        PentagoMove move = null;
        if (boardState.getTurnNumber() == 0) {
            move = new PentagoMove(1, 1, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
            return move;
        }
        if (boardState.getTurnNumber() == 1) {

            if (boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) {
                if (boardState.isLegal(new PentagoMove(1, 1, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 1, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 1, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 1, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 4, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 4, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else {
                    move = new PentagoMove(1, 1, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                }
            } else if (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) {
                if (boardState.isLegal(new PentagoMove(1, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 4, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 4, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                }

            } else if (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) {
                if (boardState.isLegal(new PentagoMove(1, 1, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 1, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 4, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 4, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                }
            } else if (boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) {
                if (boardState.isLegal(new PentagoMove(1, 4, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 4, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 4, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 4, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                }
            } else {
                MctsMove ai = new MctsMove(1000);
                move = ai.getMove(boardState);

            }
            return move;
        }
        if (boardState.getTurnNumber() == 2) {

            if (boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) {
                //check for vertical build
                if (boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE && ((boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.BLACK))) {
                    if (boardState.isLegal(new PentagoMove(0, 1, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(0, 1, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer());

                    } else if (boardState.isLegal(new PentagoMove(2, 4, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(2, 4, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer());
                    }
                    //just build top horizontal
                } else if (boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE && (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK)) {
                    if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer());
                        //should not even reach here
                    } else if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer());
                    }
                } else if (boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE && (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK)) {
                    if (boardState.isLegal(new PentagoMove(1, 0, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 0, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    }
                } else if (boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE && (boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.BLACK)) {
                    if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    }
                } else if (boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE && (boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.BLACK)) {
                    if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer());
                    }
                } else if (boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) {
                    if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer());
                    }
                    //where we see if we must do vertical build or not
                } else if (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE && ((boardState.getPieceAt(4, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.BLACK))) {
                    if (boardState.isLegal(new PentagoMove(3, 1, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(3, 1, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(2, 4, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(2, 4, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer());
                    }
                    //just build top horizontal
                } else if (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE && (boardState.getPieceAt(4, 0) == PentagoBoardState.Piece.BLACK)) {
                    if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                        //should not even reach here
                    } else if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    }
                } else if (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE && (boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.BLACK)) {
                    if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    }
                } else if (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE && (boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.BLACK)) {
                    if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    }
                } else if (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE && (boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.BLACK)) {
                    if (boardState.isLegal(new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    }
                } else if ((boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE)) {
                    if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    }
                }
                //check for vertical build
                else if (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE && ((boardState.getPieceAt(4, 3) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(4, 5) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 3) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 3) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 5) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 5) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.BLACK))) {
                    if (boardState.isLegal(new PentagoMove(3, 4, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(3, 4, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(2, 4, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(2, 4, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    }
                    //continue horizontal on top

                } else if (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE && (boardState.getPieceAt(4, 3) == PentagoBoardState.Piece.BLACK)) {
                    if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                        //should not even reach here
                    } else if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    }
                } else if (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE && (boardState.getPieceAt(4, 5) == PentagoBoardState.Piece.BLACK)) {
                    if (boardState.isLegal(new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    }
                } else if (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE && (boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.BLACK)) {
                    if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    }
                } else if (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE && (boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.BLACK)) {
                    if (boardState.isLegal(new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    }
                } else if ((boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE)) {
                    if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    }
                }
            } else if (boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) {
                //build vertical on the left
                if (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE && ((boardState.getPieceAt(4, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK))) {
                    if (boardState.isLegal(new PentagoMove(3, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(3, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(2, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(2, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    }
                    //just build top horizontal
                } else if (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE && (boardState.getPieceAt(4, 0) == PentagoBoardState.Piece.BLACK)) {
                    if (boardState.isLegal(new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                        //should not even reach here
                    } else if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    }
                } else if (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE && (boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.BLACK)) {
                    if (boardState.isLegal(new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    }
                } else if (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE && (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK)) {
                    if (boardState.isLegal(new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    }
                } else if (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE && (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK)) {
                    if (boardState.isLegal(new PentagoMove(1, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    }
                } else if ((boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE)) {
                    if (boardState.isLegal(new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    }
                }
                //check for vertical
                else if (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE && ((boardState.getPieceAt(4, 3) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(4, 5) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 3) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 3) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 5) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 5) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK))) {
                    if (boardState.isLegal(new PentagoMove(2, 1, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(2, 1, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(3, 4, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(3, 4, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    }
                    //continue horizontal on top

                } else if (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE && (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK)) {
                    if (boardState.isLegal(new PentagoMove(1, 0, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 0, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                        //should not even reach here
                    } else if (boardState.isLegal(new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    }
                } else if (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE && (boardState.getPieceAt(4, 5) == PentagoBoardState.Piece.BLACK)) {
                    if (boardState.isLegal(new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    }
                } else if (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE && (boardState.getPieceAt(4, 3) == PentagoBoardState.Piece.BLACK)) {
                    if (boardState.isLegal(new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    }
                } else if (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE && (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK)) {
                    if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    }
                } else if ((boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE)) {
                    if (boardState.isLegal(new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    }
                }
                //in this case we have no choice but to build the vertical, just to reduce the state space
            } else if (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) {
                if ((boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE)) {
                    if (boardState.isLegal(new PentagoMove(5, 1, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(5, 1, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    } else if (boardState.isLegal(new PentagoMove(4, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                        move = new PentagoMove(4, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    }
                }
            } else {
                MctsMove ai = new MctsMove(1000);
                move = ai.getMove(boardState);
            }

            return move;
        }


        if (boardState.getTurnNumber() == 3) {
            //if there are 2 inline , then we will not make a win using this approach anymore, so turn to mcts
            if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && ((boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.BLACK))) {
                MctsMove ai = new MctsMove(1000);
                move = ai.getMove(boardState);


            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.WHITE)) {

                if (boardState.isLegal(new PentagoMove(1, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                }


            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 0, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 0, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                }

            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                }

            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 0, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 0, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                }
                // check to see if there is a vertical build on the left

            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(5, 1) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(2, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(2, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(3, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(3, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(0, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(0, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else {
                    MctsMove ai = new MctsMove(1000);
                    move = ai.getMove(boardState);

                }
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(3, 1) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(0, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(0, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(5, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(5, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(2, 1, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(2, 1, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else {
                    MctsMove ai = new MctsMove(1000);
                    move = ai.getMove(boardState);

                }
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(2, 1) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(5, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(5, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(3, 1, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(3, 1, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(0, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(0, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else {
                    MctsMove ai = new MctsMove(1000);
                    move = ai.getMove(boardState);

                }
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(0, 1) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(5, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(5, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(3, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(3, 1, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(2, 1, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(2, 1, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else {
                    MctsMove ai = new MctsMove(1000);
                    move = ai.getMove(boardState);

                }
                //can no longer do left vertical build
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && ((boardState.getPieceAt(0, 1) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(2, 1) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(0, 1) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(3, 1) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(0, 1) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(5, 1) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(2, 1) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(3, 1) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(2, 1) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(5, 1) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(3, 1) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(5, 1) == PentagoBoardState.Piece.BLACK))) {
                MctsMove ai = new MctsMove(1000);
                move = ai.getMove(boardState);


                // if two black values for this potential horizontal build, then just do mcts
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && ((boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(4, 0) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(4, 0) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.BLACK))) {
                MctsMove ai = new MctsMove(1000);
                move = ai.getMove(boardState);
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else {
                    MctsMove ai = new MctsMove(1000);
                    move = ai.getMove(boardState);

                }
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 0) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else {
                    MctsMove ai = new MctsMove(1000);
                    move = ai.getMove(boardState);

                }
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else {
                    MctsMove ai = new MctsMove(1000);
                    move = ai.getMove(boardState);

                }
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else {
                    MctsMove ai = new MctsMove(1000);
                    move = ai.getMove(boardState);

                }

                // check for build on the right


            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && ((boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(4, 3) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(4, 5) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(4, 3) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(4, 5) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 3) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(4, 5) == PentagoBoardState.Piece.BLACK))) {
                MctsMove ai = new MctsMove(1000);
                move = ai.getMove(boardState);
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 3) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 0, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 0, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else {
                    MctsMove ai = new MctsMove(1000);
                    move = ai.getMove(boardState);

                }
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 5) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 0, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 0, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else {
                    MctsMove ai = new MctsMove(1000);
                    move = ai.getMove(boardState);

                }
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else {
                    MctsMove ai = new MctsMove(1000);
                    move = ai.getMove(boardState);

                }
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 0, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 0, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                } else {
                    MctsMove ai = new MctsMove(1000);
                    move = ai.getMove(boardState);

                }


            } else if ((boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && ((boardState.getPieceAt(4, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 0) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.BLACK) || (boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.BLACK && boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.BLACK))) {
                MctsMove ai = new MctsMove(1000);
                move = ai.getMove(boardState);
            } else if ((boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else {
                    MctsMove ai = new MctsMove(1000);
                    move = ai.getMove(boardState);

                }
            } else if ((boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else {
                    MctsMove ai = new MctsMove(1000);
                    move = ai.getMove(boardState);

                }
            } else if ((boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 0) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else {
                    MctsMove ai = new MctsMove(1000);
                    move = ai.getMove(boardState);

                }
            } else if ((boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else {
                    MctsMove ai = new MctsMove(1000);
                    move = ai.getMove(boardState);

                }
            }
            else if ((boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else {
                    MctsMove ai = new MctsMove(1000);
                    move = ai.getMove(boardState);

                }
            } else if ((boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else {
                    MctsMove ai = new MctsMove(1000);
                    move = ai.getMove(boardState);

                }
            } else if ((boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 3) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else {
                    MctsMove ai = new MctsMove(1000);
                    move = ai.getMove(boardState);

                }
            } else if ((boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 5) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else if (boardState.isLegal(new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                } else {
                    MctsMove ai = new MctsMove(1000);
                    move = ai.getMove(boardState);

                }



            } else {
                MctsMove ai = new MctsMove(1000);
                move = ai.getMove(boardState);

            }
            return move;
        }
        if (boardState.getTurnNumber() == 4) {

            if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer());
                    return move;
                }
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(1, 0, PentagoBoardState.Quadrant.TR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 0, PentagoBoardState.Quadrant.TR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                }
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.WHITE)) {
                System.out.println("hello");
                if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.BR, boardState.getTurnPlayer());
                    return move;

                } else if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                }

            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.TL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                }
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;

                }
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 0) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                }
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 0) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(1, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                }
            }
            if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(1, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                }
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 3) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 0, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 0, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                }
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 5) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(1, 0, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 0, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                }
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 5) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                }
            } else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 3) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                }
            }
            else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 3) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 5) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 2, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 2, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(1, 0, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 0, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                }
            }
            else if ((boardState.getPieceAt(1, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 0) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 2) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TR, boardState.getTurnPlayer());
                    return move;
                }

            } else if ((boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                }
            } else if ((boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                }
            } else if ((boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 0, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                }
            } else if ((boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 0) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 2) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                }
            }
            else if ((boardState.getPieceAt(4, 1) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 0) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 2, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BL, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                }
            } else if ((boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                }
            } else if ((boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 3) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                }
            } else if ((boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 3) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 5) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                }
            } else if ((boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 3) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                }
            } else if ((boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(1, 5) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 5) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(4, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                }
            } else if ((boardState.getPieceAt(1, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 4) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 3) == PentagoBoardState.Piece.WHITE) && (boardState.getPieceAt(4, 5) == PentagoBoardState.Piece.WHITE)) {
                if (boardState.isLegal(new PentagoMove(1, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 3, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                } else if (boardState.isLegal(new PentagoMove(1, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer()))) {
                    move = new PentagoMove(1, 5, PentagoBoardState.Quadrant.BR, PentagoBoardState.Quadrant.TL, boardState.getTurnPlayer());
                    return move;
                }



            } else {
                MctsMove ai = new MctsMove(1000);
                move = ai.getMove(boardState);
                // return move;

            }

            return move;


        }
        return move;
    }

}