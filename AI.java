import java.util.Random;

public class AI extends Player{
  public AI(String s, int v, Board b, int c) {
    super(s, v, b, c);
  }
  public void move() {
    if(winExists()[0]>=0) {
      System.out.println("Found a winning move!");
      board.setPos(winExists()[0], winExists()[1], val, icon);
    }
    else {
      defaultMove();
    }
  }

  private int[] winExists() {
    int[] points = {-1, -1};
    for(int i=0; i<3; i++) {
      if(board.addRow(i)==val*2) {
        points[0]=i;
        for(int j = 0; j<3; j++) {
          if(board.getPos(i,j)==0) {
            points[1]=j;
            return points;
          }
        }
      }
      if(board.addCol(i)==val*2) {
        points[1]=i;
        for(int j = 0; j<3; j++) {
          if(board.getPos(j,i)==0) {
            points[0]=j;
            return points;
          }
        }
      }
      if(board.addRow(i)==opp*2) {
        points[0]=i;
        for(int j = 0; j<3; j++) {
          if(board.getPos(i,j)==0) {
            points[1]=j;
            return points;
          }
        }
      }
      if(board.addCol(i)==opp*2) {
        points[1]=i;
        for(int j = 0; j<3; j++) {
          if(board.getPos(j,i)==0) {
            points[0]=j;
            return points;
          }
        }
      }
    }
    if(board.addDiag(0)==6||board.addDiag(0)==20)
      playDiag(0);
    if(board.addDiag(1)==6||board.addDiag(1)==20)
      playDiag(1);

    return points;
  }

  private void defaultMove() {
    if(board.getPos(1, 1)==0) {
      System.out.println("Playing center!");
      board.setPos(1, 1, val, icon);
    }
    else {
      attemptCorner();
    }
  }

  private void attemptCorner() {
    int i=0;
    int j=2;
    if (board.getPos(i, j)==0) {
      System.out.println("Option 1");
      System.out.println(board);
      board.setPos(i, j, val, icon);
      System.out.println(board);
      return;
    }
    else if (board.getPos(i, i)==0) {
      System.out.println("Option 2");
      System.out.println(board);
      board.setPos(i, i, val, icon);
      System.out.println(board);
      return;
    }
    else if (board.getPos(j, j)==0) {
      System.out.println("Option 3");
      System.out.println(board);
      board.setPos(j, j, val, icon);
      System.out.println(board);
      return;
    }
    else if (board.getPos(j, i)==0) {
      System.out.println("Option 4");
      board.setPos(j, i, val, icon);
      return;
    }
    
  }

  private void playSide() {
    if (board.getPos(0, 1)==0) {
      board.setPos(0, 1, val, icon);
      return;
    }
    else if (board.getPos(1, 2)==0) {
      board.setPos(1, 2, val, icon);
      return;
    }
    else if (board.getPos(2, 1)==0) {
      board.setPos(2, 1, val, icon);
      return;
    }
    else if (board.getPos(1, 0)==0) {
      board.setPos(1, 0, val, icon);
      return;
    }
  }

  private void playDiag(int a) {
    if(a==0) {
      for(int i=0; i<3; i++) {
        if (board.getPos(i, i)==0){
          board.setPos(i, i, val, icon);
          return;
        }
      }
    }
    else if(a==1) {
      for(int i=0; i<3; i++) {
        for (int j=2; j>=0; j--) {
          if(board.getPos(i, j)==0)
            board.setPos(i, j, val, icon);
        }
      }
    }
    else {
      System.out.println("Error");
      defaultMove();
    }
  }
}
